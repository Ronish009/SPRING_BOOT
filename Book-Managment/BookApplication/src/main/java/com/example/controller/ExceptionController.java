package com.example.controller;

import com.example.exception.BookException;
import com.example.exception.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(BookException.class)
    public ResponseEntity<?> handleException(BookException e) {
        ErrorResponse productNotFound = new ErrorResponse(LocalDateTime.now(), e.getMessage(), "Details Not Found");
        return new ResponseEntity<>(productNotFound, HttpStatus.NOT_FOUND);
        //return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
}
