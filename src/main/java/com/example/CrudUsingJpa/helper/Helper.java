package com.example.CrudUsingJpa.helper;

import com.example.CrudUsingJpa.model.AllocationManagement;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Helper {

    public static boolean checkExcel(MultipartFile multipartFile)
    {
        String contentType=multipartFile.getContentType();

        if(contentType.equals("/Users/gautampatwa/Downloads/Financial Sample.xlsx"))
        {
            return true;
        }
        else {
            return false;
        }
    }


    public static List<AllocationManagement> convert(InputStream is)
    {
        List<AllocationManagement> list=new ArrayList<>();
        try {
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.getSheet("");

            int rowNumber=0;
            Iterator<Row> iterator=sheet.iterator();

            while (iterator.hasNext())
            {
                Row row= iterator.next();
                if(rowNumber==0)
                {
                    rowNumber++;
                    continue;
                }

                Iterator<Cell> cells = row.iterator();
                int cid=0;
                AllocationManagement management=new AllocationManagement();
                while ((cells.hasNext()))
                {
                    Cell cell = cells.next();
                    switch (cid)
                    {
                        case 0:
                            management.setSegment(cell.getStringCellValue());
                        case 1:
                            management.setCountry(cell.getStringCellValue());
                        default:
                            break;
                    }
                }
                list.add(management);
            }

        }
        catch (Exception e)
        {

        }
        return list;
    }

}
