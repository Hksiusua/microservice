package com.example.user.api;

import com.example.user.dto.RoleDto;
import com.example.user.mgt.ResponseObject;
import com.example.user.service.RoleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class RoleApi {
    @Autowired
    public RoleService roleService;
    @GetMapping("/getAllRole")
    public ResponseObject<?> getAllRole(RoleDto roleDto) {
        ResponseObject resultApi = new ResponseObject();
        try {
            resultApi.setData(roleService.getAllRole(roleDto));
            resultApi.setSuccess(true);
            resultApi.setMessage("Thành công");
        } catch (Exception e) {
            resultApi.setFailMessage(e.getMessage());
            resultApi.setSuccess(false);
            resultApi.setMessage("Thất bại");
            log.error("Fail When Call API : " + e);

        }
        return resultApi;
    }


}
