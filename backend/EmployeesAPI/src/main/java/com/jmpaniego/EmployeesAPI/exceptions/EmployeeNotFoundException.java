package com.jmpaniego.EmployeesAPI.exceptions;

public class EmployeeNotFoundException extends RuntimeException {

  @Override
  public String getMessage() {
    return super.getMessage();
  }

  public EmployeeNotFoundException() {
    super();
  }

  public EmployeeNotFoundException(String message) {
    super(message);
  }
}
