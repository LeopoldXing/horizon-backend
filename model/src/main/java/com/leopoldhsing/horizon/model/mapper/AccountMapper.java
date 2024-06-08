package com.leopoldhsing.horizon.model.mapper;

import com.leopoldhsing.horizon.model.dto.AccountDto;
import com.leopoldhsing.horizon.model.entity.Account;
import org.springframework.beans.BeanUtils;

public class AccountMapper {

    public static Account mapToAccount(AccountDto accountDto) {
        Account account = new Account();
        BeanUtils.copyProperties(accountDto, account);
        account.setOwnerId(accountDto.getOwner() == null ? null : accountDto.getOwner().getId());
        account.setInstitutionId(accountDto.getInstitution() == null ? null : accountDto.getInstitution().getInstitutionId());
        return account;
    }

    public static AccountDto mapToAccountDto(Account account) {
        AccountDto accountDto = new AccountDto();
        BeanUtils.copyProperties(account, accountDto);
        return accountDto;
    }

    private AccountMapper() {}
}
