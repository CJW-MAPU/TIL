package com.example.oauth.model.vo;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TokenData {
    private String tokenId;
    private String accessToken;
    private String refreshToken;
    private String name;
    private String email;
}
