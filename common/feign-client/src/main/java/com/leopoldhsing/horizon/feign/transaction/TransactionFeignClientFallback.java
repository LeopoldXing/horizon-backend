package com.leopoldhsing.horizon.feign.transaction;

import com.leopoldhsing.horizon.model.dto.CategoryDto;
import com.leopoldhsing.horizon.model.dto.TransactionDto;
import com.leopoldhsing.horizon.model.vo.TransactionResponseVo;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TransactionFeignClientFallback implements TransactionFeignClient {

    @Override
    public void saveTransactionList(List<TransactionDto> transactionDtoList) {

    }

    @Override
    public List<TransactionResponseVo> getTransactionListByAccountId(Long accountId) {
        return List.of();
    }

    @Override
    public CategoryDto saveCategory(String category) {
        return null;
    }
}
