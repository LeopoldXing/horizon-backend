package com.leopoldhsing.horizon.service.plaid.service.impl;

import com.leopoldhsing.horizon.common.utils.constants.RedisConstants;
import com.leopoldhsing.horizon.common.utils.exception.InvalidAccessTokenException;
import com.leopoldhsing.horizon.feign.bank.BankFeignClient;
import com.leopoldhsing.horizon.feign.user.UserFeignClient;
import com.leopoldhsing.horizon.model.dto.AccountDto;
import com.leopoldhsing.horizon.model.dto.BankDto;
import com.leopoldhsing.horizon.model.dto.UserDto;
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

    @Autowired
    private UserFeignClient userFeignClient;

    @Autowired
    private BankFeignClient bankFeignClient;

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
        // 4.2 get account owner dto [RPC]
        UserDto userDto = userFeignClient.getUser(userId);
        // 4.3 get account list
        List<AccountDto> accountDtoList = responseBody.getAccounts()
                .stream()
                .map(accountBase -> {
                    // get institution info
                    bankFeignClient.alignBankInformation(new BankDto(institutionId));
                    BankDto bankDto = bankFeignClient.getBankByInstitutionId(institutionId);
                    // construct accountdto
                    AccountDto accountDto = new AccountDto();
                    accountDto.setPlaidAccountId(accountBase.getAccountId());
                    accountDto.setName(accountBase.getName());
                    accountDto.setOwner(userDto);
                    accountDto.setMask(accountBase.getMask());
                    accountDto.setOfficialName(accountBase.getOfficialName());
                    accountDto.setType(accountBase.getType().toString());
                    accountDto.setSubtype(Objects.requireNonNull(accountBase.getSubtype()).toString());
                    accountDto.setCurrentBalance(BigDecimal.valueOf(accountBase.getBalances().getCurrent() == null ? 0 : accountBase.getBalances().getCurrent()));
                    accountDto.setAvailableBalance(BigDecimal.valueOf(accountBase.getBalances().getAvailable() == null ? 0 : accountBase.getBalances().getAvailable()));
                    accountDto.setLimitBalance(BigDecimal.valueOf(accountBase.getBalances().getLimit() == null ? 0 : accountBase.getBalances().getLimit()));
                    accountDto.setIsoCurrencyCode(accountBase.getBalances().getIsoCurrencyCode());
                    accountDto.setInstitution(bankDto);
                    return accountDto;
                }).toList();

        // 5. return result;
        return accountDtoList;
    }
}
