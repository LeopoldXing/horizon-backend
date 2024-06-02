package com.leopoldhsing.horizon.service.plaid.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "plaid")
public class PlaidConfigurationProperties {

    private String clientId;
    private String secret;
    private String env;
    private List<String> products;
    private List<String> countryCodes;

    public PlaidConfigurationProperties() {
    }

    public PlaidConfigurationProperties(String clientId, String secret, String env, List<String> products, List<String> countryCodes) {
        this.clientId = clientId;
        this.secret = secret;
        this.env = env;
        this.products = products;
        this.countryCodes = countryCodes;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
    }

    public List<String> getProducts() {
        return products;
    }

    public void setProducts(List<String> products) {
        this.products = products;
    }

    public List<String> getCountryCodes() {
        return countryCodes;
    }

    public void setCountryCodes(List<String> countryCodes) {
        this.countryCodes = countryCodes;
    }
}
