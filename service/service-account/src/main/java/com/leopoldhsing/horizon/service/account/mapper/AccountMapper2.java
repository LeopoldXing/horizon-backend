package com.leopoldhsing.horizon.service.account.mapper;

import com.leopoldhsing.horizon.feign.bank.BankFeignClient;
import com.leopoldhsing.horizon.feign.user.UserFeignClient;
import com.leopoldhsing.horizon.model.dto.AccountDto;
import com.leopoldhsing.horizon.model.dto.BankDto;
import com.leopoldhsing.horizon.model.dto.UserDto;
import com.leopoldhsing.horizon.model.entity.Account;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper2 {

    @Autowired
    private BankFeignClient bankFeignClient;

    @Autowired
    private UserFeignClient userFeignClient;

    public Account mapToAccount(AccountDto accountDto) {
        Account account = new Account();
        BeanUtils.copyProperties(accountDto, account);
        account.setOwnerId(accountDto.getOwner() == null ? null : accountDto.getOwner().getId());
        account.setInstitutionId(accountDto.getInstitution() == null ? null : accountDto.getInstitution().getInstitutionId());
        account.setBankId(accountDto.getInstitution() == null ? null : bankFeignClient.getBankByInstitutionId(account.getInstitutionId()).getId());
        return account;
    }

    public AccountDto mapToAccountDto(Account account) {
        AccountDto accountDto = new AccountDto();
        BeanUtils.copyProperties(account, accountDto);
        BankDto bankDto = bankFeignClient.getBankByInstitutionId(account.getInstitutionId());
        accountDto.setInstitution(bankDto);
        UserDto userDto = userFeignClient.getUser(account.getOwnerId());
        accountDto.setOwner(userDto);
        return accountDto;
    }
}
