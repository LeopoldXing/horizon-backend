package com.leopoldhsing.horizon.service.account.service.impl;

import com.leopoldhsing.horizon.common.utils.exception.ResourceNotFoundException;
import com.leopoldhsing.horizon.model.dto.AccountDto;
import com.leopoldhsing.horizon.model.entity.Account;
import com.leopoldhsing.horizon.model.mapper.AccountMapper;
import com.leopoldhsing.horizon.service.account.mapper.AccountMapper2;
import com.leopoldhsing.horizon.service.account.repository.AccountRepository;
import com.leopoldhsing.horizon.service.account.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountMapper2 accountMapper2;

    @Override
    public List<AccountDto> getAccountByUserId(Long uid) {
        List<Account> accountList = accountRepository.findAccountsByOwnerId(uid);
        List<AccountDto> accountDtoList = accountList
                .stream()
                .map(account -> accountMapper2.mapToAccountDto(account))
                .toList();
        return accountDtoList;
    }

    @Override
    public List<AccountDto> saveAccountList(List<AccountDto> accountDtoList) {
        List<AccountDto> savedAccountDtoList = accountDtoList
                .stream()
                .peek(accountDto -> {
                    Account account = accountMapper2.mapToAccount(accountDto);
                    Account saved = accountRepository.save(account);
                    accountDto.setId(saved.getId());
                }).toList();
        return savedAccountDtoList;
    }

    @Override
    public AccountDto getAccountById(Long accountId) {
        Account account = accountRepository.findById(accountId).orElseThrow(
                () -> new ResourceNotFoundException("Account", "accountId", String.valueOf(accountId))
        );
        AccountDto accountDto = AccountMapper.mapToAccountDto(account);
        return accountDto;
    }

    @Override
    public AccountDto getAccountByPlaidAccountId(String plaidAccountId) {
        Account account = accountRepository.findAccountByPlaidAccountId(plaidAccountId).orElseThrow(
                () -> new ResourceNotFoundException("Account", "plaidAccountId", plaidAccountId)
        );
        return accountMapper2.mapToAccountDto(account);
    }

}
