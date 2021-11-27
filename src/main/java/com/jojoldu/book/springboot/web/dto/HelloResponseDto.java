package com.jojoldu.book.springboot.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor //final이 붙은 필드의 생성자를 자동으로 만들어준다.
public class HelloResponseDto {

    private final String name;
    private final int amount;

}
