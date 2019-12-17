package com.norbo.projects.csaladi.kassza.adatok.utils;

import com.norbo.projects.csaladi.kassza.adatok.Szamla;
import com.norbo.projects.csaladi.kassza.adatok.SzamlaAdatokDialog;
import com.norbo.projects.csaladi.kassza.settings.Beallitas;
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
 * Számlák beállítása az adatbázisban
 * Új felvitele, módosítás
 * @author igloi
 */
public class DBMelos {
    private static final Beallitas BEALLITAS = new Beallitas();
    private static Connection conn;
    /**
     * Kapcsolat url MySql-hez
     */
    public static final String CONNURL = "jdbc:mysql://localhost:3306/csaladikassza"+
            "?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC"+
            "&useUnicode=true&characterEncoding=UTF-8";
    /**
     * Kapcsolat url Java DB-hez
     */
    public static final String DERBYURL = "jdbc:derby://localhost:1527/derbykassza";
    
    
    static {
        try {
            
            if (BEALLITAS.getDbProp("DB").equals("mysql")) {
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection(
                        BEALLITAS.getDbUrl(), 
                        BEALLITAS.getDbUser(),
                        BEALLITAS.getDbPass());
            } else {
                Class.forName("org.apache.derby.jdbc.Driver42");
                conn = DriverManager.getConnection(DERBYURL, "kuser", "kuser0105");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBMelos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBMelos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    /**
     * Elkészíti a számla listát az adatbázisból
     * @return 
     */
    public static List<Szamla> getSzamlakFromDB() {
        List<Szamla> sl = new ArrayList<>();
        try {
            //connection init itt volt
            
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
                        Integer.parseInt(befido), vartosszeg, kijeloles));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(SzamlaAdatokDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return sl;
    }
  
    /**
     * Az adatbázisból lekéri a szamlaszám paraméternek megfelelő számlát
     * @param szamlaszam
     * @return 
     */
    public static Szamla getSzamlaFromDB(String szamlaszam) {
        try {
            Statement stmt = conn.createStatement();
            
            ResultSet result = stmt.executeQuery("SELECT * FROM szamlak WHERE szamlaszam = '"+szamlaszam+"'");
            while(result.next()) {
                return new Szamla(result.getInt("id"),
                        result.getString("szamlaszam"), 
                        result.getString("megjelenitnev"), 
                        getPrior(result.getInt("prioritas")),
                        Integer.parseInt(result.getString("befizetesideje")), 
                        result.getInt("vartosszeg"),
                        result.getString("szine"));
            }
            
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(SzamlaAdatokDialog.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    
    /**
     * Új számlát ad a dburl-el elért adatbázishoz (derby, mysql)
     * @param dburl
     * @param szamla
     * @return true ha sikeres volt a beszúrás egyébbként false
     */
    public static boolean addSzamlaToDB(String dburl, Szamla szamla) {
        try {
            PreparedStatement pst = conn.prepareStatement("INSERT INTO szamlak "+
                    "(szamlaszam, megjelenitnev, befizetesideje, prioritas, vartosszeg, szine) "+
                    "VALUES (?,?,?,?,?,?)");
            pst.setString(1, szamla.getSzamlaSzam());
            pst.setString(2, szamla.getMegjelenoNev());
            pst.setString(3, Integer.toString(szamla.getBefizetesHatarido()));
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
            Logger.getLogger(DBMelos.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    /**
     * Számla adatait módosítja az adatbázisban
     * @param dburl
     * @param szamla
     * @return 
     */
    public static boolean setSzamlaInDB(String dburl, Szamla szamla) {
        try {
            PreparedStatement pst = conn.prepareStatement("UPDATE szamlak SET szamlaszam = ?, megjelenitnev = ?, "+
                    "befizetesideje = ?, prioritas = ?, vartosszeg = ?, szine= ? WHERE id = ?");
            pst.setString(1, szamla.getSzamlaSzam());
            pst.setString(2, szamla.getMegjelenoNev());
            pst.setString(3, Integer.toString(szamla.getBefizetesHatarido()));
            pst.setInt(4, Integer.parseInt(szamla.getPrioritas().toString()));
            pst.setInt(5, (int)szamla.getOsszeg());
            pst.setString(6, szamla.getKijeloles());
            pst.setInt(7, szamla.getId());
            
            
            int cnt = pst.executeUpdate();
            
            if(cnt > 0) {
                return true;
            } else {
                System.out.println("Nem tudtam frissíteni a számlát!");
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBMelos.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    /**
     * Prioritást alakítja át Prior enummá
     * @param prior
     * @return Prior objektum
     */
    public static Szamla.Prior getPrior(int prior) {
        switch (prior) {
            case 3: return Szamla.Prior.LOW;
            case 2: return Szamla.Prior.MEDIUM;
            case 1: return Szamla.Prior.HIGH;
        }
        return null;
    }
    
    /**
     * String alakban kiolvasott adatot alakít át Prior objektumba
     * @param pr
     * @return Prior objektum
     */
    public static Szamla.Prior getPrior(String pr) {
        switch (pr.trim()) {
            case "Alacsony": return Szamla.Prior.LOW;
            case "Közepes": return Szamla.Prior.MEDIUM;
            case "Magas": return Szamla.Prior.HIGH;
        }
        return null;
    }
}
