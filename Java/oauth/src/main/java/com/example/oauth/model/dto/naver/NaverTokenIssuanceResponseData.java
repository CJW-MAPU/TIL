package com.example.oauth.model.dto.naver;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class NaverTokenIssuanceResponseData {
    private String access_token;
    private String refresh_token;
    private String token_type;
    private String expires_in;
}
