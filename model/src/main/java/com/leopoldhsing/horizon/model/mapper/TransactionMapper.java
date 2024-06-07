package com.leopoldhsing.horizon.model.mapper;

import com.leopoldhsing.horizon.model.dto.TransactionDto;
import com.leopoldhsing.horizon.model.entity.Transaction;
import com.leopoldhsing.horizon.model.vo.TransactionResponseVo;
import org.springframework.beans.BeanUtils;

public class TransactionMapper {

    public static Transaction mapToTransaction(TransactionDto transactionDto) {
        Transaction transaction = new Transaction();
        BeanUtils.copyProperties(transactionDto, transaction);
        return transaction;
    }

    public static TransactionDto mapToTransactionDto(Transaction transaction) {
        TransactionDto transactionDto = new TransactionDto();
        BeanUtils.copyProperties(transaction, transactionDto);
        return transactionDto;
    }

    public static TransactionResponseVo mapToTransactionResponseVo(Transaction transaction) {
        TransactionResponseVo transactionResponseVo = new TransactionResponseVo();
        BeanUtils.copyProperties(transaction, transactionResponseVo);
        return transactionResponseVo;
    }

    public static TransactionResponseVo mapToTransactionResponseVo(TransactionDto transactionDto) {
        Transaction transaction = mapToTransaction(transactionDto);
        return mapToTransactionResponseVo(transaction);
    }

    private TransactionMapper() {
    }
}
