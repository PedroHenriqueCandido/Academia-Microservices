package com.academia.authservice.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.academia.authservice.models.User;

/**
 * Repositório de acesso a dados para a entidade {@link User}.
 * 
 * Estende JpaRepository para fornecer operações CRUD básicas.
 * Também define uma consulta personalizada para buscar usuários por e-mail.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    /**
     * Busca um usuário pelo seu e-mail.
     *
     * @param email o e-mail do usuário a ser buscado
     * @return um Optional contendo o usuário, se encontrado
     */
    Optional<User> findByEmail(String email);
}