package com.example.demo.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.time.ZonedDateTime;
import java.util.Date;

@Component
public class TokenUtil {

    private final Key key;

    public TokenUtil(@Value("${jwt.secret}") String secret) {
        key = Keys.hmacShaKeyFor(secret.getBytes());
    }

    public String generateAccessToken(String username) {
        return Jwts.builder()
                .claim("username", username)
                .signWith(key, SignatureAlgorithm.HS256)
                .setExpiration(Date.from(ZonedDateTime.now().plusWeeks(1).toInstant()))
                .compact();
    }
}
