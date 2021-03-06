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
    TRICEPSZ("Tricepsz"), VADLI("Vádli"), VALL("Váll"), CSUKLYA("Csuklya");
    
    String s;
    
    private Izomcsoport(String s) {
        this.s = s;
    }

    @Override
    public String toString() {
        return s;
    }

    public static Izomcsoport getIzomCsoport(String nev) {
        switch(nev) {
            case "Mell" : return MELL;
            case "Hát" : return HAT;
            case "Láb" : return LAB;
            case "Alkar" : return ALKAR;
            case "Bicepsz" : return BICEPSZ;
            case "Tricepsz" : return TRICEPSZ;
            case "Has" : return HAS;
            case "Váll": return VALL;
            case "Vádli" : return VADLI;
            case "Csuklya" : return CSUKLYA;
            default: return null;
        }
    }
    
    /**
     * Valamiért amikor jsonba mentem, a JSONArray kollekcióból nem a toStringet menti
     * hanem az enum-ot, ezért visszatöltéskor ezt használom
     * @param jsonnev
     * @return 
     */
    public static Izomcsoport getCsoportFromJSON(String jsonnev) {
        switch(jsonnev) {
            case "MELL" : return MELL;
            case "HAT" : return HAT;
            case "LAB" : return LAB;
            case "ALKAR" : return ALKAR;
            case "BICEPSZ" : return BICEPSZ;
            case "TRICEPSZ" : return TRICEPSZ;
            case "HAS" : return HAS;
            case "VALL": return VALL;
            case "VADLI" : return VADLI;
            case "CSUKLYA" : return CSUKLYA;
            default: return null;
        }
    }
}
