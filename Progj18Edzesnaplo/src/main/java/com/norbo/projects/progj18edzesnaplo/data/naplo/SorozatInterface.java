/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.norbo.projects.progj18edzesnaplo.data.naplo;

import com.norbo.projects.progj18edzesnaplo.data.IGyakorlat;
import java.time.LocalTime;
import java.util.List;

/**
 *
 * @author igloi
 */
public interface SorozatInterface {
    public IGyakorlat getGyakorlat();
    public void setGyakorlat(IGyakorlat gyakorlat);
    
    public void setSulyList(List<Integer> sulylist);
    public List<Integer> getSulyList();
    public void addSuly(int suly);
    public void setSulyAt(int index, int nsuly);
    
    public void setIsmList(List<Integer> ismlist);
    public List<Integer> getIsmList();
    public void addIsm(int ism);
    public void setIsmAt(int index, int nism);
    
    public void setIsmIdoList(List<LocalTime> ismido);
    public List<LocalTime> getIsmIdoList();
    public void addIsmIdo(LocalTime idopont);
}
