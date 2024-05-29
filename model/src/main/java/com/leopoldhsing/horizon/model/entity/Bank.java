package com.leopoldhsing.horizon.model.entity;

import jakarta.persistence.Entity;

import java.util.Date;
import java.util.Objects;

@Entity
public class Bank extends BaseEntity {

    private String bankName;

    private String accountId;

    private String fundingSourceUrl;

    private String shareableId;

    private String userId;

    public Bank() {
    }

    public Bank(String id, Date createdAt, Date updatedAt, String createdBy, String updatedBy) {
        super(id, createdAt, updatedAt, createdBy, updatedBy);
    }

    public Bank(String bankName, String accountId, String fundingSourceUrl, String shareableId, String userId) {
        this.bankName = bankName;
        this.accountId = accountId;
        this.fundingSourceUrl = fundingSourceUrl;
        this.shareableId = shareableId;
        this.userId = userId;
    }

    public Bank(String id, Date createdAt, Date updatedAt, String createdBy, String updatedBy, String bankName, String accountId, String fundingSourceUrl, String shareableId, String userId) {
        super(id, createdAt, updatedAt, createdBy, updatedBy);
        this.bankName = bankName;
        this.accountId = accountId;
        this.fundingSourceUrl = fundingSourceUrl;
        this.shareableId = shareableId;
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "bankName='" + bankName + '\'' +
                ", accountId='" + accountId + '\'' +
                ", fundingSourceUrl='" + fundingSourceUrl + '\'' +
                ", shareableId='" + shareableId + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getFundingSourceUrl() {
        return fundingSourceUrl;
    }

    public void setFundingSourceUrl(String fundingSourceUrl) {
        this.fundingSourceUrl = fundingSourceUrl;
    }

    public String getShareableId() {
        return shareableId;
    }

    public void setShareableId(String shareableId) {
        this.shareableId = shareableId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Bank bank = (Bank) o;
        return Objects.equals(bankName, bank.bankName) && Objects.equals(accountId, bank.accountId) && Objects.equals(fundingSourceUrl, bank.fundingSourceUrl) && Objects.equals(shareableId, bank.shareableId) && Objects.equals(userId, bank.userId);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(bankName);
        result = 31 * result + Objects.hashCode(accountId);
        result = 31 * result + Objects.hashCode(fundingSourceUrl);
        result = 31 * result + Objects.hashCode(shareableId);
        result = 31 * result + Objects.hashCode(userId);
        return result;
    }
}
