package com.leopoldhsing.horizon.service.bank.service.impl;

import com.leopoldhsing.horizon.common.utils.exception.ResourceNotFoundException;
import com.leopoldhsing.horizon.model.dto.BankDto;
import com.leopoldhsing.horizon.model.entity.Account;
import com.leopoldhsing.horizon.model.entity.Bank;
import com.leopoldhsing.horizon.model.mapper.BankMapper;
import com.leopoldhsing.horizon.service.bank.repository.AccountRepository;
import com.leopoldhsing.horizon.service.bank.repository.BankRepository;
import com.leopoldhsing.horizon.service.bank.service.IBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class BankServiceImpl implements IBankService {

    @Autowired
    private BankRepository bankRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public List<BankDto> getBankListByUserId(Long userId) {
        // 1. get account list
        List<Account> accountList = accountRepository.findAccountsByOwnerId(userId);

        // 2. get unique bank ids then get all Bank information
        Set<Long> bankIdSet = new HashSet<>();
        accountList.forEach(account -> bankIdSet.add(account.getInstitutionId()));
        List<BankDto> bankList = bankIdSet.stream().map(bankId -> BankMapper.mapToBankDto(bankRepository.findById(bankId)
                .orElseThrow(() -> new ResourceNotFoundException("Bank", "bankId", String.valueOf(bankId)))
        )).toList();

        return bankList;
    }
}
