package com.cos.blog.model;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity // User 클래스가 MySQL에 테이블 생성이 된다.
public class User {

    @Id //Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //프로젝트에서 연결된 DB의 넘버링 전략을 따라간다.
    private int id; //오라클: 시퀀스, mysql: autoincrement

    @Column(nullable = false, length = 30)
    private String username; //아이디

    @Column(nullable = false, length = 100) // 해쉬(암호화)해야하니 길이가 길어야하므
    private String password;

    @Column(nullable = false, length = 50)
    private String email;

    @ColumnDefault("'user'")
    private String role; // Enum을 쓰는게 좋다. //admin, user, manager

    @CreationTimestamp //시간 자동 입력
    private Timestamp createDate;

}
