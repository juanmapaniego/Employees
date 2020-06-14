package com.jmpaniego.EmployeesAPI.controllers;

import com.jmpaniego.EmployeesAPI.entities.Department;
import com.jmpaniego.EmployeesAPI.entities.Employee;
import com.jmpaniego.EmployeesAPI.servicies.DepartmentService;
import com.jmpaniego.EmployeesAPI.servicies.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
@CrossOrigin("http://localhost:4200")
public class DepartmentController {

  @Autowired
  private DepartmentService departmentService;

  @GetMapping(value = {"","/"})
  public ResponseEntity<List<Department>> getAll(){
    return ResponseEntity.ok(
        departmentService.getAll()
    );
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<Department> getDepartmentById(@PathVariable Long id){
    return ResponseEntity.ok(
        departmentService.getDepartmentById(id)
    );
  }

  @GetMapping(value = "/{id}/employee")
  public ResponseEntity<List<Employee>> getEmployeesById(@PathVariable Long id){
    return ResponseEntity.ok(
        departmentService.getEmployeesById(id)
    );
  }
}
