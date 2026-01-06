package com.example.exception;

import com.example.entity.Book;

public class BookException extends RuntimeException {
    public BookException(String message) {
        super(message);
    }
}
