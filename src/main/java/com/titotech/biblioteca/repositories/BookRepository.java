package com.titotech.biblioteca.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.titotech.biblioteca.entities.Book;


public interface BookRepository extends JpaRepository<Book,Long>  {
    
    @Query("SELECT b FROM Book b WHERE LOWER(b.title) = LOWER(:title)")
    Optional<Book> findByTitle(String title);
}