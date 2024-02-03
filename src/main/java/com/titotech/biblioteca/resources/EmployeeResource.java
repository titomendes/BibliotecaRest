package com.titotech.biblioteca.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.titotech.biblioteca.entities.Employee;
import com.titotech.biblioteca.entities.dto.EmployeeDTO;
import com.titotech.biblioteca.entities.dto.UserDTO;
import com.titotech.biblioteca.services.EmployeeService;

@RestController
@RequestMapping(value="/employees")
public class EmployeeResource {
    
    @Autowired
    private EmployeeService service;


    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> findAlll(){
        List<Employee> list = service.findAll();
        List<EmployeeDTO> listDto = list.stream().map(x -> new EmployeeDTO(x)).collect((Collectors.toList()));
        return ResponseEntity.ok().body(listDto);
    }

    @GetMapping(value ="/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Long id ){
       Employee obj = service.findById(id);
       return ResponseEntity.ok().body(new UserDTO(obj));   
    }

     @PostMapping
    public ResponseEntity<Employee> insert(@RequestBody EmployeeDTO obj){
      EmployeeDTO dto = new EmployeeDTO();
      Employee emp = dto.fromDTO(obj);
      emp = service.insert(emp);
      URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
      return ResponseEntity.created(uri).body(emp);
    }
}

