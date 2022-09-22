package com.cos.blog.repository;

import com.cos.blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// DAO
// 자동으로 빈 등록이 된다.
// @Repository 안해도 빈으로 등록됨
public interface UserRepository extends JpaRepository<User, Integer> {
}
