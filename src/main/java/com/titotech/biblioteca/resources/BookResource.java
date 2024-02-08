package com.titotech.biblioteca.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.titotech.biblioteca.entities.Book;
import com.titotech.biblioteca.services.BookService;

@RestController
@RequestMapping(value="/books")
public class BookResource {

    @Autowired
    private BookService service;
    
    @GetMapping
    public ResponseEntity<List<Book>> findAlll(){
        List<Book> list = service.findAll();
       
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value ="/{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id ){
       Book obj = service.findById(id);
       return ResponseEntity.ok().body(obj);   
    }

    @PostMapping
    public ResponseEntity<Book> insert(@RequestBody Book obj){
    
     Book book = new Book(obj.getId(),obj.getTitle());
     book = service.insert(book);
      URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
      return ResponseEntity.created(uri).body(book);
    }
}
