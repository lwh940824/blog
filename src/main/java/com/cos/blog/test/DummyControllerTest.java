package com.cos.blog.test;

import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;
import com.cos.blog.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

@RestController
public class DummyControllerTest {

    @Autowired // 의존성 주입
    private UserRepository userRepository;

    // email, password
    @Transactional
    @PutMapping("/dummy/user/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User requestUser) {
        System.out.println("id = " + id);
        System.out.println("requestUser = " + requestUser.getEmail());
        System.out.println("requestUser = " + requestUser.getPassword());

        User user = userRepository.findById(id).orElseThrow(() -> {
            return new IllegalArgumentException();
        });
        user.setPassword(requestUser.getPassword());
        user.setEmail(requestUser.getEmail());

//        userRepository.save(requestUser);
        // 더티 체킹
        return null;
    }

    // http://localhost:8000/blog/dummy/user
    @GetMapping("/dummy/users")
    public List<User> list() {
        return userRepository.findAll();
    }

    // 한페이지당 2건에 데이터를 리턴받아 볼 예정
    @GetMapping("/dummy/user")
    public List<User> pageList(@PageableDefault(size = 2, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
        List<User> users = userRepository.findAll(pageable).getContent();
        return users;
    }

    // {id} 주소로ㅗ 파라메터를 전달 받을 수 있음
    // http://localhost:8000/blog/dummy/user/3
    @GetMapping("/dummy/user/{id}")

    public User detail(@PathVariable int id) {
        // user/4를 찾으면 내가 데이터베이스에서 못찾아오게 되면 user가 null이 될 것 아냐
        // 그럼 return null
        // Optional로 User객체를 가져올테니 null인지 아닌지 판단해서 return
        User user = userRepository.findById(id).orElseThrow(() -> {
            return new IllegalArgumentException("해당 사용자는 없습니다");
        });
        // 요청 : 웹브라우저
        // user 객체 = 자바 오브젝트
        // 변환 (웹 브라우저가 이해할 수 있는 데이터) -> json
        // 스프링부트 = MessageConverter라는 애가 응답시에 자동작동
        // 만약에 자바 오브젝트를 리턴하게 되면 MessageConverter가 라이브러리를 호출해서
        // user 오브젝트를 json으로 변환해서 브라우저에게 던져줍니다.
        return user;
    }

    // http://localhost:8000/blog/dummy/join(요청)
    // http의 body에 username, password, email 데이터를 가지고 (요청)
    @PostMapping("/dummy/join")
    public String join(User user) {
        System.out.println("user.getId() = " + user.getId());
        System.out.println("user = " + user.getRole());
        System.out.println("username = " + user.getUsername());
        System.out.println("password = " + user.getPassword());
        System.out.println("email = " + user.getEmail());

        user.setRole(RoleType.USER);
        userRepository.save(user);
        return "회원가입이 완료되었습니다.";
    }
}
