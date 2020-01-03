package com.pedro.webfluxdemo.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

@Component
@Slf4j
public class LogFilter implements WebFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange serverWebExchange, WebFilterChain webFilterChain) {
        String id = serverWebExchange.getRequest().getId();
        String path = serverWebExchange.getRequest().getPath().toString();
        log.info("request [{}] -> from [{}] is coming", id, path);
        return webFilterChain.filter(serverWebExchange);
    }
}
