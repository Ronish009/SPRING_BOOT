package com.example.controller;

import com.example.WeatherApplication;
import com.example.dto.APIResponse;
import com.example.exception.CityException;
import com.example.exception.WeatherException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class RequestExceptionHandler {

    @ExceptionHandler(value = CityException.class)
    public ResponseEntity<?> handleException(CityException exception) {
        APIResponse res = new APIResponse(LocalDateTime.now(),exception.getMessage(),"City is not present");
        return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = WeatherException.class)
    public ResponseEntity<?> handleException(WeatherException exception) {
        APIResponse res = new APIResponse(LocalDateTime.now(),exception.getMessage(), "Weather is Not Present");
        return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
    }


}
