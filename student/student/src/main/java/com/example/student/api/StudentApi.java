package com.example.student.api;


import com.example.student.dto.StudentDto;
import com.example.student.mgt.ResponseObject;
import com.example.student.service.StudentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/student")
public class StudentApi {
@Autowired
    private StudentService studentService;

    @GetMapping("/getAllStudent")
    public ResponseObject<?> doGetUsers(StudentDto studentDto) {
        ResponseObject resultApi = new ResponseObject();
        try {
            resultApi.setData(studentService.getAllUsers(studentDto));
            resultApi.setSuccess(true);
            resultApi.setMessage("Thành công");
        } catch (Exception e) {
            resultApi.setSuccess(false);
            resultApi.setMessage("Thất bại");
          log.error("Fail When Call API : " + e);
        }
        return resultApi;
    }
    @PostMapping("/postSaveStudent")
    public ResponseObject<?> saveStudent(@RequestBody StudentDto studentDto) {
        System.out.println("Received student: " + studentDto);
        ResponseObject resultApi = new ResponseObject();
        try {
            resultApi.setData(studentService.saveUser(studentDto));
            resultApi.setSuccess(true);
            resultApi.setMessage("Thành công");
        } catch (Exception e) {
            resultApi.setSuccess(false);
            resultApi.setMessage("fail");
            log.error("Fail When Call API  : ", e);
        }
        return resultApi;
    }
//
//    @DeleteMapping ("/delteUser")
//    public ResponseObject<?> doDeleteGiaoHo(@RequestBody UserDto userDto) {
//        ResponseObject resultApi = new ResponseObject();
//        try {
//            resultApi.setData(userService.deleteUser(userDto));
//            resultApi.setSuccess(true);
//            resultApi.setMessage(ApiMessage.GiaoHoMessageApi.SUCCESS_SAVE.getMessage());
//        } catch (Exception e) {
//            resultApi.setSuccess(false);
//            resultApi.setMessage(ApiMessage.GiaoHoMessageApi.CANNOT_SAVE.getMessage());
//            log.error("Fail When Call API  : ", e);
//        }
//        return resultApi;
//    }
//
//


}

