package com.academia.userservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.academia.userservice.DTO.AuthLoginRequest;
import com.academia.userservice.DTO.AuthResponse;
import com.academia.userservice.models.User;
import com.academia.userservice.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;
    
    // Endpoint para cadastro de usuário
    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        // O objeto User esperado deve incluir a senha para o registro no Auth Service
        return userService.createUser(user);
    }
    
    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthLoginRequest loginRequest) {
        return userService.loginUser(loginRequest.getEmail(), loginRequest.getPassword());
    }

    // Endpoint para buscar usuário por email
    @GetMapping("/{email}")
    public User getUserByEmail(@PathVariable String email) {
        return userService.getUserByEmail(email);
    }
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    // Deletar usuário
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    // Listar todos os usuários (acesso restrito)
    @GetMapping
    public List<User> getAllUsers() {
        return userService.findAll();
    }
}