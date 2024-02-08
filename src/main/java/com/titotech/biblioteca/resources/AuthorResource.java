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

import com.titotech.biblioteca.entities.Author;
import com.titotech.biblioteca.services.AuthorService;

@RestController
@RequestMapping(value=" Authors")
public class AuthorResource {

    @Autowired
    private AuthorService service;
    
    @GetMapping
    public ResponseEntity<List<Author>> findAlll(){
        List<Author> list = service.findAll();
       
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value ="/{id}")
    public ResponseEntity<Author> findById(@PathVariable Long id ){
       Author obj = service.findById(id);
       return ResponseEntity.ok().body(obj);   
    }

    @PostMapping
    public ResponseEntity<Author> insert(@RequestBody Author obj){
    
     Author author = new Author(obj.getId(),obj.getName());
     author = service.insert(author);
      URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
      return ResponseEntity.created(uri).body(author);
    }
}
