package com.app.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

//
//
@Configuration
@EnableWebSecurity
public class SecurityConfig {


@Bean
public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
    return httpSecurity.cors().and()
            .csrf().disable()
            .authorizeHttpRequests(authorize -> authorize
                    .requestMatchers("/api/auth/**")
                    .permitAll()

                    .anyRequest()
                    .authenticated())
            .build();
}
//
@Bean
PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
}
}
