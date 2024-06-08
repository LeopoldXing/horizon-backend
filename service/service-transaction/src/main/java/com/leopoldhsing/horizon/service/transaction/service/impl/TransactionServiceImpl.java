package com.leopoldhsing.horizon.service.transaction.service.impl;

import com.leopoldhsing.horizon.common.utils.RequestUtil;
import com.leopoldhsing.horizon.common.utils.exception.ActionNotAuthorizedException;
import com.leopoldhsing.horizon.feign.account.AccountFeignClient;
import com.leopoldhsing.horizon.feign.bank.BankFeignClient;
import com.leopoldhsing.horizon.feign.plaid.PlaidFeignClient;
import com.leopoldhsing.horizon.feign.user.UserFeignClient;
import com.leopoldhsing.horizon.model.dto.AccountDto;
import com.leopoldhsing.horizon.model.dto.BankDto;
import com.leopoldhsing.horizon.model.dto.TransactionDto;
import com.leopoldhsing.horizon.model.dto.UserDto;
import com.leopoldhsing.horizon.model.entity.Transaction;
import com.leopoldhsing.horizon.model.vo.TransactionVo;
import com.leopoldhsing.horizon.service.transaction.mapper.TransactionMapper2;
import com.leopoldhsing.horizon.service.transaction.repository.TransactionRepository;
import com.leopoldhsing.horizon.service.transaction.service.ITransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements ITransactionService {

    @Autowired
    private AccountFeignClient accountFeignClient;

    @Autowired
    private UserFeignClient userFeignClient;

    @Autowired
    private BankFeignClient bankFeignClient;

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private TransactionMapper2 transactionMapper;

    @Override
    public List<TransactionDto> getTransactionListByAccountId(Long accountId) {
        // 1. get userId
        Long userId = RequestUtil.getUid();

        // 2. check authorization for this action
        // 2.1 get account list [RPC]
        List<AccountDto> accountDtoList = accountFeignClient.getAccountsByUserId(userId);
        // 2.2 determine if the user has the authorization
        if (accountDtoList.stream().noneMatch(account -> accountId.equals(account.getId()))) {
            // this account is not under the current logged-in user
            throw new ActionNotAuthorizedException("getTransactionListByAccountId", userId);
        }

        // 3. get transaction list
        List<Transaction> transactionList = transactionRepository.findAllByAccountId(accountId);

        // 4. construct transactionDto
        // 4.1 get accountDto
        AccountDto accountDto = accountDtoList
                .stream()
                .filter(account -> accountId.equals(account.getId()))
                .toList().get(0);
        // 4.2 convert transaction -> transactionDto
        List<TransactionDto> transactionDtoList = transactionList
                .stream()
                .map(transaction -> {
                    TransactionDto transactionDto = transactionMapper.mapToTransactionDto(transaction);
                    transactionDto.setAccountDto(accountDto);
                    if (transaction.getSenderId() != null) {
                        UserDto sender = userFeignClient.getUser(transaction.getSenderId());
                        transactionDto.setSender(sender);
                    }
                    if (transaction.getReceiverId() != null) {
                        UserDto receiver = userFeignClient.getUser(transaction.getReceiverId());
                        transactionDto.setReceiver(receiver);
                    }
                    if (transaction.getReceiverBankId() != null) {
                        BankDto receiverBank = bankFeignClient.getBankById(transaction.getReceiverBankId());
                        transactionDto.setReceiverBank(receiverBank);
                    }
                    if (transaction.getSenderBankId() != null) {
                        BankDto senderBank = bankFeignClient.getBankById(transaction.getSenderBankId());
                        transactionDto.setSenderBank(senderBank);
                    }
                    return transactionDto;
                }).toList();

        // 5. return result
        return transactionDtoList;
    }

    @Override
    public void saveTransactionList(List<TransactionDto> transactionDtoList) {
        transactionRepository.saveAll(transactionDtoList
                .stream()
                .map(transactionMapper::mapToTransaction)
                .toList()
        );
    }

    @Override
    public TransactionDto createTransaction(TransactionVo transactionVo) {
        return null;
    }
}
