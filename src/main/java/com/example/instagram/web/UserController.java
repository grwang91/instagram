package com.example.instagram.web;

import com.example.instagram.service.UserService;
import com.example.instagram.web.dto.UserJoinRequestDto;
import com.example.instagram.web.dto.UserLoginRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor      // 초기화 필요한 arg만 constructor
@RestController
public class UserController {

    private final UserService userService;

    @PostMapping("/user/join")                //mapping 하나하나마다 swagger 항목 추가
    public Long join(@RequestBody UserJoinRequestDto userJoinRequestDto) {       //RequestBody -> dto로 알아서 wrapping
        return userService.join(userJoinRequestDto);
    }

    @PostMapping("/user/login")
    public Long login(@RequestBody UserLoginRequestDto userLoginRequestDto) {
        return userService.login(userLoginRequestDto);
    }

}