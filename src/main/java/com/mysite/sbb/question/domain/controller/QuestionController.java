package com.mysite.sbb.question.domain.controller;

import com.mysite.sbb.question.domain.dao.QuestionRepository;
import com.mysite.sbb.question.domain.domain.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionRepository questionRepository;

    //    QuestionController(QuestionRepository questionRepository) {
//        this.questionRepository = questionRepository;
//    }
    @RequestMapping("/")
    public String root() {
        return "redirect:/question/list";
    }

    @RequestMapping("/question/list")
    public String list(Model model) {
        List<Question> questionList = questionRepository.findAll();
        model.addAttribute("questionList", questionList);
        return "question_list";
    }
}
