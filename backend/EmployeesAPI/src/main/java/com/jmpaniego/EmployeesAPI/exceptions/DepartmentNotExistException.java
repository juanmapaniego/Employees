package com.jmpaniego.EmployeesAPI.exceptions;

import org.springframework.dao.DataIntegrityViolationException;

public class DepartmentNotExistException extends RuntimeException {
  public DepartmentNotExistException() {
    super();
  }

  public DepartmentNotExistException(String message) {
    super(message);
  }

  public DepartmentNotExistException(String message, Throwable e) {
    super(message,e);
  }
}
