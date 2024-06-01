package com.leopoldhsing.horizon.model.dto;

import com.leopoldhsing.horizon.model.enumeration.DwollaCustomerStatus;
import com.leopoldhsing.horizon.model.enumeration.DwollaCustomerType;

import java.util.Objects;

public class DwollaCustomerDto {

    private String dwollaCustomerUrl;
    private DwollaCustomerType customerType;
    private DwollaCustomerStatus customerStatus;

    public DwollaCustomerDto(String dwollaCustomerUrl, DwollaCustomerType customerType, DwollaCustomerStatus customerStatus) {
        this.dwollaCustomerUrl = dwollaCustomerUrl;
        this.customerType = customerType;
        this.customerStatus = customerStatus;
    }

    @Override
    public String toString() {
        return "DwollaCustomerDto{" +
                "dwollaCustomerUrl='" + dwollaCustomerUrl + '\'' +
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

    public DwollaCustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(DwollaCustomerType customerType) {
        this.customerType = customerType;
    }

    public DwollaCustomerStatus getCustomerStatus() {
        return customerStatus;
    }

    public void setCustomerStatus(DwollaCustomerStatus customerStatus) {
        this.customerStatus = customerStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DwollaCustomerDto that = (DwollaCustomerDto) o;
        return Objects.equals(dwollaCustomerUrl, that.dwollaCustomerUrl) && customerType == that.customerType && customerStatus == that.customerStatus;
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(dwollaCustomerUrl);
        result = 31 * result + Objects.hashCode(customerType);
        result = 31 * result + Objects.hashCode(customerStatus);
        return result;
    }
}
