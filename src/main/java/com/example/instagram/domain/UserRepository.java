package com.example.instagram.domain;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {    // <User, User 의 ID>
    //CRUD 기능 기본적으로 구현
}
