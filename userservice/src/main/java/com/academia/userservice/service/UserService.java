package com.academia.userservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.academia.userservice.DTO.AuthRegistrationRequest;
import com.academia.userservice.client.AuthClient;
import com.academia.userservice.models.User;
import com.academia.userservice.repository.UserRepository;

@Service
public class UserService {

	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
    private AuthClient authClient;

    public User createUser(User user) {
        // Primeiro salva os dados do usuário (exceto a senha, que não é persistida aqui)
        User savedUser = userRepository.save(user);
        
        // Em seguida, chama o Auth Service para registrar a senha de forma segura
        // O user.getPassword() é temporário e não será salvo no User Service
        AuthRegistrationRequest authRequest = new AuthRegistrationRequest(user.getEmail(), user.getPassword(), user.getRole());
        authClient.registerUser(authRequest);
        
        return savedUser;
    }
    
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email).orElse(null);
    }
	
	
}
