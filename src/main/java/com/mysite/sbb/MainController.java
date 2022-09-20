package com.mysite.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {
    int increaseNum = 0;

    @RequestMapping("/sbb")
    @ResponseBody
    public String index() {
        System.out.println("sbb");
        return "sbb";
    }

    @GetMapping("/page1")
    @ResponseBody
    public String showPage1() {
        return """
                <form method="POST" action="/page2">
                <input type="number" name="age" placeholder="나이"/>
                <input type="submit" value="page2로 POST방식으로 이동" />
                </form>
                """;
    }

    @PostMapping("/page2")
    @ResponseBody
    public String showPage2Post(@RequestParam(value = "age", defaultValue = "0") int age) {
        System.out.println("age : " + age);
        return """
                <h1>입력된 나이 : %d</h1>
                <h1>POST 방식으로 옴</h1>
                """.formatted(age);
    }

    @GetMapping("/plus")
    @ResponseBody
    public int plus(int a, int b) {
        return a + b;
    }

    @GetMapping("/minor")
    @ResponseBody
    public int minus(int a, int b) {
        return a - b;
    }

    @GetMapping("/increase")
    @ResponseBody
    public int increases() {
        return increaseNum++;
    }


    @GetMapping("/gugudan")
    @ResponseBody
    public String gugudan(int dan, int limit) {
        String result = "";
        for (int i = 1; i <= limit ; i++) {
            result += dan + " * " + i + " = " + (dan * i) + "<br />\n";
        }
        return result;
    }
}
