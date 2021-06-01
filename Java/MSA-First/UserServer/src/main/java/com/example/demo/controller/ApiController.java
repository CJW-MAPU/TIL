package com.example.demo.controller;

import com.example.demo.model.dto.TestRequestData;
import com.example.demo.model.dto.TestResponseData;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ApiController {

    @PostMapping("/test")
    public TestResponseData test(TestRequestData requestData) {
        System.out.println(requestData);

        return TestResponseData.builder()
                .UUID("uuid")
                .jwtAccessToken("jwt")
                .jwtRefreshToken("refresh")
                .build();
    }

    @GetMapping("/test/{UUID}")
    public TestResponseData test2(@PathVariable("UUID") String UUID) {

        System.out.println(UUID);

        return TestResponseData.builder()
                .UUID("uuid")
                .jwtAccessToken("jwt")
                .jwtRefreshToken("refresh")
                .build();
    }
}
