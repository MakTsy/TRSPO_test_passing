package com.studenttest.trspo_test_passing.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.studenttest.trspo_test_passing.repo.models.UserAnswer;

public interface UserAnswerRepo extends JpaRepository<UserAnswer, Long> {
    @Query
    List<UserAnswer> findAllByUserIdAndTestId(long userId, long testId);

    @Query
    List<UserAnswer> findAllByUserId(long userId);
}
