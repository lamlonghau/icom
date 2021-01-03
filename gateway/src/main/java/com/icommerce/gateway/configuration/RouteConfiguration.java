package com.icommerce.gateway.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RouteConfiguration {

    @Value("${product.service.url}")
    private String productService;

    @Value("${order.service.url}")
    private String orderService;

    @Value("${userlog.service.url}")
    private String userlogService;

    @Value("${shopcard.service.url}")
    private String shopCardService;

    @Bean
    public RouteLocator config(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("productService", p -> p.path( "/product-service/**").uri(productService))
                .route("orderService", p -> p.path("/order-service/**").uri(orderService))
                .route("userlogService", p -> p.path("/userlog-service/**").uri(userlogService))
                .route("userlogService", p -> p.path("/shopcard-service/**").uri(shopCardService))
                .build();
    }
}
