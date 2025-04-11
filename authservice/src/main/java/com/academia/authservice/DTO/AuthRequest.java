package com.academia.authservice.DTO;


/**
 * Classe DTO (Data Transfer Object) utilizada para representar a requisição de autenticação.
 * 
 * <p>Contém os dados necessários para realizar o login do usuário:
 * <ul>
 *   <li><strong>email</strong> - E-mail do usuário.</li>
 *   <li><strong>password</strong> - Senha do usuário.</li>
 * </ul>
 */
public class AuthRequest {

    /** E-mail do usuário */
    private String email;

    /** Senha do usuário */
    private String password;

    /** Construtor padrão sem argumentos. Necessário para frameworks como Jackson. */
    public AuthRequest() {}

    /**
     * Construtor com todos os campos.
     * 
     * @param email E-mail do usuário
     * @param password Senha do usuário
     */
    public AuthRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    /**
     * Retorna o e-mail do usuário.
     * 
     * @return e-mail
     */
    public String getEmail() {
        return email;
    }

    /**
     * Define o e-mail do usuário.
     * 
     * @param email novo e-mail
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Retorna a senha do usuário.
     * 
     * @return senha
     */
    public String getPassword() {
        return password;
    }

    /**
     * Define a senha do usuário.
     * 
     * @param password nova senha
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
