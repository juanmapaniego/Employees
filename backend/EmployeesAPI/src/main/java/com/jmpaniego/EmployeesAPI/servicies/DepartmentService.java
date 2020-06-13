package com.jmpaniego.EmployeesAPI.servicies;

import com.jmpaniego.EmployeesAPI.entities.Department;
import com.jmpaniego.EmployeesAPI.entities.Employee;
import com.jmpaniego.EmployeesAPI.exceptions.DepartmentNotExistException;
import com.jmpaniego.EmployeesAPI.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

  @Autowired
  private DepartmentRepository departmentRepository;

  public List<Department> getAll(){
    return departmentRepository.findAll();
  }

  public List<Employee> getEmployeesById(Long id) {
    Department department = departmentRepository.findById(id)
        .orElseThrow(
            () ->new DepartmentNotExistException("Department not exist")
        );
    return department.getEmployees();
  }

  public Department getDepartmentById(Long id) {
    return departmentRepository.
        findById(id)
        .orElseThrow(
            () ->new DepartmentNotExistException("Department not exist")
        );
  }
}
