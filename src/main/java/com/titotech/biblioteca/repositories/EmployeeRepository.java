package com.titotech.biblioteca.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.titotech.biblioteca.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    
}
