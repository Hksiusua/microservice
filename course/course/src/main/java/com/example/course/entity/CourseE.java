package com.example.course.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CourseE {
    private Long idCourse;
    private String courseName;
    private String description;
    private Date dateStart;
    private Date dateEnd;

}
