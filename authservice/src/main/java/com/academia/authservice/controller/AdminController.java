package com.academia.authservice.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controlador de teste para endpoints acessíveis exclusivamente por usuários
 * com a role ADMIN.
 * 
 * Este controller serve como exemplo de endpoint protegido apenas para
 * administradores, utilizando controle de acesso com Spring Security e JWT.
 * 
 * Endpoint: - GET /admin/test → Acessível apenas para usuários autenticados com
 * role ADMIN.
 * 
 * Autor: Pedro Henrique Cândido Data: 11/04/2025
 */
@RestController
@RequestMapping("/admin")
public class AdminController {

	/**
	 * Endpoint de teste acessível apenas por usuários com a role ADMIN.
	 *
	 * @return Uma string indicando que o usuário possui permissão de administrador.
	 */
	@GetMapping("/test")
	@PreAuthorize("hasRole('ADMIN')")
	public String adminOnly() {
		return "Você é ADMIN!";
	}
}
