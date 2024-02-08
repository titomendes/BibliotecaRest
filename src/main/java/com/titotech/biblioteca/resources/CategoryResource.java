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

import com.titotech.biblioteca.entities.Category;
import com.titotech.biblioteca.services.CategoryService;

@RestController
@RequestMapping(value="/categories")
public class CategoryResource {

    @Autowired
    private CategoryService service;
    
    @GetMapping
    public ResponseEntity<List<Category>> findAlll(){
        List<Category> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value ="/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id ){
        Category obj = service.findById(id);
        return ResponseEntity.ok().body(obj);   
    }

    @PostMapping
    public ResponseEntity<Category> insert(@RequestBody Category obj){
        Category Category = new Category(obj.getId(),obj.getName());
        Category = service.insert(Category);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(Category);
    }
}
