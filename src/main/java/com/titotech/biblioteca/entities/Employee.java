package com.titotech.biblioteca.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name="tb_employee")
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)//não chamar a classe mãe
@NoArgsConstructor
@AllArgsConstructor
public class Employee extends User {
    
    private String jobTitle;
}
