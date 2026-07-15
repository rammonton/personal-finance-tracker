package com.rammonton.authservice.service;

import com.rammonton.authservice.dto.request.LoginRequest;
import com.rammonton.authservice.dto.request.RegisterRequest;
import com.rammonton.authservice.dto.response.LoginResponse;
import com.rammonton.authservice.dto.response.RegisterResponse;

public interface AuthService {

    RegisterResponse register(RegisterRequest request);

    LoginResponse login(LoginRequest request);

}