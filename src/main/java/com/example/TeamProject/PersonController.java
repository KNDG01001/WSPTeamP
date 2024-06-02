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

    @GetMapping("/result") //회원가입 폼으로 넘김
    public String showForm(Model model) {
        model.addAttribute("person", new Person());
        return "result";
    }

    @PostMapping("/result") // 가입 정보 저장
    public String registerSubmit(@ModelAttribute Person person, Model model) {
        personService.addUser(person);
        model.addAttribute("person", person);
        return "result";
    }

    @GetMapping("/login") //오류 발생 시
    public String loginSubmit(@RequestParam("id") String id, @RequestParam("pw") String pw, Model model) {
        Person person = personService.findById(id);
        if(personService.validateUser(id, pw)) {
            model.addAttribute("message", person.getName()+"님 환영합니다");
            return "redirect:/login";
        } else {
            model.addAttribute("message", "아이디 또는 비밀번호가 유효하지 않습니다. 회원가입을 진행해주세요");
            return "Main";
        }
    }
    @GetMapping("/register") //회원가입 폼으로 넘김
    public String showRegistrationForm(Model model) {
        model.addAttribute("person", new Person());
        return "register";
    }

    @PostMapping("/register") // 회원가입 폼 제출
    public String submitRegistrationForm(@ModelAttribute Person person, Model model) {
        personService.addUser(person);
        model.addAttribute("person", person);
        return "register";
    }


}
