package com.embibe.musicPlatform.dao;

import org.springframework.stereotype.Component;

import com.embibe.musicPlatform.model.Book;

import java.util.List;

@Component
public class BookService {
    private BookRepository bookRepository;

    // You need to provide the constructor else Spring will have
    // no way to inject your dependency
    // BookRepository is an interface not a bean. So the actual
    // bean will be provided at runtime. See class for more documentation.
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return (List<Book>) bookRepository.findAll();
    }
    
    public void saveBook(Book b) {
        bookRepository.save(b);
    }
}
