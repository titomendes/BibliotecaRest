package com.titotech.biblioteca.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.titotech.biblioteca.entities.Author;
import com.titotech.biblioteca.repositories.AuthorRepository;
import com.titotech.biblioteca.services.exceptions.ObjectNotFound;

@Service
public class AuthorService {

   @Autowired
     AuthorRepository repo;

    public List<Author> findAll(){
        return repo.findAll();
    }

    public Author findById(Long id){ 
        Optional<Author> obj = repo.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFound("Object not found"));
    }
    
    public Author insert(Author obj){
        return repo.save(obj);
    }
    
}
