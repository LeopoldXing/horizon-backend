package com.leopoldhsing.horizon.service.account.service.impl;

import com.leopoldhsing.horizon.model.dto.AccountDto;
import com.leopoldhsing.horizon.model.entity.Account;
import com.leopoldhsing.horizon.model.mapper.AccountMapper;
import com.leopoldhsing.horizon.service.account.repository.AccountRepository;
import com.leopoldhsing.horizon.service.account.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public List<AccountDto> getAccountByUserId(Long uid) {
        List<Account> accountList = accountRepository.findAccountsByOwnerId(uid);
        List<AccountDto> accountDtoList = accountList.parallelStream().map(AccountMapper::mapToAccountDto).toList();
        return accountDtoList;
    }

    @Override
    public void saveAccountList(List<AccountDto> accountDtoList) {
        List<Account> accountList = new ArrayList<>();
        if (!CollectionUtils.isEmpty(accountDtoList)) {
            accountList = accountDtoList.stream().map(AccountMapper::mapToAccount).toList();
        }

        accountRepository.saveAll(accountList);
    }

}
