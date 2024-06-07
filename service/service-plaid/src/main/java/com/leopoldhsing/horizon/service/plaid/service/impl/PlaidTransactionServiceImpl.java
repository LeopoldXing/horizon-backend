package com.leopoldhsing.horizon.service.plaid.service.impl;

import com.leopoldhsing.horizon.common.utils.RequestUtil;
import com.leopoldhsing.horizon.common.utils.constants.RedisConstants;
import com.leopoldhsing.horizon.feign.account.AccountFeignClient;
import com.leopoldhsing.horizon.model.dto.AccountDto;
import com.leopoldhsing.horizon.model.dto.TransactionDto;
import com.leopoldhsing.horizon.model.enumeration.TransactionStatus;
import com.leopoldhsing.horizon.service.plaid.service.IPlaidTransactionService;
import com.plaid.client.model.RemovedTransaction;
import com.plaid.client.model.Transaction;
import com.plaid.client.model.TransactionsSyncRequest;
import com.plaid.client.model.TransactionsSyncResponse;
import com.plaid.client.request.PlaidApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import retrofit2.Response;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class PlaidTransactionServiceImpl implements IPlaidTransactionService {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private PlaidApi plaidClient;

    @Autowired
    private AccountFeignClient accountFeignClient;

    @Override
    public List<TransactionDto> getTransactionsByAccountId(Long accountId) throws IOException {
        // 1. get accountDto [RPC]
        AccountDto accountDto = accountFeignClient.getAccountById(accountId);

        // 2. Set cursor to empty to receive all historical transactions
        String cursor = null;

        // 3. get access token
        long userId = RequestUtil.getUid();
        String accessToken = redisTemplate
                .opsForValue()
                .get(RedisConstants.PLAID_KEY_PREFIX + RedisConstants.PLAID_ACCESS_TOKEN_KEY_SUFFIX + userId);

        // 4. New transaction updates since "cursor"
        List<Transaction> added = new ArrayList<>();
        List<Transaction> modified = new ArrayList<>();
        List<RemovedTransaction> removed = new ArrayList<>();
        boolean hasMore = true;
        // Iterate through each page of new transaction updates for item
        while (hasMore) {
            // construct get transaction request object
            TransactionsSyncRequest request = new TransactionsSyncRequest()
                    .accessToken(accessToken)
                    .cursor(cursor);

            // get response
            Response<TransactionsSyncResponse> response = plaidClient.transactionsSync(request).execute();
            TransactionsSyncResponse responseBody = response.body();

            // Add this page of results
            assert responseBody != null;
            added.addAll(responseBody.getAdded());
            modified.addAll(responseBody.getModified());
            removed.addAll(responseBody.getRemoved());
            hasMore = responseBody.getHasMore();
            // Update cursor to the next cursor
            cursor = responseBody.getNextCursor();
        }

        // 5. processing transaction list: sort (oldest -> latest) and filter by accountId
        added.sort(Comparator.comparing(Transaction::getDate));
        List<Transaction> transactionList = added
                .stream()
                .filter(transaction -> accountDto.getPlaidAccountId().equals(transaction.getAccountId()))
                .toList();

        // 6. convert plaid transaction -> transactionDto
        List<TransactionDto> res = transactionList
                .stream()
                .map(transaction -> {
                    TransactionDto dto = new TransactionDto();
                    dto.setAmount(transaction.getAmount() == null ? new BigDecimal(0) : BigDecimal.valueOf(transaction.getAmount()));
                    dto.setCurrency(transaction.getIsoCurrencyCode());
                    dto.setDate(transaction.getDate());
                    dto.setAuthorizedDate(transaction.getDate());
                    dto.setName(transaction.getName());
                    dto.setChannel("online");
                    dto.setStatus(transaction.getPending() ? TransactionStatus.PENDING : TransactionStatus.PROCESSED);
                    dto.setAccountDto(accountDto);
                    return dto;
                }).toList();

        // 7. return results
        return res;
    }

}
