package com.example.TeamProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class PersonController {

    @RequestMapping("/")
    public String Main() {
        return "Main";
    }

    @RequestMapping("/register")
    public String register() {
        return "register";
    }


}
