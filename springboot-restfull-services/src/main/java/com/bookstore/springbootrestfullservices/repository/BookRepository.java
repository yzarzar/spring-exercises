package com.bookstore.springbootrestfullservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookstore.springbootrestfullservices.enitty.Book;;

public interface BookRepository extends JpaRepository<Book, Long> {
    
}
