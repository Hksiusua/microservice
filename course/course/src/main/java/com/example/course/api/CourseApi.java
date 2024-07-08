package com.example.course.api;

import com.example.course.dto.CourseDto;
import com.example.course.mgt.ResponseObject;
import com.example.course.service.CourseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/course")
@RequiredArgsConstructor
@Slf4j
public class CourseApi {
  @Autowired
    private CourseService courseService;

    @GetMapping("/getAllCourse")
    public ResponseObject<?> doGetUsers(CourseDto courseDto) {
        ResponseObject resultApi = new ResponseObject();
        try {
            resultApi.setData(courseService.getCourse(courseDto));
            resultApi.setSuccess(true);
            resultApi.setMessage("thành công");
        } catch (Exception e) {
            resultApi.setSuccess(false);
            resultApi.setMessage("thất bại");
            log.error("Fail When Call API : " + e);
        }
        return resultApi;
    }

//    @PostMapping("/postSaveCourse")
//    public ResponseObject<?> doPostSaveGiaoHo(@RequestBody CourseDto courseDto) {
//        ResponseObject resultApi = new ResponseObject();
//        try {
//            resultApi.setData(courseService.saveCourse(courseDto));
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
//    @DeleteMapping("/delteCourse")
//    public ResponseObject<?> doDeleteGiaoHo(@RequestBody CourseDto courseDto) {
//        ResponseObject resultApi = new ResponseObject();
//        try {
//            resultApi.setData(courseService.deleteCourse(courseDto));
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
//    @GetMapping("/UserByIdCourse")
//    public ResponseObject<List<CourseE>> getUsersByCourseId(CourseDto courseDto) {
//        ResponseObject<List<CourseE>> resultApi = new ResponseObject<>();
//        try {
//            List<CourseE> coures = courseService.getCoursesByUserId(courseDto);
//            resultApi.setData(coures);
//            resultApi.setSuccess(true);
//            resultApi.setMessage(ApiMessage.GiaoHoMessageApi.SUCCESS_SAVE.getMessage());
//        } catch (Exception e) {
//            resultApi.setSuccess(false);
//            resultApi.setMessage(ApiMessage.GiaoHoMessageApi.CANNOT_SAVE.getMessage());
//            log.error("Fail When Call API: ", e);
//        }
//        return resultApi;
//    }
}
