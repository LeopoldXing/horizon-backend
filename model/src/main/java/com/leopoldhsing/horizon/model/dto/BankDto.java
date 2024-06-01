package com.leopoldhsing.horizon.model.dto;

import java.util.List;
import java.util.Objects;

public class BankDto {

    private String name;
    private String url;
    private String status;
    private List<String> countryCodeList;

    public BankDto() {
    }

    public BankDto(String name, String url, String status, List<String> countryCodeList) {
        this.name = name;
        this.url = url;
        this.status = status;
        this.countryCodeList = countryCodeList;
    }

    @Override
    public String toString() {
        return "BankDto{" +
                "name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", status='" + status + '\'' +
                ", countryCodeList=" + countryCodeList +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<String> getCountryCodeList() {
        return countryCodeList;
    }

    public void setCountryCodeList(List<String> countryCodeList) {
        this.countryCodeList = countryCodeList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BankDto bankDto = (BankDto) o;
        return Objects.equals(name, bankDto.name) && Objects.equals(url, bankDto.url) && Objects.equals(status, bankDto.status) && Objects.equals(countryCodeList, bankDto.countryCodeList);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(name);
        result = 31 * result + Objects.hashCode(url);
        result = 31 * result + Objects.hashCode(status);
        result = 31 * result + Objects.hashCode(countryCodeList);
        return result;
    }
}
