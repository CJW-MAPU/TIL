package com.example.oauth.client.kakao;

import com.example.oauth.model.dto.kakao.KakaoProfileResponseData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@Component
@FeignClient(
        name = "kakao-api",
        url = "https://kapi.kakao.com"
)
public interface KakaoApiClient {

    @PostMapping(value = "/v2/user/me", consumes = "application/x-www-form-urlencoded")
    KakaoProfileResponseData getProfile(@RequestHeader("Authorization") String authorization);

}
