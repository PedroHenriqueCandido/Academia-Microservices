package com.academia.authservice.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador de teste para endpoints acessíveis por usuários com as roles USER
 * ou ADMIN.
 * 
 * Este controller serve como exemplo de endpoint protegido por roles usando o
 * Spring Security.
 * 
 * Endpoint: - GET /user/test → Acessível apenas para usuários autenticados com
 * role USER ou ADMIN.
 * 
 * Autor: Pedro Henrique Cândido Data: 11/04/2025
 */
@RestController
@RequestMapping("/user")
public class UserController {

	/**
	 * Endpoint de teste acessível apenas por usuários com as roles USER ou ADMIN.
	 *
	 * @return Uma string indicando que o usuário possui uma das roles necessárias.
	 */
	@GetMapping("/test")
	@PreAuthorize("hasAnyRole('USER', 'ADMIN')")
	public String userOrAdmin() {
		return "Você é USER ou ADMIN!";
	}
}
