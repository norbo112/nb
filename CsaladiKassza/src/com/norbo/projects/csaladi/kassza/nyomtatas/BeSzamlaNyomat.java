/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.norbo.projects.csaladi.kassza.nyomtatas;

import com.norbo.projects.csaladi.kassza.adatok.BeSzamla;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 *
 * @author igloi
 */
public class BeSzamlaNyomat implements Printable {
    private List<BeSzamla> beSzamlaLista;

    public BeSzamlaNyomat(List<BeSzamla> beSzamlaLista) {
        this.beSzamlaLista = beSzamlaLista;
    }
    

    @Override
    public int print(Graphics arg0, PageFormat arg1, int arg2) throws PrinterException {
        Graphics2D g = (Graphics2D) arg0;
        
        if(arg2 > 0) {
            return NO_SUCH_PAGE;
        }
        
        g.translate(arg1.getImageableX(), arg1.getImageableY());

        drawFejlec(g, arg1);
        drawAdatok(g, arg1);
        
        return PAGE_EXISTS;
    }

    private void drawFejlec(Graphics2D g, PageFormat pg) {
        g.drawString("Befizetett számlák", 10, 20);
        g.drawString(LocalDateTime.now().format(DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss")), 150, 20);
        g.drawLine(10, 25, (int)pg.getWidth() - 10, 25);
    }

    private void drawAdatok(Graphics2D g, PageFormat arg1) {
        String space = "          ";
        int x = 15;
        int y = 40;
        
        g.drawString("Cég"+space+"Befizetés ideje"+space+"Összeg"+space+"Állapot", x, y);
        y += 20;
        
        for( BeSzamla be: beSzamlaLista) {
            g.drawString(be.getSzamla().getMegjelenoNev()+space+
                    be.getBefizetesiido().format(DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss"))+space+
                    be.getOsszeg()+space+ (be.getBefizetve() ? "befizetve" : "függőben")
                    , x, y);
            y += 20;
        }
    }
    
}
