package com.leopoldhsing.horizon.service.plaid.service.impl;

import com.leopoldhsing.horizon.service.plaid.config.PlaidConfigurationProperties;
import com.leopoldhsing.horizon.service.plaid.service.IPlaidService;
import com.plaid.client.model.ItemPublicTokenExchangeRequest;
import com.plaid.client.model.ItemPublicTokenExchangeResponse;
import com.plaid.client.request.PlaidApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.Response;

import java.io.IOException;

@Service
public class PlaidServiceImpl implements IPlaidService {

    @Autowired
    private PlaidApi plaidClient;

    @Autowired
    private PlaidConfigurationProperties configurationProperties;

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
        }

        System.out.println("accessToken -> " + accessToken);
        return true;
    }

}
