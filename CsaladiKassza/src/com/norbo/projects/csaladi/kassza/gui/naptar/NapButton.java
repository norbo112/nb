/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.norbo.projects.csaladi.kassza.gui.naptar;

import com.norbo.projects.csaladi.kassza.adatok.utils.szamlalista.SzamlaLista;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author igloi
 */
public class NapButton extends JButton {
    /**
     * Hol és merre jelenleg meg a kis kép, ha van mentett fájl az adott napon
     */
    public enum Orient {
        DK, DNY, ENY, EK;
    }

    private boolean kijelolve = false;
    private SzamlaLista szamlaLista;
    private final ImageIcon haveikon = new ImageIcon(getClass().getClassLoader().getResource("resources/button/kassza_button_have.png"));
    
    private Orient orient = Orient.DNY;
    
    public NapButton() {
    }

    public NapButton(String text) {
        super(text);
    }

    public NapButton(Action a) {
        super(a);
    }

    public NapButton(String text, Icon icon) {
        super(text, icon);
    }

    public boolean isKijelolve() {
        return kijelolve;
    }

    public void setKijelolve(boolean kijelolve) {
        this.kijelolve = kijelolve;
    }

    public String getFilenev() {
        return szamlaLista.getFilenev();
    }

    public void setSzamlaLista(SzamlaLista szamlaLista) {
        this.szamlaLista = szamlaLista;
        repaint();
    }

    public SzamlaLista getSzamlaLista() {
        return szamlaLista;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        if(szamlaLista != null) {
            switch (orient) {
                case DK : 
                    g.drawImage(haveikon.getImage(), 5, getHeight() - 20, 20, 20, null);
                    break;
                case DNY : 
                    g.drawImage(haveikon.getImage(), getWidth() - 20, getHeight() - 20, 19, 19, null);
                    break;
                default : 
                    g.drawImage(haveikon.getImage(), getWidth() - 20, getHeight() - 20, 19, 19, null);
                    break;
            }
        }
    }
    
    
    
}
