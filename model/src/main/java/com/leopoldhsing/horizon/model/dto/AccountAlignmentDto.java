package com.leopoldhsing.horizon.model.dto;

import java.util.List;

public class AccountAlignmentDto {
    private List<AccountDto> accountDtoList;
    private UserDto userDto;

    public AccountAlignmentDto() {
    }

    public AccountAlignmentDto(List<AccountDto> accountDtoList, UserDto userDto) {
        this.accountDtoList = accountDtoList;
        this.userDto = userDto;
    }

    public List<AccountDto> getAccountDtoList() {
        return accountDtoList;
    }

    public void setAccountDtoList(List<AccountDto> accountDtoList) {
        this.accountDtoList = accountDtoList;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }
}
