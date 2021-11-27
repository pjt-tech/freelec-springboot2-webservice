package com.jojoldu.book.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    //메인 클래스로 프로젝트 최상단에 위치해야한다.
    //이유는 @SpringBootApplication 부터 설정을 읽어가기때문.
    public static void main(String[] args) {
        //부트는 톰캣을 설치할 필요없이 내장 WAS를 제공한다.
        //부트 외장WAS를 사용함으로써 언제 어디서나 같은 환경으로 스프링 부트를 배포할수있다.
        SpringApplication.run(Application.class, args); //내장 WAS를 실행
    }
}
