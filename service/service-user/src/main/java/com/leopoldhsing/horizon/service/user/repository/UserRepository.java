package com.leopoldhsing.horizon.service.user.repository;

import com.leopoldhsing.horizon.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
