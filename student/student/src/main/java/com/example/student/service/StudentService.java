package com.example.student.service;



import com.example.student.dto.StudentDto;
import com.example.student.model.StudentM;

import java.sql.SQLException;
import java.util.List;

public interface StudentService {
    List<StudentM> getAllUsers(StudentDto studentDto) throws SQLException;
    boolean kiemTraTonTaiUser(StudentDto studentDto) throws SQLException;
    byte saveUser(StudentDto studentDto) throws SQLException, Exception;
    boolean deleteUser(StudentDto studentDto) throws SQLException;


}
