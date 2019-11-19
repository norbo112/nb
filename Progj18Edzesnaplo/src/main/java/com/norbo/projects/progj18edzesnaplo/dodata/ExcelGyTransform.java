/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.norbo.projects.progj18edzesnaplo.dodata;

import com.norbo.projects.progj18edzesnaplo.data.Gyakorlat;
import com.norbo.projects.progj18edzesnaplo.data.IGyakorlat;
import com.norbo.projects.progj18edzesnaplo.data.Izomcsoport;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbookFactory;

/**
 *
 * @author igloi
 */
public class ExcelGyTransform extends AbstractTransform {
    @Override
    public List<IGyakorlat> betolt(String path) {
        List<IGyakorlat> gyakorlats = new ArrayList<>();
        try {
            
            InputStream in = new FileInputStream(new File(path));
            
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

    @Override
    public boolean gyakorlatMent(List<IGyakorlat> gyks, String path) {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("gyakorlatlista");
        
        XSSFRow row = sheet.createRow(0);
        row.createCell(0).setCellValue("ID");
        row.createCell(1).setCellValue("Izomcsoport");
        row.createCell(2).setCellValue("Megnevezés");
        row.createCell(3).setCellValue("Leírás");
        row.createCell(4).setCellValue("Videolink");
        row.createCell(5).setCellValue("Videostartpoz");
        
        for (int i = 1; i < gyks.size(); i++) {
            row = sheet.createRow(i);
            row.createCell(0).setCellValue((double)gyks.get(i).getId());
            row.createCell(1).setCellValue(gyks.get(i).getIzomcsoport().toString());
            row.createCell(2).setCellValue(gyks.get(i).getMegnevezes());
            row.createCell(3).setCellValue(gyks.get(i).getLeiras());
            row.createCell(4).setCellValue(gyks.get(i).getVideolink());
            row.createCell(5).setCellValue((double)gyks.get(i).getVideostartpoz());
        }
        
        try(FileOutputStream out = new FileOutputStream(path)) {
            workbook.write(out);
            
            return true;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ExcelGyTransform.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ExcelGyTransform.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
}
