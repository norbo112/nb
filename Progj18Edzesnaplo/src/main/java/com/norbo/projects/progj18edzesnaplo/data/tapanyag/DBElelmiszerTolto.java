/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.norbo.projects.progj18edzesnaplo.data.tapanyag;

import com.norbo.projects.progj18edzesnaplo.data.Elelmiszer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author igloi
 */
public class DBElelmiszerTolto implements DBToltoInterface {
    @Override
    public List<Elelmiszer> getElelmiszerList(Map<String, String> parameters) {
        List<Elelmiszer> elelmiszers = new ArrayList<>();
        try {
            Connection con = DriverManager.getConnection(parameters.get("dburl"),
                    parameters.get("user"),
                    parameters.get("pass"));
            
            Statement stmt = con.createStatement();
            
            ResultSet result = stmt.executeQuery("SELECT * FROM "+parameters.get("tabla"));
            while(result.next()) {
                String nev = result.getString("elelmiszerneve");
                String fajta = result.getString("fajta");
                int kj = result.getInt("kj");
                int kcal = result.getInt("kcal");
                double szenh = result.getDouble("szenhidrat");
                double feherje = result.getDouble("feherje");
                double zsir = result.getDouble("zsir");
                double rost = result.getDouble("rost");
                
                elelmiszers.add(new Elelmiszer(nev, fajta, kj, kcal, feherje, zsir, szenh, rost));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBElelmiszerTolto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return elelmiszers;
    }
    
}
