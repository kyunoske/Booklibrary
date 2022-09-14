package com.example.booklibrary.service;

import com.example.booklibrary.model.Book;
import com.example.booklibrary.repository.BookDB;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BookServiceTest {

    BookDB bookDataBase = mock(BookDB.class);

    BookService service = new BookService();

    @Test
    void getAllBooks() {
        //Given
        Book book1 = new Book("Hans im Glück", "Jacob Grimm", "1");
        Book book2 = new Book("Java ist auch eine Insel", "Christian Ullenboom", "2");
        Book book3 = new Book("Die besten Flachwitze für Coaches", "Dominic", "3");

        List<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
        books.add(book3);

        when(bookDataBase.getAllBooks()).thenReturn(books);
        //When
        List<Book> actual = service.getAllBooks();

        //Then
        assertEquals(books, actual);
    }

    @Test
    void getBookId() {
        //Given
        String id = "2";
        when(bookDataBase.getBookById(id)).thenReturn(new Book("Java ist auch eine Insel", "Christian Ullenboom", "2"));

        //When
        Book actual = service.getBookId(id);

        //Then
        Book expected = new Book("Java ist auch eine Insel", "Christian Ullenboom", "2");
        assertEquals(expected, actual);
    }
}