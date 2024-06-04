package com.leopoldhsing.horizon.model.dto;

import java.util.Objects;

public class PlaidCustomerDto {

    private String id;
    private String plaidId;
    private String shareableUrl;
    private String phoneNumber;

    public PlaidCustomerDto() {
    }

    public PlaidCustomerDto(String id, String plaidId, String shareableUrl, String phoneNumber) {
        this.id = id;
        this.plaidId = plaidId;
        this.shareableUrl = shareableUrl;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "PlaidCustomerDto{" +
                "id='" + id + '\'' +
                ", plaidId='" + plaidId + '\'' +
                ", shareableUrl='" + shareableUrl + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

        PlaidCustomerDto that = (PlaidCustomerDto) o;
        return Objects.equals(id, that.id) && Objects.equals(plaidId, that.plaidId) && Objects.equals(shareableUrl, that.shareableUrl) && Objects.equals(phoneNumber, that.phoneNumber);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(id);
        result = 31 * result + Objects.hashCode(plaidId);
        result = 31 * result + Objects.hashCode(shareableUrl);
        result = 31 * result + Objects.hashCode(phoneNumber);
        return result;
    }
}
