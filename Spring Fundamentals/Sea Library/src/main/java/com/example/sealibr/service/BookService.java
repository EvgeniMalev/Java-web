package com.example.sealibrary.service;

import java.util.List;

import com.example.sealibrary.model.Book;

public interface BookService {
    List<Book> getAllBooks();
    void saveBook(Book book);
}
