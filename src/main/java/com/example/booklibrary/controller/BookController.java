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
}


//    List<Book> getAllBooks()  die alle Books zurück gibt.
//    Book getBookById(String id ) die ein einzelnes Book zurück gibt
//3. Schreibe Unit Tests und mocke dabei das Repo!
//            4. Implementiere den BookController für den Endpunkt /book , mit folgenden Endpunkten
//    GET /book  der alle Bücher zurück gibt
//    GET /book/{id}  der ein einzelnes Buch zurück gibt
//}
