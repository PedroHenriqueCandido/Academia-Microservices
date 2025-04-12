package com.academia.userservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.academia.userservice.DTO.AuthLoginRequest;
import com.academia.userservice.DTO.AuthRegistrationRequest;
import com.academia.userservice.DTO.AuthResponse;

@FeignClient(name = "auth-service", url = "${auth.service.url}/auth")
public interface AuthClient {

    @PostMapping("/register")
    void registerUser(AuthRegistrationRequest request);
    
    @PostMapping("/login")
    AuthResponse loginUser(@RequestBody AuthLoginRequest request);
}