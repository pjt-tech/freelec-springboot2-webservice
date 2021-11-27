package com.jojoldu.book.springboot.config.auth;

import com.jojoldu.book.springboot.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity //스프링 시큐리티 설정들을 활성화 시켜준다.
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                //h2-console 을 사용하기위한설정
                .csrf().disable()
                .headers().frameOptions().disable()
                .and()
                    //URL 별 권한관리 시작점
                    .authorizeRequests()
                    //permitAll 은 전체 열람 권한이다.
                    .antMatchers("/", "/css/**", "/images/**","/js/**,","/h2-console/**","/profile").permitAll()
                    //hasRole 부분은 USER 권한만 가능하다.
                    .antMatchers("/api/v1/**").hasRole(Role.USER.name())
                    //나마지 URL 은 인증된 사용자에게만 허가
                    .anyRequest().authenticated()
                .and()
                    //로그아웃성공시 "/" 로 이동
                    .logout()
                        .logoutSuccessUrl("/")
                .and()
                    //로그인에 대한 여러설정 진입점
                    .oauth2Login()
                        //로그인 성공이후 사용자정보를 가져올때 설정들을 담당
                        .userInfoEndpoint()
                            //성공 시 후속조치를 진행할 인터페이스를 구현한 구현체
                            .userService(customOAuth2UserService);
    }
    // 정적 자원에 대해서는 Security 설정을 적용하지 않음.
    @Override public void configure(WebSecurity web) {
        //일단은 위 설정에 리소스를 넣어도 index.mustache 파일이 아니라 js파일이 리다이렉트되는 현상으로 이 설정을 추가했다.
        web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations())
        .antMatchers("/favicon.ico","/resources/**","/error","/templates/**"); }
}
