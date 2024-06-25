package com.leopoldhsing.horizon.feign.bank;

import com.leopoldhsing.horizon.model.dto.BankDto;
import org.springframework.stereotype.Component;

@Component
public class BankFeignClientFallback implements BankFeignClient{

    @Override
    public BankDto getBankByInstitutionId(String institutionId) {
        return null;
    }

    @Override
    public void alignBankInformation(BankDto bankDto) {

    }

    @Override
    public BankDto getBankById(Long id) {
        return null;
    }
}
