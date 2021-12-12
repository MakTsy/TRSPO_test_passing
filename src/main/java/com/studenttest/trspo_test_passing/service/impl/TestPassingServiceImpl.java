package com.studenttest.trspo_test_passing.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.studenttest.trspo_test_passing.api.dto.Test;
import com.studenttest.trspo_test_passing.clients.TestManagementClient;
import com.studenttest.trspo_test_passing.repo.UserAnswerRepo;
import com.studenttest.trspo_test_passing.repo.models.UserAnswer;
import com.studenttest.trspo_test_passing.service.TestPassingService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class TestPassingServiceImpl implements TestPassingService {

    private final UserAnswerRepo userAnswerRepo;

    public List<UserAnswer> fetchUserAnswersByTestId(long userId, long testId) {
        return userAnswerRepo.findAllByUserIdAndTestId(userId, testId);
    }

    public List<Test> fetchTestsPassedByUser(long userId) {
        final List<UserAnswer> answerList = userAnswerRepo.findAllByUserId(userId);
        return answerList.stream().map(userAnswer -> TestManagementClient.getTestById(userAnswer.getTestId())).toList();
    }

    public long createUserAnswer(long userId, long testId, long questionId, long answerId) {
        final UserAnswer userAnswer = new UserAnswer(userId, testId, questionId, answerId);
        final UserAnswer savedUser = userAnswerRepo.save(userAnswer);

        return savedUser.getAnswerId();
    }
}
