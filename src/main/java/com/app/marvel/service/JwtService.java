package com.app.marvel.service;

import com.app.marvel.persistence.entity.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Map;


public interface JwtService {
    String generateToken(UserDetails user, Map<String, Object> stringObjectMap);

    String extraerSubject(String jwt);
}
