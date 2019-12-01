/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.norbo.projects.csaladi.kassza.adatok.utils;

import com.norbo.projects.csaladi.kassza.adatok.BeSzamla;
import com.norbo.projects.csaladi.kassza.adatok.Szamla;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author igloi
 */
public class CsvFeldolgozo implements AdatFeldolgozas<File, List<BeSzamla>>{

    @Override
    public boolean ment(File path, List<BeSzamla> obj) {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            bw.write("Cég neve;Számlaszám;Befizetés ideje;Összeg\n");
            
            for (BeSzamla sz : obj) {
//                String date = sz.getBefizetesiido().toLocalDate().toString();
//                String time = sz.getBefizetesiido().toLocalTime().toString().substring(0, 
//                        sz.getBefizetesiido().toLocalTime().toString().lastIndexOf('.'));
                bw.write(
                        sz.getSzamla().getMegjelenoNev()+";"+
                        sz.getSzamla().getSzamlaSzam()+";"+
                        sz.getBefizetesiido().toString()+";"+
                        sz.getOsszeg()+"\n"
                );
            }
            
            return true;
        } catch (FileNotFoundException e) {
            System.out.println("Nem találtam a fájlt");
            return false;
        } catch (IOException e) {
            System.out.println("I/O Hiba "+e);
            return false;
        }
    }

    @Override
    public List<BeSzamla> betolt(File path) {
        List<BeSzamla> result = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine(); //fejléc off
            while((line = br.readLine()) != null) {
                String[] splitted = line.split(";");
                Szamla szamla = SzamlaMelos.getSzamlaFromDB(splitted[1]); //lehet hogy itt csak üres számlát kellene használnom
                
                LocalDateTime ido = LocalDateTime.parse(splitted[2]);
                double osszeg = Double.parseDouble(splitted[3]);
                result.add(new BeSzamla(szamla, ido, osszeg));
            }
            
            return result;
        } catch (FileNotFoundException e) {
            System.out.println("Nem találtam a fájlt");
            return null;
        } catch (IOException e) {
            System.out.println("I/O Hiba "+e);
            return null;
        }
    }
    
}
