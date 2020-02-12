package com.hyunjii.springboot.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public class UserRepository extends JpaRepository<User, Long> {

    // 이미 가입된 사용자인지 확인
    Optional<User> findByEmail(String email);
}
