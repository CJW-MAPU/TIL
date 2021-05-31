package com.example.oauth.client.naver;

import com.example.oauth.model.dto.naver.NaverProfileResponseData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@Component
@FeignClient(
        name = "naver-api",
        url = "https://openapi.naver.com"
)
public interface NaverApiClient {

    @GetMapping("/v1/nid/me")
    NaverProfileResponseData getProfile(@RequestHeader("Authorization") String authorization);
}
