package com.leopoldhsing.horizon.service.transaction.mapper;

import com.leopoldhsing.horizon.feign.account.AccountFeignClient;
import com.leopoldhsing.horizon.feign.user.UserFeignClient;
import com.leopoldhsing.horizon.model.dto.AccountDto;
import com.leopoldhsing.horizon.model.dto.CategoryDto;
import com.leopoldhsing.horizon.model.dto.TransactionDto;
import com.leopoldhsing.horizon.model.dto.UserDto;
import com.leopoldhsing.horizon.model.entity.Category;
import com.leopoldhsing.horizon.model.entity.Transaction;
import com.leopoldhsing.horizon.model.enumeration.TransactionStatus;
import com.leopoldhsing.horizon.model.vo.TransactionCreationVo;
import com.leopoldhsing.horizon.model.vo.TransactionResponseVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

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
        List<CategoryDto> categoryDtos = transactionDto.getCategories();
        if (!CollectionUtils.isEmpty(categoryDtos)) {
            transaction.setCategories(categoryDtos.stream().map(CategoryMapper::mapToCategory).collect(Collectors.toSet()));
        }
        return transaction;
    }

    public Transaction mapToTransaction(TransactionCreationVo transactionCreationVo) {
        Transaction transaction = new Transaction();
        BeanUtils.copyProperties(transactionCreationVo, transaction);
        transaction.setAmount(new BigDecimal(transactionCreationVo.getAmount()));
        transaction.setSenderAccountId(Long.parseLong(transactionCreationVo.getSenderAccountId()));
        return transaction;
    }

    public TransactionDto mapToTransactionDto(Transaction transaction) {
        TransactionDto transactionDto = new TransactionDto();
        BeanUtils.copyProperties(transaction, transactionDto);
        if (transaction.getSenderId() != null) {
            transactionDto.setSender(userFeignClient.getUser(transaction.getSenderId()));
        } else {
            transactionDto.setSender(new UserDto());
        }
        if (transaction.getReceiverId() != null) {
            transactionDto.setReceiver(userFeignClient.getUser(transaction.getReceiverId()));
        } else {
            transactionDto.setReceiver(new UserDto());
        }
        if (transaction.getSenderAccountId() != null) {
            transactionDto.setSenderAccount(accountFeignClient.getAccountById(transaction.getSenderAccountId()));
        } else {
            transactionDto.setSenderAccount(new AccountDto());
        }
        if (transaction.getReceiverAccountId() != null) {
            transactionDto.setReceiverAccount(accountFeignClient.getAccountById(transaction.getReceiverAccountId()));
        } else {
            transactionDto.setReceiverAccount(new AccountDto());
        }
        Set<Category> categories = transaction.getCategories();
        if (!CollectionUtils.isEmpty(categories)) {
            transactionDto.setCategories(categories.stream().map(CategoryMapper::mapToCategoryDto).toList());
        }
        return transactionDto;
    }

    public TransactionDto mapToTransactionDto(Transaction transaction, AccountDto senderAccount, AccountDto receiverAccount) {
        TransactionDto transactionDto = new TransactionDto();
        BeanUtils.copyProperties(transaction, transactionDto);
        transactionDto.setSender(userFeignClient.getUser(transaction.getSenderId()));
        transactionDto.setReceiver(userFeignClient.getUser(transaction.getReceiverId()));
        transactionDto.setReceiverAccount(senderAccount);
        transactionDto.setSenderAccount(receiverAccount);
        Set<Category> categories = transaction.getCategories();
        if (!CollectionUtils.isEmpty(categories)) {
            transactionDto.setCategories(categories.stream().map(CategoryMapper::mapToCategoryDto).toList());
        }
        return transactionDto;
    }

    public TransactionDto mapToTransactionDto(Transaction transaction, AccountDto senderAccount, AccountDto receiverAccount, UserDto sender) {
        TransactionDto transactionDto = new TransactionDto();
        BeanUtils.copyProperties(transaction, transactionDto);
        transactionDto.setSender(sender);
        transactionDto.setReceiver(userFeignClient.getUser(transaction.getReceiverId()));
        transactionDto.setReceiverAccount(receiverAccount);
        transactionDto.setSenderAccount(senderAccount);
        Set<Category> categories = transaction.getCategories();
        if (!CollectionUtils.isEmpty(categories)) {
            transactionDto.setCategories(categories.stream().map(CategoryMapper::mapToCategoryDto).toList());
        }
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
        Set<Category> categories = transaction.getCategories();
        if (!CollectionUtils.isEmpty(categories)) {
            transactionResponseVo.setCategory(categories.iterator().next().getCategoryName());
        }
        return transactionResponseVo;
    }
}
