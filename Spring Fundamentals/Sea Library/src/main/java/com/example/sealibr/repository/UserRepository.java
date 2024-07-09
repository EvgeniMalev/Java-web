package com.example.sealibrary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.sealibrary.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
