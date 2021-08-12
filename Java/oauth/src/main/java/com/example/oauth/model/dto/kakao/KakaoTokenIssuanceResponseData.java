package com.example.oauth.model.dto.kakao;

import lombok.*;

@Getter

@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class KakaoTokenIssuanceResponseData {
    private String token_type;
    private String access_token;
    private Integer expires_in;
    private String refresh_token;
    private Integer refresh_token_expires_in;
    private String scope;
}
