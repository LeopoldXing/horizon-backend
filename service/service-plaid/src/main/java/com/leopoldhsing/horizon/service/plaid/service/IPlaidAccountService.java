package com.leopoldhsing.horizon.service.plaid.service;

import com.leopoldhsing.horizon.model.entity.Account;

import java.io.IOException;
import java.util.List;

public interface IPlaidAccountService {
    List<Account> getAccountsFromPlaidByUserId(Long userId) throws IOException;
}
