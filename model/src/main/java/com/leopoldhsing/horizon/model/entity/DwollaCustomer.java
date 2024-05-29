package com.leopoldhsing.horizon.model.entity;

import jakarta.persistence.Entity;

import java.util.Date;
import java.util.Objects;

@Entity
public class DwollaCustomer extends BaseEntity {

    private String dwollaCustomerUrl;

    private String status;

    private Integer customerType;

    private Integer customerStatus;

    public DwollaCustomer() {
    }

    public DwollaCustomer(String id, Date createdAt, Date updatedAt, String createdBy, String updatedBy) {
        super(id, createdAt, updatedAt, createdBy, updatedBy);
    }

    public DwollaCustomer(String dwollaCustomerUrl, String status, Integer customerType, Integer customerStatus) {
        this.dwollaCustomerUrl = dwollaCustomerUrl;
        this.status = status;
        this.customerType = customerType;
        this.customerStatus = customerStatus;
    }

    public DwollaCustomer(String id, Date createdAt, Date updatedAt, String createdBy, String updatedBy, String dwollaCustomerUrl, String status, Integer customerType, Integer customerStatus) {
        super(id, createdAt, updatedAt, createdBy, updatedBy);
        this.dwollaCustomerUrl = dwollaCustomerUrl;
        this.status = status;
        this.customerType = customerType;
        this.customerStatus = customerStatus;
    }

    @Override
    public String toString() {
        return "DwollaCustomer{" +
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
        if (!super.equals(o)) return false;

        DwollaCustomer that = (DwollaCustomer) o;
        return Objects.equals(dwollaCustomerUrl, that.dwollaCustomerUrl) && Objects.equals(status, that.status) && Objects.equals(customerType, that.customerType) && Objects.equals(customerStatus, that.customerStatus);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(dwollaCustomerUrl);
        result = 31 * result + Objects.hashCode(status);
        result = 31 * result + Objects.hashCode(customerType);
        result = 31 * result + Objects.hashCode(customerStatus);
        return result;
    }
}
