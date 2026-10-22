package com.ecxam_system.Exam_system.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecxam_system.Exam_system.entity.result;
import com.ecxam_system.Exam_system.repository.resultRepository;

@RestController
@RequestMapping("/api/results")
public class resultController {
        @Autowired
    private resultRepository resultRepo;

    @PostMapping
    public result save(@RequestBody result r) { return resultRepo.save(r); }

    @GetMapping("/user/{userId}")
    public List<result> byUser(@PathVariable Long userId) {
        return resultRepo.findByUserId(userId);
}


}

