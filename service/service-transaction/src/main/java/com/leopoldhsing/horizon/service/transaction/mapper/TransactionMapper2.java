package com.leopoldhsing.horizon.service.transaction.mapper;

import com.leopoldhsing.horizon.feign.account.AccountFeignClient;
import com.leopoldhsing.horizon.feign.user.UserFeignClient;
import com.leopoldhsing.horizon.model.dto.AccountDto;
import com.leopoldhsing.horizon.model.dto.TransactionDto;
import com.leopoldhsing.horizon.model.dto.UserDto;
import com.leopoldhsing.horizon.model.entity.Transaction;
import com.leopoldhsing.horizon.model.enumeration.TransactionStatus;
import com.leopoldhsing.horizon.model.vo.TransactionResponseVo;
import com.leopoldhsing.horizon.model.vo.TransactionVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Objects;

@Component
public class TransactionMapper2 {

    @Autowired
    private AccountFeignClient accountFeignClient;

    @Autowired
    private UserFeignClient userFeignClient;

    public Transaction mapToTransaction(TransactionDto transactionDto) {
        Transaction transaction = new Transaction();
        BeanUtils.copyProperties(transactionDto, transaction);
        transaction.setSenderId(transactionDto.getSender() == null ? null : transactionDto.getSender().getId());
        transaction.setReceiverId(transactionDto.getReceiver() == null ? null : transactionDto.getReceiver().getId());
        transaction.setSenderAccountId(transactionDto.getSenderAccount() == null ? null : transactionDto.getSenderAccount().getId());
        transaction.setReceiverAccountId(transactionDto.getReceiverAccount() == null ? null : transactionDto.getReceiverAccount().getId());
        return transaction;
    }

    public Transaction mapToTransaction(TransactionVo transactionVo) {
        Transaction transaction = new Transaction();
        BeanUtils.copyProperties(transactionVo, transaction);
        transaction.setAmount(new BigDecimal(transactionVo.getAmount()));
        transaction.setSenderId(Long.parseLong(transactionVo.getSenderId()));
        transaction.setReceiverId(Long.parseLong(transactionVo.getReceiverId()));
        transaction.setSenderAccountId(Long.parseLong(transactionVo.getSenderBankId()));
        transaction.setReceiverAccountId(Long.parseLong(transactionVo.getReceiverBankId()));
        return transaction;
    }

    public TransactionDto mapToTransactionDto(Transaction transaction) {
        TransactionDto transactionDto = new TransactionDto();
        BeanUtils.copyProperties(transaction, transactionDto);
        transactionDto.setSender(userFeignClient.getUser(transaction.getSenderId()));
        transactionDto.setReceiver(userFeignClient.getUser(transaction.getReceiverId()));
        transactionDto.setReceiverAccount(accountFeignClient.getAccountById(transaction.getReceiverAccountId()));
        transactionDto.setSenderAccount(accountFeignClient.getAccountById(transaction.getSenderAccountId()));
        return transactionDto;
    }

    public TransactionDto mapToTransactionDto(Transaction transaction, AccountDto senderAccount, AccountDto receiverAccount) {
        TransactionDto transactionDto = new TransactionDto();
        BeanUtils.copyProperties(transaction, transactionDto);
        transactionDto.setSender(userFeignClient.getUser(transaction.getSenderId()));
        transactionDto.setReceiver(userFeignClient.getUser(transaction.getReceiverId()));
        transactionDto.setReceiverAccount(senderAccount);
        transactionDto.setSenderAccount(receiverAccount);
        return transactionDto;
    }

    public TransactionDto mapToTransactionDto(Transaction transaction, AccountDto senderAccount, AccountDto receiverAccount, UserDto sender) {
        TransactionDto transactionDto = new TransactionDto();
        BeanUtils.copyProperties(transaction, transactionDto);
        transactionDto.setSender(sender);
        transactionDto.setReceiver(userFeignClient.getUser(transaction.getReceiverId()));
        transactionDto.setReceiverAccount(receiverAccount);
        transactionDto.setSenderAccount(senderAccount);
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
        transactionResponseVo.setDate(String.valueOf(transaction.getDate()));
        transactionResponseVo.setAmount(transaction.getAmount().doubleValue());
        transactionResponseVo.setPending(Objects.equals(transaction.getStatus(), TransactionStatus.PENDING.toString()));
        transactionResponseVo.set$createdAt(String.valueOf(transaction.getCreatedAt()));
        return transactionResponseVo;
    }
}
