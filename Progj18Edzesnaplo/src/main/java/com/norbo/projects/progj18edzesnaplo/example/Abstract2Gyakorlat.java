/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.norbo.projects.progj18edzesnaplo.example;

import com.norbo.projects.progj18edzesnaplo.data.IGyakorlat;
import com.norbo.projects.progj18edzesnaplo.data.Izomcsoport;

/**
 *
 * @author igloi
 */
public abstract class Abstract2Gyakorlat implements IGyakorlat {
    private final int id;
    private final String nev;
    private final Izomcsoport izomcsoport;
    private final String leiras;
    private final String videoId;
    private final int videoPoz;

    public Abstract2Gyakorlat(int id, String nev, Izomcsoport izomcsoport, String leiras, String videoId, int videoPoz) {
        this.id = id;
        this.nev = nev;
        this.izomcsoport = izomcsoport;
        this.leiras = leiras;
        this.videoId = videoId;
        this.videoPoz = videoPoz;
    }
    
    
    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getNew() {
        return nev;
    }

    @Override
    public Izomcsoport getIzomcsoport() {
        return izomcsoport;
    }

    @Override
    public String getLeiras() {
        return leiras;
    }

    @Override
    public String getVideoId() {
        return videoId;
    }

    @Override
    public int getVideoPoz() {
        return videoPoz;
    }

    @Override
    public String toString() {
        return "[" + id + 
                "] " + nev + 
                " " + izomcsoport +
                " "+ leiras + " "+
                (videoId.length() != 0 ? videoId : "") +
                (videoPoz != 0 ? videoPoz : "");
    }
}
