package com.example.Gateway.repository;

import com.example.Gateway.dto.ApiResponse;
import com.example.Gateway.dto.request.IntrospectRequest;
import com.example.Gateway.dto.response.IntrospectResponse;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.MediaType;
import reactor.core.publisher.Mono;
import org.springframework.web.service.annotation.PostExchange;
import reactor.core.publisher.Mono;
public interface UserClient {
    @PostExchange(url = "/auth/introspect", contentType= MediaType.APPLICATION_JSON_VALUE)
    Mono<ApiResponse<IntrospectResponse>> introspect (@RequestBody IntrospectRequest request);

}

//sttp inter

