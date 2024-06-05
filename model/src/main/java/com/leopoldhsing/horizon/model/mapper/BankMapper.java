package com.leopoldhsing.horizon.model.mapper;

import com.leopoldhsing.horizon.model.dto.BankDto;
import com.leopoldhsing.horizon.model.entity.Bank;
import org.springframework.beans.BeanUtils;

public class BankMapper {
    public static Bank mapToBank(BankDto bankDto) {
        Bank bank = new Bank();
        BeanUtils.copyProperties(bankDto, bank);

        return bank;
    }

    public static BankDto mapToBankDto(Bank bank) {
        BankDto bankDto = new BankDto();
        BeanUtils.copyProperties(bank, bankDto);
        return bankDto;
    }

    private BankMapper() {
    }
}
