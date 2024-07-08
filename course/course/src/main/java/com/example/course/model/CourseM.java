package com.example.course.model;

import com.example.course.entity.CourseE;
import lombok.*;

import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CourseM {
    private Long idCourse;
    private String courseName;
    private String description;
    private Date dateStart;
    private Date dateEnd;


    public static CourseM convertCourseEToCourseM(CourseE courseE) {
        return CourseM.builder()
                .idCourse(courseE.getIdCourse())
                .courseName(courseE.getCourseName())
                .description(courseE.getDescription())
                .dateStart(courseE.getDateStart())
                .dateEnd(courseE.getDateEnd())
                .build();
    }
    public static List<CourseM> convertListCourseEToListUserMForUser(List<CourseE> giaoDanEList) {
        return giaoDanEList.stream()
                .map(e -> convertCourseEToCourseM(e))
                .collect(Collectors.toList());
    }
}
