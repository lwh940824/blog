package com.cos.blog.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TempControllerTest {

    @GetMapping("/temp/home")
    public String tempHone() {
        System.out.println("TempControllerTest.tempHone");
        return "home.html";
    }

    @GetMapping("/temp/img")
    public String tempImg() {
        return "/a.jpg";
    }

    @GetMapping("/temp/jsp")
    public String tempJsp() {
        return "test";
    }
}
