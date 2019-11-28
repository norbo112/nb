/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.norbo.projects.progj18edzesnaplo.data.naplo;

import com.norbo.projects.progj18edzesnaplo.data.IGyakorlat;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

/**
 *
 * @author igloi
 */
public interface SorozatInterface extends Serializable {
    /**
     * Amikor bejegyezted az első sorozatot, akkor rögzűl az időpont is
     * @return LocalDateTime amikor elkezdted a gyakorlatot
     */
    public LocalDateTime getRogzitesIdopont();
    public void setGyakRogzitesIdopontja(LocalDateTime idopont);
    
    public IGyakorlat getGyakorlat();
    public void setGyakorlat(IGyakorlat gyakorlat);
    
    public void setSuly(List<Integer> sulylist);
    public List<Integer> getSuly();
    public void addSuly(int suly);
    public void setSulyAt(int index, int nsuly);
    
    public void setIsm(List<Integer> ismlist);
    public List<Integer> getIsm();
    public void addIsm(int ism);
    public void setIsmAt(int index, int nism);
    
    public void setIsmRogzitesIdopontja(List<LocalTime> ismido);
    public List<LocalTime> getIsmRogzitesIdopontja();
    public void addIsmIdo(LocalTime idopont);
    
    public int getOsszSuly();
}
