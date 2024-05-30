package com.leopoldhsing.horizon.model.dto;

import java.util.Objects;

public class DwollaCustomerDto {

    private String dwollaCustomerUrl;
    private String status;
    private Integer customerType;
    private Integer customerStatus;

    public DwollaCustomerDto() {
    }

    public DwollaCustomerDto(String dwollaCustomerUrl, String status, Integer customerType, Integer customerStatus) {
        this.dwollaCustomerUrl = dwollaCustomerUrl;
        this.status = status;
        this.customerType = customerType;
        this.customerStatus = customerStatus;
    }

    @Override
    public String toString() {
        return "DwollaCustomerDto{" +
                "dwollaCustomerUrl='" + dwollaCustomerUrl + '\'' +
                ", status='" + status + '\'' +
                ", customerType=" + customerType +
                ", customerStatus=" + customerStatus +
                '}';
    }

    public String getDwollaCustomerUrl() {
        return dwollaCustomerUrl;
    }

    public void setDwollaCustomerUrl(String dwollaCustomerUrl) {
        this.dwollaCustomerUrl = dwollaCustomerUrl;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getCustomerType() {
        return customerType;
    }

    public void setCustomerType(Integer customerType) {
        this.customerType = customerType;
    }

    public Integer getCustomerStatus() {
        return customerStatus;
    }

    public void setCustomerStatus(Integer customerStatus) {
        this.customerStatus = customerStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DwollaCustomerDto that = (DwollaCustomerDto) o;
        return Objects.equals(dwollaCustomerUrl, that.dwollaCustomerUrl) && Objects.equals(status, that.status) && Objects.equals(customerType, that.customerType) && Objects.equals(customerStatus, that.customerStatus);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(dwollaCustomerUrl);
        result = 31 * result + Objects.hashCode(status);
        result = 31 * result + Objects.hashCode(customerType);
        result = 31 * result + Objects.hashCode(customerStatus);
        return result;
    }
}
