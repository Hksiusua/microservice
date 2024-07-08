package com.example.user.feign;

import com.example.user.configuration.AuthenticationRequestInterceptor;
import com.example.user.dto.StudentDto;
import com.example.user.dto.TeacherDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="teacher", url="localhost:8084",configuration = {AuthenticationRequestInterceptor.class})
public interface TeacherFeignClient {
    @PostMapping("/teacher/postSaveTeacher")
    void createTeacher(
//            @RequestHeader("Authorization") String token,
            @RequestBody TeacherDto teacherDto);
}
