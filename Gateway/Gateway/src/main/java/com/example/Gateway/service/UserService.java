package com.example.Gateway.service;

import com.example.Gateway.dto.ApiResponse;
import com.example.Gateway.dto.request.IntrospectRequest;
import com.example.Gateway.dto.response.IntrospectResponse;
import com.example.Gateway.repository.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class UserService {
@Autowired
    private UserClient userClient;

    public Mono<ApiResponse<IntrospectResponse>> introspect(String token) {
        return userClient.introspect(IntrospectRequest.builder().token(token).build());
    }
}
