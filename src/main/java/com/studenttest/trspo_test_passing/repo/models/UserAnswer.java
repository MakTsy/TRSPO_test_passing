package com.studenttest.trspo_test_passing.repo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "user_answer")
@NoArgsConstructor
public class UserAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id;
    private long userId;
    private long testId;
    private long questionId;
    private long answerId;

    public UserAnswer(long userId, long testId, long questionId, long answerId) {
        this.userId = userId;
        this.testId = testId;
        this.questionId = questionId;
        this.answerId = answerId;
    }
}
