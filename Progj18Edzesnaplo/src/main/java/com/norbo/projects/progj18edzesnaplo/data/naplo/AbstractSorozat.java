/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.norbo.projects.progj18edzesnaplo.data.naplo;

import com.norbo.projects.progj18edzesnaplo.data.IGyakorlat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author igloi
 */
public class AbstractSorozat implements SorozatInterface {
    private static final long serialversionUID = 123L;
    List<Integer> suly;
    List<Integer> ism;
    IGyakorlat gyakorlat;
    List<LocalTime> IsmRogzitesIdopontja;
    LocalDateTime rogzitesiIdopont;

    public AbstractSorozat() {
    }

    public AbstractSorozat(IGyakorlat gyakorlat) {
        this.gyakorlat = gyakorlat;
        this.suly = new ArrayList<>();
        this.IsmRogzitesIdopontja = new ArrayList<>();
        this.ism = new ArrayList<>();
    }

    public AbstractSorozat(List<Integer> sulyList, List<Integer> ismList, IGyakorlat gyakorlat, List<LocalTime> ismIdoList) {
        this.suly = sulyList;
        this.ism = ismList;
        this.gyakorlat = gyakorlat;
        this.IsmRogzitesIdopontja = ismIdoList;
    }

    @Override
    public LocalDateTime getRogzitesIdopont() {
        return rogzitesiIdopont;
    }

    @Override
    public void setGyakRogzitesIdopontja(LocalDateTime idopont) {
        this.rogzitesiIdopont = idopont;
    }
    
    

    @Override
    public IGyakorlat getGyakorlat() {
        return gyakorlat;
    }

    @Override
    public void setGyakorlat(IGyakorlat gyakorlat) {
        this.gyakorlat = gyakorlat;
    }

    @Override
    public void setSuly(List<Integer> sulylist) {
        this.suly = sulylist;
    }

    @Override
    public List<Integer> getSuly() {
        return suly;
    }

    @Override
    public void addSuly(int suly) {
        this.suly.add(suly);
    }

    @Override
    public void setIsm(List<Integer> ismlist) {
        this.ism = ismlist;
    }

    @Override
    public List<Integer> getIsm() {
        return ism;
    }

    @Override
    public void addIsm(int ism) {
        this.ism.add(ism);
    }

    @Override
    public void setIsmRogzitesIdopontja(List<LocalTime> ismido) {
        this.IsmRogzitesIdopontja = ismido;
    }

    @Override
    public List<LocalTime> getIsmRogzitesIdopontja() {
        return IsmRogzitesIdopontja;
    }

    @Override
    public void addIsmIdo(LocalTime idopont) {
        IsmRogzitesIdopontja.add(idopont);
    }

    @Override
    public void setSulyAt(int index, int nsuly) {
        suly.set(index, nsuly);
    }

    @Override
    public void setIsmAt(int index, int nism) {
        ism.set(index, nism);
    }
    
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.gyakorlat);
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
        final AbstractSorozat other = (AbstractSorozat) obj;
        if (!Objects.equals(this.gyakorlat.getMegnevezes(), other.gyakorlat.getMegnevezes())) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return gyakorlat.getMegnevezes();
    }
    
    
    @Override
    public int getOsszSuly() {
        int ossz = 0;
        for (int i = 0; i < suly.size(); i++) {
            ossz += suly.get(i) * ism.get(i);
        }
        return ossz;
    }
}
