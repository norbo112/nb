/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.norbo.projects.progj18edzesnaplo.dodata.alap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Optional;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author igloi
 */
public class Keszito {
    protected static final String GYAKURL = "http://www.edzesnaplo.eu/android/naplolistause.php";
    protected String getStringFromInput(InputStream in) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader bin = new BufferedReader(new InputStreamReader(in));
        String line;
        while((line = bin.readLine()) != null) {
            sb.append(line).append("\n");
        }
        
        return sb.toString();
    }
    
    protected Optional<String> getOpt(JSONObject obj, String key) {
        Optional<String> res = Optional.empty();
        try {
            res = Optional.ofNullable(obj.getString(key));
        } catch (JSONException e) {
            System.out.println("Hiba történt: loggolni való lesz: "+e.getMessage());
        }
        return res;
    }
}
