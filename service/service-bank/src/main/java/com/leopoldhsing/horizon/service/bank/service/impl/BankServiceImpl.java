package com.leopoldhsing.horizon.service.bank.service.impl;

import com.leopoldhsing.horizon.common.utils.exception.ResourceNotFoundException;
import com.leopoldhsing.horizon.feign.account.AccountFeignClient;
import com.leopoldhsing.horizon.model.dto.AccountDto;
import com.leopoldhsing.horizon.model.dto.BankDto;
import com.leopoldhsing.horizon.model.entity.Bank;
import com.leopoldhsing.horizon.model.mapper.BankMapper;
import com.leopoldhsing.horizon.service.bank.repository.BankRepository;
import com.leopoldhsing.horizon.service.bank.service.IBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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

    @Override
    public BankDto getBankByInstitutionId(String institutionId) {
        Bank bank = bankRepository.findBankByInstitutionId(institutionId).orElseThrow(
                () -> new ResourceNotFoundException("Bank", "institutionId", institutionId)
        );
        return BankMapper.mapToBankDto(bank);
    }

    @Override
    public void alignBankInformation(BankDto bankDto) {
        Optional<Bank> optionalBank = bankRepository.findBankByInstitutionId(bankDto.getInstitutionId());
        if (optionalBank.isEmpty()) {
            bankDto.setName(new Random(10000).toString());
            bankDto.setUrl("http://www.google.com/?random=" + new Random(100));
            bankDto.setStatus("normal");
            bankRepository.save(BankMapper.mapToBank(bankDto));
        }
    }

    @Override
    public BankDto getBankById(Long id) {
        Bank bank = bankRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Bank", "id", String.valueOf(id))
        );
        BankDto bankDto = BankMapper.mapToBankDto(bank);
        return bankDto;
    }
}
