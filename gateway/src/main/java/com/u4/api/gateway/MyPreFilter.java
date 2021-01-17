package com.u4.api.gateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Set;


// it takes in the ServerWebExchange object from which we can read the details of the http request, process the details
// and if needed add new details and then pass this ServerWebExchange object to the next filter in chain. Once all pre
// filters are executed, spring cloud API gateway will route the request to the destination MS

@Component
public class MyPreFilter implements GlobalFilter, Ordered {

    final Logger logger = LoggerFactory.getLogger(MyPreFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        logger.info("first global pre-filter is executed...");

        String requestPath = exchange.getRequest().getPath().toString();
        logger.info("Request path = " + requestPath);

        HttpHeaders headers = exchange.getRequest().getHeaders();

        Set<String> headerNames = headers.keySet();

        headerNames.forEach((headerName) -> {
            String headerValue = headers.getFirst(headerName);
            logger.info(headerName + ": " + headerValue);
        });

        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
