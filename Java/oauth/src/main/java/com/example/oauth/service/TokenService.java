package com.example.oauth.service;

import com.example.oauth.client.UserServiceClient;
import com.example.oauth.common.SocialType;
import com.example.oauth.factory.OAuthServiceFactory;
import com.example.oauth.model.dto.JwtRequestData;
import com.example.oauth.model.dto.JwtResponseData;
import com.example.oauth.model.dto.OAuthRequestData;
import com.example.oauth.model.dto.OAuthResponseData;
import com.example.oauth.model.vo.TokenData;
import com.example.oauth.repository.TokenRepository;
import org.springframework.stereotype.Service;

@Service
public class TokenService {

    private final OAuthServiceFactory factory;
    private final UserServiceClient userServiceClient;
    private final TokenRepository tokenRepository;

    public TokenService(OAuthServiceFactory factory, UserServiceClient userServiceClient, TokenRepository tokenRepository) {
        this.factory = factory;
        this.userServiceClient = userServiceClient;
        this.tokenRepository = tokenRepository;
    }

    public OAuthResponseData oauth(SocialType type, OAuthRequestData requestData) {
        OAuthService oAuthService = factory.createService(type);

        TokenData tokenData = oAuthService.oauth(requestData);

        JwtRequestData jwtRequestData = JwtRequestData.builder()
                .nickname(tokenData.getName())
                .email(tokenData.getEmail())
                .build();

        JwtResponseData jwtResponseData = userServiceClient.getJwt(jwtRequestData);

//        Optional<Token> token = tokenRepository.findByTokenIdAndType(tokenData.getTokenId(), String.valueOf(type));

        return OAuthResponseData.builder()
                .jwtAccessToken(jwtResponseData.getJwtAccessToken())
                .jwtRefreshToken(jwtResponseData.getJwtRefreshToken())
                .build();
    }
}
