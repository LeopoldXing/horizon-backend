package com.leopoldhsing.horizon.service.transaction.service.impl;

import com.leopoldhsing.horizon.common.utils.Base64Util;
import com.leopoldhsing.horizon.common.utils.RequestUtil;
import com.leopoldhsing.horizon.common.utils.exception.ActionNotAuthorizedException;
import com.leopoldhsing.horizon.common.utils.exception.FailToCreateTransferException;
import com.leopoldhsing.horizon.feign.account.AccountFeignClient;
import com.leopoldhsing.horizon.feign.dwolla.DwollaFeignClient;
import com.leopoldhsing.horizon.model.dto.AccountDto;
import com.leopoldhsing.horizon.model.dto.TransactionDto;
import com.leopoldhsing.horizon.model.dto.TransferCreationDto;
import com.leopoldhsing.horizon.model.entity.Transaction;
import com.leopoldhsing.horizon.model.enumeration.TransactionStatus;
import com.leopoldhsing.horizon.model.vo.TransactionCreationVo;
import com.leopoldhsing.horizon.service.transaction.mapper.TransactionMapper2;
import com.leopoldhsing.horizon.service.transaction.repository.CategoryRepository;
import com.leopoldhsing.horizon.service.transaction.repository.TransactionRepository;
import com.leopoldhsing.horizon.service.transaction.service.ICategoryService;
import com.leopoldhsing.horizon.service.transaction.service.ITransactionService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransactionServiceImpl implements ITransactionService {

    @Autowired
    private AccountFeignClient accountFeignClient;

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private TransactionMapper2 transactionMapper;

    @Autowired
    private DwollaFeignClient dwollaFeignClient;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ICategoryService categoryService;

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

        // 5. return result
        return transactionList
                .stream()
                .map(transaction -> transactionMapper.mapToTransactionDto(transaction))
                .toList();
    }

    @Override
    public void saveTransactionList(List<TransactionDto> transactionDtoList) {
        List<Transaction> transactionList = transactionDtoList
                .stream()
                .map(transactionMapper::mapToTransaction)
                .toList();
        transactionRepository.saveAll(transactionList);
    }

    @Transactional
    @Override
    public TransactionDto createTransaction(TransactionCreationVo transactionCreationVo) {
        // 1. decrypt receiverId
        Long receiverAccountId = Long.parseLong(new String(Base64Util.decode(transactionCreationVo.getReceiverAccountShareableId())));

        // 2. create transaction object
        Transaction transaction = transactionMapper.mapToTransaction(transactionCreationVo);
        transaction.setSenderId(RequestUtil.getUid());
        transaction.setReceiverAccountId(receiverAccountId);
        transaction.setCurrency("USD");
        transaction.setDate(LocalDate.now());
        transaction.setDatetime(LocalDateTime.now());
        transaction.setStatus(TransactionStatus.PENDING.toString());
        transaction.setChannel("online");
        Long receiverId = accountFeignClient.getOwnerIdByAccountId(receiverAccountId);
        transaction.setReceiverId(receiverId);
        TransactionDto transactionDto = transactionMapper.mapToTransactionDto(transaction);

        // 3. create dwolla transfer
        TransferCreationDto transferCreationDto = new TransferCreationDto();
        transferCreationDto.setAmount(transaction.getAmount());
        transferCreationDto.setSourceFundingSourceUrl(transactionDto.getSenderAccount().getFundingSourceUrl());
        transferCreationDto.setDestinationFundingSourceUrl(transactionDto.getReceiverAccount().getFundingSourceUrl());
        String transferCreationRes = dwollaFeignClient.createTransfer(transferCreationDto);
        if (!StringUtils.hasLength(transferCreationRes)) {
            throw new FailToCreateTransferException(transferCreationDto.getSourceFundingSourceUrl(),
                    transferCreationDto.getDestinationFundingSourceUrl(),
                    transferCreationDto.getAmount());
        }

        // 4. store transaction into the database
        Transaction savedTransaction = transactionRepository.save(transaction);
        transactionDto.setId(savedTransaction.getId());

        // 5. return result
        return transactionDto;
    }
}
