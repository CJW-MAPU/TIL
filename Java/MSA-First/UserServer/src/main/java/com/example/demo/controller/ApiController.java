package com.example.demo.controller;

import com.example.demo.model.dto.TestRequestData;
import com.example.demo.model.dto.TestResponseData;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {

    @PostMapping("/test")
    public TestResponseData test(TestRequestData requestData) {
        System.out.println(requestData);

        return TestResponseData.builder()
                .UUID(1L)
                .jwtAccessToken("jwt")
                .jwtRefreshToken("refresh")
                .build();
    }
}
