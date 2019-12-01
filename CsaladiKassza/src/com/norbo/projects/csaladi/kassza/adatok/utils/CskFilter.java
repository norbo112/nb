/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.norbo.projects.csaladi.kassza.adatok.utils;

import java.io.File;

/**
 *
 * @author igloi
 */
public class CskFilter extends javax.swing.filechooser.FileFilter {

    @Override
    public String getDescription() {
        return ".csk fájlok keresése és kiválasztása";
    }
    

    @Override
    public boolean accept(File arg0) {
        return arg0.getAbsolutePath().endsWith(".csk");
    }
    
}
