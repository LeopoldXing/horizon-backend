package com.leopoldhsing.horizon.service.plaid.service.impl;

import com.leopoldhsing.horizon.common.utils.constants.RedisConstants;
import com.leopoldhsing.horizon.common.utils.exception.InvalidAccessTokenException;
import com.leopoldhsing.horizon.model.dto.AccountDto;
import com.leopoldhsing.horizon.model.entity.Account;
import com.leopoldhsing.horizon.model.mapper.AccountMapper;
import com.leopoldhsing.horizon.service.plaid.service.IPlaidAccountService;
import com.plaid.client.model.AccountsBalanceGetRequest;
import com.plaid.client.model.AccountsGetResponse;
import com.plaid.client.request.PlaidApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import retrofit2.Response;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Service
public class PlaidAccountServiceImpl implements IPlaidAccountService {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private PlaidApi plaidClient;

    @Override
    public List<AccountDto> getAccountsFromPlaidByUserId(Long userId) throws IOException {
        // 1. get access token
        String accessToken = redisTemplate
                .opsForValue()
                .get(RedisConstants.PLAID_KEY_PREFIX + RedisConstants.PLAID_ACCESS_TOKEN_KEY_SUFFIX + userId);
        if (!StringUtils.hasLength(accessToken)) {
            throw new InvalidAccessTokenException(accessToken);
        }

        // 2. construct getting account list request
        AccountsBalanceGetRequest request = new AccountsBalanceGetRequest().accessToken(accessToken);

        // 3. get response
        Response<AccountsGetResponse> response = plaidClient.accountsBalanceGet(request).execute();
        AccountsGetResponse responseBody = Objects.requireNonNull(response.body());

        // 4. parse result
        // 4.1 get institutionId
        String institutionId = responseBody.getItem().getInstitutionId();
        // 4.2 get account list
        List<AccountDto> accounts = responseBody.getAccounts()
                .parallelStream()
                .map(accountBase -> {
                    Account account = new Account();
                    account.setPlaidAccountId(accountBase.getAccountId());
                    account.setName(accountBase.getName());
                    account.setMask(accountBase.getMask());
                    account.setOfficialName(accountBase.getOfficialName());
                    account.setType(accountBase.getType().toString());
                    account.setSubtype(Objects.requireNonNull(accountBase.getSubtype()).toString());
                    account.setCurrentBalance(BigDecimal.valueOf(accountBase.getBalances().getCurrent()));
                    account.setAvailableBalance(BigDecimal.valueOf(accountBase.getBalances().getAvailable()));
                    account.setLimitBalance(BigDecimal.valueOf(accountBase.getBalances().getLimit()));
                    account.setIsoCurrencyCode(accountBase.getBalances().getIsoCurrencyCode());
                    account.setInstitutionId(institutionId);
                    return AccountMapper.mapToAccountDto(account);
                }).toList();

        // 5. return result;
        return accounts;
    }
}
