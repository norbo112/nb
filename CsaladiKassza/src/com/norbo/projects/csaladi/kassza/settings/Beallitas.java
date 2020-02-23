/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.norbo.projects.csaladi.kassza.settings;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author igloi
 */
public class Beallitas {
    public static final String EGYENLEG = "egyenleg";
    
    private final String BEALLITASFILE = "settings.properties";
    private final String ALAPEGYENLEG = "100000.0";
    private final String KASSZADB = "mysql";
    
    private final String DEFDBURL = "jdbc:mysql://localhost:3306/csaladikassza"+
            "?zeroDateTimeBehavior=CONVERT_TO_NULL&serverTimezone=UTC"+
            "&useUnicode=true&characterEncoding=UTF-8";
    private final String DEFUSER = "root";
    private final String DEFPASS = "root";
    
    private Properties prop;

    public Beallitas() {
        prop = new Properties();
        File f = new File(BEALLITASFILE);
        
        try {
            if(!f.exists()) {
                f.createNewFile();
            }
            
            prop.load(new FileInputStream(f));
        } catch (FileNotFoundException e) {
            System.out.println("IO Error: "+e);
        } catch (IOException e) {
            System.out.println("");
        }
    }

    public Properties getProp() {
        return prop;
    }
    
    public void setProp(String key, String value) {
        prop.setProperty(key, value);
        System.out.println(key+" tulajdonság beállítva a "+value+" értékre!");
    }
    
    /**
     * A megfelelő kulcshoz tartozó érték kivétele a propertiesből
     * @param key keresett properties kulcs
     * @return visszatér a kulcs értékével vagy null-al ha nincs
     */
    public String getEgyenlegProp(String key) {
        return prop.getProperty(key, ALAPEGYENLEG);
    }
    
    public String getDbProp(String key) {
        return prop.getProperty(key, KASSZADB);
    }
    
    public String getDbUrl() {
        return prop.getProperty("dburl", DEFDBURL);
    }
    
    public String getDbUser() {
        return prop.getProperty("user", DEFUSER);
    }
    
    public String getDbPass() {
        return prop.getProperty("pass", DEFPASS);
    }

    public void saveBeallitas() {
        try {
            File f = new File(BEALLITASFILE);
            
            if(prop.getProperty("user") == null) {
                prop.setProperty("user", DEFUSER);
            }
            
            if(prop.getProperty("pass") == null) {
                prop.setProperty("pass", DEFPASS);
            }
            
            if(prop.getProperty("dburl") == null) {
                prop.setProperty("dburl", DEFDBURL);
            }
            
            prop.store(new FileOutputStream(f), "Családi Kassza beállításai");
        } catch (IOException e) {
            System.out.println("Probléma merült fel a properties elmentése közben: "+e);
        }
    }
}
