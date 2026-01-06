package com.example.exception;

public class ApplicantNotFoundException extends RuntimeException{
    public ApplicantNotFoundException(String message){
        super(message);
    }
}
