package com.example.CrudUsingJpa.service;

import com.example.CrudUsingJpa.helper.Helper;
import com.example.CrudUsingJpa.model.AllocationManagement;
import com.example.CrudUsingJpa.repo.AllocationManagementRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class AllocationManagementServiceImpl implements AllocationManagementService {
    private static final Logger logger = LoggerFactory.getLogger(AllocationManagementServiceImpl.class);

    @Autowired
    private AllocationManagementRepo allocationManagementRepo;

    public void saveDataFromExcel(MultipartFile file) throws IOException {

        try{
           List<AllocationManagement> lists=Helper.convert(file.getInputStream());
           this.allocationManagementRepo.saveAll(lists);
        }
        catch (Exception e)
        {
        e.printStackTrace();
        }
    }

    public List<AllocationManagement> getAll()
    {
return this.allocationManagementRepo.findAll();
    }
}
