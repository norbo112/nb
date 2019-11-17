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
    public JSONObject readObject(String source) {
        return new JSONObject(source);
    }

    @Override
    public void loadGyakorlatFromJson(JSONObject jsonobject) {
        setId(jsonobject.getInt("gyak_id"));
        setMegnevezes(jsonobject.getString("megnevezes"));
        setIzomcsoport(Izomcsoport.getIzomCsoport(jsonobject.getString("csoport")));
        setLeiras(jsonobject.getString("leiras"));
        setVideolink(jsonobject.getString("videolink"));
        setVideostartpoz(jsonobject.getInt("videostartpoz"));
    }

    @Override
    public int compareTo(IGyakorlat o) {
        return getIzomcsoport().compareTo(o.getIzomcsoport());
    }
}
