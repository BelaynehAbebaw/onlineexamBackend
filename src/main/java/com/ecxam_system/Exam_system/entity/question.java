package com.ecxam_system.Exam_system.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "questions")
public class question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "question_text", nullable = false, columnDefinition = "TEXT")
    private String questionText;
    @Column(name = "question_type", nullable = false, length = 30)
    private String questionType;

    // Multiple choice options
    @Column(name = "option_a")
    private String optionA;

    @Column(name = "option_b")
    private String optionB;

    @Column(name = "option_c")
    private String optionC;

    @Column(name = "option_d")
    private String optionD;
    @Column(name = "correct_answer", columnDefinition = "TEXT")
    private String correctAnswer;
    @Column(name = "explanation", columnDefinition = "TEXT")
    private String explanation;

    @Column(length = 100)
    private String subject;
    @Column(name = "marks")
    private Double marks = 1.0;
    @Column(name = "question_data", columnDefinition = "TEXT")
    private String questionData;

    @JsonIgnore
    @ManyToMany(mappedBy = "questions")
    private List<result> results = new ArrayList<>();
    public question() {
    }

    // Constructor
    public question(
            Long id,
            String questionText,
            String questionType,
            String optionA,
            String optionB,
            String optionC,
            String optionD,
            String correctAnswer,
            String subject) {

        this.id = id;
        this.questionText = questionText;
        this.questionType = questionType;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.correctAnswer = correctAnswer;
        this.subject = subject;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getQuestionType() {
        return questionType;
    }

    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }

    public String getOptionA() {
        return optionA;
    }

    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    public String getOptionD() {
        return optionD;
    }

    public void setOptionD(String optionD) {
        this.optionD = optionD;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Double getMarks() {
        return marks;
    }

    public void setMarks(Double marks) {
        this.marks = marks;
    }

    public String getQuestionData() {
        return questionData;
    }

    public void setQuestionData(String questionData) {
        this.questionData = questionData;
    }

    public List<result> getResults() {
        return results;
    }

    public void setResults(List<result> results) {
        this.results = results;
    }
}
