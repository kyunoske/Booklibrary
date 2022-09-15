package com.example.booklibrary.controller;

import com.example.booklibrary.model.Book;
import com.example.booklibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService books;

    @GetMapping()
    public List<Book> getAllBooks() {
        return books.getAllBooks();
    }

    @GetMapping(path = "{id}")
    public Book getBookById(@PathVariable String id) {
        return books.getBookId(id);
    }
}

