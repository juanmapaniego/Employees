package com.jmpaniego.EmployeesAPI;

import com.jmpaniego.EmployeesAPI.entities.Department;
import com.jmpaniego.EmployeesAPI.entities.Employee;
import com.jmpaniego.EmployeesAPI.repositories.DepartmentRepository;
import com.jmpaniego.EmployeesAPI.repositories.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EmployeesApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeesApiApplication.class, args);
	}


	@Bean
	public CommandLineRunner init(EmployeeRepository employeeRepository,
																DepartmentRepository departmentRepository){
		return args -> {
			Department dep1 = new Department("IT");
			Department dep2 = new Department("RRHH");
			departmentRepository.save(dep1);
			departmentRepository.save(dep2);

			Employee emp1 = new Employee("Mia","Prieto",dep1);
			Employee emp2 = new Employee("Juan","Paniagua",dep2);

			employeeRepository.save(emp1);
			employeeRepository.save(emp2);
		};
	}
}
