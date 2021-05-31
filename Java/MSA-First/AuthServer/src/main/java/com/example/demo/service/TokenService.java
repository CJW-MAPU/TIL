package com.example.demo.service;

import com.example.demo.exception.InvalidUsernameException;
import com.example.demo.model.dto.TokenResponseData;
import com.example.demo.model.dto.UserRequestData;
import com.example.demo.util.TokenUtil;
import org.springframework.stereotype.Service;

@Service
public class TokenService {

    private final TokenUtil tokenUtil;

    public TokenService(TokenUtil tokenUtil) {
        this.tokenUtil = tokenUtil;
    }

    public TokenResponseData generateToken(UserRequestData requestData) {

        if (requestData.getUsername() != null) {
            return TokenResponseData.builder()
                    .accessToken(tokenUtil.generateAccessToken(requestData.getUsername()))
                    .build();
        } else {
            throw new InvalidUsernameException();
        }
    }
}
