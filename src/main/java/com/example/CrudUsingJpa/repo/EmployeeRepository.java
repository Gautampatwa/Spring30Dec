package com.example.CrudUsingJpa.repo;

import com.example.CrudUsingJpa.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {


    Employee findByEmail(String email);
    @Query("SELECT e FROM Employee e LEFT JOIN FETCH e.role")
    List<Employee> findAllWithRoles();
}
