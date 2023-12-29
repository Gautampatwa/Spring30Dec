package com.example.CrudUsingJpa;

import com.example.CrudUsingJpa.model.Employee;
import com.example.CrudUsingJpa.model.Role;
import com.example.CrudUsingJpa.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class CrudUsingJpaApplication implements CommandLineRunner {

	@Autowired
	private final EmployeeRepository employeeRepository;

	public CrudUsingJpaApplication(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(CrudUsingJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		Employee employee=new Employee();
//		employee.setFirstName("Payal");
//		employee.setLastName("Gupta");
//		employee.setEmail("payal@gmail.com");
//
//		Role role1=new Role();
//		Role role2=new Role();
//		role1.setRole_name("Admin");
//		role1.setEmployee(employee);
//		role2.setRole_name("Normal");
//		role2.setEmployee(employee);
//		List<Role> list=new ArrayList<>();
//		list.add(role1);
//		list.add(role2);
//		employee.setRole(list);
//		System.out.println(employee);
//		Employee save = employeeRepository.save(employee);
//		System.out.println(save);

	}
}
