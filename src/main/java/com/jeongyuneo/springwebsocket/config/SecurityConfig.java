package com.jeongyuneo.springwebsocket.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable() // CSRF 보호 비활성화
                .authorizeHttpRequests(authorizeRequests -> authorizeRequests
                        .requestMatchers("/", "/index", "/login", "/static/**", "/messages").permitAll() // 해당 경로는 허용
                        .anyRequest().authenticated())
                .formLogin(formLogin -> formLogin
                        .loginPage("/login") // 로그인 페이지 설정
                        .defaultSuccessUrl("/chatting", true)
                        .permitAll())
                .logout(logout -> logout
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login?logout")
                        .permitAll());

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        var userDetailsManager = new InMemoryUserDetailsManager();

        var user = User.withUsername("user")
                .password("{noop}password") // "{noop}"은 비밀번호를 인코딩하지 않음을 의미합니다.
                .roles("USER")
                .build();

        userDetailsManager.createUser(user);

        return userDetailsManager;
    }
}