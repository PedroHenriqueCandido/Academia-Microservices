package com.academia.authservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Classe de configuração responsável por fornecer um bean de {@link PasswordEncoder}.
 *
 * <p>Esse bean é utilizado em todo o sistema para codificar e verificar senhas dos usuários
 * usando o algoritmo BCrypt, garantindo maior segurança no armazenamento das credenciais.
 *
 * <p>Ao anotar com {@code @Configuration}, o Spring entende que esta classe contém
 * definições de beans para o contexto da aplicação.
 */
@Configuration
public class PasswordEncoderConfig {

    /**
     * Cria e registra um {@link PasswordEncoder} baseado em {@link BCryptPasswordEncoder}.
     *
     * @return instância de {@code BCryptPasswordEncoder} para uso na codificação de senhas
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}