/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.norbo.projects.progj18edzesnaplo.dodata;

import com.norbo.projects.progj18edzesnaplo.data.Gyakorlat;
import com.norbo.projects.progj18edzesnaplo.data.IGyakorlat;
import com.norbo.projects.progj18edzesnaplo.data.Izomcsoport;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbookFactory;

/**
 *
 * @author igloi
 */
public class ExcelGyTransform extends AbstractTrasform<String>{

    @Override
    public List<IGyakorlat> betolt(String fn) {
        List<IGyakorlat> gyakorlats = new ArrayList<>();
        try {
            
            InputStream in = this.getClass().getClassLoader().getResourceAsStream(fn);
            
            XSSFWorkbook workbook = XSSFWorkbookFactory.createWorkbook(in);
            XSSFSheet sheet = workbook.getSheetAt(0);
            for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
                XSSFRow row = sheet.getRow(i);
                int id = (int)row.getCell(0).getNumericCellValue();
                String izomcsop = row.getCell(1).getStringCellValue();
                String megnevezes = row.getCell(2).getStringCellValue();
                String leiras = row.getCell(3).getStringCellValue();
                String videoid;
                try {
                    videoid = row.getCell(4).getStringCellValue();
                    
                } catch (NullPointerException e) {
                    videoid = "";
                }
                
                int videopoz;
                try {
                    videopoz = (int) row.getCell(5).getNumericCellValue();
                } catch (NullPointerException e) {
                    videopoz = 0;
                }
                
                gyakorlats.add(
                        new Gyakorlat(id, megnevezes, Izomcsoport.getIzomCsoport(izomcsop), leiras, videoid, videopoz));
            }
 
        } catch (IOException | InvalidFormatException ex) {
            Logger.getLogger(ExcelGyTransform.class.getName()).log(Level.SEVERE, null, ex);
        }
        return gyakorlats;
    }
}
