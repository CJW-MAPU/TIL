package com.example.demo.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;

@Component
public class CustomGlobalFilter implements GlobalFilter {
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpResponse response = exchange.getResponse();
        /*try {
            test();
        } catch (IllegalArgumentException e) {
            byte[] bytes = errorCodeMaker(55).getBytes(StandardCharsets.UTF_8);
            DataBuffer buffer = exchange.getResponse().bufferFactory().wrap(bytes);
            response.setStatusCode(HttpStatus.UNAUTHORIZED);

            return response.writeWith(Flux.just(buffer));
        }*/
        return chain.filter(exchange);
    }
    // NOTE : 프론트에서 데이터를 리턴 받으면 무조건 스트링이라 Json.parse() 이런식으로 파싱을해서 매핑을 해주나
    // NOTE : 그냥 알아서 매핑이 되나 물어보기


    private String errorCodeMaker(int errorCode) {
        return "{\n" +
                "\t\"Error Code\": " + errorCode + ",\n" +
                "\t\"Error Message\": " + "\"Token is Expire\"" +
                "\n}";
    }

    private void test() {
        throw new IllegalArgumentException();
    }
}
