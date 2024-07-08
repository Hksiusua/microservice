package com.example.teacher.service;

import com.example.teacher.dto.TeacherDto;
import com.example.teacher.model.TeacherM;

import java.sql.SQLException;
import java.util.List;

public interface TeacherService {
    List<TeacherM> getAllTeacher(TeacherDto teacherDto) throws SQLException;
    boolean kiemTraTonTaiTeacher(TeacherDto teacherDto) throws SQLException;
    byte saveTeacher(TeacherDto teacherDto) throws SQLException, Exception;
    boolean deleteTeacher(TeacherDto teacherDto) throws SQLException;

}
