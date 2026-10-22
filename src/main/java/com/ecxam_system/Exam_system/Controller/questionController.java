package com.ecxam_system.Exam_system.Controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecxam_system.Exam_system.entity.question;
import com.ecxam_system.Exam_system.repository.questionRepository;


    @RestController
@RequestMapping("/api/questions")
public class questionController {

    @Autowired
    private questionRepository questionRepo;

    @GetMapping
    public List<question> getAll() { return questionRepo.findAll(); }

    @GetMapping("/subject/{subject}")
    public List<question> bySubject(@PathVariable String subject) {
        return questionRepo.findBySubject(subject);
    }

    @PostMapping
    public question add(@RequestBody question q) { return questionRepo.save(q); }
}

