package com.leopoldhsing.horizon.service.account.service;

import com.leopoldhsing.horizon.model.dto.AccountDto;
import com.leopoldhsing.horizon.model.entity.Account;

import java.util.List;

public interface IAccountService {
    List<AccountDto> getAccountByUserId(Long uid);

    void saveAccountList(List<Account> accountList);

    AccountDto getAccountById(Long accountId);
}
