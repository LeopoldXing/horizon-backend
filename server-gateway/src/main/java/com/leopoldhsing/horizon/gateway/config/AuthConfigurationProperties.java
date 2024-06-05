package com.leopoldhsing.horizon.gateway.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Objects;

@Configuration
@ConfigurationProperties(prefix = "horizon.url.pattern")
public class AuthConfigurationProperties {

    private String loginPath;
    private List<String> trustedUriPatterns;
    private List<String> requireAuthUriPatterns;
    private List<String> innerUriPatterns;
    private String signUpUriPatterns;
    private String signInUriPatterns;

    public AuthConfigurationProperties() {
    }

    public AuthConfigurationProperties(String loginPath, List<String> trustedUriPatterns, List<String> requireAuthUriPatterns, List<String> innerUriPatterns, String signUpUriPatterns, String signInUriPatterns) {
        this.loginPath = loginPath;
        this.trustedUriPatterns = trustedUriPatterns;
        this.requireAuthUriPatterns = requireAuthUriPatterns;
        this.innerUriPatterns = innerUriPatterns;
        this.signUpUriPatterns = signUpUriPatterns;
        this.signInUriPatterns = signInUriPatterns;
    }

    @Override
    public String toString() {
        return "AuthConfigurationProperties{" +
                "loginPath='" + loginPath + '\'' +
                ", trustedUriPatterns=" + trustedUriPatterns +
                ", requireAuthUriPatterns=" + requireAuthUriPatterns +
                ", innerUriPatterns=" + innerUriPatterns +
                ", signUpUriPatterns='" + signUpUriPatterns + '\'' +
                ", signInUriPatterns='" + signInUriPatterns + '\'' +
                '}';
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

    public String getSignUpUriPatterns() {
        return signUpUriPatterns;
    }

    public void setSignUpUriPatterns(String signUpUriPatterns) {
        this.signUpUriPatterns = signUpUriPatterns;
    }

    public String getSignInUriPatterns() {
        return signInUriPatterns;
    }

    public void setSignInUriPatterns(String signInUriPatterns) {
        this.signInUriPatterns = signInUriPatterns;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AuthConfigurationProperties that = (AuthConfigurationProperties) o;
        return Objects.equals(loginPath, that.loginPath) && Objects.equals(trustedUriPatterns, that.trustedUriPatterns) && Objects.equals(requireAuthUriPatterns, that.requireAuthUriPatterns) && Objects.equals(innerUriPatterns, that.innerUriPatterns) && Objects.equals(signUpUriPatterns, that.signUpUriPatterns) && Objects.equals(signInUriPatterns, that.signInUriPatterns);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(loginPath);
        result = 31 * result + Objects.hashCode(trustedUriPatterns);
        result = 31 * result + Objects.hashCode(requireAuthUriPatterns);
        result = 31 * result + Objects.hashCode(innerUriPatterns);
        result = 31 * result + Objects.hashCode(signUpUriPatterns);
        result = 31 * result + Objects.hashCode(signInUriPatterns);
        return result;
    }
}
