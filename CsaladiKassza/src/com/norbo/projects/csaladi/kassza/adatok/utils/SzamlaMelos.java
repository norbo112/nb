/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.norbo.projects.csaladi.kassza.adatok.utils;

import com.norbo.projects.csaladi.kassza.adatok.Szamla;
import com.norbo.projects.csaladi.kassza.adatok.Szamlak;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author igloi
 */
public class SzamlaMelos {
    private static final String CONNURL = "jdbc:mysql://localhost:3306/csaladikassza?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC";
    //ezt talán külön szálon kellene
    public static List<Szamla> getSzamlakFromDB() {
        List<Szamla> sl = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection(CONNURL,"root","JuanScript18");
            Statement stmt = conn.createStatement();
            
            ResultSet result = stmt.executeQuery("SELECT * FROM szamlak");
            while(result.next()) {
                String szamlaszam = result.getString("szamlaszam");
                int prior = result.getInt("prioritas");
                String befido = result.getString("befizetesideje");
                String megjnev = result.getString("megjelenitnev");
                int vartosszeg = result.getInt("vartosszeg");
                
                sl.add(new Szamla(szamlaszam, megjnev, getPrior(prior), 
                        LocalDate.parse(befido), vartosszeg));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Szamlak.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return sl;
    }
    
    public static Szamla.Prior getPrior(int prior) {
        switch (prior) {
            case 3: return Szamla.Prior.LOW;
            case 2: return Szamla.Prior.MEDIUM;
            case 1: return Szamla.Prior.HIGH;
        }
        return null;
    }
    
        
    public static Szamla.Prior getPrior(String pr) {
        switch (pr.trim()) {
            case "Alacsony": return Szamla.Prior.LOW;
            case "Közepes": return Szamla.Prior.MEDIUM;
            case "Magas": return Szamla.Prior.HIGH;
        }
        return null;
    }
}
