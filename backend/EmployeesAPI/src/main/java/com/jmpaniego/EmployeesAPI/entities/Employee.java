package com.jmpaniego.EmployeesAPI.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Employee implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String firstName;
  private String lastName;
  @Lob
  private byte[] avatar;
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "fk_department")
  private Department department;


  public Employee()  {
  }

  public Employee(String firstName, String lastName, Department department) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.department = department;
  }

  public byte[] getAvatar() {
    //return Base64.getEncoder().encode(avatar);
    return avatar;
  }

  public void setAvatar(byte[] avatar) {
    this.avatar = avatar;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Department getDepartment() {
    return department;
  }

  public void setDepartment(Department department) {
    this.department = department;
  }

  @Override
  public String toString() {
    return "Employee{" +
        "id=" + id +
        ", firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        ", department=" + department +
        ", avatar=" + avatar +
        '}';
  }
}
