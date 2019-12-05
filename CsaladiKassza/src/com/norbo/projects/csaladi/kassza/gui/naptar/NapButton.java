/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.norbo.projects.csaladi.kassza.gui.naptar;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;

/**
 *
 * @author igloi
 */
public class NapButton extends JButton {

    private boolean kijelolve = false;
    
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
    
    
}
