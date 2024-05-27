package com.app.marvel.service.impl;

import com.app.marvel.dto.security.LoginRequest;
import com.app.marvel.dto.security.LoginResponse;
import com.app.marvel.persistence.entity.User;
import com.app.marvel.persistence.repository.UserRespository;
import com.app.marvel.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Autowired
    private HttpSecurity httpSecurity;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRespository userRespository;


    @Override
    public LoginResponse authenticate(LoginRequest loginRequest) {
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                loginRequest.usermane(), loginRequest.password()
        );

        //si pasa esta linea es que inicio sesion
        authenticationManager.authenticate(authToken);
        User user =  userRespository.findByUsername(loginRequest.usermane()).get();

        String token = jwtService.generateToken(user, generateExtraClaims(user));

        return new LoginResponse(token) ;
    }

    private Map<String, Object> generateExtraClaims(User user) {
        Map<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("name", user.getName());
        extraClaims.put("role", user.getRole());
        extraClaims.put("permissions", user.getAuthorities());
        return extraClaims;
    }

    @Override
    public void logout() {
        try{
            httpSecurity.logout(logoutConfig -> {
                logoutConfig.deleteCookies("JSESSIONID")
                        .clearAuthentication(true)
                        .invalidateHttpSession(true);
            });
        }catch (Exception exception){
            throw new RuntimeException(exception);
        }
    }

}
