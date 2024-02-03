package com.titotech.biblioteca.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name="tb_employee")
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class Employee extends User {
    
    private String jobTitle;

    public Employee(Long id, String userName, String email, String jobTitle){
        super(id, userName,email);
        this.jobTitle=jobTitle;
    }
}
