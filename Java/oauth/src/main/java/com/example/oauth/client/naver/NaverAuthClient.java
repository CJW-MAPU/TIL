package com.example.oauth.client.naver;

import com.example.oauth.model.dto.naver.NaverTokenIssuanceRequestData;
import com.example.oauth.model.dto.naver.NaverTokenIssuanceResponseData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Component
@FeignClient(
        name = "naver-auth",
        url = "https://nid.naver.com/oauth2.0"
)
public interface NaverAuthClient {

    @PostMapping(value = "/token", consumes = "application/x-www-form-urlencoded")
    NaverTokenIssuanceResponseData getToken(@RequestBody NaverTokenIssuanceRequestData request);

}
