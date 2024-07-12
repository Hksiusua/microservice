use mybatisuser;
-- CREATE TABLE users (
--     idUser BIGINT AUTO_INCREMENT PRIMARY KEY,
-- 	nameRole VARCHAR(50) NOT NULL,
--     usernameUser VARCHAR(50) NOT NULL UNIQUE,
--     passwordUser VARCHAR(100) NOT NULL,
--     emailUser VARCHAR(100) NOT NULL UNIQUE,
--     maUser VARCHAR(100) NOT NULL UNIQUE,
--     enabledUser BOOLEAN NOT NULL DEFAULT TRUE
-- );

-- select * from users;

-- CREATE TABLE role (
--     idRole BIGINT AUTO_INCREMENT PRIMARY KEY,
--     nameRole VARCHAR(50) NOT NULL UNIQUE
-- );

-- CREATE TABLE user_role (
--     user_id BIGINT NOT NULL,
--     role_id BIGINT NOT NULL,
--     PRIMARY KEY (user_id, role_id),
--     FOREIGN KEY (user_id) REFERENCES users(idUser),
--     FOREIGN KEY (role_id) REFERENCES role(idRole)
-- );

-- Insert users
-- INSERT INTO users (usernameUser, passwordUser, emailUser, maUser,nameRole)
-- VALUES ('nghia', '123', 'user1@example.com', 'MA123456789','admin');

-- INSERT INTO users (usernameUser, passwordUser, emailUser, maUser,nameRole)
-- VALUES ('nghia1', '123', 'user2@example.com', 'MA9876543sd21','teacher');

-- INSERT INTO users (usernameUser, passwordUser, emailUser, maUser,nameRole)
-- VALUES ('nghia12ng', '123', 'user3@example.com', 'MA987s621','student');


-- INSERT INTO users (nameRole,usernameUser, passwordUser, emailUser, maUser)
-- VALUES ('student','nghia12nádg', '123', 'usáder3@example.com', 'MAá987s621');

-- -- Insert roles
-- INSERT INTO role (nameRole)
-- VALUES ('admin');

-- INSERT INTO role (nameRole)
-- VALUES ('student');
-- INSERT INTO role (nameRole)
-- VALUES ('teacher');

-- -- Insert user roles
-- INSERT INTO user_role (user_id, role_id)
-- VALUES (1, 1);  -- user1 is assigned the admin role

-- INSERT INTO user_role (user_id, role_id)
-- VALUES (2, 2);  -- user2 is assigned the user role

-- INSERT INTO user_role (user_id, role_id)
-- VALUES (5, 3);

	CREATE TABLE sys_user (
    user_id INT AUTO_INCREMENT,
    username NVARCHAR(50),
    `password` NVARCHAR(200),
    username_display NVARCHAR(50),
    gender BIT,
    age INT,
    phone_number VARCHAR(10),
    `description` NVARCHAR(300),
    img NVARCHAR(200),
    role_id INT,
    is_active BIT DEFAULT 1,
    PRIMARY KEY (user_id),
	FOREIGN KEY (role_id) REFERENCES sys_role(role_id)
);
SHOW COLUMNS FROM sys_user LIKE 'username';


INSERT INTO sys_user (username, `password`, username_display, gender, age, phone_number, `description`, img, role_id, is_active) VALUES
('admin', '$2a$12$NIny3mYBMfoik4VM4XnEVe243AwrlxXndzx3pxyCE6SyQx8ByvEv2', 'Admin User', 1, 30, '1234567890', 'Administrator account', 'admin.png', 1, 1),
('nghia', '$2a$12$qpY0BbLTuGX.6W8eRDYrEOVpzUSNnGHjbTtpq6bRbq2W4emnowsdG', 'Regular User', 1, 25, '0987654321', 'Regular user account', 'user.png', 2, 1),
('nghiadz', '$2a$12$qo74Ff0UV87qIMz3gF4mnO0lNbkv85IB1Owyj8zMw9xMQ2GIZR1yq', 'Guest User', 0, 20, '1112223333', 'Guest user account', 'guest.png', 3, 1);


    
    CREATE TABLE sys_role (
    role_id INT AUTO_INCREMENT,
    role_name NVARCHAR(50),
    `description` NVARCHAR(300),
    PRIMARY KEY (role_id)
);
    
INSERT INTO sys_user (username, `password`, username_display, gender, age, phone_number, `description`, img, roles, is_active)
VALUES ('nghia', '123', 'John Doe', 1, 28, '0123456789', 'An experienced developer', 'img1.jpg', 'ADMIN', 1);

INSERT INTO sys_user (username, `password`, username_display, gender, age, phone_number, `description`, img, roles, is_active)
VALUES ('hoai', '123', 'Jane Smith', 0, 32, '0987654321', 'A proficient data analyst', 'img2.jpg', 'TEACHER', 1);

INSERT INTO sys_user (username, `password`, username_display, gender, age, phone_number, `description`, img, roles, is_active)
VALUES ('vu', '123', 'Alice Jones', 0, 24, '0112233445', 'A junior web designer', 'img3.jpg', 'USER', 1);


INSERT INTO SYS_ROLE(role_name, `description`) values("ROLE_ADMIN", "Main Account - Full Access");
INSERT INTO SYS_ROLE(role_name, `description`) values("ROLE_TEACHER", "Teacher");
INSERT INTO SYS_ROLE(role_name, `description`) values("ROLE_USER", "User");

 SELECT 	u.user_id,
            u.username,
            u.username_display,
            u.img,
            u.password,
            r.role_name
        FROM sys_user u
                 LEFT JOIN sys_role r ON u.role_id = r.role_id
        WHERE u.username = 'admin';
select * from sys_role;
select * from sys_user