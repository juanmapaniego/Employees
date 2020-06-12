package com.jmpaniego.EmployeesAPI.exceptions;

public class EmployeeNotFoundException extends RuntimeException {

  public EmployeeNotFoundException() {
    super();
  }

  public EmployeeNotFoundException(String message) {
    super(message);
  }
}
