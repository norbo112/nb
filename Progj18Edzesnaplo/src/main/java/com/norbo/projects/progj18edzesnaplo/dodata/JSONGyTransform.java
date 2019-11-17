/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.norbo.projects.progj18edzesnaplo.dodata;

import com.norbo.projects.progj18edzesnaplo.data.Gyakorlat;
import com.norbo.projects.progj18edzesnaplo.data.IGyakorlat;
import com.norbo.projects.progj18edzesnaplo.data.Izomcsoport;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author igloi
 */
public class JSONGyTransform extends AbstractTrasform<JSONObject>{

    public JSONGyTransform(String url) {
        super(url);
    }

    @Override
    public List<IGyakorlat> betolt(JSONObject source) {
        List<IGyakorlat> gyakorlats = new ArrayList<>();
       
        JSONArray josarr = source.getJSONArray("gyakorlatlista");
        for (int i = 0; i < josarr.length(); i++) {
            JSONObject jobi = josarr.getJSONObject(i);
            gyakorlats.add(new Gyakorlat(
                    jobi.getInt("gyak_id"),
                    jobi.getString("megnevezes"),
                    Izomcsoport.getIzomCsoport(jobi.getString("csoport")),
                    jobi.getString("leiras"),
                    jobi.getString("videolink"),
                    jobi.getInt("videostartpoz")
            ));
        }
        
        return gyakorlats;
    }
}
