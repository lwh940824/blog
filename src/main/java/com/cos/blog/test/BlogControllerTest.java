package com.cos.blog.test;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


// 스프링이 com.cos.blog 패키지 이하를 스캔해서 모든 파일을 메모리에 new 하는게 아니라
// 특정 어노테이션이 붙어 있는 클래스 파일을 new 해서(IoC) 스프링 컨테이너에 관리해준다.
@RestController
public class BlogControllerTest {

    @GetMapping("/test/hello")
    public String hello() {
        return "<h1>hello spring boot<h1>";
    }
}
