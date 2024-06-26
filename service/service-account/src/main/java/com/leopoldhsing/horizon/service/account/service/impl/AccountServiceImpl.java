package com.leopoldhsing.horizon.service.account.service.impl;

import com.leopoldhsing.horizon.common.utils.Base64Util;
import com.leopoldhsing.horizon.common.utils.exception.ResourceNotFoundException;
import com.leopoldhsing.horizon.feign.dwolla.DwollaFeignClient;
import com.leopoldhsing.horizon.feign.plaid.PlaidFeignClient;
import com.leopoldhsing.horizon.model.dto.AccountDto;
import com.leopoldhsing.horizon.model.dto.DwollaCustomerDto;
import com.leopoldhsing.horizon.model.dto.ProcessorTokenCreationDto;
import com.leopoldhsing.horizon.model.dto.UserDto;
import com.leopoldhsing.horizon.model.entity.Account;
import com.leopoldhsing.horizon.model.mapper.AccountMapper;
import com.leopoldhsing.horizon.service.account.mapper.AccountMapper2;
import com.leopoldhsing.horizon.service.account.repository.AccountRepository;
import com.leopoldhsing.horizon.service.account.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.nio.charset.StandardCharsets;
import java.util.List;

@Service
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private AccountMapper2 accountMapper2;

    @Autowired
    private PlaidFeignClient plaidFeignClient;

    @Autowired
    private DwollaFeignClient dwollaFeignClient;

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
                    saved.setShareableId(Base64Util.encode(String.valueOf(saved.getId()).getBytes(StandardCharsets.UTF_8)));
                    accountRepository.save(saved);
                    accountDto.setId(saved.getId());
                    accountDto.setShareableId(saved.getShareableId());
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

    @Override
    public List<AccountDto> alignAccountInfo(List<AccountDto> accountDtoList, UserDto userDto) {
        if (CollectionUtils.isEmpty(accountDtoList)) return accountDtoList;
        accountDtoList = accountDtoList
                .stream()
                .peek(accountDto -> accountRepository.findAccountByPlaidAccountId(accountDto.getPlaidAccountId())
                        .ifPresentOrElse(account -> {
                            // account exits, check if it has a funding source url
                            String fundingSourceUrl = account.getFundingSourceUrl();
                            if (!StringUtils.hasLength(fundingSourceUrl)) {
                                // 1. get processorToken [RPC]
                                String processorToken = plaidFeignClient.getProcessorToken(new ProcessorTokenCreationDto(userDto, accountDto));

                                // 2. create funding source
                                String url = this.createFundingSource(userDto, accountDto, processorToken);

                                // 3. set funding source url into the object, then persist the update into database
                                account.setFundingSourceUrl(url);
                                accountRepository.save(account);
                            }
                            accountDto.setId(account.getId());
                            accountDto.setShareableId(Base64Util.encode(String.valueOf(account.getId()).getBytes(StandardCharsets.UTF_8)));
                        }, () -> {
                            // account doesn't exist, create funding source then store in the database
                            // 1. get processorToken [RPC]
                            String processorToken = plaidFeignClient.getProcessorToken(new ProcessorTokenCreationDto(userDto, accountDto));

                            // 2. create funding source
                            String fundingSourceUrl = this.createFundingSource(userDto, accountDto, processorToken);

                            // 3. add funding source url into account object
                            accountDto.setFundingSourceUrl(fundingSourceUrl);

                            // 4. save to database
                            Account savedAccount = accountRepository.save(accountMapper2.mapToAccount(accountDto));
                            savedAccount.setShareableId(Base64Util.encode(String.valueOf(savedAccount.getId()).getBytes(StandardCharsets.UTF_8)));
                            accountRepository.save(savedAccount);
                            accountDto.setId(savedAccount.getId());
                            accountDto.setShareableId(savedAccount.getShareableId());
                            accountDto.setId(savedAccount.getId());
                        })
                ).toList();

        return accountDtoList;
    }

    @Override
    public String createFundingSource(UserDto userDto, AccountDto accountDto, String processorToken) {
        // 1. get DwollaCustomerDto info
        DwollaCustomerDto dwollaCustomerDto = null;
        if (!ObjectUtils.isEmpty(userDto)) {
            dwollaCustomerDto = userDto.getDwollaCustomerDto();
        }
        String dwollaCustomerId = null;
        if (!ObjectUtils.isEmpty(dwollaCustomerDto)) {
            String dwollaCustomerUrl = dwollaCustomerDto.getDwollaCustomerUrl();
            if (StringUtils.hasLength(dwollaCustomerUrl)) {
                String[] split = dwollaCustomerUrl.split("/");
                dwollaCustomerId = split[split.length - 1];
            }
        }

        // 2. Create a funding source URL for the account using the Dwolla customer id, processor token, and bank name [RPC]
        String fundingSourceUrl = dwollaFeignClient.createFundingSource(dwollaCustomerId, processorToken, accountDto);

        return fundingSourceUrl;
    }

    @Override
    public Long getOwnerIdByAccountId(Long accountId) {
        Account account = accountRepository.findById(accountId).orElseThrow(
                () -> new ResourceNotFoundException("Account", "accountId", String.valueOf(accountId))
        );

        return account.getOwnerId();
    }

}
