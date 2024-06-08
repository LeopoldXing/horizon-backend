package com.leopoldhsing.horizon.feign.bank;

import com.leopoldhsing.horizon.model.dto.BankDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("bank")
public interface BankFeignClient {

    @GetMapping("/api/v1/inner/bank/institution/{id}")
    BankDto getBankByInstitutionId(@PathVariable("id") String institutionId);

    @PostMapping("/api/v1/inner/bank/align")
    void alignBankInformation(@RequestBody BankDto bankDto);

    @GetMapping("/api/v1/inner/bank/{id}")
    BankDto getBankById(@PathVariable("id") Long id);

}
