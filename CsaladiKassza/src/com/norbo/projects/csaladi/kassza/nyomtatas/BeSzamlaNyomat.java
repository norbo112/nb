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
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.management.MBeanServerFactory;
import javax.swing.ImageIcon;

/**
 *
 * @author igloi
 */
public class BeSzamlaNyomat implements Printable {
    private List<BeSzamla> beSzamlaLista;
    private final int BEHUZAS = 50;
    private final String PENZNEM = "Ft";

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
        g.drawImage(new ImageIcon(getClass().getClassLoader().getResource("resources/nyomtatas/hatter/nyomtatas_hatter.png")).getImage(),
                0,0, (int)arg1.getWidth(), (int)arg1.getHeight(), null);
        drawFejlec(g, arg1);
        drawAdatok(g, arg1);
        
        return PAGE_EXISTS;
    }

    private void drawFejlec(Graphics2D g, PageFormat pg) {
        g.drawString("Befizetett számlák", 10, 20);
        g.drawString(LocalDateTime.now().format(DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss")), (int)pg.getWidth() - 150, 20);
        g.drawLine(10, 25, (int)pg.getWidth() - 10, 25);
    }

    private void drawAdatok(Graphics2D g, PageFormat arg1) {
        int y = 40;
        
        drawFejlecSor(g, y);
        y += 20;
        
        for( BeSzamla be: beSzamlaLista) {
            drawSor(g, be, y);
            y += 20;
        }
    }
    
    private void drawSor(Graphics2D g, BeSzamla besz, int ysor) {
        g.drawString(besz.getSzamla().getMegjelenoNev(), BEHUZAS, ysor);
        g.drawString(besz.getBefizetesiido()
                .format(DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss")), BEHUZAS+100, ysor);
        g.drawString(besz.getOsszeg()+" "+PENZNEM, BEHUZAS+250, ysor);
        g.drawString((besz.getBefizetve() ? "befizetve" : "függőben"), BEHUZAS+340, ysor);
    }
    
    private void drawFejlecSor(Graphics2D g, int ysor) {
        g.drawString("Cég", BEHUZAS, ysor);
        g.drawString("Befizetési határidő", BEHUZAS+100, ysor);
        g.drawString("Összeg", BEHUZAS+250, ysor);
        g.drawString("Állapot", BEHUZAS+340, ysor);
    }
}
