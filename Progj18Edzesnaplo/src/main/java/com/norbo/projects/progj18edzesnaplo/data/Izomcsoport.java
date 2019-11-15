/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.norbo.projects.progj18edzesnaplo.data;

/**
 *
 * @author igloi
 */
public enum Izomcsoport {
    MELL("Mell"), HAT("Hát"), LAB("Láb"),
    HAS("Has"), ALKAR("Alkar"), BICEPSZ("Bicepsz"),
    TRICEPSZ("Tricepsz"), VADLI("Vádli"), VALL("Váll");
    
    String s;
    
    private Izomcsoport(String s) {
        this.s = s;
    }

    @Override
    public String toString() {
        return s;
    }

    
}
