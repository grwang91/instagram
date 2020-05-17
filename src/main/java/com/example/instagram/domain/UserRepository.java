package com.example.instagram.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//CRUD 기능 기본적으로 구현
public interface UserRepository extends JpaRepository<User, Long> {     // <User, User 의 ID>

    Optional<User> findByUserName(String userName);     //이미 만들어져 있는 method, findBy~~

}
