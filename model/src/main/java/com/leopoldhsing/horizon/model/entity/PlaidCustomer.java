package com.leopoldhsing.horizon.model.entity;

import jakarta.persistence.Entity;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity(name = "plaid_customers")
public class PlaidCustomer extends BaseEntity {

    private String plaidId;
    private String shareableUrl;
    private String phoneNumber;

    public PlaidCustomer() {
    }

    public PlaidCustomer(Long id, LocalDateTime createdAt, LocalDateTime updatedAt, String createdBy, String updatedBy) {
        super(id, createdAt, updatedAt, createdBy, updatedBy);
    }

    public PlaidCustomer(String plaidId, String shareableUrl, String phoneNumber) {
        this.plaidId = plaidId;
        this.shareableUrl = shareableUrl;
        this.phoneNumber = phoneNumber;
    }

    public PlaidCustomer(Long id, LocalDateTime createdAt, LocalDateTime updatedAt, String createdBy, String updatedBy, String plaidId, String shareableUrl, String phoneNumber) {
        super(id, createdAt, updatedAt, createdBy, updatedBy);
        this.plaidId = plaidId;
        this.shareableUrl = shareableUrl;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "PlaidCustomer{" +
                "plaidId='" + plaidId + '\'' +
                ", shareableUrl='" + shareableUrl + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    public String getPlaidId() {
        return plaidId;
    }

    public void setPlaidId(String plaidId) {
        this.plaidId = plaidId;
    }

    public String getShareableUrl() {
        return shareableUrl;
    }

    public void setShareableUrl(String shareableUrl) {
        this.shareableUrl = shareableUrl;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        PlaidCustomer that = (PlaidCustomer) o;
        return Objects.equals(plaidId, that.plaidId) && Objects.equals(shareableUrl, that.shareableUrl) && Objects.equals(phoneNumber, that.phoneNumber);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(plaidId);
        result = 31 * result + Objects.hashCode(shareableUrl);
        result = 31 * result + Objects.hashCode(phoneNumber);
        return result;
    }
}
