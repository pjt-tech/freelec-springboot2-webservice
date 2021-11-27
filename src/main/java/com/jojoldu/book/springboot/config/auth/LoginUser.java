package com.jojoldu.book.springboot.config.auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER) //소스에서 파라미터로 선언된 객체만 사용가능하다.
@Retention(RetentionPolicy.RUNTIME) //
public @interface LoginUser { //LoginUser 라는 이름의 어노테이션이다.
}
