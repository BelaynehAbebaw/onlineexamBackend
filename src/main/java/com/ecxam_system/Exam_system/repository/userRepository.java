package com.ecxam_system.Exam_system.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecxam_system.Exam_system.entity.user;

public interface userRepository extends JpaRepository<user, Long> {
    Optional<user> findByEmail(String email);
    Optional<user> findByUsername(String username);
    boolean existsByEmail(String email);
}
