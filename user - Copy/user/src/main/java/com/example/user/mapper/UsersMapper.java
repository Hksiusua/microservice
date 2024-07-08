package com.example.user.mapper;

import com.example.user.dto.UsersDto;
import com.example.user.entity.UsersE;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface UsersMapper {
    List<UsersE> getAllUsers(UsersDto usersDto);

    int insertUsers(UsersDto usersDto);
     boolean kiemTraTonTaiUsers(UsersDto usersDto);
    int updateUsers(UsersDto usersDto);

    UsersE getUserLogin(@Param("username") String username);

}
