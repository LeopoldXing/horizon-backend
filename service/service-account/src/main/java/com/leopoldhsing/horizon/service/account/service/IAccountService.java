package com.leopoldhsing.horizon.service.account.service;

import com.leopoldhsing.horizon.model.dto.AccountDto;

import java.util.List;

public interface IAccountService {
    List<AccountDto> getAccountByUserId(Long uid);

    void saveAccountList(List<AccountDto> accountDtoList);
}
