package com.leopoldhsing.horizon.model.dto;

import java.util.Objects;

public class BankDto {

    private String bankName;
    private String accountId;
    private String fundingSourceUrl;
    private String shareableId;
    private UserDto userDto;

    public BankDto() {
    }

    public BankDto(String bankName, String accountId, String fundingSourceUrl, String shareableId, UserDto userDto) {
        this.bankName = bankName;
        this.accountId = accountId;
        this.fundingSourceUrl = fundingSourceUrl;
        this.shareableId = shareableId;
        this.userDto = userDto;
    }

    @Override
    public String toString() {
        return "BankDto{" +
                "bankName='" + bankName + '\'' +
                ", accountId='" + accountId + '\'' +
                ", fundingSourceUrl='" + fundingSourceUrl + '\'' +
                ", shareableId='" + shareableId + '\'' +
                ", userDto=" + userDto +
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

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BankDto bankDto = (BankDto) o;
        return Objects.equals(bankName, bankDto.bankName) && Objects.equals(accountId, bankDto.accountId) && Objects.equals(fundingSourceUrl, bankDto.fundingSourceUrl) && Objects.equals(shareableId, bankDto.shareableId) && Objects.equals(userDto, bankDto.userDto);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(bankName);
        result = 31 * result + Objects.hashCode(accountId);
        result = 31 * result + Objects.hashCode(fundingSourceUrl);
        result = 31 * result + Objects.hashCode(shareableId);
        result = 31 * result + Objects.hashCode(userDto);
        return result;
    }
}
