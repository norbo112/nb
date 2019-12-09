/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.norbo.projects.csaladi.kassza.adatok;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author igloi
 */
public class Szamla {
    public enum Prior {
        LOW(3),MEDIUM(2),HIGH(1);
        
        int a;

        private Prior(int a) {
            this.a = a;
        }

        @Override
        public String toString() {
            return Integer.toString(a);
        }
    }
    
    private String szamlaSzam;
    private String megjelenoNev;
    private Prior prioritas;
    private LocalDate befizetesHatarido;
    private double osszeg;
    private int id;
    private String kijeloles = "0,255,0";

    //egy üres adatokkal rendelkező, a válassz listára
    public Szamla() {
    }

    public Szamla(int id, String szamlaSzam, String megjelenoNev, Prior prioritas, LocalDate befizetesHatarido, double osszeg) {
        this.id = id;
        this.szamlaSzam = szamlaSzam;
        this.megjelenoNev = megjelenoNev;
        this.prioritas = prioritas;
        this.befizetesHatarido = befizetesHatarido;
        this.osszeg = osszeg;
    }

    public Szamla(int id, String szamlaSzam, 
            String megjelenoNev, Prior prioritas, LocalDate befizetesHatarido, 
            double osszeg, String kijeloles) {
        this.id = id;
        this.szamlaSzam = szamlaSzam;
        this.megjelenoNev = megjelenoNev;
        this.prioritas = prioritas;
        this.befizetesHatarido = befizetesHatarido;
        this.osszeg = osszeg;
        this.kijeloles = kijeloles;
    }

    public String getKijeloles() {
        return kijeloles;
    }
    
    
    
    public String getSzamlaSzam() {
        return szamlaSzam;
    }

    public String getMegjelenoNev() {
        return megjelenoNev;
    }

    public Prior getPrioritas() {
        return prioritas;
    }

    public LocalDate getBefizetesHatarido() {
        return befizetesHatarido;
    }

    public double getOsszeg() {
        return osszeg;
    }

    public int getId() {
        return id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.szamlaSzam);
        hash = 29 * hash + Objects.hashCode(this.megjelenoNev);
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
        final Szamla other = (Szamla) obj;
        if (!Objects.equals(this.szamlaSzam, other.szamlaSzam)) {
            return false;
        }
        if (!Objects.equals(this.megjelenoNev, other.megjelenoNev)) {
            return false;
        }
        return true;
    }
    
    
}
