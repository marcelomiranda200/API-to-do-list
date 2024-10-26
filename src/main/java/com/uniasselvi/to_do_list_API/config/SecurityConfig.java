package com.uniasselvi.to_do_list_API.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Classe de configuração de segurança para a aplicação.
 * Utiliza o Spring Security para gerenciar as configurações de segurança das requisições.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    /**
     * Configura o filtro de segurança para as requisições HTTP.
     *
     * @param http Objeto HttpSecurity que permite definir configurações de segurança.
     * @return O SecurityFilterChain configurado.
     * @throws Exception Caso ocorra um erro ao configurar a segurança.
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // Configura as autorizações de requisições
                .authorizeHttpRequests(authorize -> authorize
                        // Permite que qualquer requisição seja feita sem autenticação
                        .anyRequest().permitAll() // Permite todas as requisições
                )
                // Desabilita a proteção CSRF (Cross-Site Request Forgery)
                .csrf().disable() // Desabilita a proteção CSRF

                // Desabilita a autenticação básica (não é necessário)
                .httpBasic().disable();

        return http.build(); // Retorna o objeto configurado do filtro de segurança
    }
}
