package com.example.CrudUsingJpa.controller;


import com.example.CrudUsingJpa.dto.EmployeeDTO;
import com.example.CrudUsingJpa.dto.EmployeeRole;
import com.example.CrudUsingJpa.dto.RoleDTO;
import com.example.CrudUsingJpa.model.Employee;
import com.example.CrudUsingJpa.model.Role;
import com.example.CrudUsingJpa.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeservice;


    @GetMapping("/employee")
    public List<EmployeeDTO> getUserListWithRoles() {
        List<Employee> userList = employeeservice.findAllWithRoles();

        // Convert to DTOs
        List<EmployeeDTO> userDTOList = userList.stream()
                .map(this::convertToEmployeeDTO)
                .collect(Collectors.toList());

        return userDTOList;
    }

    private EmployeeDTO convertToEmployeeDTO(Employee employee) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setFirstName(employee.getFirstName());
        employeeDTO.setLastName(employee.getLastName());
        employeeDTO.setEmail(employee.getEmail());

//        // Convert roles to RoleDTOs
//        List<RoleDTO> roleDTOList = employee.getRole().stream()
//                .map(this::convertToRoleDTO)
//                .collect(Collectors.toList());
//
//        employeeDTO.setRoles(roleDTOList);

        return employeeDTO;
    }

    private RoleDTO convertToRoleDTO(Role role) {
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setRole_name(role.getRole_name());
        return roleDTO;
    }

//
//    @GetMapping
//    public PageResponse<Employee> getAllEmployee(
//            @PathVariable(required = false) int page,
//            @PathVariable(required = false) int pageSize) {
//        int pageNumber = (page != 0) ? page : 0;
//        int size = (pageSize != 0) ? pageSize : 5;
//        Page<Employee> employees = employeeservice.getAllEmployeesSortedByFirstNamePaged(pageNumber, size);
//        PageResponse<Employee> response = new PageResponse<>(employees.getContent(), pageNumber, employees.getTotalElements(), employees.getTotalPages());
//
//        return response;
//
//    }

    @GetMapping("/employee/{id}")
    public Optional<Employee> getEmployee(@PathVariable("id") Long id) {
        return employeeservice.getEmployeeById(id);
    }
//
//    @GetMapping("/employee/getAllNames")
//    public List<Employee> getEmployee() {
//        return employeeservice.getAllNames();
//    }

//    @GetMapping("/employee/ByFirstNameOrEmail")
//    public List<Employee> getByName(@RequestParam(required = false) String firstName, @RequestParam
//            (required = false) String email, @RequestParam(required = false) String lastName) {
//        String searchTerm = (firstName != null && !firstName.isEmpty()) ? firstName :
//                (email != null && !email.isEmpty()) ? email :
//                        (lastName != null && !lastName.isEmpty()) ? lastName : null;
//
//        List<Employee> employeeList = employeeservice.getEmployeeByFirstName(searchTerm);
//        System.out.println(employeeList);
//        return employeeList;
//    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable("id") Long id) {
        employeeservice.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PostMapping("/save")
    public EmployeeDTO saveEmployee(@RequestBody EmployeeDTO employeeDTO) {
//        List<Role> roles = employeeDTO.getRole();
//        employeeDTO.setRole(roles);
        Employee user = convertToEntity(employeeDTO);
// Perform any necessary business logic here
        Employee createdUser =
                employeeservice.saveOrUpdate(user);

        // Convert the created entity back to DTO
        EmployeeDTO createdUserDTO = convertToDTO(createdUser);

        return createdUserDTO;
    }

    private Employee convertToEntity(EmployeeDTO employeeDTO) {
        Employee user = new Employee();
        user.setEmail(employeeDTO.getEmail());
        user.setFirstName(employeeDTO.getFirstName());
        user.setLastName(employeeDTO.getLastName());
        // Convert int to UserRole using valueOf
        try {
            user.setType(EmployeeRole.valueOf(employeeDTO.getType()));
        } catch (IllegalArgumentException e) {
            // Handle the exception or log a message
            e.printStackTrace();
        }

        // Map other fields...

        return user;
    }

    private EmployeeDTO convertToDTO(Employee createdUser) {
        EmployeeDTO userDTO = new EmployeeDTO();
        userDTO.setEmail(createdUser.getEmail());
        userDTO.setFirstName(createdUser.getFirstName());
        userDTO.setLastName(createdUser.getLastName());
        // Map other fields...

        // Convert UserRole to int using getValue() method
        userDTO.setType(createdUser.getType().getValue());

        return userDTO;
    }


    @PutMapping("/update")
    public Employee update(@RequestBody Employee employee) {
        employeeservice.saveOrUpdate(employee);
        return employee;
    }
}