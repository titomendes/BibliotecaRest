package com.titotech.biblioteca.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.titotech.biblioteca.entities.User;

@RestController
@RequestMapping(value="/users")
public class UserResource {
    
    @GetMapping
    public ResponseEntity<User> findUser(){
        User user = new User(null, "tito", "tito@gmail.com");
        return ResponseEntity.ok().body(user);
        
    }

    
}
