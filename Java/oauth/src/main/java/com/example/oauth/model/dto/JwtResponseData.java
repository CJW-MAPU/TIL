package com.example.oauth.model.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class JwtResponseData {
    private String UUID;
    private String jwtAccessToken;
    private String jwtRefreshToken;
}
