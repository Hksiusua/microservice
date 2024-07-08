package com.example.user.feign;

import com.example.user.configuration.AuthenticationRequestInterceptor;
import com.example.user.dto.StudentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name="student", url="localhost:8082",configuration = {AuthenticationRequestInterceptor.class})
public interface StudentFeignClient {
    @PostMapping("/student/postSaveStudent")
    void createStudent(
//            @RequestHeader("Authorization") String token,
            @RequestBody StudentDto studentDto);
}
