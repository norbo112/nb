/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.norbo.projects.csaladi.kassza.adatok;

import java.time.LocalDateTime;
import java.util.Objects;

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

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.szamla.getMegjelenoNev());
        return hash;
    }

    

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final BeSzamla other = (BeSzamla) obj;
        if (!Objects.equals(this.szamla.getMegjelenoNev(), other.szamla.getMegjelenoNev())) {
            return false;
        }
        return true;
    }

    public void setAllapot(boolean b) {
       this.befizetve = b;
    }

    
    
}
