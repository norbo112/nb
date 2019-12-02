/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.norbo.projects.csaladi.kassza.adatok;

import java.time.LocalDateTime;

/**
 *
 * @author igloi
 */
public class BeSzamla {
    private Szamla szamla;
    private LocalDateTime befizetesiido;
    private double osszeg;
    private boolean befizetve = true; //alapértelmezett

    //egy üres adatokkal rendelkező, a válassz listára
    public BeSzamla() {
    }

    public BeSzamla(Szamla szamla, LocalDateTime befizetesiido, double osszeg) {
        this.szamla = szamla;
        this.befizetesiido = befizetesiido;
        this.osszeg = osszeg;
    }

    public boolean getBefizetve() {
        return befizetve;
    }
    
    

    public Szamla getSzamla() {
        return szamla;
    }

    public LocalDateTime getBefizetesiido() {
        return befizetesiido;
    }

    public double getOsszeg() {
        return osszeg;
    }

    @Override
    public String toString() {
        return String.format("%s\t%s\t%,.2f\t%d\n", szamla.getMegjelenoNev(),
                befizetesiido, osszeg, (befizetve ? 1 : 0));
    }

    
    
}
