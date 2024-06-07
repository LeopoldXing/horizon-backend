package com.leopoldhsing.horizon.service.transaction.service.impl;

import com.leopoldhsing.horizon.common.utils.RequestUtil;
import com.leopoldhsing.horizon.common.utils.exception.ActionNotAuthorizedException;
import com.leopoldhsing.horizon.feign.plaid.PlaidFeignClient;
import com.leopoldhsing.horizon.model.dto.AccountDto;
import com.leopoldhsing.horizon.model.dto.TransactionDto;
import com.leopoldhsing.horizon.model.entity.Account;
import com.leopoldhsing.horizon.model.entity.Transaction;
import com.leopoldhsing.horizon.model.mapper.AccountMapper;
import com.leopoldhsing.horizon.model.mapper.TransactionMapper;
import com.leopoldhsing.horizon.service.transaction.repository.TransactionRepository;
import com.leopoldhsing.horizon.service.transaction.service.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements ITransactionService {

    @Autowired
    private PlaidFeignClient plaidFeignClient;

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public List<TransactionDto> getTransactionListByAccountId(Long accountId) {
        // 1. get userId
        Long userId = RequestUtil.getUid();

        // 2. check authorization for this action
        // 2.1 get accountInfo from plaid [RPC]
        List<Account> accountList = plaidFeignClient.getAccountsFromPlaidByUserId(userId);
        // 2.2 determine if the user has the authorization
        if (accountList.stream().noneMatch(account -> accountId.equals(account.getId()))) {
            // this account is not under the current logged-in user
            throw new ActionNotAuthorizedException("getTransactionListByAccountId", userId);
        }

        // 3. get transaction list
        List<Transaction> transactionList = transactionRepository.findAllByAccountId(accountId);

        // 4. construct transactionDto
        // 4.1 get accountDto
        AccountDto accountDto = accountList
                .stream()
                .filter(account -> accountId.equals(account.getId()))
                .map(AccountMapper::mapToAccountDto)
                .toList().get(0);
        // 4.2 convert transaction -> transactionDto
        List<TransactionDto> transactionDtoList = transactionList
                .stream()
                .map(transaction -> {
                    TransactionDto transactionDto = TransactionMapper.mapToTransactionDto(transaction);
                    transactionDto.setAccountDto(accountDto);
                    return transactionDto;
                }).toList();

        // 5. return result
        return transactionDtoList;
    }
}
