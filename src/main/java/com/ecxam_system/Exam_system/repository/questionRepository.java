package com.ecxam_system.Exam_system.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecxam_system.Exam_system.entity.question;

public interface questionRepository extends JpaRepository<question, Long> {
    List<question> findBySubject(String subject);
}