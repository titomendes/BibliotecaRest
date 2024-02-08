package com.titotech.biblioteca.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.titotech.biblioteca.entities.Category;
import com.titotech.biblioteca.repositories.CategoryRepository;
import com.titotech.biblioteca.services.exceptions.ObjectNotFound;

@Service
public class CategoryService {

   @Autowired
     CategoryRepository repo;

    public List<Category> findAll(){
        return repo.findAll();
    }

    public Category findById(Long id){ 
        Optional<Category> obj = repo.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFound("Object not found"));
    }
    
    public Category insert(Category obj){
        return repo.save(obj);
    }
    
}
