package com.jojoldu.book.springboot.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    //소셜로그인을 통해 반환되는 값 중 이메일을 통해 이미 생성된 사용자인지 체크하기 위함
    Optional<User> findByEmail(String email);
}
