package com.example.student.mapper;


import com.example.student.dto.StudentDto;
import com.example.student.entity.StudentE;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Mapper
public interface StudentMapper {
    List<StudentE> getAllUsers(StudentDto studentDto);

    int insertStudent(StudentDto studentDto);

    boolean kiemTraTonTaiUser(StudentDto studentDto);

    int updateStudent(StudentDto studentDto);

    @Transactional
    int deleteUser(@Param("maUser") String maUser);

}
