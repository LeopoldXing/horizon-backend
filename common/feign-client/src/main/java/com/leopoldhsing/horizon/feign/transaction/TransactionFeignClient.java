package com.leopoldhsing.horizon.feign.transaction;

import com.leopoldhsing.horizon.model.dto.TransactionDto;
import com.leopoldhsing.horizon.model.vo.TransactionResponseVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient("transaction")
public interface TransactionFeignClient {

    @PostMapping("/api/v1/inner/transaction/list")
    void saveTransactionList(@RequestBody List<TransactionDto> transactionDtoList);

    @GetMapping("/api/v1/inner/transaction/accountId/{accountId}")
    List<TransactionResponseVo> getTransactionListByAccountId(@PathVariable("accountId") Long accountId);
}
