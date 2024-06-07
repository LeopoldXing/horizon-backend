package com.leopoldhsing.horizon.service.transaction.repository;

import com.leopoldhsing.horizon.model.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

    List<Transaction> findAllByAccountId(Long accountId);

}
