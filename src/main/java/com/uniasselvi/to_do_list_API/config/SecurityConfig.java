package com.uniasselvi.to_do_list_API.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .anyRequest().permitAll() // Permite todas as requisições sem autenticação
                .and()
                .csrf().disable(); // Desabilita proteção CSRF (se necessário)

        return http.build();
    }
}
