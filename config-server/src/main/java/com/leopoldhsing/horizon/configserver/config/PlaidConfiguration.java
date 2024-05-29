package com.leopoldhsing.horizon.configserver.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties(prefix = "horizon.plaid")
public class PlaidConfiguration {

    public String clientId;
    public String secret;
    public String env;
    public List<String> products;
    public List<String> countryCodes;

    public PlaidConfiguration() {
    }

    public PlaidConfiguration(String clientId, String secret, String env, List<String> products, List<String> countryCodes) {
        this.clientId = clientId;
        this.secret = secret;
        this.env = env;
        this.products = products;
        this.countryCodes = countryCodes;
    }

    @Override
    public String toString() {
        return "PlaidConfiguration{" +
                "clientId='" + clientId + '\'' +
                ", secret='" + secret + '\'' +
                ", env='" + env + '\'' +
                ", products=" + products +
                ", countryCodes=" + countryCodes +
                '}';
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
