package com.example.user.service;

import com.example.user.dto.UsersDto;
import com.example.user.entity.UsersE;
import com.example.user.model.UsersM;

import org.apache.ibatis.annotations.Param;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface UsersService {
    List<UsersM> getAllUsers(UsersDto usersDto)throws SQLException;
    byte insertAndUpdateUsers(UsersDto usersDto);
    boolean kiemTraTonTaiUsers(UsersDto usersDto);

    public Optional<UsersE> findByUserName(String userName);
}
