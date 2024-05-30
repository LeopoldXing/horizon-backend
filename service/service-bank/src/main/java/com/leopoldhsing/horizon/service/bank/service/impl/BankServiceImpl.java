package com.leopoldhsing.horizon.service.bank.service.impl;

import com.leopoldhsing.horizon.service.bank.repository.BankRepository;
import com.leopoldhsing.horizon.service.bank.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankServiceImpl implements BankService {

    @Autowired
    private BankRepository bankRepository;

}
