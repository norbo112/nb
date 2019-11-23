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
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author igloi
 */
public class AbstractSorozat implements SorozatInterface {
    List<Integer> sulyList;
    List<Integer> ismList;
    IGyakorlat gyakorlat;
    List<LocalTime> ismIdoList;
    LocalDateTime rogzitesiIdopont;

    public AbstractSorozat(IGyakorlat gyakorlat) {
        this.gyakorlat = gyakorlat;
        this.sulyList = new ArrayList<>();
        this.ismIdoList = new ArrayList<>();
        this.ismList = new ArrayList<>();
    }

    public AbstractSorozat(List<Integer> sulyList, List<Integer> ismList, IGyakorlat gyakorlat, List<LocalTime> ismIdoList) {
        this.sulyList = sulyList;
        this.ismList = ismList;
        this.gyakorlat = gyakorlat;
        this.ismIdoList = ismIdoList;
    }

    @Override
    public LocalDateTime getGyakRogzitesIdopontja() {
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
    public void setSulyList(List<Integer> sulylist) {
        this.sulyList = sulylist;
    }

    @Override
    public List<Integer> getSulyList() {
        return sulyList;
    }

    @Override
    public void addSuly(int suly) {
        sulyList.add(suly);
    }

    @Override
    public void setIsmList(List<Integer> ismlist) {
        this.ismList = ismlist;
    }

    @Override
    public List<Integer> getIsmList() {
        return ismList;
    }

    @Override
    public void addIsm(int ism) {
        ismList.add(ism);
    }

    @Override
    public void setIsmIdoList(List<LocalTime> ismido) {
        this.ismIdoList = ismido;
    }

    @Override
    public List<LocalTime> getIsmIdoList() {
        return ismIdoList;
    }

    @Override
    public void addIsmIdo(LocalTime idopont) {
        ismIdoList.add(idopont);
    }

    @Override
    public void setSulyAt(int index, int nsuly) {
        sulyList.set(index, nsuly);
    }

    @Override
    public void setIsmAt(int index, int nism) {
        ismList.set(index, nism);
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
}
