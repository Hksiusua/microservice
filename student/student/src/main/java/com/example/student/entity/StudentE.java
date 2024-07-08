package com.example.student.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentE {
    private Long idStudent;
    private String nameStudent;
    private String maStudent;
    private Long idUser;
}
