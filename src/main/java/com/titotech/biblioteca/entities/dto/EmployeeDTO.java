package com.titotech.biblioteca.entities.dto;

import java.io.Serializable;

import com.titotech.biblioteca.entities.Employee;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

 @Getter
 @Setter
 @NoArgsConstructor
public class EmployeeDTO extends UserDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private String jobTitle;

    public EmployeeDTO(Employee obj){
        super(obj);
        this.jobTitle=obj.getJobTitle();
    }

    public Employee fromDTO(EmployeeDTO empDto){
        Employee emp = new Employee(empDto.getId(), empDto.getUserName(),empDto.getEmail(),empDto.getJobTitle());
        return emp;
    }

}
