package com.example.booklibrary.controller;

import com.example.booklibrary.model.Book;
import com.example.booklibrary.service.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @GetMapping()
    public List<Book> getAllBooks() {
        BookService books = new BookService();
        return books.getAllBooks();
    }

    @GetMapping(path = "{id}")
    public Book getBookById(@PathVariable String id) {
        BookService books = new BookService();
        return books.getBookId(id);
    }
    //test
}

