package com.jmpaniego.EmployeesAPI;

import com.jmpaniego.EmployeesAPI.entities.Department;
import com.jmpaniego.EmployeesAPI.entities.Employee;
import com.jmpaniego.EmployeesAPI.repositories.DepartmentRepository;
import com.jmpaniego.EmployeesAPI.repositories.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.File;
import java.io.FileInputStream;

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

			/* read image */
			File file = new File("/home/jmpaniego/descarga.png");
			byte[] bFile = new byte[(int) file.length()];
			FileInputStream fileInputStream = new FileInputStream(file);
			fileInputStream.read(bFile);
			fileInputStream.close();
			/*      */
			emp1.setAvatar(bFile);
			emp2.setAvatar(bFile);

			employeeRepository.save(emp1);
			employeeRepository.save(emp2);
		};
	}
}
