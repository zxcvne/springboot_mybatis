package com.example.demo.config;

import com.example.demo.security.CustomUserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {
    // private public 작성 X
    @Bean
    PasswordEncoder passwordEncoder(){
        return PasswordEncoderFactories.createDelegatingPasswordEncoder(); // password 인코딩을 생성해주는 객체
    }

    /* SecurityFilterChain 객체 생성 */
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // 권한 검색시 ROLE_ 기본 앞에 설정되어 있음
        return http.csrf(csrf-> csrf.disable())
                .authorizeHttpRequests(authrize ->
                        authrize.requestMatchers("/user/list").hasAnyRole("ADMIN")
                                .requestMatchers("/", "/index", "/js/**", "/board/list",
                                        "/board/detail", "/user/signup", "/user/login").permitAll()
                                .anyRequest().authenticated()
                )
                .formLogin(login->
                        login.usernameParameter("email")
                                .passwordParameter("pwd")
                                .loginPage("/user/login")
                                .defaultSuccessUrl("/board/list")
                                .failureUrl("/user/login")
                                .permitAll()
                )
                .logout(logout->logout
                        .logoutUrl("/user/logout")
                        .invalidateHttpSession(true)
                        .deleteCookies("JSESSIONID")
                        .logoutSuccessUrl("/index")
                ).build();
    }
    // userDetailsService : 로그인 객체를 DB에서 확인
    @Bean
    UserDetailsService userDetailsService() {
        return new CustomUserService(); // 사용자가 직접 생성
    }
    // authenticationManager : 객체 생성
    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

}
