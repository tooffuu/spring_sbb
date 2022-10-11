package com.mysite.sbb;

import com.mysite.sbb.question.dao.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    @Autowired
    private QuestionRepository questionRepository;

    @RequestMapping("/")
    public String root() {
        return "redirect:/question/list";
    }

}

