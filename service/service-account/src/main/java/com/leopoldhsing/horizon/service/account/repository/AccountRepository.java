package com.leopoldhsing.horizon.service.account.repository;

import com.leopoldhsing.horizon.model.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    List<Account> findAccountsByOwnerId(Long ownerId);
}
