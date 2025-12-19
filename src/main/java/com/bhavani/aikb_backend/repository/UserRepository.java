package com.bhavani.aikb_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bhavani.aikb_backend.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
