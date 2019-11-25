/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.norbo.projects.progj18edzesnaplo.data;

import java.util.Comparator;
import java.util.Objects;
import org.json.JSONObject;

/**
 *
 * @author igloi
 */
public abstract class AbstractGyakorlat implements IGyakorlat, Comparable<IGyakorlat>, Comparator<IGyakorlat> {
    private int id;
    private String megnevezes;
    private Izomcsoport izomcsoport;
    private String leiras;
    private String videolink;
    private int videostartpoz;

    public AbstractGyakorlat() {
    }

    public AbstractGyakorlat(String megnevezes) {
        this.megnevezes = megnevezes;
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
    public abstract int compareTo(IGyakorlat o);

    @Override
    public abstract int compare(IGyakorlat o1, IGyakorlat o2);

    @Override
    public JSONObject makeJsonObject() {
        JSONObject job = new JSONObject();
        job.append("gyak_id", id)
                .append("csoport", izomcsoport.toString())
                .append("megnevezes", megnevezes)
                .append("leiras", leiras)
                .append("Videolink", videolink)
                .append("Videostartpoz", videostartpoz);
        return job;
    }

    @Override
    public String makeCsvForm() {
        return id+";"+megnevezes+";"+izomcsoport.toString()+";"+
                (leiras != null && leiras.length()>5 ? leiras : "nincs leírás")+";"+
                (videolink != null && videolink.length() > 5 ? videolink : "nincs video")+";"+videostartpoz;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.id;
        hash = 83 * hash + Objects.hashCode(this.megnevezes);
        hash = 83 * hash + Objects.hashCode(this.izomcsoport);
        hash = 83 * hash + Objects.hashCode(this.leiras);
        hash = 83 * hash + Objects.hashCode(this.videolink);
        hash = 83 * hash + this.videostartpoz;
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
        final AbstractGyakorlat other = (AbstractGyakorlat) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.videostartpoz != other.videostartpoz) {
            return false;
        }
        if (!Objects.equals(this.megnevezes, other.megnevezes)) {
            return false;
        }
        if (!Objects.equals(this.leiras, other.leiras)) {
            return false;
        }
        if (!Objects.equals(this.videolink, other.videolink)) {
            return false;
        }
        if (this.izomcsoport != other.izomcsoport) {
            return false;
        }
        return true;
    }
    
    
}
