package com.example.CrudUsingJpa.controller;

import com.example.CrudUsingJpa.helper.Helper;
import com.example.CrudUsingJpa.model.AllocationManagement;
import com.example.CrudUsingJpa.service.AllocationManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
public class AllocationManagementController {

    @Autowired
    private AllocationManagementService allocationManagementService;

    @PostMapping("/upload")
    public ResponseEntity<?> handleFileUpload(@RequestParam("file") MultipartFile file) throws IOException {
//        if (Helper.checkExcel(file)) {
            this.allocationManagementService.saveDataFromExcel(file);
            return ResponseEntity.ok(Map.of("message", "File upload succesfully"));
//        }
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please upload right file");
    }

    @GetMapping("/getAll")
    public List<AllocationManagement> getAll()
    {
        List<AllocationManagement> all = allocationManagementService.getAll();
        return all;
    }
}
