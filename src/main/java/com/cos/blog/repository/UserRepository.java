package com.cos.blog.repository;

import com.cos.blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

// DAO
// 자동으로 빈 등록이 된다.
// @Repository 안해도 빈으로 등록됨
public interface UserRepository extends JpaRepository<User, Integer> {

}

// JPA Naming 전략
// SELECT * FROM user WHERE username = ? AND password = ?;
//    User findByUsernameAndPassword(String username, String password);

//    @Query(value = "SELECT * FROM user WHERE username=? AND password = ?", nativeQuery = true)
//    User login(String username, String password);
