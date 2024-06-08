package com.leopoldhsing.horizon.service.plaid.service;

import com.leopoldhsing.horizon.model.dto.AccountDto;

import java.io.IOException;
import java.util.List;

public interface IPlaidAccountService {

    List<AccountDto> getAccountsFromPlaidByUserId(Long userId) throws IOException;

}
