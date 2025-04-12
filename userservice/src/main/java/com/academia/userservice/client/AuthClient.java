package com.academia.userservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import com.academia.userservice.DTO.AuthRegistrationRequest;

@FeignClient(name = "auth-service", url = "${auth.service.url}")
public interface AuthClient {

    @PostMapping("/api/auth/register")
    void registerUser(AuthRegistrationRequest request);
}