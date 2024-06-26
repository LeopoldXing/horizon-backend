package com.leopoldhsing.horizon.service.bank.service;

import com.leopoldhsing.horizon.model.dto.BankDto;

import java.util.List;

public interface IBankService {

    List<BankDto> getBankListByUserId(Long userId);

    BankDto getBankByInstitutionId(String institutionId);

    void alignBankInformation(BankDto bankDto);

    BankDto getBankById(Long id);
}
