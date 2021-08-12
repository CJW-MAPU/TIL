package com.example.oauth.model.dto.naver;

import lombok.*;

import java.util.Map;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class NaverProfileResponseData {
    private String resultcode;
    private String message;
    private Map<String, Object> response;
}
