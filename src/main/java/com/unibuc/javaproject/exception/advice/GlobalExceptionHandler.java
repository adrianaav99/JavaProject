package com.unibuc.javaproject.exception.advice;

import com.unibuc.javaproject.exception.EntityNotFoundException;
import com.unibuc.javaproject.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handle(MethodArgumentNotValidException e) {
        return ResponseEntity.badRequest()
                .body("Invalid value : " + e.getFieldError().getRejectedValue() +
                        " for field " + e.getFieldError().getField() +
                        " with message " + e.getFieldError().getDefaultMessage());
    }
    @ExceptionHandler({EntityNotFoundException.class})
    public ResponseEntity<String> handle(EntityNotFoundException e) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(e.getMessage());
    }

    @ExceptionHandler({NotFoundException.class})
    public ResponseEntity<String> handle(NotFoundException e) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(e.getMessage() + "at " + LocalDateTime.now());
    }
}
