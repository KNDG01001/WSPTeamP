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
    public String showMain() {
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

    @GetMapping("/login")
    public String loginSubmit(@RequestParam("id") String id, @RequestParam("pw") String pw, Model model) {
        if(personService.validateUser(id, pw)) {
            Person person = personService.findById(id);
            model.addAttribute("message", person.getName()+"님 환영합니다");
            return "redirect:/BookList";
        } else {
            model.addAttribute("error", "아이디 또는 비밀번호가 유효하지 않습니다. 회원가입을 진행해주세요");
            return "error";
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

//    @GetMapping("/Book") // Book 페이지로 이동
//    public String showBookPage(@RequestParam("id") String id, Model model) {
//        Person person = personService.findById(id);
//        if (person != null) {
//            model.addAttribute("userName", person.getName());
//            return "Book";
//        } else {
//            model.addAttribute("error", "사용자 정보를 찾을 수 없습니다.");
//            return "error";
//        }
//    }




}
