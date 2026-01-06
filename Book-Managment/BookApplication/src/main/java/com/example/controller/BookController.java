package com.example.controller;

import com.example.config.ConfigData;
import com.example.dto.APIResponse;
import com.example.entity.Book;
import com.example.exception.BookException;
import com.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("book/v1")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/addBook")
    public ResponseEntity<Book> addTitle(@RequestBody Book book) {
        Book savebook = bookService.addBook(book);
        return ResponseEntity.ok().body(savebook);
    }

    @GetMapping("/getTitle/{title}")
    public ResponseEntity<Book> findByTitle(@PathVariable("title") String title) {
        Book savebook = bookService.getBook(title);
        return ResponseEntity.ok().body(savebook);
    }

    @PutMapping("/updateTitle")
    public ResponseEntity<Book> updateTitle(@RequestBody Book book) {
        Book savebook = bookService.updateBook(book);
        return ResponseEntity.ok().body(savebook);
    }

    @GetMapping("/getAllBook")
    public ResponseEntity<List<Book>> addTitle() {
        List<Book> getBook = bookService.findAll();
        return ResponseEntity.ok().body(getBook);
    }

    @DeleteMapping("/deleteBook/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable("id") Integer id) {
        bookService.deleteBook(id);
        return ResponseEntity.ok(new APIResponse("Book deleted successfully"));
    }
}
