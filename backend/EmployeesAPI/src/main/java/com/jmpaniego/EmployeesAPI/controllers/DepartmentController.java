package com.jmpaniego.EmployeesAPI.controllers;

import com.jmpaniego.EmployeesAPI.entities.Department;
import com.jmpaniego.EmployeesAPI.entities.Employee;
import com.jmpaniego.EmployeesAPI.servicies.DepartmentService;
import com.jmpaniego.EmployeesAPI.servicies.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

  @Autowired
  private DepartmentService departmentService;

  @GetMapping(value = {"","/"})
  public ResponseEntity<List<Department>> getAll(){
    return ResponseEntity.ok(
        departmentService.getAll()
    );
  }
}
