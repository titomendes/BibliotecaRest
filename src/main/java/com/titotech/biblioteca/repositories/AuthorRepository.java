package com.titotech.biblioteca.repositories;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.titotech.biblioteca.entities.Author;

public interface AuthorRepository extends JpaRepository<Author,Long>  {
    
    @Query("SELECT a FROM Author a WHERE LOWER(a.name) = LOWER(:name)")
    Optional<Author> findByName(String name);
}
