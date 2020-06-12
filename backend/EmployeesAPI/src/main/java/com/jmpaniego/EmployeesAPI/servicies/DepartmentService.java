package com.jmpaniego.EmployeesAPI.servicies;

import com.jmpaniego.EmployeesAPI.entities.Department;
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
}
