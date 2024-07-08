package com.example.student.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.nio.file.AccessDeniedException;

@ControllerAdvice
public class MyHandler {
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleAllExceptions(Exception ex){
        ErrorResponse er = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(er);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ErrorResponse> handleAccessDeniedException(Exception ex) {
        ErrorResponse er = new ErrorResponse(HttpStatus.FORBIDDEN.value(), "Bạn không có quyền truy cập vào tài nguyên này");
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(er);
    }
}
