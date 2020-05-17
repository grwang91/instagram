package com.example.instagram.web.dto;

import com.example.instagram.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;



@AllArgsConstructor
@Getter
public class UserJoinRequestDto {

    private String userName;    //EMAIL ID

    private String password;


    public User toEntity() {
        return User.builder().userName(userName).password(password).build();
    }
}
