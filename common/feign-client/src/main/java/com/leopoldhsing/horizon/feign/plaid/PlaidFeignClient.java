package com.leopoldhsing.horizon.feign.plaid;

import com.leopoldhsing.horizon.model.dto.TransactionDto;
import com.leopoldhsing.horizon.model.entity.Account;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient("plaid")
public interface PlaidFeignClient {

    @GetMapping("/api/v1/inner/plaid/account/list/{uid}")
    List<Account> getAccountsFromPlaidByUserId(@PathVariable Long uid);

    @GetMapping("/api/v1/inner/plaid/transaction/{accountId}")
    List<TransactionDto> getTransactionsFromPlaidByAccountId(@PathVariable Long accountId);

}
