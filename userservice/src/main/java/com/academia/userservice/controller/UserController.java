package com.academia.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
}