package com.example.controller;

import com.example.dto.APIResponse;
import com.example.exception.CronException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(value = CronException.class)
    public ResponseEntity<?> handleException(CronException exception) {
        APIResponse res = new APIResponse(LocalDateTime.now(),exception.getMessage(),"Task is not Present");
        return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
    }
}
