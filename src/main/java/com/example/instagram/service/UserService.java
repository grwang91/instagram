package com.example.instagram.service;

import com.example.instagram.domain.UserRepository;
import com.example.instagram.web.dto.UserJoinRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public Long join(UserJoinRequestDto userJoinRequestDto) {
        return userRepository.save(userJoinRequestDto.toEntity()).getId();
    }

}
