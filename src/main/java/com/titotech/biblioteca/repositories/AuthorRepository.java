package com.titotech.biblioteca.repositories;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.titotech.biblioteca.entities.Author;

public interface AuthorRepository extends JpaRepository<Author,Long>  {
    
    Optional<Author> findByFirstNameAndLastName(String firstName,String lastName);
}
