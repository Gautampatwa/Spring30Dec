package com.example.CrudUsingJpa.service;

import com.example.CrudUsingJpa.model.Employee;
import com.example.CrudUsingJpa.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployee() {
        List<Employee> employee = new ArrayList<>();
        employeeRepository.findAll().forEach(employee::add);
        return employee;
    }
//    public Page<Employee> getAllEmployeesSortedByFirstNamePaged(int page, int pageSize) {
//        Sort sortByFirstName = Sort.by("lastName");
//        Pageable pageable = PageRequest.of(page-1, pageSize, sortByFirstName);
//        Page<Employee> all = employeeRepository.findAll(pageable);
//        return all;
//    }
//    public List<Employee> getEmployeeByFirstName( String searchTerm) {
//        return employeeRepository.findByFirstNameOrEmailOrLastNameContainingIgnoreCase(searchTerm);
//    }

    public Employee saveOrUpdate(Employee employee) {
        employeeRepository.save(employee);
        return employee;
    }

    public void delete(Long id) {
        employeeRepository.deleteById(id);
    }

    public void update(Employee employee) {
        employeeRepository.save(employee);
    }


    public Employee findByUserName(String email) {
        return employeeRepository.findByEmail(email);
    }

    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }

    public List<Employee> findAllWithRoles() {
        List<Employee> allWithRoles = employeeRepository.findAllWithRoles();
        return allWithRoles;
    }
}
