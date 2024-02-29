package com.titotech.biblioteca.entities.dto;

import com.titotech.biblioteca.entities.Employee;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

 @Getter
 @Setter
 @NoArgsConstructor
public class EmployeeDTO extends UserDTO{
   
    
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
