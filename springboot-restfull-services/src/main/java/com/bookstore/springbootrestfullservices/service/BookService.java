package com.bookstore.springbootrestfullservices.service;

import java.util.List;

import com.bookstore.springbootrestfullservices.enitty.*;;;

public interface BookService {

    Book createBook(Book book);
    Book getBookById(Long bookId);
    List<Book> getAllBooks();
    Book updateBook(Book book);
    void deleteBook(Long bookId);
} 
