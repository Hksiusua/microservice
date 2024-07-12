use mybatiscourse;
CREATE TABLE course (
    idCourse BIGINT AUTO_INCREMENT PRIMARY KEY,
    courseName VARCHAR(255) NOT NULL,
    description NVARCHAR(255),
    dateStart DATE,
    dateEnd DATE,
	idTeacher BIGINT not null,
	FOREIGN KEY (idTeacher) REFERENCES mybatisteacher.teacher(idTeacher)
);

CREATE TABLE course_student (
    idCourse BIGINT NOT NULL,
    idStudent BIGINT NOT NULL,
    PRIMARY KEY (idCourse, idStudent),
    FOREIGN KEY (idCourse) REFERENCES course(idCourse),
    FOREIGN KEY (idStudent) REFERENCES mybatisstudent.student(idStudent)
);

INSERT INTO course (courseName, description, dateStart, dateEnd, idTeacher) VALUES 
('Math 101', 'Basic Mathematics', '2024-09-01', '2024-12-31', 2);


INSERT INTO course_student (idCourse, idStudent) VALUES (4, 1);
INSERT INTO course_student (idCourse, idStudent) VALUES (4, 2);


select * from course_student ;
select * from course;

INSERT INTO course (courseName, description, dateStart, dateEnd) VALUES
('Introduction to Programming', 'This course covers basic programming concepts.', '2024-06-01', '2024-06-30'),
('Web Development Fundamentals', 'Learn the fundamentals of web development.', '2024-07-05', '2024-07-31'),
('Database Design and SQL', 'Explore database design principles and SQL queries.', '2024-08-10', '2024-09-10'),
('Object-Oriented Programming', 'Understand the principles of object-oriented programming.', '2024-09-15', '2024-10-15'),
('Data Structures and Algorithms', 'Study various data structures and algorithms.', '2024-10-20', '2024-11-30');

