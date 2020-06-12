package com.jmpaniego.EmployeesAPI.exceptions;

public class EmployeeNotFoundException extends RuntimeException {
  private String message;

  public EmployeeNotFoundException(String message) {
    this.message = message;
  }
}
