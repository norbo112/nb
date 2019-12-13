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

    public void saveBeallitas() {
        try {
            File f = new File(BEALLITASFILE);
            prop.store(new FileOutputStream(f), "Családi Kassza beállításai");
        } catch (IOException e) {
            System.out.println("Probléma merült fel a properties elmentése közben: "+e);
        }
    }
}
