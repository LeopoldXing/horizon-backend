package com.leopoldhsing.horizon.service.user.repository;

import com.leopoldhsing.horizon.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Long countUsersByEmail(String email);

    Optional<User> findByEmailAndPassword (String email, String password);

}
