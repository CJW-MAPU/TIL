package com.example.oauth.factory;

import com.example.oauth.common.SocialType;
import com.example.oauth.service.GoogleOAuthService;
import com.example.oauth.service.KakaoOAuthService;
import com.example.oauth.service.NaverOAuthService;
import com.example.oauth.service.OAuthService;
import org.springframework.stereotype.Component;

@Component
public class OAuthServiceFactory {

    private final KakaoOAuthService kakaoOAuthService;
    private final NaverOAuthService naverOAuthService;
    private final GoogleOAuthService googleOAuthService;

    public OAuthServiceFactory(
            KakaoOAuthService kakaoOAuthService,
            NaverOAuthService naverOAuthService,
            GoogleOAuthService googleOAuthService
    ) {
        this.kakaoOAuthService = kakaoOAuthService;
        this.naverOAuthService = naverOAuthService;
        this.googleOAuthService = googleOAuthService;
    }


    public OAuthService createService(SocialType type) {

        OAuthService service = null;

        switch (type) {
            case KAKAO: {
                service = kakaoOAuthService;
                break;
            }
            case NAVER: {
                service = naverOAuthService;
                break;
            }
            case GOOGLE: {
                service = googleOAuthService;
                break;
            }
            default: {
                break;
            }
        }

        return service;
    }
}
