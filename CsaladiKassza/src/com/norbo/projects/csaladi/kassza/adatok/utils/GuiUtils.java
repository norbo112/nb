/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.norbo.projects.csaladi.kassza.adatok.utils;

import java.awt.Color;

/**
 *
 * @author igloi
 */
public class GuiUtils {
    /**
     * 
     * @param colorstr  ("255,255,255") stringet vár, mely R,G,B formában van
     * @return Color objektumot ad vissza a paraméterben megadott Stringből
     */
    public static Color parseColor(String colorstr) {
        String[] split = colorstr.split(",");
        return new Color(
                Integer.parseInt(split[0]), 
                Integer.parseInt(split[1]), 
                Integer.parseInt(split[2]));
    }
    
    /**
     * Igazáól a getBackground-ra irtam, ott kiszedem az R,G,B-t majd átalakítom az
     * adatbázisban tárolt háttérszinre
     * 
     * Számla színkódjával kapcsolatos
     * 
     * @param r
     * @param g
     * @param b
     * @return 
     */
    public static String getColorStr(int r, int g, int b) {
        return r+","+g+","+b;
    }
}
