package com.leopoldhsing.horizon.service.transaction.mapper;

import com.leopoldhsing.horizon.feign.account.AccountFeignClient;
import com.leopoldhsing.horizon.feign.bank.BankFeignClient;
import com.leopoldhsing.horizon.feign.user.UserFeignClient;
import com.leopoldhsing.horizon.model.dto.TransactionDto;
import com.leopoldhsing.horizon.model.entity.Transaction;
import com.leopoldhsing.horizon.model.enumeration.TransactionStatus;
import com.leopoldhsing.horizon.model.vo.TransactionResponseVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class TransactionMapper2 {

    @Autowired
    private AccountFeignClient accountFeignClient;

    @Autowired
    private UserFeignClient userFeignClient;

    @Autowired
    private BankFeignClient bankFeignClient;

    public Transaction mapToTransaction(TransactionDto transactionDto) {
        Transaction transaction = new Transaction();
        BeanUtils.copyProperties(transactionDto, transaction);
        transaction.setAccountId(transactionDto.getAccountDto() == null ? null : transactionDto.getAccountDto().getId());
        transaction.setSenderId(transactionDto.getSender() == null ? null : transactionDto.getSender().getId());
        transaction.setReceiverId(transactionDto.getReceiver() == null ? null : transactionDto.getReceiver().getId());
        transaction.setSenderBankId(transactionDto.getSenderBank() == null ? null : transactionDto.getSenderBank().getId());
        transaction.setReceiverBankId(transactionDto.getReceiverBank() == null ? null : transactionDto.getReceiverBank().getId());
        return transaction;
    }

    public TransactionDto mapToTransactionDto(Transaction transaction) {
        TransactionDto transactionDto = new TransactionDto();
        BeanUtils.copyProperties(transaction, transactionDto);
        transactionDto.setAccountDto(accountFeignClient.getAccountById(transaction.getAccountId()));
        transactionDto.setSender(userFeignClient.getUser(transaction.getSenderId()));
        transactionDto.setReceiver(userFeignClient.getUser(transaction.getReceiverId()));
        transactionDto.setReceiverBank(bankFeignClient.getBankById(transaction.getReceiverBankId()));
        transactionDto.setSenderBank(bankFeignClient.getBankById(transaction.getSenderBankId()));
        return transactionDto;
    }

    public TransactionResponseVo mapToTransactionResponseVo(TransactionDto transactionDto) {
        return mapToTransactionResponseVo(mapToTransaction(transactionDto));
    }

    public TransactionResponseVo mapToTransactionResponseVo(Transaction transaction) {
        TransactionResponseVo transactionResponseVo = new TransactionResponseVo();
        BeanUtils.copyProperties(transaction, transactionResponseVo);
        transactionResponseVo.setId(String.valueOf(transaction.getId()));
        transactionResponseVo.set$id(String.valueOf(transaction.getId()));
        transactionResponseVo.setPaymentChannel(transaction.getChannel());
        transactionResponseVo.setAccountId(String.valueOf(transaction.getAccountId()));
        transactionResponseVo.setDate(String.valueOf(transaction.getDate()));
        transactionResponseVo.setAmount(transaction.getAmount().doubleValue());
        transactionResponseVo.setPending(Objects.equals(transaction.getStatus(), TransactionStatus.PENDING.toString()));
        transactionResponseVo.set$createdAt(String.valueOf(transaction.getCreatedAt()));
        return transactionResponseVo;
    }
}
