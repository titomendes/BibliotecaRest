package com.titotech.biblioteca;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.titotech.biblioteca.entities.Employee;
import com.titotech.biblioteca.entities.User;
import com.titotech.biblioteca.repositories.EmployeeRepository;
import com.titotech.biblioteca.repositories.UserRepository;

@Configuration
public class Config implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

     @Autowired
     private EmployeeRepository employeeRepository;

    @Override
    public void run(String... args) throws Exception {
        
        User user1 = new User(1L, "userName1", "email1@example.com");
        User user2 = new User(2L, "userName2", "email2@example.com");   
        User user3 = new User(3L, "userName3", "email3@example.com");
        User user4 = new User(4L, "userName4", "email4@example.com");
        User user5 = new User(5L, "userName5", "email5@example.com");

        Employee emp1 = new Employee(1L, "employee1Username", "employee1email@example.com", "Software Engineer");
        Employee emp2 = new Employee(2L, "employee2Username", "employee2email@example.com", "Product Manager");
        Employee emp3 = new Employee(3L, "employee3Username", "employee3email@example.com", "Design Lead");
        Employee emp4 = new Employee(4L, "employee4Username", "employee4email@example.com", "Quality Assurance");
        Employee emp5 = new Employee(5L, "employee5Username", "employee5email@example.com", "Human Resources");
      
       userRepository.saveAll(Arrays.asList(user1,user2,user3,user4,user5));
       employeeRepository.saveAll(Arrays.asList(emp1,emp2,emp3,emp4,emp5));
    }
    
}
