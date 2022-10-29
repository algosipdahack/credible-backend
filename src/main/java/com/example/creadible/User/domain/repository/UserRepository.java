package com.example.creadible.User.domain.repository;

import com.example.creadible.User.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
