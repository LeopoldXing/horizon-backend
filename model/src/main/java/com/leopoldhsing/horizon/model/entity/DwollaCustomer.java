package com.leopoldhsing.horizon.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDateTime;
import java.util.Objects;

@Table(name = "dwolla_customer")
@Entity
public class DwollaCustomer extends BaseEntity {

    private String dwollaCustomerUrl;
    private String customerType;
    private String customerStatus;

    public DwollaCustomer() {
    }

    public DwollaCustomer(Long id, LocalDateTime createdAt, LocalDateTime updatedAt, String createdBy, String updatedBy) {
        super(id, createdAt, updatedAt, createdBy, updatedBy);
    }

    public DwollaCustomer(String dwollaCustomerUrl, String customerType, String customerStatus) {
        this.dwollaCustomerUrl = dwollaCustomerUrl;
        this.customerType = customerType;
        this.customerStatus = customerStatus;
    }

    public DwollaCustomer(Long id, LocalDateTime createdAt, LocalDateTime updatedAt, String createdBy, String updatedBy, String dwollaCustomerUrl, String customerType, String customerStatus) {
        super(id, createdAt, updatedAt, createdBy, updatedBy);
        this.dwollaCustomerUrl = dwollaCustomerUrl;
        this.customerType = customerType;
        this.customerStatus = customerStatus;
    }

    @Override
    public String toString() {
        return "DwollaCustomer{" +
                "dwollaCustomerUrl='" + dwollaCustomerUrl + '\'' +
                ", customerType='" + customerType + '\'' +
                ", customerStatus='" + customerStatus + '\'' +
                '}';
    }

    public String getDwollaCustomerUrl() {
        return dwollaCustomerUrl;
    }

    public void setDwollaCustomerUrl(String dwollaCustomerUrl) {
        this.dwollaCustomerUrl = dwollaCustomerUrl;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getCustomerStatus() {
        return customerStatus;
    }

    public void setCustomerStatus(String customerStatus) {
        this.customerStatus = customerStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        DwollaCustomer that = (DwollaCustomer) o;
        return Objects.equals(dwollaCustomerUrl, that.dwollaCustomerUrl) && Objects.equals(customerType, that.customerType) && Objects.equals(customerStatus, that.customerStatus);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + Objects.hashCode(dwollaCustomerUrl);
        result = 31 * result + Objects.hashCode(customerType);
        result = 31 * result + Objects.hashCode(customerStatus);
        return result;
    }
}
