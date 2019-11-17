/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.norbo.projects.progj18edzesnaplo.gui.gyakorlatok.szuro;

import com.norbo.projects.progj18edzesnaplo.data.IGyakorlat;
import com.norbo.projects.progj18edzesnaplo.data.Izomcsoport;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

/**
 *
 * @author igloi
 */
public class GyakorlatSzuro {
    private Izomcsoport izomcsoport;

    private final Map<String, Predicate<IGyakorlat>> feltetelek = new HashMap<>();
    
    {
        feltetelek.put("izomcsoport", x -> x.getIzomcsoport() == getIzomcsoport());
    }

    public void setIzomcsoport(Izomcsoport izomcsoport) {
        this.izomcsoport = izomcsoport;
    }

    public Izomcsoport getIzomcsoport() {
        return izomcsoport;
    }
    
    private <T> List<T> szures(List<T> lista, Predicate<T> feltetel) {
        List<T> szurt = new ArrayList<>();
        for (T element : lista) {
            if (feltetel.test(element)) {
                szurt.add(element);
            }
        }
        return szurt;
    }
    
    public List<IGyakorlat> pszures(List<IGyakorlat> lista) {
        Predicate<IGyakorlat> sz = x->true;
        if(izomcsoport != null) sz = sz.and(feltetelek.get("izomcsoport"));
        
        return szures(lista, sz);
    }
}
