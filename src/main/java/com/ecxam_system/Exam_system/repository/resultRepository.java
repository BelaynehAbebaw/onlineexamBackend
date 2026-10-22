package com.ecxam_system.Exam_system.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecxam_system.Exam_system.entity.result;

public interface resultRepository extends JpaRepository<result, Long> {
    List<result> findByUserId(Long userId);
}


