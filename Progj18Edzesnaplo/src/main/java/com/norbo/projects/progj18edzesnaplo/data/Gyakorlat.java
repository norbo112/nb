/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.norbo.projects.progj18edzesnaplo.data;

import org.json.JSONObject;

/**
 *
 * @author igloi
 */
public class Gyakorlat extends AbstractGyakorlat {

    public Gyakorlat() {
    }
    
    public Gyakorlat(int id, String nev, 
            Izomcsoport izomcsoport, 
            String leiras, 
            String videoId, 
            int videoPoz) {
        super(id, nev, izomcsoport, leiras, videoId, videoPoz);
    }

    @Override
    public int compareTo(IGyakorlat o) {
        return getIzomcsoport().toString().compareTo(o.getIzomcsoport().toString());
    }

    @Override
    public int compare(IGyakorlat o1, IGyakorlat o2) {
        return o1.getIzomcsoport().toString().compareTo(o2.getIzomcsoport().toString());
    }
}
