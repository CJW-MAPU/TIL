package com.example.demo.model.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TestRequestData {
    private String nickname;
    private String email;
}
