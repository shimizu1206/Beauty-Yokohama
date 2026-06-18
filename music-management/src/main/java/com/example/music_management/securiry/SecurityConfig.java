package com.example.music_management.securiry;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

    @Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(request -> request
                 .requestMatchers("/register", "/login", "/error", "/css/**", "/images/**").permitAll()
                 .requestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")).permitAll()
                .anyRequest().authenticated())
                .csrf(csrf -> csrf.csrfTokenRepository(new HttpSessionCsrfTokenRepository())
                 // h2-consoleでCSRFを無効にする
                  .ignoringRequestMatchers(AntPathRequestMatcher.antMatcher("/h2-console/**")) )
                   // h2-consoleの設定 
                   .securityMatcher("/h2-console/**") 
                   .headers(headers -> headers.frameOptions( frame -> frame.sameOrigin()))
                   .securityMatcher("/**")
            .formLogin(login -> login
                .loginProcessingUrl("/login")
                .loginPage("/login")
                .defaultSuccessUrl("/shops")
                .failureUrl("/login?error")
                .permitAll()
            );
        return http.build();
    }

     @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
