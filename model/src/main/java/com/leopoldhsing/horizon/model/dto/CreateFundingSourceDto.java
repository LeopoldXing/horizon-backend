package com.leopoldhsing.horizon.model.dto;

import java.util.Objects;

public class CreateFundingSourceDto {

    private UserDto userDto;
    private AccountDto accountDto;
    private String processorToken;

    public CreateFundingSourceDto() {
    }

    public CreateFundingSourceDto(UserDto userDto, AccountDto accountDto, String processorToken) {
        this.userDto = userDto;
        this.accountDto = accountDto;
        this.processorToken = processorToken;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }

    public AccountDto getAccountDto() {
        return accountDto;
    }

    public void setAccountDto(AccountDto accountDto) {
        this.accountDto = accountDto;
    }

    public String getProcessorToken() {
        return processorToken;
    }

    public void setProcessorToken(String processorToken) {
        this.processorToken = processorToken;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CreateFundingSourceDto that = (CreateFundingSourceDto) o;
        return Objects.equals(userDto, that.userDto) && Objects.equals(accountDto, that.accountDto) && Objects.equals(processorToken, that.processorToken);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(userDto);
        result = 31 * result + Objects.hashCode(accountDto);
        result = 31 * result + Objects.hashCode(processorToken);
        return result;
    }
}
