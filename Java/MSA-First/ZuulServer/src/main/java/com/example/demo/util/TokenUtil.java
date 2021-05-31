package com.example.demo.util;

import com.example.demo.exception.InvalidTokenException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;

@Component
public class TokenUtil {

    private final Key key;

    public TokenUtil(@Value("${jwt.secret}") String secret) {
        key = Keys.hmacShaKeyFor(secret.getBytes());
    }

    public void validate(String token) throws InvalidTokenException {
        token = token.replace("Bearer ", "");

        decode(token);
    }

    private void decode(String token) throws InvalidTokenException {
        try {
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();

            System.out.println(claims.get("username"));

            System.out.println(claims.getExpiration());
        } catch (Exception e) {
            throw new InvalidTokenException();
        }
    }
}
