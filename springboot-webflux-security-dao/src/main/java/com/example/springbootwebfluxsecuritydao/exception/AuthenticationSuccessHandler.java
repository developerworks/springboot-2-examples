package com.example.springbootwebfluxsecuritydao.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.server.WebFilterExchange;
import org.springframework.security.web.server.authentication.ServerAuthenticationSuccessHandler;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Slf4j
public class AuthenticationSuccessHandler implements ServerAuthenticationSuccessHandler {
    @Override
    public Mono<Void> onAuthenticationSuccess(WebFilterExchange webFilterExchange, Authentication authentication) {
        log.info("custom AuthenticationSuccessHandler -------------------------> " + authentication.getName());

        ServerWebExchange exchange = webFilterExchange.getExchange();

        return webFilterExchange.getChain().filter(exchange);
    }
}