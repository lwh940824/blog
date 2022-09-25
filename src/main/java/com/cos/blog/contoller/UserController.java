package com.cos.blog.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/user/loinform")
    public String loginForm() {
        return "user/loginForm";
    }

    @GetMapping("/user/joinform")
    public String joinForm() {
        return "user/joinForm";
    }
}
