package com.example.booklibrary.service;

import com.example.booklibrary.model.Book;
import com.example.booklibrary.repository.BookDB;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private BookDB bookDataBase = new BookDB();

    // get all books list
    public List<Book> getAllBooks() {
        return bookDataBase.getAllBooks();
    }

    // get book by id
    public Book getBookId(String bookId) {
        return bookDataBase.getBookById(bookId);
    }
    //test
}
