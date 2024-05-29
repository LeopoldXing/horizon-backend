package com.leopoldhsing.horizon.configserver.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "horizon.dwolla")
public class DwollaConfiguration {
    public String key;
    public String secret;
    public String baseUrl;
    public String env;

    public DwollaConfiguration() {
    }

    public DwollaConfiguration(String key, String secret, String baseUrl, String env) {
        this.key = key;
        this.secret = secret;
        this.baseUrl = baseUrl;
        this.env = env;
    }

    @Override
    public String toString() {
        return "DwollaConfiguration{" +
                "key='" + key + '\'' +
                ", secret='" + secret + '\'' +
                ", baseUrl='" + baseUrl + '\'' +
                ", env='" + env + '\'' +
                '}';
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
    }
}
