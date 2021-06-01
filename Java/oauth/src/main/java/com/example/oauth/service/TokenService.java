package com.example.oauth.service;

import com.example.oauth.client.UserServiceClient;
import com.example.oauth.common.SocialType;
import com.example.oauth.factory.OAuthServiceFactory;
import com.example.oauth.model.dto.JwtRequestData;
import com.example.oauth.model.dto.JwtResponseData;
import com.example.oauth.model.dto.OAuthRequestData;
import com.example.oauth.model.dto.OAuthResponseData;
import com.example.oauth.model.entity.Token;
import com.example.oauth.model.vo.TokenData;
import com.example.oauth.repository.TokenRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

        Optional<Token> token = tokenRepository.findByTokenIdAndType(tokenData.getTokenId(), String.valueOf(type));

        var context = new Object() {
            JwtResponseData jwtResponseData;
        };

        token.ifPresentOrElse(item -> {
            context.jwtResponseData = userServiceClient.login(item.getUUID());

            item.setAccessToken(tokenData.getAccessToken());
            item.setRefreshToken(tokenData.getRefreshToken());

            tokenRepository.save(item);
        }, () -> {
            context.jwtResponseData = userServiceClient.register(jwtRequestData);

            Token item = tokenBuilder(tokenData, context.jwtResponseData, String.valueOf(type));

            tokenRepository.save(item);

        });

        return OAuthResponseData.builder()
                .jwtAccessToken(context.jwtResponseData.getJwtAccessToken())
                .jwtRefreshToken(context.jwtResponseData.getJwtRefreshToken())
                .build();
    }

    private Token tokenBuilder(TokenData tokenData, JwtResponseData jwtResponseData, String type) {
        return Token.builder()
                .tokenId(tokenData.getTokenId())
                .UUID(jwtResponseData.getUUID())
                .type(String.valueOf(type))
                .accessToken(tokenData.getAccessToken())
                .refreshToken(tokenData.getRefreshToken())
                .build();
    }
}
