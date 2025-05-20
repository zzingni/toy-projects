package com.github.zzingni.logindemo.controller;

import com.github.zzingni.logindemo.entity.User;
import com.github.zzingni.logindemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired // 스프링이 자동으로 객체를 생성해주는 어노테이션(new 사용 안 하고 객체 생성)
    private UserService userService;

    // 회원가입 폼 보여주기
    @GetMapping("/signup")
    public String signupForm() {
        return "signup"; // templates/signup.html
    }

    // 회원가입 처리
    @PostMapping("/signup")
    public String registerUser(@ModelAttribute User user, Model model) {
        boolean success = userService.register(user);
        if (success) {
            return "redirect:/login";
        } else {
            model.addAttribute("error", "이미 존재하는 아이디입니다.");
            return "signup";
        }
    }

    // 로그인 폼 보여주기 (선택)
    @GetMapping("/login")
    public String loginForm() {
        return "login"; // templates/login.html
    }

    @PostMapping("/login")
    public String login(@RequestParam String id,
                        @RequestParam String passwd,
                        HttpSession session,
                        Model model) {

        return userService.findById(id).map(user -> {
            if (userService.checkPassword(passwd, user.getPasswd())) {
                session.setAttribute("loginUser", user);
                return "redirect:/welcome"; // 로그인 성공 후 이동할 페이지
            } else {
                model.addAttribute("error", "비밀번호가 틀렸습니다.");
                return "login";
            }
        }).orElseGet(() -> {
            model.addAttribute("error", "존재하지 않는 아이디입니다.");
            return "login";
        });
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "welcome";  // templates/welcome.html 필요
    }
}
