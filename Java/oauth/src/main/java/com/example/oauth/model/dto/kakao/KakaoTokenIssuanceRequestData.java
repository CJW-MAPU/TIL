package com.example.oauth.model.dto.kakao;

import lombok.*;

@Getter

@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class KakaoTokenIssuanceRequestData {

    private String grant_type;

    private String client_id;

    private String client_secret;

    private String redirect_uri;

    private String code;
}
