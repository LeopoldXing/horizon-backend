package com.leopoldhsing.horizon.model.dto;

public class ProcessorTokenCreationDto {
    private UserDto userDto;
    private AccountDto accountDto;

    public ProcessorTokenCreationDto() {
    }

    public ProcessorTokenCreationDto(UserDto userDto, AccountDto accountDto) {
        this.userDto = userDto;
        this.accountDto = accountDto;
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
}
