/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.norbo.projects.progj18edzesnaplo.dodata;

import com.norbo.projects.progj18edzesnaplo.data.Gyakorlat;
import com.norbo.projects.progj18edzesnaplo.data.IGyakorlat;
import com.norbo.projects.progj18edzesnaplo.data.Izomcsoport;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONWriter;

/**
 *
 * @author igloi
 */
public class JSONGyTransform extends AbstractTransform { 
    
    @Override
    public List<IGyakorlat> betolt(String path) {
        List<IGyakorlat> gyakorlats = new ArrayList<>();
       
        JSONObject source = null;
        try {
            source = new JSONObject(getString(path, KERES_GYAKLEKER));
        } catch (IOException ex) {
            Logger.getLogger(JSONGyTransform.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(source != null) {
            JSONArray josarr = source.getJSONArray("gyakorlatlista");
            for (int i = 0; i < josarr.length(); i++) {
                JSONObject jobi = josarr.getJSONObject(i);
                gyakorlats.add(new Gyakorlat(
                        jobi.getInt("gyak_id"),
                        jobi.getString("megnevezes"),
                        Izomcsoport.getIzomCsoport(jobi.getString("csoport")),
                        jobi.get("leiras").toString(),
                        jobi.getString("videolink"),
                        jobi.getInt("videostartpoz")
                ));
            }
        }
        
        return gyakorlats;
    }

    @Override
    public boolean gyakorlatMent(List<IGyakorlat> gyks, String path) {
        JSONObject job = new JSONObject();
        JSONArray arr = new JSONArray();
        
        for (IGyakorlat gyk : gyks) {
            arr.put(gyk.makeJsonObject());
        }
        
        job.append("gyakorlatlista", arr);
        
        try(BufferedWriter br = new BufferedWriter(new FileWriter(path))) {
            br.append(job.toString());
            
            return true;
        } catch (IOException ex) {
            Logger.getLogger(JSONGyTransform.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
}
