package com.cos.blog.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder //빌더 패턴
@Entity
//@DynamicInsert // insert시에 null인 필드를 제외시켜준다.
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

//    @ColumnDefault("user")
    // DB는 RoleType이라는게 없다.
    @Enumerated(EnumType.STRING)
    private RoleType role; // Enum을 쓰는게 좋다. //admin, user, manager

    @CreationTimestamp //시간 자동 입력
    private Timestamp createDate;

}
