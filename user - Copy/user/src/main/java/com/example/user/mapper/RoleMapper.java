package com.example.user.mapper;

import com.example.user.dto.RoleDto;
import com.example.user.entity.RoleE;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoleMapper {
       List<RoleE> getAllRole(RoleDto roleDto) throws Exception;

}
