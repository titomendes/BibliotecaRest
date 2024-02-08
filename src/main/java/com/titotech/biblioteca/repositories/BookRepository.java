package com.titotech.biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.titotech.biblioteca.entities.Book;

public interface BookRepository extends JpaRepository<Book,Long>  {
    
}
