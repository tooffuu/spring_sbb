package com.mysite.sbb.question.domain.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class QuestionController {

    @RequestMapping("/question/list")
    public String list() {
        return "question_list";
    }
}
