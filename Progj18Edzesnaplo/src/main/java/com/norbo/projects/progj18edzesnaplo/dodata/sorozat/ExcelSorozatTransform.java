/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.norbo.projects.progj18edzesnaplo.dodata.sorozat;

import com.norbo.projects.progj18edzesnaplo.data.naplo.Sorozat;
import com.norbo.projects.progj18edzesnaplo.data.naplo.SorozatInterface;
import com.norbo.projects.progj18edzesnaplo.dodata.ExcelGyTransform;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Excel fájlba menti a megadott File objektummal a sorozat listát
 * @author igloi
 */
public class ExcelSorozatTransform implements SorozatTransform<File> {

    @Override
    public boolean ment(List<SorozatInterface> sorozats, File path) {
        sorozats.sort((o1, o2) -> {
            return o1.getGyakRogzitesIdopontja().compareTo(o2.getGyakRogzitesIdopontja());
        });
        
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Edzésnap");
        
        int index = 0;
        XSSFRow row = sheet.createRow(index);
        row.createCell(0).setCellValue("ID");
        row.createCell(1).setCellValue("Rögzítés ideje");
        row.createCell(2).setCellValue("Izomcsoport");
        row.createCell(3).setCellValue("Megnevezés");
        row.createCell(4).setCellValue("Súly");
        row.createCell(5).setCellValue("Ismétlés");
        row.createCell(6).setCellValue("Időpontok");
        
        for (SorozatInterface s : sorozats) {
            for (int k = 0; k < s.getSulyList().size(); k++) {
                row = sheet.createRow(++index);
                row.createCell(0).setCellValue((double) index);
                String time0 = s.getGyakRogzitesIdopontja().toLocalTime().toString();
                row.createCell(1).setCellValue(
                        s.getGyakRogzitesIdopontja().toLocalDate() + " "
                        + time0.substring(0, time0.lastIndexOf('.')));
                row.createCell(2).setCellValue(s.getGyakorlat().getIzomcsoport().toString());
                row.createCell(3).setCellValue(s.getGyakorlat().getMegnevezes());
                row.createCell(4).setCellValue(s.getSulyList().get(k));
                row.createCell(5).setCellValue(s.getIsmList().get(k));
                time0 = s.getIsmIdoList().get(k).toString();
                row.createCell(6).setCellValue(
                        time0.substring(0, time0.lastIndexOf('.')));
            }
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
