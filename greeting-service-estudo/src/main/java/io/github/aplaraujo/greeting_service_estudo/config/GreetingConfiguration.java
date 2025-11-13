package io.github.aplaraujo.greeting_service_estudo.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("greeting-service")
public record GreetingConfiguration(
        String greeting,
        String defaultValue
) {}
