/**
 * Esta é uma classe de configuração de segurança para a aplicação, usando o Spring Security para gerenciar
 * as configurações de segurança das requisições. Ela declara o pacote onde está localizada e utiliza anotações
 * como @Configuration e @Bean para definir a classe como uma fonte de configurações e métodos de criação de beans.
 * Através de HttpSecurity, são fornecidos métodos para configurar a segurança HTTP, habilitando autenticação e
 * autorização nos endpoints. Com @EnableWebSecurity, a segurança web é ativada, e SecurityFilterChain define
 * a cadeia de filtros de segurança, permitindo personalizar a lógica de segurança para cada request HTTP.
 */
package com.uniasselvi.to_do_list_API.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;



















/**
 * Das linhas 49 em diante.
 * É configurado o filtro de segurança para as requisições HTTP.
 * @Bean: Define o método como um bean gerenciado pelo Spring, permitindo sua injeção no contexto.
 * HttpSecurity: Permite definir configurações de segurança para as requisições HTTP.
 * SecurityFilterChain: Responsável por construir e aplicar as configurações de segurança.
 *
 * Configurações de segurança:
 * - Autorizações: Permite que qualquer requisição seja feita sem autenticação, liberando o acesso a todos os endpoints.
 * - CSRF: Desabilita a proteção CSRF, que impede ataques de falsificação de requisição entre sites, pois não é necessária nesta aplicação.
 * Autenticação básica: Desabilita o uso de autenticação HTTP Basic para simplificação.
 * @param http Objeto HttpSecurity que permite definir configurações de segurança.
 * @return O SecurityFilterChain configurado.
 * @throws Exception Caso ocorra um erro ao configurar a segurança.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        .anyRequest().permitAll()
                )
                .csrf().disable()
                .httpBasic().disable();

        return http.build();
    }
}
