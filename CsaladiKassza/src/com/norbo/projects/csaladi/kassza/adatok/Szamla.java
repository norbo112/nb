/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.norbo.projects.csaladi.kassza.adatok;

import java.time.LocalDate;

/**
 *
 * @author igloi
 */
public class Szamla {
    public enum Prior {
        LOW,MEDIUM,HIGH;
    }
    
    private String szamlaSzam;
    private String megjelenoNev;
    private Prior prioritas;
    private LocalDate befizetesHatarido;
    private double osszeg;

    //egy üres adatokkal rendelkező, a válassz listára
    public Szamla() {
    }

    public Szamla(String szamlaSzam, String megjelenoNev, Prior prioritas, LocalDate befizetesHatarido, double osszeg) {
        this.szamlaSzam = szamlaSzam;
        this.megjelenoNev = megjelenoNev;
        this.prioritas = prioritas;
        this.befizetesHatarido = befizetesHatarido;
        this.osszeg = osszeg;
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
    
    
}
