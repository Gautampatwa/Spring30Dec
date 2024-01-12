package com.example.CrudUsingJpa.repo;

import com.example.CrudUsingJpa.model.AllocationManagement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AllocationManagementRepo extends JpaRepository<AllocationManagement,String> {
}
