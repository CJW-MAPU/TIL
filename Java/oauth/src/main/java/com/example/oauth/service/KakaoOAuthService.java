package com.example.oauth.service;

import com.example.oauth.client.kakao.KakaoApiClient;
import com.example.oauth.client.kakao.KakaoAuthClient;
import com.example.oauth.model.dto.OAuthRequestData;
import com.example.oauth.model.dto.kakao.KakaoProfileResponseData;
import com.example.oauth.model.dto.kakao.KakaoTokenIssuanceRequestData;
import com.example.oauth.model.dto.kakao.KakaoTokenIssuanceResponseData;
import com.example.oauth.model.vo.TokenData;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class KakaoOAuthService implements OAuthService {

    @Value("${oauth.grant_type}") private String GRANT_TYPE;
    @Value("${kakao.client_id}") private String CLIENT_ID;
    @Value("${kakao.client_secret}") private String CLIENT_SECRET;
    @Value("${kakao.redirect_uri}") private String REDIRECT_URI;

    private final KakaoAuthClient kakaoAuthClient;
    private final KakaoApiClient kakaoApiClient;

    public KakaoOAuthService(KakaoAuthClient kakaoAuthClient, KakaoApiClient kakaoApiClient) {
        this.kakaoAuthClient = kakaoAuthClient;
        this.kakaoApiClient = kakaoApiClient;
    }

    @Override
    public TokenData oauth(OAuthRequestData request) {
        String code = request.getCode();

        KakaoTokenIssuanceRequestData requestData = KakaoTokenIssuanceRequestData.builder()
                .grant_type(GRANT_TYPE)
                .client_id(CLIENT_ID)
                .client_secret(CLIENT_SECRET)
                .redirect_uri(REDIRECT_URI)
                .code(code)
                .build();

        KakaoTokenIssuanceResponseData tokenResponseData = kakaoAuthClient.getToken(requestData);

        System.out.println(tokenResponseData.getAccess_token());

        KakaoProfileResponseData profileResponseData = kakaoApiClient.getProfile(tokenResponseData.getToken_type() + " " + tokenResponseData.getAccess_token());

        return TokenData.builder()
                .tokenId(String.valueOf(profileResponseData.getId()))
                .accessToken(tokenResponseData.getAccess_token())
                .refreshToken(tokenResponseData.getRefresh_token())
                .name((String) profileResponseData.getProperties().get("nickname"))
                .email((String) profileResponseData.getKakao_account().get("email"))
                .build();
    }
}
