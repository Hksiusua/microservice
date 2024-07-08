package com.example.course.service;



import com.example.course.dto.CourseDto;
import com.example.course.model.CourseM;

import java.sql.SQLException;
import java.util.List;

public interface CourseService {
    List<CourseM> getCourse(CourseDto courseDto) throws SQLException;
    boolean kiemTraTonTaiCourse(CourseDto courseDto) throws SQLException;

    byte saveCourse(CourseDto courseDto) throws SQLException, Exception;
    byte deleteCourse(CourseDto courseDto) throws SQLException;
    List<CourseM> getCoursesByUserId(CourseDto courseDto) throws SQLException;



}
