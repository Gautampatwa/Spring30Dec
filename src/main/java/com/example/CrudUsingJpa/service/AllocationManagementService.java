package com.example.CrudUsingJpa.service;

import com.example.CrudUsingJpa.model.AllocationManagement;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface AllocationManagementService {
    void saveDataFromExcel(MultipartFile excelFile) throws IOException;
    List<AllocationManagement> getAll();
}
