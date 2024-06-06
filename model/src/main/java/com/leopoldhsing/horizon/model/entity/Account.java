package com.leopoldhsing.horizon.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

@Table(name = "accounts")
@Entity
public class Account extends BaseEntity {

    private String name;
    private String plaidAccountId;
    private String officialName;
    private Long ownerId;
    private BigDecimal currentBalance;
    private BigDecimal availableBalance;
    private BigDecimal limitBalance;
    private String isoCurrencyCode;
    private Long bankId;
    private String institutionId;
    private String shareableId;
    private String fundingSourceUrl;
    private String mask;
    private String persistentAccountId;
    private String type;
    private String subtype;

    public Account() {
    }

    public Account(Long id, LocalDateTime createdAt, LocalDateTime lastModifiedAt, String createdBy, String lastModifiedBy) {
        super(id, createdAt, lastModifiedAt, createdBy, lastModifiedBy);
    }

    public Account(String name, String plaidAccountId, String officialName, Long ownerId, BigDecimal currentBalance, BigDecimal availableBalance, BigDecimal limitBalance, String isoCurrencyCode, Long bankId, String institutionId, String shareableId, String fundingSourceUrl, String mask, String persistentAccountId, String type, String subtype) {
        this.name = name;
        this.plaidAccountId = plaidAccountId;
        this.officialName = officialName;
        this.ownerId = ownerId;
        this.currentBalance = currentBalance;
        this.availableBalance = availableBalance;
        this.limitBalance = limitBalance;
        this.isoCurrencyCode = isoCurrencyCode;
        this.bankId = bankId;
        this.institutionId = institutionId;
        this.shareableId = shareableId;
        this.fundingSourceUrl = fundingSourceUrl;
        this.mask = mask;
        this.persistentAccountId = persistentAccountId;
        this.type = type;
        this.subtype = subtype;
    }

    public Account(Long id, LocalDateTime createdAt, LocalDateTime lastModifiedAt, String createdBy, String lastModifiedBy, String name, String plaidAccountId, String officialName, Long ownerId, BigDecimal currentBalance, BigDecimal availableBalance, BigDecimal limitBalance, String isoCurrencyCode, Long bankId, String institutionId, String shareableId, String fundingSourceUrl, String mask, String persistentAccountId, String type, String subtype) {
        super(id, createdAt, lastModifiedAt, createdBy, lastModifiedBy);
        this.name = name;
        this.plaidAccountId = plaidAccountId;
        this.officialName = officialName;
        this.ownerId = ownerId;
        this.currentBalance = currentBalance;
        this.availableBalance = availableBalance;
        this.limitBalance = limitBalance;
        this.isoCurrencyCode = isoCurrencyCode;
        this.bankId = bankId;
        this.institutionId = institutionId;
        this.shareableId = shareableId;
        this.fundingSourceUrl = fundingSourceUrl;
        this.mask = mask;
        this.persistentAccountId = persistentAccountId;
        this.type = type;
        this.subtype = subtype;
    }

    @Override
    public String toString() {
        return "Account{" +
                "name='" + name + '\'' +
                ", plaidAccountId='" + plaidAccountId + '\'' +
                ", officialName='" + officialName + '\'' +
                ", ownerId=" + ownerId +
                ", currentBalance=" + currentBalance +
                ", availableBalance=" + availableBalance +
                ", limitBalance=" + limitBalance +
                ", isoCurrencyCode='" + isoCurrencyCode + '\'' +
                ", bankId=" + bankId +
                ", institutionId='" + institutionId + '\'' +
                ", shareableId='" + shareableId + '\'' +
                ", fundingSourceUrl='" + fundingSourceUrl + '\'' +
                ", mask='" + mask + '\'' +
                ", persistentAccountId='" + persistentAccountId + '\'' +
                ", type='" + type + '\'' +
                ", subtype='" + subtype + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlaidAccountId() {
        return plaidAccountId;
    }

    public void setPlaidAccountId(String plaidAccountId) {
        this.plaidAccountId = plaidAccountId;
    }

    public String getOfficialName() {
        return officialName;
    }

    public void setOfficialName(String officialName) {
        this.officialName = officialName;
    }

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
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

    public Long getBankId() {
        return bankId;
    }

    public void setBankId(Long bankId) {
        this.bankId = bankId;
    }

    public String getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(String institutionId) {
        this.institutionId = institutionId;
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

    public String getSubtype() {
        return subtype;
    }

    public void setSubtype(String subtype) {
        this.subtype = subtype;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Account account = (Account) o;
        return Objects.equals(name, account.name) && Objects.equals(plaidAccountId, account.plaidAccountId) && Objects.equals(officialName, account.officialName) && Objects.equals(ownerId, account.ownerId) && Objects.equals(currentBalance, account.currentBalance) && Objects.equals(availableBalance, account.availableBalance) && Objects.equals(limitBalance, account.limitBalance) && Objects.equals(isoCurrencyCode, account.isoCurrencyCode) && Objects.equals(bankId, account.bankId) && Objects.equals(institutionId, account.institutionId) && Objects.equals(shareableId, account.shareableId) && Objects.equals(fundingSourceUrl, account.fundingSourceUrl) && Objects.equals(mask, account.mask) && Objects.equals(persistentAccountId, account.persistentAccountId) && Objects.equals(type, account.type) && Objects.equals(subtype, account.subtype);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(name);
        result = 31 * result + Objects.hashCode(plaidAccountId);
        result = 31 * result + Objects.hashCode(officialName);
        result = 31 * result + Objects.hashCode(ownerId);
        result = 31 * result + Objects.hashCode(currentBalance);
        result = 31 * result + Objects.hashCode(availableBalance);
        result = 31 * result + Objects.hashCode(limitBalance);
        result = 31 * result + Objects.hashCode(isoCurrencyCode);
        result = 31 * result + Objects.hashCode(bankId);
        result = 31 * result + Objects.hashCode(institutionId);
        result = 31 * result + Objects.hashCode(shareableId);
        result = 31 * result + Objects.hashCode(fundingSourceUrl);
        result = 31 * result + Objects.hashCode(mask);
        result = 31 * result + Objects.hashCode(persistentAccountId);
        result = 31 * result + Objects.hashCode(type);
        result = 31 * result + Objects.hashCode(subtype);
        return result;
    }
}
