package com.mysite.sbb.answer.dao;

import com.mysite.sbb.answer.domain.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Integer> {
}
