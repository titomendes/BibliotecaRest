package com.titotech.biblioteca.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.titotech.biblioteca.entities.Category;

public interface CategoryRepository extends JpaRepository<Category,Long>  {
    
    @Query("SELECT c FROM Category c WHERE LOWER(c.name) = LOWER(:name)")
    Optional<Category> findByName(String name);
}
