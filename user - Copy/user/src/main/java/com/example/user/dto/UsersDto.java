package com.example.user.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsersDto {
    private Long userId;
    private String userNameDisPlay;
    private String username;
    private String password;
    private byte gender;
    private String img;
    private String phoneNumber;
    private Long roles;
    private String description;
    private byte isActive;
    private String role_name;

}
