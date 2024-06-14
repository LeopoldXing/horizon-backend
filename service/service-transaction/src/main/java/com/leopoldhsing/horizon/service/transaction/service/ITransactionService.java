package com.leopoldhsing.horizon.service.transaction.service;

import com.leopoldhsing.horizon.model.dto.TransactionDto;
import com.leopoldhsing.horizon.model.vo.TransactionCreationVo;

import java.util.List;

public interface ITransactionService {

    List<TransactionDto> getTransactionListByAccountId(Long accountId);

    void saveTransactionList(List<TransactionDto> transactionDtoList);

    TransactionDto createTransaction(TransactionCreationVo transactionCreationVo);
}
