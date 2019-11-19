package com.norbo.projects.progj18edzesnaplo.data;

import java.io.Serializable;
import org.json.JSONObject;

/**
 *  egy Gyakorlat typust reprezentáló interface
 * @author igloi
 */
public interface IGyakorlat extends Serializable {
    public int getId();
    public String getMegnevezes();
    public Izomcsoport getIzomcsoport();
    public String getLeiras();
    public String getVideolink();
    public int getVideostartpoz();
    
    public void setId(int id);
    public void setMegnevezes(String megnevezes);
    public void setIzomcsoport(Izomcsoport izomcsop);
    public void setLeiras(String leiras);
    public void setVideolink(String videolink);
    public void setVideostartpoz(int videostartpoz);
    
    public JSONObject makeJsonObject();
    public String makeCsvForm();
}
