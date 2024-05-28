package com.example.TeamProject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class PersonController {
    @RequestMapping("/login")
    @ResponseBody
    public String form(@RequestParam("id") String id, @RequestParam("pw") String pw){
        return id + "님 환영합니다!";
    }
    @GetMapping("/register")
    public String registerUser(Person person) {
        PersonService.addUser(person);
        return "회원 가입 성공";
    }

    @GetMapping
    public ArrayList<Person> getAllUsers() {
        return PersonService.getUsers();
    }
}
