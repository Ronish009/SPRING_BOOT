package com.example.controller;

import com.example.dto.ExceptionResponse;
import com.example.exception.ApplicantNotFoundException;
import com.example.exception.ApplicationNotFoundException;
import com.example.exception.JobNotFoundException;
import com.example.exception.ResumeNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value= ApplicantNotFoundException.class)
    public ResponseEntity<?> ApplicantNotFoundException(ApplicantNotFoundException ex){
        ExceptionResponse exceptionResponse = new  ExceptionResponse(LocalDateTime.now(), ex.getMessage(),"Applicant Not found");
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value= ResumeNotFoundException.class)
    public ResponseEntity<?> ResumeNotFoundException(ResumeNotFoundException ex){
        ExceptionResponse exceptionResponse = new  ExceptionResponse(LocalDateTime.now(), ex.getMessage(),"Resume not found with Applicant Id");
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value= ApplicationNotFoundException.class)
    public ResponseEntity<?> ApplicationNotFoundException(ApplicationNotFoundException ex){
        ExceptionResponse exceptionResponse = new  ExceptionResponse(LocalDateTime.now(), ex.getMessage(),"Applicant not found with given Application");
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value= JobNotFoundException.class)
    public ResponseEntity<?> JobNotFoundException(JobNotFoundException ex){
        ExceptionResponse exceptionResponse = new  ExceptionResponse(LocalDateTime.now(), ex.getMessage(),"Job Not found");
        return new ResponseEntity<>(exceptionResponse, HttpStatus.NOT_FOUND);
    }
}
