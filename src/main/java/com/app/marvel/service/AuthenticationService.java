package com.app.marvel.service;

import com.app.marvel.dto.security.LoginRequest;
import com.app.marvel.dto.security.LoginResponse;

public interface AuthenticationService {
    LoginResponse authenticate(LoginRequest loginRequest);

    void logout();
}
