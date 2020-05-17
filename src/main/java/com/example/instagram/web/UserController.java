package com.example.instagram.web;

import com.example.instagram.service.UserService;
import com.example.instagram.web.dto.UserJoinRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor      // 초기화 필요한 arg만 constructor
@RestController
public class UserController {

    private final UserService userService;

    @PostMapping("/user/join")
    public Long join(@RequestBody UserJoinRequestDto userJoinRequestDto) {       //RequestBody -> dto로 알아서 wrapping
        return userService.join(userJoinRequestDto);
    }

}