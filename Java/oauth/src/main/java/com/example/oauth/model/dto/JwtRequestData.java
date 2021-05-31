package com.example.oauth.model.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JwtRequestData {
    private String nickname;
    private String email;
}
