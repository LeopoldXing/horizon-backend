package com.leopoldhsing.horizon.model.dto;

import java.math.BigDecimal;
import java.util.Objects;

public class AccountDto {

    private String name;
    private String officialName;
    private UserDto owner;
    private BigDecimal currentBalance;
    private BigDecimal availableBalance;
    private BigDecimal limitBalance;
    private String isoCurrencyCode;
    private BankDto institution;
    private String shareableId;
    private String fundingSourceUrl;
    private String mask;
    private String persistentAccountId;
    private String type;
    private String subType;

    public AccountDto() {
    }

    public AccountDto(String name, String officialName, UserDto owner, BigDecimal currentBalance, BigDecimal availableBalance, BigDecimal limitBalance, String isoCurrencyCode, BankDto institution, String shareableId, String fundingSourceUrl, String mask, String persistentAccountId, String type, String subType) {
        this.name = name;
        this.officialName = officialName;
        this.owner = owner;
        this.currentBalance = currentBalance;
        this.availableBalance = availableBalance;
        this.limitBalance = limitBalance;
        this.isoCurrencyCode = isoCurrencyCode;
        this.institution = institution;
        this.shareableId = shareableId;
        this.fundingSourceUrl = fundingSourceUrl;
        this.mask = mask;
        this.persistentAccountId = persistentAccountId;
        this.type = type;
        this.subType = subType;
    }

    @Override
    public String toString() {
        return "AccountDto{" +
                "name='" + name + '\'' +
                ", officialName='" + officialName + '\'' +
                ", owner=" + owner +
                ", currentBalance=" + currentBalance +
                ", availableBalance=" + availableBalance +
                ", limitBalance=" + limitBalance +
                ", isoCurrencyCode='" + isoCurrencyCode + '\'' +
                ", institution=" + institution +
                ", shareableId='" + shareableId + '\'' +
                ", fundingSourceUrl='" + fundingSourceUrl + '\'' +
                ", mask='" + mask + '\'' +
                ", persistentAccountId='" + persistentAccountId + '\'' +
                ", type='" + type + '\'' +
                ", subType='" + subType + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOfficialName() {
        return officialName;
    }

    public void setOfficialName(String officialName) {
        this.officialName = officialName;
    }

    public UserDto getOwner() {
        return owner;
    }

    public void setOwner(UserDto owner) {
        this.owner = owner;
    }

    public BigDecimal getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(BigDecimal currentBalance) {
        this.currentBalance = currentBalance;
    }

    public BigDecimal getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(BigDecimal availableBalance) {
        this.availableBalance = availableBalance;
    }

    public BigDecimal getLimitBalance() {
        return limitBalance;
    }

    public void setLimitBalance(BigDecimal limitBalance) {
        this.limitBalance = limitBalance;
    }

    public String getIsoCurrencyCode() {
        return isoCurrencyCode;
    }

    public void setIsoCurrencyCode(String isoCurrencyCode) {
        this.isoCurrencyCode = isoCurrencyCode;
    }

    public BankDto getInstitution() {
        return institution;
    }

    public void setInstitution(BankDto institution) {
        this.institution = institution;
    }

    public String getShareableId() {
        return shareableId;
    }

    public void setShareableId(String shareableId) {
        this.shareableId = shareableId;
    }

    public String getFundingSourceUrl() {
        return fundingSourceUrl;
    }

    public void setFundingSourceUrl(String fundingSourceUrl) {
        this.fundingSourceUrl = fundingSourceUrl;
    }

    public String getMask() {
        return mask;
    }

    public void setMask(String mask) {
        this.mask = mask;
    }

    public String getPersistentAccountId() {
        return persistentAccountId;
    }

    public void setPersistentAccountId(String persistentAccountId) {
        this.persistentAccountId = persistentAccountId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccountDto that = (AccountDto) o;
        return Objects.equals(name, that.name) && Objects.equals(officialName, that.officialName) && Objects.equals(owner, that.owner) && Objects.equals(currentBalance, that.currentBalance) && Objects.equals(availableBalance, that.availableBalance) && Objects.equals(limitBalance, that.limitBalance) && Objects.equals(isoCurrencyCode, that.isoCurrencyCode) && Objects.equals(institution, that.institution) && Objects.equals(shareableId, that.shareableId) && Objects.equals(fundingSourceUrl, that.fundingSourceUrl) && Objects.equals(mask, that.mask) && Objects.equals(persistentAccountId, that.persistentAccountId) && Objects.equals(type, that.type) && Objects.equals(subType, that.subType);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(name);
        result = 31 * result + Objects.hashCode(officialName);
        result = 31 * result + Objects.hashCode(owner);
        result = 31 * result + Objects.hashCode(currentBalance);
        result = 31 * result + Objects.hashCode(availableBalance);
        result = 31 * result + Objects.hashCode(limitBalance);
        result = 31 * result + Objects.hashCode(isoCurrencyCode);
        result = 31 * result + Objects.hashCode(institution);
        result = 31 * result + Objects.hashCode(shareableId);
        result = 31 * result + Objects.hashCode(fundingSourceUrl);
        result = 31 * result + Objects.hashCode(mask);
        result = 31 * result + Objects.hashCode(persistentAccountId);
        result = 31 * result + Objects.hashCode(type);
        result = 31 * result + Objects.hashCode(subType);
        return result;
    }
}
