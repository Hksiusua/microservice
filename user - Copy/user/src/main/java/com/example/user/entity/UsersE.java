package com.example.user.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsersE {
        private Long userId;
        private String userNameDisPlay;
        private String username;
        private String password;
        private byte gender;
        private String img;
        private String phoneNumber;
        private String description;
        private Long roles;
        private byte isActive;
        private String role_name;

    }
