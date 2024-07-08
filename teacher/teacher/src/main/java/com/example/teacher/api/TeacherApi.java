package com.example.teacher.api;

import com.example.teacher.dto.TeacherDto;
import com.example.teacher.mgt.ResponseObject;
import com.example.teacher.service.TeacherService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/teacher")
public class TeacherApi {
    @Autowired
    private TeacherService teacherService;
    @GetMapping("/getAllStudent")
    public ResponseObject<?> doGetTeacher(TeacherDto teacherDto) {
        ResponseObject resultApi = new ResponseObject();
        try {
            resultApi.setData(teacherService.getAllTeacher(teacherDto));
            resultApi.setSuccess(true);
            resultApi.setMessage("Thành công");
        } catch (Exception e) {
            resultApi.setSuccess(false);
            resultApi.setMessage("Thất bại");
            log.error("Fail When Call API : " + e);
        }
        return resultApi;
    }
    @PostMapping("/postSaveTeacher")
    public ResponseObject<?> saveTeacher(@RequestBody TeacherDto teacherDto) {
        System.out.println("Received student: " + teacherDto);
        ResponseObject resultApi = new ResponseObject();
        try {
            resultApi.setData(teacherService.saveTeacher(teacherDto));
            resultApi.setSuccess(true);
            resultApi.setMessage("Thành công");
        } catch (Exception e) {
            resultApi.setSuccess(false);
            resultApi.setMessage("fail");
            log.error("Fail When Call API  : ", e);
        }
        return resultApi;
    }
}
