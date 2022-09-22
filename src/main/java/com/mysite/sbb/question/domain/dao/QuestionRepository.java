package com.mysite.sbb.question.domain.dao;

import com.mysite.sbb.question.domain.domain.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
}
