package com.leopoldhsing.horizon.gateway.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties(prefix = "horizon.url.pattern")
public class AuthConfigurationProperties {

    private String loginPath;
    private List<String> trustedUriPatterns;
    private List<String> requireAuthUriPatterns;
    private List<String> innerUriPatterns;

    public AuthConfigurationProperties() {
    }

    public AuthConfigurationProperties(String loginPath, List<String> trustedUriPatterns, List<String> requireAuthUriPatterns, List<String> innerUriPatterns) {
        this.loginPath = loginPath;
        this.trustedUriPatterns = trustedUriPatterns;
        this.requireAuthUriPatterns = requireAuthUriPatterns;
        this.innerUriPatterns = innerUriPatterns;
    }

    public String getLoginPath() {
        return loginPath;
    }

    public void setLoginPath(String loginPath) {
        this.loginPath = loginPath;
    }

    public List<String> getTrustedUriPatterns() {
        return trustedUriPatterns;
    }

    public void setTrustedUriPatterns(List<String> trustedUriPatterns) {
        this.trustedUriPatterns = trustedUriPatterns;
    }

    public List<String> getRequireAuthUriPatterns() {
        return requireAuthUriPatterns;
    }

    public void setRequireAuthUriPatterns(List<String> requireAuthUriPatterns) {
        this.requireAuthUriPatterns = requireAuthUriPatterns;
    }

    public List<String> getInnerUriPatterns() {
        return innerUriPatterns;
    }

    public void setInnerUriPatterns(List<String> innerUriPatterns) {
        this.innerUriPatterns = innerUriPatterns;
    }
}
