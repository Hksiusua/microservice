package com.example.course.service.impl;


import com.example.course.dto.CourseDto;
import com.example.course.mapper.CourseMapper;
import com.example.course.model.CourseM;
import com.example.course.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
   @Autowired
    final CourseMapper courseMapper;

    @Override
    public List<CourseM> getCourse(CourseDto courseDto) throws SQLException {
        var listResultEntity = courseMapper.getCourse(courseDto);
        if (Objects.nonNull(listResultEntity)) {
            return CourseM.convertListCourseEToListUserMForUser(listResultEntity);
        }
        return null;
    }

    @Override
    public boolean kiemTraTonTaiCourse(CourseDto courseDto) throws SQLException {
        return courseMapper.kiemTraTonTaiCourse(courseDto);
    }

    @Override
    public byte saveCourse(CourseDto courseDto) throws SQLException, Exception {
        var exited= this.kiemTraTonTaiCourse(courseDto);
        byte rowAffected = 0;
        if(!exited){
            rowAffected = (byte) courseMapper.insertCourse(courseDto);
        }else{
            rowAffected=(byte) courseMapper.updateCourse(courseDto);
        }
        return 0;
    }

    @Override
    public byte deleteCourse(CourseDto courseDto) throws SQLException {
        return 0;
    }

    @Override
    public List<CourseM> getCoursesByUserId(CourseDto courseDto) throws SQLException {
        return null;
    }

}
