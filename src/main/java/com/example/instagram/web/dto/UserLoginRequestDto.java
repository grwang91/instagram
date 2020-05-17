package com.example.instagram.web.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserLoginRequestDto {

    private String userName;

    private String password;
}
