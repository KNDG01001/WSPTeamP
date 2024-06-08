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
        // 사용자가 로그인 페이지에 처음 접근할 때 세션을 초기화
        session.invalidate();
        return "Main";
    }

    @PostMapping("/login") // 로그인 제출 시
    public String login(@RequestParam("Id") String userId, @RequestParam("Pw") String userPw, Model model, HttpServletRequest request) {
        if (userId.isEmpty() || userPw.isEmpty()) { // 값이 비어있는 경우
            model.addAttribute("error", "아이디와 비밀번호를 모두 입력해주세요");
            return "error";
        }
        if (personService.authorize(userId, userPw)) {
            HttpSession session = request.getSession();

            PersonDTO user = personService.findUserById(userId);
            if (user != null) {
                session.setAttribute("userName", user.getUserName()); // 사용자 이름을 세션에 추가
            }
            session.setAttribute("userId", userId);
            session.setAttribute("userPw", userPw);
            return "redirect:/BookList";
        } else {
            model.addAttribute("error", "아이디 또는 비밀번호가 유효하지 않습니다.");
            return "error";
        }
    }
    @GetMapping("/register") // 회원가입 폼으로 이동
    public String showRegistrationForm(Model model) {
        model.addAttribute("person", new Person());
        return "register";
    }

    @PostMapping("/register") // 회원가입 폼 제출
    public String submitRegistrationForm(@ModelAttribute PersonDTO personDTO, Model model) {
        if (personDTO.getUserId().isEmpty() ||personDTO.getUserPw().isEmpty()||personDTO.getUserName().isEmpty()) { // 값이 비어있는 경우
            model.addAttribute("error", "아이디와 비밀번호,이름을 모두 입력해주세요");
            return "error";
        }
        else{
            if(personService.duplicateCheck(personDTO)){
                personService.addUser(personDTO);
                model.addAttribute("person",personDTO);
                return "result"; // 가입 결과 페이지로 이동
            }
            else{
                model.addAttribute("error", "중복된 아이디입니다. 다시 시도해주세요.");
                return "error";
            }
        }
    }
}


