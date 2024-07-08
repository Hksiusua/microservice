package com.example.user.service;

import com.example.user.dto.RoleDto;
import com.example.user.entity.RoleE;
import com.example.user.model.RoleM;

import java.util.List;

public interface RoleService {
     List<RoleM> getAllRole(RoleDto roleDto) throws Exception;
}
