package com.example.student.model;

import com.example.student.entity.StudentE;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentM {
    private Long idStudent;
    private String nameStudent;
    private String maStudent;
    private Long idUser;
    public static StudentM convertStudentEToStudentM(StudentE studentE) {
        return StudentM.builder()
                .idStudent(studentE.getIdStudent())
                .nameStudent(studentE.getNameStudent())
                .maStudent(studentE.getMaStudent())
                .idUser(studentE.getIdUser())
                .build();
    }
    public static List<StudentM> convertListUserEToListUserMForUser(List<StudentE> giaoDanEList) {
        return giaoDanEList.stream()
                .map(e -> convertStudentEToStudentM(e))
                .collect(Collectors.toList());
    }
}
