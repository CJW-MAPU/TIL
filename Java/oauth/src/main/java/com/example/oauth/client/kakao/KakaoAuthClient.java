package com.example.oauth.client.kakao;

import com.example.oauth.model.dto.kakao.KakaoTokenIssuanceRequestData;
import com.example.oauth.model.dto.kakao.KakaoTokenIssuanceResponseData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Component
@FeignClient(
        name = "kakao-oauth",
        url = "https://kauth.kakao.com"
)
public interface KakaoAuthClient {

    @PostMapping(value = "/oauth/token", consumes = "application/x-www-form-urlencoded")
    KakaoTokenIssuanceResponseData getToken(@RequestBody KakaoTokenIssuanceRequestData request);
}
