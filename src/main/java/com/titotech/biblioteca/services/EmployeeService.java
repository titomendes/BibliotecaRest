package com.titotech.biblioteca.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.titotech.biblioteca.entities.Employee;
import com.titotech.biblioteca.repositories.EmployeeRepository;
import com.titotech.biblioteca.services.exceptions.ObjectNotFound;

@Service
public class EmployeeService {

     @Autowired
     EmployeeRepository repo;

    public List<Employee> findAll(){
        return repo.findAll();
    }

    public Employee findById(Long id){ 
        Optional<Employee> obj = repo.findById(id);
        return obj.orElseThrow(()-> new ObjectNotFound("Object not found"));
    }
    
    public Employee insert(Employee obj){
        return repo.save(obj);
    }
}
