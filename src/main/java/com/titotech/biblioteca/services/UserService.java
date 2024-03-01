package com.titotech.biblioteca.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.titotech.biblioteca.entities.User;
import com.titotech.biblioteca.repositories.UserRepository;
import com.titotech.biblioteca.services.exceptions.ObjectNotFound;

 @Service
public class UserService {

    @Autowired
    UserRepository repo;

    public List<User> findAll(){
        return repo.findAll();
    }

    public User findById(Long id){ 
        Optional<User> obj = repo.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFound("Object not found"));
    }
    
    public User insert(User obj){
        return repo.save(obj);
    }

    public User update (Long id, User obj){
        User user = repo.getReferenceById(id);
        updateData(user,obj);
        return repo.save(user);
    }

    private void updateData(User user, User obj) {
        user.setUserName(obj.getUserName());
        user.setEmail(obj.getEmail());
    }
}
