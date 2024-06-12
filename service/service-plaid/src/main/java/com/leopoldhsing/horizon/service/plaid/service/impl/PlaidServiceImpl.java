package com.leopoldhsing.horizon.service.plaid.service.impl;

import com.leopoldhsing.horizon.common.utils.RequestUtil;
import com.leopoldhsing.horizon.common.utils.constants.RedisConstants;
import com.leopoldhsing.horizon.common.utils.exception.ErrorGeneratingProcessorTokenException;
import com.leopoldhsing.horizon.common.utils.exception.PlaidPublicTokenInvalidException;
import com.leopoldhsing.horizon.model.dto.AccountDto;
import com.leopoldhsing.horizon.model.dto.UserDto;
import com.leopoldhsing.horizon.service.plaid.config.PlaidConfigurationProperties;
import com.leopoldhsing.horizon.service.plaid.service.IPlaidService;
import com.plaid.client.model.*;
import com.plaid.client.request.PlaidApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import retrofit2.Response;

import java.io.IOException;

@Service
public class PlaidServiceImpl implements IPlaidService {

    @Autowired
    private PlaidApi plaidClient;

    @Autowired
    private PlaidConfigurationProperties configurationProperties;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Override
    public Boolean exchangePublicToken(String publicToken) throws IOException {
        // 1. Prepare public token exchange schema
        ItemPublicTokenExchangeRequest exchangeRequest = new ItemPublicTokenExchangeRequest()
                .clientId(configurationProperties.getClientId())
                .secret(configurationProperties.getSecret())
                .publicToken(publicToken);

        // 2. Get response
        Response<ItemPublicTokenExchangeResponse> response = plaidClient.itemPublicTokenExchange(exchangeRequest).execute();

        // 3. Parse response
        String accessToken = "";
        if (response.body() != null) {
            accessToken = response.body().getAccessToken();
        } else throw new PlaidPublicTokenInvalidException(publicToken);

        // 4. store access token into redis
        redisTemplate.opsForValue().set(RedisConstants.PLAID_KEY_PREFIX
                + RedisConstants.PLAID_ACCESS_TOKEN_KEY_SUFFIX
                + RequestUtil.getUid(), accessToken);

        return true;
    }

    @Override
    public void deleteAccessToken() {
        redisTemplate.delete(RedisConstants.PLAID_KEY_PREFIX + RedisConstants.PLAID_ACCESS_TOKEN_KEY_SUFFIX + RequestUtil.getUid());
    }

    @Override
    public String getProcessorToken(UserDto userDto, AccountDto accountDto) throws IOException {
        // 1. get accessToken
        Long uid = RequestUtil.getUid();
        String accessToken = redisTemplate
                .opsForValue()
                .get(RedisConstants.PLAID_KEY_PREFIX + RedisConstants.PLAID_ACCESS_TOKEN_KEY_SUFFIX + uid);

        // 2. Create a processor token for Dwolla using the access token and account ID [external]
        ProcessorTokenCreateRequest tokenCreateRequest = new ProcessorTokenCreateRequest()
                .accessToken(accessToken)
                .accountId(accountDto.getPlaidAccountId())
                .processor(ProcessorTokenCreateRequest.ProcessorEnum.DWOLLA);
        Response<ProcessorTokenCreateResponse> tokenCreateResponse = plaidClient.processorTokenCreate(tokenCreateRequest).execute();
        String processorToken = "";
        if (tokenCreateResponse.body() != null) {
            processorToken = tokenCreateResponse.body().getProcessorToken();
        } else {
            throw new ErrorGeneratingProcessorTokenException(configurationProperties.getClientId(), accessToken);
        }

        return processorToken;
    }

}
