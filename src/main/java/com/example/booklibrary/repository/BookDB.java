package com.example.booklibrary.repository;

import com.example.booklibrary.model.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BookDB {

    private Map<String, Book> studentMap = new HashMap<>(
            Map.of(
                    "1", new Book("Hans im Glück", "Jacob Grimm", "1"),
                    "2", new Book("Java ist auch eine Insel", "Christian Ullenboom", "2"),
                    "3", new Book("Die besten Flachwitze für Coaches", "Dominic", "3")));

    public List<Book> getAllStudents(){
        return new ArrayList<Book>(studentMap.values());
    }

    public Book getStudentById(String id){
        return studentMap.get(id);
    }

    public Book deleteStudentById(String id){
        return studentMap.remove(id);
    }

    public Book postNewStudent(Book book){
        return studentMap.put(book.getId(), book);
    }

}
