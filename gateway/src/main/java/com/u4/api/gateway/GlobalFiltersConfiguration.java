package com.u4.api.gateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import reactor.core.publisher.Mono;

@Configuration
public class GlobalFiltersConfiguration {

    final Logger logger = LoggerFactory.getLogger(GlobalFiltersConfiguration.class);

    @Bean
    @Order(1)
    public GlobalFilter secondFilters() {
        return (exchange, chain) -> {
            logger.info("second global pre-filter is executed...");
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                logger.info("second global post-filter is executed...");
            }));
        };
    }

    @Bean
    @Order(2)
    public GlobalFilter thirdFilters() {
        return (exchange, chain) -> {
            logger.info("third global pre-filter is executed...");
            return chain.filter(exchange).then(Mono.fromRunnable(() -> {
                logger.info("first global post-filter is executed...");
            }));
        };
    }
}
