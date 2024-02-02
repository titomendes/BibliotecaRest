package com.titotech.biblioteca;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.titotech.biblioteca.entities.User;
import com.titotech.biblioteca.repositories.UserRepository;

@Configuration
public class Config implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        
        User user1 = new User(1L, "userName1", "email1@example.com");
        User user2 = new User(2L, "userName2", "email2@example.com");   
        User user3 = new User(3L, "userName3", "email3@example.com");
        User user4 = new User(4L, "userName4", "email4@example.com");
        User user5 = new User(5L, "userName5", "email5@example.com");
      
       userRepository.saveAll(Arrays.asList(user1,user2,user3,user4,user5));
    }
    
}
