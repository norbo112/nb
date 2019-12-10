/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.norbo.projects.csaladi.kassza.adatok.utils.szamlalista;

import com.norbo.projects.csaladi.kassza.adatok.BeSzamla;
import java.time.Instant;
import java.util.List;

/**
 *
 * @author igloi
 */
public class SzamlaLista {
    private String filenev;
    private Instant lastModified;
    private List<BeSzamla> beSzamlas;

    public SzamlaLista(String filenev, Instant lastModified, List<BeSzamla> beSzamlas) {
        this.filenev = filenev;
        this.lastModified = lastModified;
        this.beSzamlas = beSzamlas;
    }

    public String getFilenev() {
        return filenev;
    }

    public Instant getLastModified() {
        return lastModified;
    }

    public List<BeSzamla> getBeSzamlas() {
        return beSzamlas;
    }
}
