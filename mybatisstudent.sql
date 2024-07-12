use mybatisstudent;


CREATE TABLE student (
    idStudent BIGINT AUTO_INCREMENT PRIMARY KEY,
    nameStudent VARCHAR(100) NOT NULL,
    maStudent VARCHAR(100) NOT NULL UNIQUE,
    idUser INT not null,
    FOREIGN KEY (idUser) REFERENCES mybatisuser.sys_user(user_id)
);

INSERT INTO student (nameStudent, maStudent, idUser) VALUES ('Nguyen Van A', 'MS123456', 6);
INSERT INTO student (nameStudent, maStudent, idUser) VALUES ('Tran Thi B', 'MS123457', 5);
INSERT INTO student (nameStudent, maStudent, idUser) VALUES ('Nguyen Van c', 'MS12345a', 7);

select * from student