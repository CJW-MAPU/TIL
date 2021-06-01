package com.example.oauth.client;

import com.example.oauth.model.dto.JwtRequestData;
import com.example.oauth.model.dto.JwtResponseData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Component
@FeignClient(
        name = "user-service"
)
public interface UserServiceClient {

    @GetMapping(value = "/api/test/{UUID}", consumes = "application/x-www-form-urlencoded")
    JwtResponseData login(@PathVariable("UUID") String UUID);

    @PostMapping(value = "/api/test", consumes = "application/x-www-form-urlencoded")
    JwtResponseData register(JwtRequestData requestData);
}
