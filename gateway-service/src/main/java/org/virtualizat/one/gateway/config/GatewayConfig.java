package org.virtualizat.one.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("plugin-service", r -> r.path("/plugin/**")
                        .uri("lb://PLUGIN-SERVICE"))
                .build();

    }
}
