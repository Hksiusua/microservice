//package com.example.Gateway;
//
//import org.springframework.cloud.gateway.route.RouteLocator;
//import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class GatewayConfig {
//
//    @Bean
//    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
//        return builder.routes()
//                .route("course", r -> r
//                        .path("/users/getAllCourse")
//                        .uri("lb://course")) // Route to 'course' service
//                .route("student", r -> r
//                        .path("/users/**") // Adjust the path as needed
//                        .uri("lb://student")) // Route to 'student' service
//                .build();
//    }
//}
