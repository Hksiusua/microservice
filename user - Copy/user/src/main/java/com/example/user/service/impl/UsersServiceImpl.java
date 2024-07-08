package com.example.user.service.impl;

import com.example.user.dto.StudentDto;
import com.example.user.dto.TeacherDto;
import com.example.user.dto.UsersDto;
import com.example.user.entity.UsersE;
import com.example.user.feign.StudentFeignClient;
import com.example.user.feign.TeacherFeignClient;
import com.example.user.mapper.UsersMapper;
import com.example.user.model.UsersM;
import com.example.user.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.sql.SQLException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {
    private static final Logger log = LoggerFactory.getLogger(UsersServiceImpl.class);
    final UsersMapper usersMapper;
    final StudentFeignClient studentFeignClient;
    final TeacherFeignClient teacherFeignClient;
    final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);

    @Override
    public List<UsersM> getAllUsers(UsersDto usersDto) throws SQLException {
        var users = usersMapper.getAllUsers(usersDto);
        if (Objects.nonNull(users)) {
            return UsersM.conVertListUsersEToListUsersM(users);
        }
        return null;
    }


    @Override
    public boolean kiemTraTonTaiUsers(UsersDto usersDto) {
        return usersMapper.kiemTraTonTaiUsers(usersDto);
    }

    @Override
    public Optional<UsersE> findByUserName(String userName) {
        UsersE userLogin = usersMapper.getUserLogin(userName);
        if (Objects.nonNull(userLogin)) return Optional.of(userLogin);
        return Optional.empty();
    }


//    @Override
//    public byte insertAndUpdateUsers(UsersDto usersDto) {
//        var check = this.kiemTraTonTaiUsers(usersDto);
//        byte save = 0;
//        if (!check) {
//            // Mã hóa mật khẩu trước khi lưu
//            String encodedPassword = passwordEncoder.encode(usersDto.getPassword());
//            usersDto.setPassword(encodedPassword);
//
//            usersDto.setRoles(3L);
//            save = (byte) usersMapper.insertUsers(usersDto);
//
//            // Lấy idUser từ usersDto sau khi insert
//            Long idUser = usersDto.getUserId();
//
//            // Tạo đối tượng Student từ thông tin người dùng
//            StudentDto studentDto = new StudentDto();
//            studentDto.setNameStudent(usersDto.getUsername());
//            studentDto.setMaStudent(usersDto.getPhoneNumber());
//            studentDto.setIdUser(idUser);  // Đảm bảo idUser không null
//
//            // Log dữ liệu trước khi gửi
//            System.out.println("Sending student data: " + studentDto);
//
//            // MUỐN SỬ DỤNG INTERCEPTOR THÌ CẦN CÁI NÀY
////            ServletRequestAttributes servletRequestAttributes =
////                    (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
////            assert servletRequestAttributes != null;
////            var authHeader = servletRequestAttributes.getRequest().getHeader("Authorization");
////            log.warn("header: {}", authHeader);
//
//            // Gửi thông tin sinh viên đến microservice quản lý khóa học
////     cách1       studentFeignClient.createStudent(authHeader, studentDto);
//            studentFeignClient.createStudent(studentDto);
//
//
//
//
//        } else {
//            save = (byte) usersMapper.updateUsers(usersDto);
//        }
//        return save;
//    }

    public byte insertAndUpdateUsers(UsersDto usersDto) {
        var check = this.kiemTraTonTaiUsers(usersDto);
        byte save = 0;
        if (!check) {
            // Mã hóa mật khẩu trước khi lưu
            String encodedPassword = passwordEncoder.encode(usersDto.getPassword());
            usersDto.setPassword(encodedPassword);

            if ("teacher".equalsIgnoreCase(usersDto.getDescription())) {
                usersDto.setRoles(2L);
                save = (byte) usersMapper.insertUsers(usersDto);

                // Lấy idUser từ usersDto sau khi insert
                Long idUser = usersDto.getUserId();

                // Tạo đối tượng Teacher từ thông tin người dùng
                TeacherDto teacherDto = new TeacherDto();
                teacherDto.setNameTeacher(usersDto.getUsername());
                teacherDto.setMaTeacher(usersDto.getPhoneNumber());
                teacherDto.setIdUser(idUser);  // Đảm bảo idUser không null

                // Log dữ liệu trước khi gửi
                System.out.println("Sending teacher data: " + teacherDto);

                // Gửi thông tin giáo viên đến microservice quản lý giáo viên
                teacherFeignClient.createTeacher(teacherDto);
            } else if ("student".equalsIgnoreCase(usersDto.getDescription())) {
                usersDto.setRoles(3L);
                save = (byte) usersMapper.insertUsers(usersDto);

                // Lấy idUser từ usersDto sau khi insert
                Long idUser = usersDto.getUserId();

                // Tạo đối tượng Student từ thông tin người dùng
                StudentDto studentDto = new StudentDto();
                studentDto.setNameStudent(usersDto.getUsername());
                studentDto.setMaStudent(usersDto.getPhoneNumber());
                studentDto.setIdUser(idUser);  // Đảm bảo idUser không null

                // Log dữ liệu trước khi gửi
                System.out.println("Sending student data: " + studentDto);

                // Gửi thông tin sinh viên đến microservice quản lý sinh viên
                studentFeignClient.createStudent(studentDto);
            }
        } else {
            save = (byte) usersMapper.updateUsers(usersDto);
        }
        return save;
    }




}
