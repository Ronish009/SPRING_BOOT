package com.example.service;

import com.example.config.ConfigData;
import com.example.entity.Book;
import com.example.exception.BookException;
import com.example.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public ConfigData configData;

    @Autowired
    public BookService(ConfigData ConfigData) {
        this.configData = ConfigData;
    }
    @Transactional(transactionManager = "transactionManager")
    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public Book getBook(String bookName) {
        System.out.println("Developer : "+configData.developer());
        System.out.println("Information : "+configData.comment());
        return bookRepository.findByTitle(bookName).orElseThrow(()->new BookException("Book not found with title"));
    }

    public Book updateBook(Book book) {
        return bookRepository.save(book);
    }

    public List<Book> findAll() {
    return bookRepository.findAll();
    }

    public void deleteBook(Integer id) {
        bookRepository.deleteById(id);
    }
}
