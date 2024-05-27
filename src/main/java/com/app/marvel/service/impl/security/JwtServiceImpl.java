package com.app.marvel.service.impl.security;

import com.app.marvel.persistence.entity.User;
import com.app.marvel.service.JwtService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.Map;
@Service
public class JwtServiceImpl implements JwtService {

    @Value("${security.jwt.expitation-minutes}")
    private long expitationMinutes;

    @Value("${security.jwt.secret-key}")
    private String secretKet;


    @Override
    public String generateToken(UserDetails user, Map<String, Object> extrClaims) {

        Date issuedAt = new Date(System.currentTimeMillis());
        Date expirationAt = new Date(issuedAt.getTime() + expitationMinutes * 60 * 1000);

        return Jwts.builder()
                .claims(extrClaims)
                .subject(user.getUsername())
                .issuedAt(issuedAt)
                .expiration(expirationAt)
                .setHeaderParam(Header.TYPE, Header.JWT_TYPE)
                .signWith(generateKey(), SignatureAlgorithm.HS256)
                .compact();

    }

    private Key generateKey(){
        byte [] keyBytes = Decoders.BASE64.decode(secretKet);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String extraerSubject(String jwt) {
        return extraerClaims(jwt).getSubject();
    }

    private Claims extraerClaims(String jwt) {
        return Jwts.parser().build().parseSignedClaims(jwt).getPayload();
    }
}
