package com.example.oauth.service;

import com.example.oauth.model.dto.OAuthRequestData;
import com.example.oauth.model.vo.TokenData;

public interface OAuthService {

//    OAuthResponseData oauth(OAuthRequestData request);
    TokenData oauth(OAuthRequestData requestData);
}
