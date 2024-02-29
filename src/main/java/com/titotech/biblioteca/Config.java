package com.titotech.biblioteca;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.titotech.biblioteca.entities.Author;
import com.titotech.biblioteca.entities.Book;
import com.titotech.biblioteca.entities.Category;
import com.titotech.biblioteca.entities.Employee;
import com.titotech.biblioteca.entities.User;
import com.titotech.biblioteca.repositories.AuthorRepository;
import com.titotech.biblioteca.repositories.BookRepository;
import com.titotech.biblioteca.repositories.CategoryRepository;
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

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CategoryRepository categoryRepository;
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
        
        
        Author aut1 = new Author(null, "John", "Doe");
        Author aut2 = new Author(null, "Jane", "Doe");
        Author aut3 = new Author(null, "William", "Shakespeare");
        Author aut4 = new Author(null, "Virginia", "Woolf");
        Author aut5 = new Author(null, "Mark", "Twain");

        Category c1 = new Category(null, "Ficção");
        Category c2 = new Category(null, "Romance");
        Category c3 = new Category(null, "Suspense");
        Category c4 = new Category(null, "Fantasia");
        Category c5 = new Category(null, "Não Ficção");

        Book book1 = new Book(null,"Adventures Together");
        book1.addAuthor(aut1);
        book1.addAuthor(aut2);
        book1.addCategory(c1);
        book1.addCategory(c2);
        book1.addCategory(c3);

        Book book2 = new Book(null,"Historical Fiction");
        book2.addAuthor(aut3);
        book2.addAuthor(aut4);
        book2.addCategory(c5);
        book2.addCategory(c4);
        book2.addCategory(c3);

        Book book3 = new Book(null,"Modern Thoughts");
        book3.addAuthor(aut4);
        book3.addAuthor(aut5);
        book3.addCategory(c1);
        book3.addCategory(c2);
        book3.addCategory(c3);

        categoryRepository.saveAll(Arrays.asList(c1,c2,c3,c4,c5));
        userRepository.saveAll(Arrays.asList(user1,user2,user3,user4,user5));
        employeeRepository.saveAll(Arrays.asList(emp1,emp2,emp3,emp4,emp5));
        authorRepository.saveAll((Arrays.asList(aut1,aut2,aut3,aut4,aut5)));
        bookRepository.saveAll(Arrays.asList(book1,book2,book3));
       

        
        
    }
    
}
