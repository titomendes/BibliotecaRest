package com.titotech.biblioteca.services;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.titotech.biblioteca.entities.Author;
import com.titotech.biblioteca.entities.Book;
import com.titotech.biblioteca.entities.Category;
import com.titotech.biblioteca.repositories.BookRepository;
import com.titotech.biblioteca.services.exceptions.ObjectAlreadyExistsException;
import com.titotech.biblioteca.services.exceptions.ObjectNotFound;

import jakarta.transaction.Transactional;

@Service
public class BookService {

    @Autowired
    BookRepository repo;

    @Autowired
    AuthorService authorService;

    @Autowired
    CategoryService categoryService;

    public List<Book> findAll(){
        return repo.findAll();
    }

    public Book findById(Long id){
        Optional<Book> obj = repo.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFound("Object not found"));
    }

    public Book findByTitle(String title){
        Optional<Book> obj = repo.findByTitle(title);
        return obj.orElse(null);
    }
    
    @Transactional
    public Book insert(Book obj){
        Set<Author> updatedAuthors = new HashSet<>();
        Set<Category> updatedCategories = new HashSet<>();

        Optional<Book> book = repo.findByTitle(obj.getTitle());
        if(book.isPresent()){
            throw new ObjectAlreadyExistsException("Book with the name "+ obj.getTitle() + " already exists");
        }

        for (Author incomingAuthor : obj.getAuthors()){
            Author author = authorService.findByFirstNameAndLastName(incomingAuthor.getFirstName(),incomingAuthor.getLastName());
            if(author==null){
                author= authorService.insert(incomingAuthor);
            }
            updatedAuthors.add(author);
        }

        for ( Category incomingCategory : obj.getCategories()){
            Category category = categoryService.findByName(incomingCategory.getName());
            if(category==null){
                category= categoryService.insert(incomingCategory);
            }
            updatedCategories.add(category);
        }

            obj.setCategories(updatedCategories);
            obj.setAuthors(updatedAuthors);
            return repo.save(obj);
    }
}
