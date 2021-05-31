package com.example.demo.controller;

import com.example.demo.model.dto.TokenResponseData;
import com.example.demo.model.dto.UserRequestData;
import com.example.demo.service.TokenService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/token")
public class TokenController {

    private final TokenService tokenService;

    public TokenController(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @PostMapping("/generate")
    public ResponseEntity<TokenResponseData> generateToken(UserRequestData requestData) {
        return ResponseEntity.ok(tokenService.generateToken(requestData));
    }

}
