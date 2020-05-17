package com.example.instagram.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@NoArgsConstructor         //Entity 들어가는 곳은 꼭 들어가야함
@Getter
@Entity
public class User {

    @Id
    @Column(name = "USER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)      // 새로운 데이터 들어올 때마다 id를 1씩 증가시키는
    private Long id;

    @Column(unique = true)
    private String userName;    //EMAIL ID

    private String password;

    private String avatarUrl;

    @Builder
    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }
}
