package com.mysite.sbb;

import com.mysite.sbb.question.domain.dao.QuestionRepository;
import com.mysite.sbb.question.domain.domain.Question;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.util.List;

@Controller
public class MainController {
    @Autowired
    private QuestionRepository questionRepository;

    @RequestMapping("/")
    public String root() {
        return "redirect:/question/list";
    }

    @GetMapping("/createQuestion")
    @ResponseBody
    public List<Question> createQuestion() {
        Question q1 = new Question();
        q1.setSubject("sbb가 무엇인가요?");
        q1.setContent("sbb에 대해서 알고 싶습니다.");
        q1.setCreateDate(LocalDateTime.now());
        this.questionRepository.save(q1);

        Question q2 = new Question();
        q2.setSubject("스프링부트 모델 질문입니다.");
        q2.setContent("id는 자동으로 생성되나요?");
        q2.setCreateDate(LocalDateTime.now());
        this.questionRepository.save(q2);

        Question q3 = new Question();
        q3.setSubject("스프링과 스프링부트");
        q3.setContent("스프링과 스프링부트의 차이점은 무엇인가요?");
        q3.setCreateDate(LocalDateTime.now());
        this.questionRepository.save(q3);

        return questionRepository.findAll();
    }

    @GetMapping("/saveSessionAge")
    @ResponseBody
    public String saveSessionAge(@RequestParam("age") int age, HttpSession session) {
        System.out.println("age : " + age);
        session.setAttribute("age", age);

        return "나이 %d살이 세션에 저장되었습니다.".formatted(age);
    }

    @GetMapping("/getSessionAge")
    @ResponseBody
    public String getSession(HttpSession session) {
        int age = (int) session.getAttribute("age");
        return "세션에 저장된 나이는 %d살 입니다.".formatted(age);
    }

    @GetMapping("/addPerson/{id}/{age}")
    @ResponseBody
    public Person addPerson(Person person, @PathVariable("id") int id, @PathVariable("age") int age) {
        System.out.println("Id : " + person.getId());
        System.out.println("Age : " + person.getAge());
        return person;
//        Person p = new Person(id, age, name);
//        return p;
    }
}

@Getter
@AllArgsConstructor
class Person {
    private int id;
    private int age;
    private String name;

//    public Person(int id, int age, String name) {
//        this.id = id;
//        this.age = age;
//        this.name = name;
//    }     AllArgsConstructor 사용하면 생성자 따로 작성안해도됨


}