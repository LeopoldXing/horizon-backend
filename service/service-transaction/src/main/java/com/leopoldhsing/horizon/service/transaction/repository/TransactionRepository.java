package com.leopoldhsing.horizon.service.transaction.repository;

import com.leopoldhsing.horizon.model.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

    @Query("SELECT t FROM Transaction t WHERE t.receiverAccountId = :accountId OR t.senderAccountId = :accountId")
    List<Transaction> findAllByAccountId(Long accountId);

}
