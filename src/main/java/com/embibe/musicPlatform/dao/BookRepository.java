package com.embibe.musicPlatform.dao;

import org.springframework.data.repository.CrudRepository;

import com.embibe.musicPlatform.model.Book;

/**
 * But that’s what makes Spring Data JPA so powerful: You don’t have to write an implementation of the repository interface.
 * Spring Data JPA creates an implementation on the fly when you run the application
 * Ref: https://spring.io/guides/gs/accessing-data-jpa/
 */
public interface BookRepository extends CrudRepository<Book, Long> {

    // you may or may not want to have specialized methods
    Book findByName(String name);
}
