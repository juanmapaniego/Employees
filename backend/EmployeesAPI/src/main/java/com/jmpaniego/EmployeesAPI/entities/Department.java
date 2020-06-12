package com.jmpaniego.EmployeesAPI.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Department {
  @Id
  private Long id;
  private String name;
  @OneToMany(mappedBy = "department")
  private List<Employee> employees = new ArrayList<Employee>();

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Department() {
  }
}
