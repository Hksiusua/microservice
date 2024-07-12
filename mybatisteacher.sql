use mybatisteacher;

CREATE TABLE teacher (
    idTeacher BIGINT AUTO_INCREMENT PRIMARY KEY,
    nameTeacher VARCHAR(100) NOT NULL,
    maTeacher VARCHAR(100) NOT NULL UNIQUE,
    idUser INT not null,
    FOREIGN KEY (idUser) REFERENCES mybatisuser.sys_user(user_id)
);

SELECT * FROM teacher;

INSERT INTO teacher (nameTeacher, maTeacher, idUser) 
VALUES ('John Doe', 'T001', 7);

INSERT INTO teacher (nameTeacher, maTeacher, idUser) 
VALUES ('Jane Smith', 'T002', 8);

