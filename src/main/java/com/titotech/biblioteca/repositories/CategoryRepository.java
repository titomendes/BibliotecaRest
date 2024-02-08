package com.titotech.biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.titotech.biblioteca.entities.Category;

public interface CategoryRepository extends JpaRepository<Category,Long>  {
    
}
