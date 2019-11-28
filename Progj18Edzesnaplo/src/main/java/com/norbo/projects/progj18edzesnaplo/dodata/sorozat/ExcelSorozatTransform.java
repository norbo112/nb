/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.norbo.projects.progj18edzesnaplo.dodata.sorozat;

import com.norbo.projects.progj18edzesnaplo.data.Gyakorlat;
import com.norbo.projects.progj18edzesnaplo.data.Izomcsoport;
import com.norbo.projects.progj18edzesnaplo.data.naplo.Sorozat;
import com.norbo.projects.progj18edzesnaplo.data.naplo.SorozatInterface;
import com.norbo.projects.progj18edzesnaplo.dodata.ExcelGyTransform;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbookFactory;

/**
 * Excel fájlba menti a megadott File objektummal a sorozat listát
 * @author igloi
 */
public class ExcelSorozatTransform implements SorozatTransform<File> {

    @Override
    public boolean ment(List<SorozatInterface> sorozats, File path) {
        sorozats.sort((o1, o2) -> {
            return o1.getRogzitesIdopont().compareTo(o2.getRogzitesIdopont());
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
            for (int k = 0; k < s.getSuly().size(); k++) {
                row = sheet.createRow(++index);
                row.createCell(0).setCellValue((double) index);
                String time0 = s.getRogzitesIdopont().toLocalTime().toString();
                row.createCell(1).setCellValue(
                        s.getRogzitesIdopont().toLocalDate() + " "
                        + time0.substring(0, time0.lastIndexOf('.')));
                row.createCell(2).setCellValue(s.getGyakorlat().getIzomcsoport().toString());
                row.createCell(3).setCellValue(s.getGyakorlat().getMegnevezes());
                row.createCell(4).setCellValue(s.getSuly().get(k));
                row.createCell(5).setCellValue(s.getIsm().get(k));
                time0 = s.getIsmRogzitesIdopontja().get(k).toString();
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

    @Override
    public List<SorozatInterface> betolt(File path) {
        List<SorozatInterface> sorozatok = null;
        try {
            XSSFWorkbook workbook = (XSSFWorkbook) XSSFWorkbookFactory.create(path);
            XSSFSheet sheet = workbook.getSheetAt(0);
            Set<SorozatInterface> sorset = new HashSet<>();
            
            for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
                XSSFRow row = sheet.getRow(i);
                //sorszám lényegtelen
                String localdatetime = row.getCell(1).getStringCellValue();
                LocalDateTime rogzites = LocalDateTime.of(
                        LocalDate.parse(localdatetime.split(" ")[0]), 
                        LocalTime.parse(localdatetime.split(" ")[1]));
                Izomcsoport csoport = Izomcsoport.getIzomCsoport(row.getCell(2).getStringCellValue());
                String megnevezes = row.getCell(3).getStringCellValue();
                List<Integer> sulylist = new ArrayList<>();
                sulylist.add((int)row.getCell(4).getNumericCellValue());
                
                List<Integer> ismlist  = new ArrayList<>();
                ismlist.add((int)row.getCell(5).getNumericCellValue());
                
                List<LocalTime> timelist = new ArrayList<>();
                timelist.add(LocalTime.parse(row.getCell(6).getStringCellValue()));
                
                Gyakorlat gyakorlat = new Gyakorlat(megnevezes);
                gyakorlat.setIzomcsoport(csoport);
                
                Sorozat s = new Sorozat(sulylist, ismlist, gyakorlat, timelist);
                s.setGyakRogzitesIdopontja(rogzites);
                
                if(! sorset.add(s)) {
                    Iterator it = sorset.iterator();
                    while(it.hasNext()) {
                        SorozatInterface sorinterface = (SorozatInterface)it.next();
                        if(sorinterface.getGyakorlat().getMegnevezes().equals(megnevezes)) {
                            sorinterface.addSuly(sulylist.get(0));
                            sorinterface.addIsm(ismlist.get(0));
                            sorinterface.addIsmIdo(timelist.get(0));
                        }
                    }
                }
            }
            
            sorozatok = new ArrayList<>(sorset);
        } catch (IOException ex) {
            Logger.getLogger(ExcelSorozatTransform.class.getName()).log(Level.SEVERE, null, ex);
        } catch (EncryptedDocumentException ex) {
            Logger.getLogger(ExcelSorozatTransform.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return sorozatok;
        
    }
}
