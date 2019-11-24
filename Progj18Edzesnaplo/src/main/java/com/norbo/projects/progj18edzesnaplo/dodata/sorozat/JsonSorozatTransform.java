/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.norbo.projects.progj18edzesnaplo.dodata.sorozat;

import com.norbo.projects.progj18edzesnaplo.data.naplo.Sorozat;
import com.norbo.projects.progj18edzesnaplo.data.naplo.SorozatInterface;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author igloi
 */
public class JsonSorozatTransform implements SorozatTransform<String> {

    /**
     * Sorozatok kimentése JSon formátumba
     * @param sorozats sorozatok mint paraméter
     * @param path fájl útvonala
     * @return true ha sikeres volt a fájl mentés, false ha nem
     */
    @Override
    public boolean ment(List<SorozatInterface> sorozats, String path) {
        JSONObject obj = new JSONObject();
        JSONArray arr = new JSONArray(sorozats);
        obj.append("edzesnap", arr);
        
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            obj.write(bw);
            return true;
        } catch(JSONException ex) {
            Logger.getLogger(JsonSorozatTransform.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JsonSorozatTransform.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
}
