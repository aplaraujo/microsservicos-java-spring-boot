package io.github.aplaraujo.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springdoc.core.properties.AbstractSwaggerUiConfigProperties;
import org.springdoc.core.properties.SwaggerUiConfigParameters;
import org.springdoc.core.properties.SwaggerUiConfigProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;

import java.util.*;
import java.util.stream.Collectors;

@Configuration
public class OpenApiConfiguration {

    @Bean
    @Lazy(false)
    public Set<String> apis(
            SwaggerUiConfigParameters swaggerUiConfigParameters,
            RouteDefinitionLocator locator) {

        Set<String> apis = new HashSet<>();

        locator.getRouteDefinitions()
                .filter(routeDefinition -> routeDefinition.getId().matches(".*-service"))
                .subscribe(routeDefinition -> {
                    String name = routeDefinition.getId();
                    String url = "/" + name + "/v3/api-docs";
                    swaggerUiConfigParameters.addGroup(name);
                    apis.add(name);
                });

        return apis;
    }
}

//@Configuration
//public class OpenApiConfiguration {
//    @Bean
//    @Primary
//    public SwaggerUiConfigParameters configParameters(SwaggerUiConfigProperties properties) {
//        return new SwaggerUiConfigParameters(properties);
//    }
//
//    @Bean
//    @Lazy(value = false)
//    public List<GroupedOpenApi> apis(SwaggerUiConfigParameters config, RouteDefinitionLocator locator) {
//
//        List<RouteDefinition> definitions = locator.getRouteDefinitions().collectList().block();
//        List<GroupedOpenApi> groups = new ArrayList<>();
//
//        if (definitions != null) {
//            definitions.stream().filter(routeDefinition -> routeDefinition.getId().matches(".*-service"))
//                    .forEach(routeDefinition -> {
//                        String name = routeDefinition.getId();
//                        config.addGroup(name);
//                        groups.add(GroupedOpenApi.builder()
//                                        .group(name)
//                                        .pathsToMatch("/" + name + "/**")
//                                .build());
//                    });
//        }
//
//        return groups;
//    }
//}
