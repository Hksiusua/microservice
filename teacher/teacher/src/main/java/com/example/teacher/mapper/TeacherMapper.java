package com.example.teacher.mapper;


import com.example.teacher.dto.TeacherDto;
import com.example.teacher.entity.TeacherE;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Mapper
public interface TeacherMapper {
    List<TeacherE> getAllTeacher(TeacherDto teacherDto);

    int insertTeacher(TeacherDto teacherDto);

    boolean kiemTraTonTaiTeacher(TeacherDto teacherDto);

    int updateTeacher(TeacherDto teacherDto);

    @Transactional
    int deleteTeacher(@Param("maUser") String maUser);

}
