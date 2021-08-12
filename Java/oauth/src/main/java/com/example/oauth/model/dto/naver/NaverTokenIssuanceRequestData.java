package com.example.oauth.model.dto.naver;

import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class NaverTokenIssuanceRequestData {
    private String grant_type;
    private String client_id;
    private String client_secret;
    private String code;
    private String state;
}
