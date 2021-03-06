package com.example.demo.model.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TestResponseData {
    private String UUID;
    private String jwtAccessToken;
    private String jwtRefreshToken;
}
