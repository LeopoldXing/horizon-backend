package com.leopoldhsing.horizon.service.bank.api;

import com.leopoldhsing.horizon.model.dto.BankDto;
import com.leopoldhsing.horizon.service.bank.service.IBankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/inner/bank")
public class BankFeignApi {

    @Autowired
    private IBankService bankService;

    @PostMapping("/align")
    public void alignBankInformation(@RequestBody BankDto bankDto) {
        bankService.alignBankInformation(bankDto);
    }

    @GetMapping("/institution/{id}")
    public BankDto getBankByInstitutionId(@PathVariable("id") String institutionId) {
        BankDto bankDto = bankService.getBankByInstitutionId(institutionId);

        return bankDto;
    }

    @GetMapping("/{id}")
    public BankDto getBankById(@PathVariable("id") Long id) {
        BankDto bankDto = bankService.getBankById(id);

        return bankDto;
    }

}
