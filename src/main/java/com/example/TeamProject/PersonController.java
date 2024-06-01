package com.example.TeamProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;

@Controller
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping("/") // 메인(로그인)화면
    public String Main() {
        return "Main";
    }

    @RequestMapping("/register") // 폼 표시
    public String registerFrom(Model model) {
        model.addAttribute("person", new Person());
        return "register";
    }

    @RequestMapping("/register") // 가입 정보 저장
    public String registerSubmit(@ModelAttribute Person person, Model model) {
        PersonService.addUser(person);
        model.addAttribute("person", person);
        return "result";
    }

    @RequestMapping("/login") // 도서 리스트에서 00님 환영합니다 표시
    @ResponseBody
    public String login(@RequestParam("id") String id) {
        return id+"님 환영합니다!";
    }


}
