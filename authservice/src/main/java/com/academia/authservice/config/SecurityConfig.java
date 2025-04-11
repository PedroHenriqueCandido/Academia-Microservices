package com.academia.authservice.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Classe de configuração de segurança da aplicação.
 * 
 * Responsável por configurar as regras de acesso (autorização) e aplicar o filtro de autenticação JWT.
 * 
 * Principais responsabilidades:
 * - Desabilita proteção CSRF (adequado para APIs REST).
 * - Define os endpoints públicos e os protegidos com base nas roles.
 * - Aplica o filtro JWT antes da autenticação padrão do Spring Security.
 * - Habilita segurança baseada em anotações com {@code @PreAuthorize} via {@code @EnableMethodSecurity}.
 * 
 * Endpoints e permissões:
 * - {@code /auth/register}, {@code /auth/login} → acesso liberado (público).
 * - {@code /admin/**} → acessível apenas por usuários com role ADMIN.
 * - {@code /user/**} → acessível por usuários com role USER ou ADMIN.
 * - Todos os outros endpoints requerem autenticação JWT.
 * 
 * Autor: Pedro Henrique Cândido  
 * Data: 11/04/2025
 */
@Configuration
@EnableMethodSecurity // Habilita segurança com anotações como @PreAuthorize
public class SecurityConfig {

    @Autowired
    private JwtAuthFilter jwtAuthFilter;

    /**
     * Define as configurações da cadeia de filtros de segurança.
     * 
     * @param http O objeto HttpSecurity usado para configurar a segurança da aplicação.
     * @return O SecurityFilterChain configurado.
     * @throws Exception Caso ocorra algum erro de configuração.
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // Desabilita CSRF para facilitar requisições via Postman, por exemplo.
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/auth/register", "/auth/login","/auth/users").permitAll() // Libera endpoints públicos
                .requestMatchers("/admin/**").hasRole("ADMIN")                 // Apenas ADMIN
                .requestMatchers("/user/**").hasAnyRole("USER", "ADMIN")      // USER ou ADMIN
                .anyRequest().authenticated()                                 // Demais rotas exigem login
            )
            .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class); // Aplica filtro JWT

        return http.build();
    }
}
