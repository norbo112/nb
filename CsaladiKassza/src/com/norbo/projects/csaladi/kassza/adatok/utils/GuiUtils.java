package com.norbo.projects.csaladi.kassza.adatok.utils;

import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * Saját szint állítok elő a saját "R,G,B" stringből és vissza
 * @author igloi
 */
public class GuiUtils {
    /**
     * Tábla DEFAULT háttérszíne
     */
    public static final Color DEFTABLEBGCOLOR = new Color(0,153,204);
    /**
     * Táblázat fejléc DEFAULT előtérszíne
     */
    public static final Color THFGCOLOR = new Color(255,255,255);
    /**
     * Táblázat fejléc DEFAULT háttérszíne
     */
    public static final Color THBGCOLOR = new Color(0,54,104);
    /**
     * 
     * @param colorstr  ("255,255,255") stringet vár, mely R,G,B formában van
     * @return Color objektumot ad vissza a paraméterben megadott Stringből
     */
    public static Color parseColor(String colorstr) {
        if(colorstr.startsWith("#")) return Color.getColor(colorstr);
        
        if(!colorstr.contains(",") && !colorstr.startsWith("#")) {
            return Color.decode("#"+colorstr);
        }
        
        String[] split = colorstr.split(",");
        return new Color(
                Integer.parseInt(split[0]), 
                Integer.parseInt(split[1]), 
                Integer.parseInt(split[2]));
    }
    
    private static Color hex2Rgb(String colorStr) {
        return new Color(
                Integer.valueOf(colorStr.substring(1, 3), 16),
                Integer.valueOf(colorStr.substring(3, 5), 16),
                Integer.valueOf(colorStr.substring(5, 7), 16));
    }
    
    /**
     * Igazáól a getBackground-ra irtam, ott kiszedem az R,G,B-t majd átalakítom az
     * adatbázisban tárolt háttérszinre
     * Hex-re alakítom hogy ugyanezt tudjam használni JSF webalkalmazáshoz
     * Számla színkódjával kapcsolatos
     * 
     * @param r
     * @param g
     * @param b
     * @return 
     */
    public static String getColorStr(int r, int g, int b) {
        return String.format("%02x%02x%02x", r, g, b);
    }
    
    /**
     * Beállítom a tábla fejléc mezőjének hátterét és szövegszínét
     * @param tables Táblák tömbje, melyeken a modosításokat elkell végezni
     * @param bgcolor Háttérszín
     * @param fgcolor Szövegszín
     */
    public static void coloriseTablaHeader(JTable[] tables, Color bgcolor, Color fgcolor) {
        DefaultTableCellRenderer header = new DefaultTableCellRenderer();
        header.setBackground(bgcolor);
        header.setForeground(fgcolor);
        
        for (JTable table : tables) {
            for(int i=0; i<table.getModel().getColumnCount(); i++) {
                table.getColumnModel().getColumn(i).setHeaderRenderer(header);
            }
        }
    }
    
    /**
     * Beállítom a tábla hátterét és előtérszínét
     * @param tableScroll  Scrollpane amiben a tábla van
     * @param bgcolor háttérszín
     * @param fgcolor előtérszín, ez lehet null is, ha null akkor nem állítom a szövegszínt
     */
    public static void coloriseTable(JScrollPane tableScroll, Color bgcolor, Color fgcolor) {
        tableScroll.getViewport().setBackground(bgcolor);
        if(fgcolor != null) {
            tableScroll.getViewport().setForeground(fgcolor);
        }
    }
}
