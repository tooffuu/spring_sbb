package com.mysite.sbb.question.domain.service;

import com.mysite.sbb.question.domain.dao.QuestionRepository;
import com.mysite.sbb.question.domain.domain.Question;
import com.mysite.sbb.question.domain.util.DataNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuestionService {
    private final QuestionRepository questionRepository;

    public List<Question> getList() {
        return questionRepository.findAll();
    }

    public Question getQuestion(Integer id) {
        Optional<Question> questionOptional = questionRepository.findById(id);
        if(questionOptional.isPresent()) {
            return questionOptional.get();
        } else {
            throw new DataNotFoundException("Question not found");
        }
    }
}
