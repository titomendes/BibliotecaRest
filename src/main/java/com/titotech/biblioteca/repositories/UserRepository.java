package com.titotech.biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.titotech.biblioteca.entities.User;

public interface UserRepository extends JpaRepository<User,Long> {
    
}
