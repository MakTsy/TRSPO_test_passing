package com.studenttest.trspo_test_passing.api;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studenttest.trspo_test_passing.api.dto.Test;
import com.studenttest.trspo_test_passing.repo.models.UserAnswer;
import com.studenttest.trspo_test_passing.service.TestPassingService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RequestMapping("/pass")
@RestController
public class TestPassingController {

    private final TestPassingService testPassingService;

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody UserAnswer userAnswer) {
        final long userId = userAnswer.getUserId();
        final long testId = userAnswer.getTestId();
        final long questionId = userAnswer.getQuestionId();
        final long answerId = userAnswer.getAnswerId();

        final long userAnswerId = testPassingService.createUserAnswer(userId, testId, questionId, answerId);
        final String userUri = String.format("/pass/%d", userAnswerId);

        return ResponseEntity.created(URI.create(userUri)).build();
    }

    @GetMapping("/tests/{userId}")
    public ResponseEntity<List<Test>> showTestsByUserId(@PathVariable long userId) {
        try {
            final List<Test> tests = testPassingService.fetchTestsPassedByUser(userId);

            return ResponseEntity.ok(tests);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{userId}/{testId}")
    public ResponseEntity<List<UserAnswer>> showUserAnswersByTestId(@PathVariable long userId, @PathVariable long testId) {
        try {
            final List<UserAnswer> answers = testPassingService.fetchUserAnswersByTestId(userId, testId);

            return ResponseEntity.ok(answers);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
