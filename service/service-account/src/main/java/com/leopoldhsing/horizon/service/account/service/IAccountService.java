package com.leopoldhsing.horizon.service.account.service;

import com.leopoldhsing.horizon.model.dto.AccountDto;

import java.util.List;

public interface IAccountService {
    List<AccountDto> getAccountByUserId(Long uid);

    List<AccountDto> saveAccountList(List<AccountDto> accountList);

    AccountDto getAccountById(Long accountId);

    AccountDto getAccountByPlaidAccountId(String plaidAccountId);

}
