package com.jmpaniego.EmployeesAPI.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
  @GetMapping({"","/"})
  public ResponseEntity<String> home(){
    //return new ResponseEntity<>("Welcome to EmployeesAPI", HttpStatus.OK);
    return ResponseEntity.ok("Welcome to EmployeesAPI");
  }
}
