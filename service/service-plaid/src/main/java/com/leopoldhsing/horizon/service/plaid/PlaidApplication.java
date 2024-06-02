package com.leopoldhsing.horizon.service.plaid;

import com.leopoldhsing.horizon.service.plaid.config.PlaidConfigurationProperties;
import com.plaid.client.ApiClient;
import com.plaid.client.request.PlaidApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;

@SpringBootApplication
public class PlaidApplication {

    @Autowired
    private PlaidConfigurationProperties configurationProperties;

    public static void main(String[] args) {
        SpringApplication.run(PlaidApplication.class, args);
    }

    @Bean
    public ApiClient apiClient() {
        String plaidClientId = configurationProperties.getClientId();
        String plaidSecret = configurationProperties.getSecret();

        String plaidEnv = switch (configurationProperties.getEnv()) {
            case "sandbox" -> ApiClient.Sandbox;
            case "development" -> ApiClient.Development;
            case "production" -> ApiClient.Production;
            default -> ApiClient.Sandbox;
        };

        HashMap<String, String> apiKeys = new HashMap<>();
        apiKeys.put("clientId", plaidClientId);
        apiKeys.put("secret", plaidSecret);
        apiKeys.put("plaidVersion", "2020-09-14");
        ApiClient apiClient = new ApiClient(apiKeys);
        apiClient.setPlaidAdapter(plaidEnv);
        return apiClient;
    }

    @Bean
    public PlaidApi initPlaidClient(ApiClient apiClient) {
        PlaidApi plaidClient = apiClient.createService(PlaidApi.class);
        return plaidClient;
    }
}
