package com.example.demo.filter;

import com.example.demo.exception.InvalidTokenException;
import com.example.demo.util.TokenUtil;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Component
public class AuthorizationFilter extends AbstractGatewayFilterFactory<AuthorizationFilter.Config> {
    private final TokenUtil tokenUtil;

    public AuthorizationFilter(TokenUtil tokenUtil) {
        super(Config.class);
        this.tokenUtil = tokenUtil;
    }

    @Override
    public GatewayFilter apply(Config config) {
        return ((exchange, chain) -> {
            ServerHttpRequest request = exchange.getRequest();
            ServerHttpResponse response = exchange.getResponse();

            try {
                String token = Objects.requireNonNull(request.getHeaders().get(HttpHeaders.AUTHORIZATION)).get(0);

                tokenUtil.validate(token);

                return chain.filter(exchange);
            } catch (NullPointerException | InvalidTokenException exception) {
                return setResponse(response, config.getBaseMessage());
            }
        });
    }

    private Mono<Void> setResponse(ServerHttpResponse response, String message) {
        response.setStatusCode(HttpStatus.UNAUTHORIZED);
        System.out.println(message);
        return response.setComplete();
    }

    @NoArgsConstructor
    @AllArgsConstructor
    @Getter
    @Setter
    public static class Config {
        private String baseMessage;
    }
}
