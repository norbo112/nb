/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.norbo.projects.csaladi.kassza.adatok.utils;

import com.mysql.cj.jdbc.PreparedStatementWrapper;
import com.norbo.projects.csaladi.kassza.adatok.Szamla;
import com.norbo.projects.csaladi.kassza.adatok.SzamlaAdatokDialog;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
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
    public static final String CONNURL = "jdbc:mysql://localhost:3306/csaladikassza"+
            "?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC"+
            "&useUnicode=true&characterEncoding=UTF-8";
    //ezt talán külön szálon kellene
    public static List<Szamla> getSzamlakFromDB() {
        List<Szamla> sl = new ArrayList<>();
        try {
            Connection conn = DriverManager.getConnection(CONNURL,"root","JuanScript18");
            Statement stmt = conn.createStatement();
            
            ResultSet result = stmt.executeQuery("SELECT * FROM szamlak");
            while(result.next()) {
                int id = result.getInt("id");
                String szamlaszam = result.getString("szamlaszam");
                int prior = result.getInt("prioritas");
                String befido = result.getString("befizetesideje");
                String megjnev = result.getString("megjelenitnev");
                int vartosszeg = result.getInt("vartosszeg");
                String kijeloles = result.getString("szine");
                sl.add(new Szamla(id, szamlaszam, megjnev, getPrior(prior), 
                        LocalDate.parse(befido), vartosszeg, kijeloles));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(SzamlaAdatokDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return sl;
    }
    
    public static Szamla getSzamlaFromDB(String szamlaszam) {
        try {
            Connection conn = DriverManager.getConnection(CONNURL,"root","JuanScript18");
            Statement stmt = conn.createStatement();
            
            ResultSet result = stmt.executeQuery("SELECT * FROM szamlak WHERE szamlaszam = '"+szamlaszam+"'");
            while(result.next()) {
                return new Szamla(result.getInt("id"),
                        result.getString("szamlaszam"), 
                        result.getString("megjelenitnev"), 
                        getPrior(result.getInt("prioritas")),
                        LocalDate.parse(result.getString("befizetesideje")), 
                        result.getInt("vartosszeg"),
                        result.getString("szine"));
            }
            
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(SzamlaAdatokDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    public static boolean addSzamlaToDB(String dburl, Szamla szamla) {
        try {
            Connection conn = DriverManager.getConnection(CONNURL,"root","JuanScript18");
            PreparedStatement pst = conn.prepareStatement("INSERT INTO szamlak "+
                    "(szamlaszam, megjelenitnev, befizetesideje, prioritas, vartosszeg, szine) "+
                    "VALUES (?,?,?,?,?,?)");
            pst.setString(1, szamla.getSzamlaSzam());
            pst.setString(2, szamla.getMegjelenoNev());
            pst.setString(3, szamla.getBefizetesHatarido().toString());
            pst.setInt(4, Integer.parseInt(szamla.getPrioritas().toString()));
            pst.setInt(5, (int)szamla.getOsszeg());
            pst.setString(6, szamla.getKijeloles());
            
            int cnt = pst.executeUpdate();
            
            if(cnt > 0) {
                return true;
            } else {
                System.out.println("Nem tudtam hozzáadni a számlát!");
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SzamlaMelos.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public static boolean setSzamlaInDB(String dburl, Szamla szamla) {
        try {
            Connection conn = DriverManager.getConnection(CONNURL,"root","JuanScript18");
            PreparedStatement pst = conn.prepareStatement("UPDATE szamlak SET szamlaszam = ?, megjelenitnev = ?, "+
                    "befizetesideje = ?, prioritas = ?, vartosszeg = ?, szine= ? WHERE id = ?;");
            pst.setString(1, szamla.getSzamlaSzam());
            pst.setString(2, szamla.getMegjelenoNev());
            pst.setString(3, szamla.getBefizetesHatarido().toString());
            pst.setInt(4, Integer.parseInt(szamla.getPrioritas().toString()));
            pst.setInt(5, (int)szamla.getOsszeg());
            pst.setInt(6, szamla.getId());
            pst.setString(7, szamla.getKijeloles());
            
            int cnt = pst.executeUpdate();
            
            if(cnt > 0) {
                return true;
            } else {
                System.out.println("Nem tudtam frissíteni a számlát!");
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SzamlaMelos.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
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
