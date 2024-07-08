package com.example.teacher.model;

import com.example.teacher.entity.TeacherE;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class TeacherM {
    private Long idTeacher;
    private String nameTeacher;
    private String maTeacher;
    private Long idUser;
    public static TeacherM convertTeacherEToTeacherM(TeacherE teacherE) {
        return TeacherM.builder()
                .idTeacher(teacherE.getIdTeacher())
                .nameTeacher(teacherE.getNameTeacher())
                .maTeacher(teacherE.getMaTeacher())
                .idUser(teacherE.getIdUser())
                .build();
    }

    public static List<TeacherM> convertListTeacherEToListTecherMForUser(List<TeacherE> giaoDanEList) {
        return giaoDanEList.stream()
                .map(e -> convertTeacherEToTeacherM(e))
                .collect(Collectors.toList());
    }
}
