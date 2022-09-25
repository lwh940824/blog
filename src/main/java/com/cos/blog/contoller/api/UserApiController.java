package com.cos.blog.contoller.api;

import com.cos.blog.dto.ResponseDto;
import com.cos.blog.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api")
@RestController
public class UserApiController {

    @PostMapping("/user")
    public ResponseDto<Integer> save(@RequestBody User user) {
        System.out.println("UserApiController.save");
        //실제로 DB에 insert를 하고 아래에서 return이 되면 되요.
        return new ResponseDto<Integer>(HttpStatus.OK, 1);
    }
}
