package com.jmpaniego.EmployeesAPI.controllers;

import com.jmpaniego.EmployeesAPI.entities.Employee;
import com.jmpaniego.EmployeesAPI.exceptions.DepartmentNotExistException;
import com.jmpaniego.EmployeesAPI.exceptions.EmployeeNotFoundException;
import com.jmpaniego.EmployeesAPI.servicies.DepartmentService;
import com.jmpaniego.EmployeesAPI.servicies.EmployeeService;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
@CrossOrigin("http://localhost:4200")
public class EmployeeController {

  @Autowired
  private EmployeeService employeeService;
  @Autowired
  private DepartmentService departmentService;

  @GetMapping(value = {"","/"})
  public ResponseEntity<List<Employee>> getAll(){
    return ResponseEntity.ok(
        employeeService.getAll()
    );
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<?> getById(@PathVariable Long id){
      return ResponseEntity.ok(employeeService.getById(id));
  }

  @GetMapping(value = "/{id}/avatar",
              produces = MediaType.IMAGE_PNG_VALUE
  )
  public @ResponseBody byte[] getAvatarById(@PathVariable Long id){
    byte[] avatar = employeeService.getById(id).getAvatar();
    return avatar;
  }

  @PostMapping(value = {"","/"})
  public ResponseEntity<Employee> create(@RequestBody Employee employee){
    employee.setDepartment(departmentService.findByName(employee.getDepartment().getName()));
    return ResponseEntity.ok(employeeService.save(employee));
  }

  @PutMapping(value = "/{id}")
  public ResponseEntity<Employee> update(@PathVariable("id") Long id,@RequestBody Employee employee){
    employee.setId(id);
    return ResponseEntity.ok(employeeService.update(employee));
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<String> update(@PathVariable("id") Long id){
    employeeService.deleteById(id);
    return ResponseEntity.ok(String.format("Employee %d deleted",id));
  }

  @ExceptionHandler(EmployeeNotFoundException.class)
  public ResponseEntity<String> employeeNotFound(EmployeeNotFoundException enfe){
    return new ResponseEntity(enfe.getMessage(),HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler(DepartmentNotExistException.class)
  public ResponseEntity<String> departmentNotExist(DepartmentNotExistException dne){
    return ResponseEntity.badRequest().body(dne.getMessage());
  }
}
