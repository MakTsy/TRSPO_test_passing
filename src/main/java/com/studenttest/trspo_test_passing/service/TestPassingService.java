package com.studenttest.trspo_test_passing.service;

import java.util.List;

import com.studenttest.trspo_test_passing.api.dto.Test;
import com.studenttest.trspo_test_passing.repo.models.UserAnswer;


public interface TestPassingService {
    List<UserAnswer> fetchUserAnswersByTestId(long userId, long testId);
    List<Test> fetchTestsPassedByUser(long userId);
    long createUserAnswer(long userId, long testId, long questionId, long answerId);
}
