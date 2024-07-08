package com.example.user.service.impl;

import com.example.user.dto.RoleDto;
import com.example.user.mapper.RoleMapper;
import com.example.user.model.RoleM;
import com.example.user.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
  @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<RoleM> getAllRole(RoleDto roleDto) throws Exception {
        var roles =  roleMapper.getAllRole(roleDto);
        if(Objects.nonNull(roles)){
        return RoleM.conVertListRoleEToListRoleM(roles);
        }
        return null;
    }
}
