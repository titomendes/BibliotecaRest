package com.titotech.biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.titotech.biblioteca.entities.Author;

public interface AuthorRepository extends JpaRepository<Author,Long>  {
    
}
