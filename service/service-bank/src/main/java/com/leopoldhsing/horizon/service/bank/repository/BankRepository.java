package com.leopoldhsing.horizon.service.bank.repository;

import com.leopoldhsing.horizon.model.entity.Bank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepository extends JpaRepository<Bank, Long> {
}
