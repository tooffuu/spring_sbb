package com.mysite.sbb.answer.controller;

import com.mysite.sbb.answer.service.AnswerService;
import com.mysite.sbb.question.domain.domain.Question;
import com.mysite.sbb.question.domain.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/answer")
@RequiredArgsConstructor
public class AnswerController {
    private final QuestionService questionService;
    private final AnswerService answerService;

    @PostMapping("/create/{id}")
    public String createAnswer(Model model, @PathVariable("id") Integer id, @RequestParam String content) {
        Question question = questionService.getQuestion(id);
        answerService.create(question, content);
        return String.format("redirect:/question/detail/%s", id);   // 답변 저장, 답변이 달린 페이지로 return
    }
}
