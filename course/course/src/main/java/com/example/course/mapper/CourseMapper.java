package com.example.course.mapper;

import com.example.course.dto.CourseDto;
import com.example.course.entity.CourseE;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Mapper
public interface CourseMapper {
    List<CourseE> getCourse(CourseDto courseDto);

    int insertCourse(CourseDto courseDto);

    boolean kiemTraTonTaiCourse(CourseDto courseDto);

    int updateCourse(CourseDto courseDto);

    @Transactional
    int deleteCourse(CourseDto courseDto);

    List<CourseE> getCoursesByUserId(CourseDto courseDto);
}
