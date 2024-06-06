package com.leopoldhsing.horizon.service.bank.service.impl;

import com.leopoldhsing.horizon.feign.account.AccountFeignClient;
import com.leopoldhsing.horizon.model.dto.AccountDto;
import com.leopoldhsing.horizon.model.dto.BankDto;
import com.leopoldhsing.horizon.model.mapper.BankMapper;
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
    private AccountFeignClient accountFeignClient;

    @Override
    public List<BankDto> getBankListByUserId(Long userId) {
        // 1. get account list [RPC]
        List<AccountDto> accountList = accountFeignClient.getAccountsByUserId(userId);

        // 2. get unique bank ids then get all Bank information
        Set<Long> bankIdSet = new HashSet<>();
        accountList.forEach(account -> bankIdSet.add(account.getInstitution().getId()));
        List<BankDto> bankList = bankRepository.findAllById(bankIdSet)
                .parallelStream()
                .map(BankMapper::mapToBankDto)
                .toList();

        return bankList;
    }
}
