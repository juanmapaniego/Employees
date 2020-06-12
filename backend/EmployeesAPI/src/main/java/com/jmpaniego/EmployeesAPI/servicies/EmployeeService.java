package com.jmpaniego.EmployeesAPI.servicies;

import com.jmpaniego.EmployeesAPI.entities.Employee;
import com.jmpaniego.EmployeesAPI.exceptions.EmployeeNotFoundException;
import com.jmpaniego.EmployeesAPI.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

  @Autowired
  private EmployeeRepository employeeRepository;

  public List<Employee> getAll(){
    return employeeRepository.findAll();
  }

  public Employee getById(Long id){
    return employeeRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(String.format("Empleado numero %d no encontrado",id)));
  }
}
