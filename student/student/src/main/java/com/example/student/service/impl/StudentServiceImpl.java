package com.example.student.service.impl;


import com.example.student.dto.StudentDto;
import com.example.student.mapper.StudentMapper;
import com.example.student.model.StudentM;
import com.example.student.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Transactional
public class StudentServiceImpl implements StudentService {
    final StudentMapper studentMapper;
    @Override
    public List<StudentM> getAllUsers(StudentDto studentDto) throws SQLException {
        var students = studentMapper.getAllUsers(studentDto);
        if (Objects.nonNull(students)) {
            return StudentM.convertListUserEToListUserMForUser(students);
        }
        return null;
    }
    @Override
    public boolean kiemTraTonTaiUser(StudentDto studentDto) throws SQLException {
        return studentMapper.kiemTraTonTaiUser(studentDto);
    }
    @Override
    public byte saveUser(StudentDto studentDto) throws SQLException, Exception {
        var check = kiemTraTonTaiUser(studentDto);
        byte saveStudent = 0;
        if (!check) {
            saveStudent = (byte) studentMapper.insertStudent(studentDto);
        } else {
            saveStudent = (byte) studentMapper.updateStudent(studentDto);
        }
        return saveStudent;
    }
    @Override
    public boolean deleteUser(StudentDto studentDto) throws SQLException {
        var check = kiemTraTonTaiUser(studentDto);
        if (check) {
            studentMapper.deleteUser(String.valueOf(studentDto.getMaStudent()));
        }
        return check;
    }




}
