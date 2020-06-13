package com.jmpaniego.EmployeesAPI.servicies;

import com.jmpaniego.EmployeesAPI.entities.Employee;
import com.jmpaniego.EmployeesAPI.exceptions.DepartmentNotExistException;
import com.jmpaniego.EmployeesAPI.exceptions.EmployeeNotFoundException;
import com.jmpaniego.EmployeesAPI.repositories.EmployeeRepository;
import org.hibernate.JDBCException;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
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

  public Employee save(Employee employee){
    try {
      return employeeRepository.save(employee);
    }catch (DataIntegrityViolationException dive){
      throw new DepartmentNotExistException("Department do not exist",dive);
    }
  }

  public Employee update(Employee employee) {
    return employeeRepository.save(employee);
  }

  public void deleteById(Long id) {
    employeeRepository.deleteById(id);
  }
}
