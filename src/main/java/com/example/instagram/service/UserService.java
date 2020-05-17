package com.example.instagram.service;

import com.example.instagram.domain.User;
import com.example.instagram.domain.UserRepository;
import com.example.instagram.web.dto.UserJoinRequestDto;
import com.example.instagram.web.dto.UserLoginRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private PasswordEncoder passwordEncoding = new BCryptPasswordEncoder();

    public Long join(UserJoinRequestDto userJoinRequestDto) throws IllegalAccessException {
        User user = new UserJoinRequestDto(userJoinRequestDto.getUserName(),
                passwordEncoding.encode(userJoinRequestDto.getPassword())).toEntity();        //password encoding해서 다시 dto로
        Optional<User> checkUser = userRepository.findByUserName(userJoinRequestDto.getUserName());
        if(checkUser.isPresent()) {
            throw new IllegalAccessException("이미 등록됨");
        }
        return userRepository.save((user)).getId();

    }

    public Long login(UserLoginRequestDto userLoginRequestDto) throws IllegalAccessException {
        Optional<User> user = userRepository.findByUserName(userLoginRequestDto.getUserName());
        if(!user.isPresent()) {
            throw new IllegalAccessException("아이디를 확인해주세요");
        }
        
        if(!passwordEncoding.matches(userLoginRequestDto.getPassword(), user.get().getPassword())) {         //passwordEncoding으로 비번 확인
            throw new IllegalAccessException("비밀번호를 확인해주세요");
        }
        
        
        if (user.isPresent() &&  user.get().getPassword().equals(userLoginRequestDto.getPassword())) {
            return user.get().getId();
        }



        return Long.valueOf(-1);
    }

}
