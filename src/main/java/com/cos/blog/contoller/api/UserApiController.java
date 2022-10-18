package com.cos.blog.contoller.api;

import com.cos.blog.dto.ResponseDto;
import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;
import com.cos.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RequestMapping("/auth")
@RestController
public class UserApiController {

    @Autowired
    private UserService userService;

    @PostMapping("/joinProc")
    public ResponseDto<Integer> save(@RequestBody User user) { // username, password
        System.out.println("UserApiController.save");
        //실제로 DB에 insert를 하고 아래에서 return이 되면 되요.
        user.setRole(RoleType.USER);
        userService.회원가입(user);
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }
}
