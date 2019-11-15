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
public abstract class AbstractGyakorlat implements IGyakorlat {
    private final int id;
    private final String nev;
    private final Izomcsoport izomcsoport;
    private final String leiras;
    private final String videoId;
    private final int videoPoz;

    public AbstractGyakorlat(int id, String nev, 
            Izomcsoport izomcsoport, String leiras, 
            String videoId, int videoPoz) {
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
        return "id=" + id + 
                ", nev=" + nev + 
                ", izomcsoport=" + izomcsoport +
                ", leiras=" + leiras + 
                ", videoId=" + videoId + 
                ", videoPoz=" + videoPoz;
    }
    
    
}
