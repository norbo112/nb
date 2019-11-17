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
public abstract class AbstractGyakorlat implements IGyakorlat, Comparable<IGyakorlat> {
    private int id;
    private String megnevezes;
    private Izomcsoport izomcsoport;
    private String leiras;
    private String videolink;
    private int videostartpoz;

    public AbstractGyakorlat() {
    }

    public AbstractGyakorlat(int id, String nev, 
            Izomcsoport izomcsoport, String leiras, 
            String videoId, int videoPoz) {
        this.id = id;
        this.megnevezes = nev;
        this.izomcsoport = izomcsoport;
        this.leiras = leiras;
        this.videolink = videoId;
        this.videostartpoz = videoPoz;
    }
    
    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getMegnevezes() {
        return megnevezes;
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
    public String getVideolink() {
        return videolink;
    }

    @Override
    public int getVideostartpoz() {
        return videostartpoz;
    }

    @Override
    public String toString() {
        return "[" + id + 
                "] " + megnevezes + 
                " " + izomcsoport +
                " "+ leiras + " "+
                (videolink.length() != 0 ? videolink : " ") +
                (videostartpoz != 0 ? videostartpoz : " ");
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public void setMegnevezes(String megnevezes) {
        this.megnevezes = megnevezes;
    }

    @Override
    public void setIzomcsoport(Izomcsoport izomcsop) {
        this.izomcsoport = izomcsop;
    }

    @Override
    public void setLeiras(String leiras) {
        this.leiras = leiras;
    }

    @Override
    public void setVideolink(String videolink) {
        this.videolink = videolink;
    }

    @Override
    public void setVideostartpoz(int videostartpoz) {
        this.videostartpoz = videostartpoz;
    }
    
    

    @Override
    public abstract JSONObject readObject(String source);

    @Override
    public abstract void loadGyakorlatFromJson(JSONObject jsonobject);

    @Override
    public abstract int compareTo(IGyakorlat o);
}
