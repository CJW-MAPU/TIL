package com.example.oauth.service;

import com.example.oauth.client.google.GoogleApiClient;
import com.example.oauth.client.google.GoogleAuthClient;
import com.example.oauth.model.dto.OAuthRequestData;
import com.example.oauth.model.dto.google.GoogleProfileResponseData;
import com.example.oauth.model.dto.google.GoogleTokenIssuanceRequestData;
import com.example.oauth.model.dto.google.GoogleTokenIssuanceResponseData;
import com.example.oauth.model.vo.TokenData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class GoogleOAuthService implements OAuthService {

    @Value("${oauth.grant_type}") private String GRANT_TYPE;
    @Value("${google.client_id}") private String CLIENT_ID;
    @Value("${google.client_secret}") private String CLIENT_SECRET;
    @Value("${google.redirect_uri}") private String REDIRECT_URI;

    private final GoogleAuthClient googleAuthClient;
    private final GoogleApiClient googleApiClient;

    public GoogleOAuthService(GoogleAuthClient googleAuthClient, GoogleApiClient googleApiClient) {
        this.googleAuthClient = googleAuthClient;
        this.googleApiClient = googleApiClient;
    }


    @Override
    public TokenData oauth(OAuthRequestData request) {
        String code = request.getCode();

        GoogleTokenIssuanceRequestData tokenRequestData = GoogleTokenIssuanceRequestData.builder()
                .grant_type(GRANT_TYPE)
                .client_id(CLIENT_ID)
                .client_secret(CLIENT_SECRET)
                .redirect_uri(REDIRECT_URI)
                .code(code)
                .build();

        GoogleTokenIssuanceResponseData tokenResponseData = googleAuthClient.getToken(tokenRequestData);

        System.out.println(tokenResponseData.getAccess_token());

        GoogleProfileResponseData profileResponseData = googleApiClient.getProfile(tokenResponseData.getToken_type() + " " + tokenResponseData.getAccess_token());

        return TokenData.builder()
                .tokenId(profileResponseData.getId())
                .accessToken(tokenResponseData.getAccess_token())
                .refreshToken(tokenResponseData.getRefresh_token())
                .name(profileResponseData.getName())
                .email(profileResponseData.getEmail())
                .build();
    }
}
