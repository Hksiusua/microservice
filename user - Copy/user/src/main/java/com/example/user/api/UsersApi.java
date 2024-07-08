package com.example.user.api;

import com.example.user.dto.UsersDto;
import com.example.user.mgt.ResponseObject;
import com.example.user.service.UsersService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UsersApi {
    @Autowired
    public UsersService usersService;

    @GetMapping("/getAllUsers")
    public ResponseObject<?> findAllUsers(UsersDto usersDto) {
        var authentication = SecurityContextHolder.getContext().getAuthentication();
        log.error("Username:{} ", authentication.getName());
        authentication.getAuthorities().forEach(grantedAuthority -> log.error("Authority:{} ", grantedAuthority.getAuthority()));

        ResponseObject resultApi = new ResponseObject();
        try {
            resultApi.setData(usersService.getAllUsers(usersDto));
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

    @PostMapping("/saveUser")
    public ResponseObject<?> saveUser(@RequestBody UsersDto usersDto) {
        ResponseObject resultApi = new ResponseObject();
        try {
            resultApi.setData(usersService.insertAndUpdateUsers(usersDto));
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
