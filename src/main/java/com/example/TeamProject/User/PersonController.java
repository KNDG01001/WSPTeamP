package com.example.TeamProject.User;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping("/") // 메인(로그인) 화면
    public String showMain(HttpSession session) {
        // 사용자가 로그인 페이지에 처음 접근할 때 세션을 초기화합니다.
        session.invalidate(); // 기존 세션을 제거하고 새로운 세션을 생성합니다.
        return "Main";
    }

    @PostMapping("/login") // 로그인 제출 시
    public String login(@RequestParam("uId") String userId, @RequestParam("uPw") String userPw, Model model, HttpServletRequest request) {
        if (personService.validateUser(userId, userPw)) {
            HttpSession session = request.getSession();
            session.setAttribute("userId", userId);
            session.setAttribute("userPw", userPw);
//            System.out.println(session.getAttribute("userId"));
            PersonDTO personDTO = personService.findById(userId);
            if (personDTO != null) {
                String userName = personDTO.getUserName();
                session.setAttribute("userName", userName); // 사용자 이름을 세션에 저장
                return "redirect:/BookList";
            } else {
                model.addAttribute("error", "사용자 정보를 찾을 수 없습니다.");
                return "error"; // 에러 페이지로 이동
            }
        } else {
            model.addAttribute("message", "아이디 또는 비밀번호가 유효하지 않습니다. 회원가입을 진행해주세요");
            return "Main";
        }
    }



    @GetMapping("/register") // 회원가입 폼으로 이동
    public String showRegistrationForm(Model model) {
        model.addAttribute("person", new Person());
        return "register";
    }

    @PostMapping("/register") // 회원가입 폼 제출
    public String submitRegistrationForm(@ModelAttribute PersonDTO personDTO, Model model) {
        personService.addUser(personDTO);
        model.addAttribute("person", personDTO);
        return "result"; // 가입 결과 페이지로 이동
    }
}


