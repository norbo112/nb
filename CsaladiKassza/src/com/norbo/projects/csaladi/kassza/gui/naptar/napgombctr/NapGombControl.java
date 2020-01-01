/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.norbo.projects.csaladi.kassza.gui.naptar.napgombctr;

import com.norbo.projects.csaladi.kassza.gui.naptar.NapButton;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author igloi
 */
public class NapGombControl extends Thread {

    private NapButton kijeloltGomb;
    private boolean fuss = true;
    
    public NapGombControl(NapButton kijeloltGomb) {
        this.kijeloltGomb = kijeloltGomb;
    }

    @Override
    public void run() {
        while(fuss) {
            try {
                kijeloltGomb.setBorder(kijeloltGomb.blinkOn);
                Thread.sleep(500);
                kijeloltGomb.setBorder(kijeloltGomb.blinkOff);
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(NapGombControl.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }

    public void setFuss(boolean fuss) {
        this.fuss = fuss;
    }
    
}
