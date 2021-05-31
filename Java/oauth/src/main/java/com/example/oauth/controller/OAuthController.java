package com.example.oauth.controller;

import com.example.oauth.common.SocialType;
import com.example.oauth.model.dto.OAuthRequestData;
import com.example.oauth.model.dto.OAuthResponseData;
import com.example.oauth.service.OAuthService;
import com.example.oauth.service.TokenService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/oauth")
public class OAuthController {

    private final TokenService tokenService;

    public OAuthController(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @PostMapping("/{social_type}")
    public ResponseEntity<OAuthResponseData> oauth(
            @PathVariable("social_type") SocialType type,
            OAuthRequestData requestData
    ) {
        /*OAuthService oAuthService = factory.createService(type);

        OAuthResponseData response = oAuthService.oauth(requestData);*/

        return ResponseEntity.ok(tokenService.oauth(type, requestData));
    }
}
