package com.leopoldhsing.horizon.service.account.mapper;

import com.leopoldhsing.horizon.feign.bank.BankFeignClient;
import com.leopoldhsing.horizon.feign.transaction.TransactionFeignClient;
import com.leopoldhsing.horizon.feign.user.UserFeignClient;
import com.leopoldhsing.horizon.model.dto.AccountDto;
import com.leopoldhsing.horizon.model.dto.BankDto;
import com.leopoldhsing.horizon.model.dto.UserDto;
import com.leopoldhsing.horizon.model.entity.Account;
import com.leopoldhsing.horizon.model.vo.AccountResponseVo;
import com.leopoldhsing.horizon.model.vo.TransactionResponseVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AccountMapper2 {

    @Autowired
    private BankFeignClient bankFeignClient;

    @Autowired
    private UserFeignClient userFeignClient;

    @Autowired
    private TransactionFeignClient transactionFeignClient;

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

    public AccountResponseVo mapToAccountResponseVo(Account account) {
        AccountResponseVo vo = new AccountResponseVo();
        BeanUtils.copyProperties(account, vo);
        vo.setId(String.valueOf(account.getId()));
        vo.set$id(vo.getId());
        vo.setAvailableBalance(account.getAvailableBalance() == null ? 0 : account.getAvailableBalance().doubleValue());
        vo.setCurrentBalance(account.getCurrentBalance() == null ? 0 : account.getCurrentBalance().doubleValue());
        // transaction list
        List<TransactionResponseVo> transactionResponseVoList = transactionFeignClient.getTransactionListByAccountId(account.getId());
        vo.setTransactionList(transactionResponseVoList);
        return vo;
    }

    public AccountResponseVo mapToAccountResponseVo(AccountDto accountDto) {
        return mapToAccountResponseVo(mapToAccount(accountDto));
    }
}
