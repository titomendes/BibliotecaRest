package com.titotech.biblioteca.services;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.titotech.biblioteca.entities.Author;
import com.titotech.biblioteca.entities.Book;
import com.titotech.biblioteca.repositories.BookRepository;
import com.titotech.biblioteca.services.exceptions.ObjectNotFound;

import jakarta.transaction.Transactional;

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
    
    @Transactional
    public Book insert(Book obj){
        Set<Author> updatedAuthors = new HashSet<>();

        for (Author incomingAuthor : obj.getAuthors()){
            Author author = authorService.findByFirstNameAndLastName(incomingAuthor.getFirstName(),incomingAuthor.getLastName());
            if(author==null){
                author= authorService.insert(incomingAuthor);
            }
            updatedAuthors.add(author);
        }
            obj.setAuthors(updatedAuthors);
            return repo.save(obj);
    }
}
