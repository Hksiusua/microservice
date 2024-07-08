package com.example.user.model;

import com.example.user.entity.UsersE;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsersM {
    private Long userId;
    private String userNameDisPlay;

    private String userName;

    private String password;
    private byte gender;
    private String img;
    private String phoneNumber;
    private String description;
    private Long roles;

    private byte isActive;
    private String role_name;


    public static UsersM conVertUsersEToUsersM(UsersE userE){
        return UsersM.builder()
                .userId(userE.getUserId())
                .userNameDisPlay(userE.getUserNameDisPlay())
                .userName(userE.getUsername())
                .password(userE.getPassword())
                .gender(userE.getGender())
                .img(userE.getImg())
                .phoneNumber(userE.getPhoneNumber())
                .description(userE.getDescription())
                .roles(userE.getRoles())
                .isActive(userE.getIsActive())
                .role_name(userE.getRole_name())
                .build();

    }

    public static List<UsersM>conVertListUsersEToListUsersM(List<UsersE> UsersE) {
        return UsersE.stream()
                .map(e -> conVertUsersEToUsersM(e))
                .collect(Collectors.toList());
    }
}
