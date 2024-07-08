package com.example.teacher.service.impl;

import com.example.teacher.dto.TeacherDto;
import com.example.teacher.mapper.TeacherMapper;
import com.example.teacher.model.TeacherM;
import com.example.teacher.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Transactional
public class TeacherServiceImpl implements TeacherService {
    final TeacherMapper studentMapper;

    @Override
    public List<TeacherM> getAllTeacher(TeacherDto teacherDto) throws SQLException {
      if(Objects.nonNull(studentMapper.getAllTeacher(teacherDto))) {
          return TeacherM.convertListTeacherEToListTecherMForUser(studentMapper.getAllTeacher(teacherDto));
      }
      return null;
    }
    @Override
    public boolean kiemTraTonTaiTeacher(TeacherDto teacherDto) throws SQLException {
        return studentMapper.kiemTraTonTaiTeacher(teacherDto);
    }

    @Override
    public byte saveTeacher(TeacherDto teacherDto) throws SQLException, Exception {
        var check = kiemTraTonTaiTeacher(teacherDto);
        byte saveStudent = 0;
        if (!check) {
            saveStudent = (byte) studentMapper.insertTeacher(teacherDto);
        } else {
            saveStudent = (byte) studentMapper.updateTeacher(teacherDto);
        }
        return saveStudent;
    }

    @Override
    public boolean deleteTeacher(TeacherDto teacherDto) throws SQLException {
        var check = kiemTraTonTaiTeacher(teacherDto);
        if (check) {
            studentMapper.deleteTeacher(String.valueOf(teacherDto.getMaTeacher()));
        }
        return check;
    }
}
