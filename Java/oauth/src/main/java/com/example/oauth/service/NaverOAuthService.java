package com.example.oauth.service;

import com.example.oauth.client.naver.NaverApiClient;
import com.example.oauth.client.naver.NaverAuthClient;
import com.example.oauth.model.dto.OAuthRequestData;
import com.example.oauth.model.dto.naver.NaverProfileResponseData;
import com.example.oauth.model.dto.naver.NaverTokenIssuanceRequestData;
import com.example.oauth.model.dto.naver.NaverTokenIssuanceResponseData;
import com.example.oauth.model.vo.TokenData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class NaverOAuthService implements OAuthService {

    @Value("${oauth.grant_type}") private String GRANT_TYPE;
    @Value("${naver.client_id}") private String CLIENT_ID;
    @Value("${naver.client_secret}") private String CLIENT_SECRET;
    @Value("${naver.state}") private String STATE;

    private final NaverAuthClient naverAuthClient;
    private final NaverApiClient naverApiClient;

    public NaverOAuthService(NaverAuthClient naverAuthClient, NaverApiClient naverApiClient) {
        this.naverAuthClient = naverAuthClient;
        this.naverApiClient = naverApiClient;
    }

    @Override
    public TokenData oauth(OAuthRequestData request) {
        String code = request.getCode();

        NaverTokenIssuanceRequestData tokenRequestData = NaverTokenIssuanceRequestData.builder()
                .grant_type(GRANT_TYPE)
                .client_id(CLIENT_ID)
                .client_secret(CLIENT_SECRET)
                .state(STATE)
                .code(code)
                .build();

        NaverTokenIssuanceResponseData tokenResponseData = naverAuthClient.getToken(tokenRequestData);

        System.out.println(tokenResponseData);

        NaverProfileResponseData profileResponseData = naverApiClient.getProfile("Bearer " + tokenResponseData.getAccess_token());

        return TokenData.builder()
                .tokenId((String) profileResponseData.getResponse().get("id"))
                .accessToken(tokenResponseData.getAccess_token())
                .refreshToken(tokenResponseData.getRefresh_token())
                .email((String) profileResponseData.getResponse().get("email"))
                .name((String) profileResponseData.getResponse().get("name"))
                .build();

        /*return JwtRequestData.builder()
                .nickname((String) profileResponseData.getResponse().get("name"))
                .email((String) profileResponseData.getResponse().get("email"))
                .build();*/
    }
}
