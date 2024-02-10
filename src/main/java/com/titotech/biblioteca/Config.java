package com.titotech.biblioteca;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.titotech.biblioteca.entities.Author;
import com.titotech.biblioteca.entities.Employee;
import com.titotech.biblioteca.entities.User;
import com.titotech.biblioteca.repositories.AuthorRepository;
import com.titotech.biblioteca.repositories.EmployeeRepository;
import com.titotech.biblioteca.repositories.UserRepository;

@Configuration
public class Config implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public void run(String... args) throws Exception {
        
        User user1 = new User(null, "userName1", "email1@example.com");
        User user2 = new User(null, "userName2", "email2@example.com");
        User user3 = new User(null, "userName3", "email3@example.com");
        User user4 = new User(null, "userName4", "email4@example.com");
        User user5 = new User(null, "userName5", "email5@example.com");

        Employee emp1 = new Employee(null, "employee1Username", "employee1email@example.com", "Software Engineer");
        Employee emp2 = new Employee(null, "employee2Username", "employee2email@example.com", "Product Manager");
        Employee emp3 = new Employee(null, "employee3Username", "employee3email@example.com", "Design Lead");
        Employee emp4 = new Employee(null, "employee4Username", "employee4email@example.com", "Quality Assurance");
        Employee emp5 = new Employee(null, "employee5Username", "employee5email@example.com", "Human Resources");
        
        Author aut1 = new Author(null, "Author Name 1");
        Author aut2 = new Author(null, "Author Name 2");
        Author aut3 = new Author(null, "Author Name 3");
        Author aut4 = new Author(null, "Author Name 4");
        Author aut5 = new Author(null, "Author Name 5");

        userRepository.saveAll(Arrays.asList(user1,user2,user3,user4,user5));
        employeeRepository.saveAll(Arrays.asList(emp1,emp2,emp3,emp4,emp5));
        authorRepository.saveAll((Arrays.asList(aut1,aut2,aut3,aut4,aut5)));
    }
    
}
