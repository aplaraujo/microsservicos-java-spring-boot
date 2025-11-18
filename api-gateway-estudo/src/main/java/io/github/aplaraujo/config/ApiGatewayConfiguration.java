package io.github.aplaraujo.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {
    @Bean
    public RouteLocator router(RouteLocatorBuilder builder) {
        return builder.routes()

                .route("book-service", p -> p.path("/book-service/**")
                        .filters(f -> f.rewritePath("/book-service(?<segment>/?.*)", "/book-service${segment}"))
                        .uri("lb://BOOK-SERVICE-ESTUDO"))

                .route("exchange-service", p -> p.path("/exchange-service/**")
                        .filters(f -> f.rewritePath("/exchange-service(?<segment>/?.*)", "/exchange-service${segment}"))
                        .uri("lb://EXCHANGE-SERVICE-ESTUDO"))

                .build();
    }
}
