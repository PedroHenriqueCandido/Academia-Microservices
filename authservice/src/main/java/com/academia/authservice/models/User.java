package com.academia.authservice.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Entidade que representa um usuário no sistema.
 * Mapeada para a tabela "tb_users" no banco de dados.
 */
@Entity
@Table(name = "tb_users")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /** Identificador único do usuário */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Email do usuário (usado como login) */
    private String email;

    /** Senha do usuário (armazenada de forma criptografada) */
    private String password;

    /** Role do usuário, como "USER" ou "ADMIN" */
    private String role;

    /** Data e hora em que o usuário foi criado */
    @Column(name = "created_at")
    private LocalDateTime createdAt;
	
	public User() {
        this.createdAt = LocalDateTime.now();
    }
	
	

	public User( String email, String password, String role, LocalDateTime createdAt) {
		super();
		this.email = email;
		this.password = password;
		this.role = role;
		this.createdAt = createdAt;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}



	@Override
	public int hashCode() {
		return Objects.hash(id);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}
}
