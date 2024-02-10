package com.titotech.biblioteca.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.titotech.biblioteca.entities.Author;
import com.titotech.biblioteca.entities.Book;
import com.titotech.biblioteca.repositories.BookRepository;
import com.titotech.biblioteca.services.exceptions.ObjectNotFound;

@Service
public class BookService {

    @Autowired
    BookRepository repo;

    @Autowired
    AuthorService authorService;

    public List<Book> findAll(){
        return repo.findAll();
    }

    public Book findById(Long id){
        Optional<Book> obj = repo.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFound("Object not found"));
    }
    
    public Book insert(Book obj){//procurar se o autor aj existe pelo nome
        for (Author x : obj.getAuthors()){
            authorService.insert(x);
        }
        return repo.save(obj);
    }
}
