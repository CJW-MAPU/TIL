package com.example.oauth.service;

import com.example.oauth.model.dto.OAuthRequestData;
import com.example.oauth.model.vo.TokenData;

public interface OAuthService {
    TokenData oauth(OAuthRequestData requestData);
}
