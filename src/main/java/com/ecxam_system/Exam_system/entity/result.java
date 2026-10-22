package com.ecxam_system.Exam_system.entity;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "results")
public class result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", nullable = false)
    private user user;

    @ManyToMany
    @JoinTable(
        name = "result_questions",
        joinColumns = @JoinColumn(name = "result_id"),
        inverseJoinColumns = @JoinColumn(name = "question_id")
    )
    private List<question> questions = new ArrayList<>();

    @Column(length = 100)
    private String subject;

    @Column(nullable = false)
    private int score;

    @Column(name = "total_questions", nullable = false)
    private int totalQuestions;

    @Column(name = "exam_date")
    private LocalDateTime examDate = LocalDateTime.now();

    public result() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public user getUser() { return user; }
    public void setUser(user user) { this.user = user; }
    public List<question> getQuestions() { return questions; }
    public void setQuestions(List<question> questions) { this.questions = questions; }
    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }
    public int getScore() { return score; }
    public void setScore(int score) { this.score = score; }
    public int getTotalQuestions() { return totalQuestions; }
    public void setTotalQuestions(int totalQuestions) { this.totalQuestions = totalQuestions; }
    public LocalDateTime getExamDate() { return examDate; }
    public void setExamDate(LocalDateTime examDate) { this.examDate = examDate; }
}

