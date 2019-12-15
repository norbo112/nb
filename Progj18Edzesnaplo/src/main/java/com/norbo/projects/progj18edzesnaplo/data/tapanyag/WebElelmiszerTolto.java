package com.norbo.projects.progj18edzesnaplo.data.tapanyag;

import com.norbo.projects.progj18edzesnaplo.data.Elelmiszer;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author igloi
 */
public class WebElelmiszerTolto implements DBToltoInterface {
    private static final Logger LOG = Logger.getLogger(WebElelmiszerTolto.class.getName());

    @Override
    public List<Elelmiszer> getElelmiszerList(Map<String, String> parameters) {
        List<Elelmiszer> elelmiszers = new ArrayList<>();
        try {
            HttpURLConnection con = (HttpURLConnection) new URL(parameters.get("url")).openConnection();
            String result = getInputString(con.getInputStream());
            
            JSONObject obj = new JSONObject(result);
            JSONArray arr = obj.getJSONArray("tapanyag");
            
            for (int i = 0; i < arr.length(); i++) {
                JSONObject objtap = arr.getJSONObject(i);
                elelmiszers.add(
                        new Elelmiszer(
                                objtap.getString("elelmiszerneve"),
                                objtap.getString("fajta"), 
                                Integer.parseInt(objtap.getString("energia")),
                                Integer.parseInt(objtap.getString("kaloria")),
                                Double.parseDouble(objtap.getString("feherje")),
                                Double.parseDouble(objtap.getString("zsir")), 
                                Double.parseDouble(objtap.getString("szenhidrat")), 
                                Double.parseDouble(objtap.getString("rost")))
                );
            }
            Logger.getLogger(WebElelmiszerTolto.class.getName()).log(Level.INFO, "Töltés befejeződott a webről");
        } catch (MalformedURLException ex) {
            Logger.getLogger(WebElelmiszerTolto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(WebElelmiszerTolto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return elelmiszers;
    }
    
    private String getInputString(InputStream in) {
        StringBuilder sb = new StringBuilder();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
            in.close();
        } catch (IOException e) {
            LOG.log(Level.FINE, "IO Hiba az HTTP tartalom olvasása közben: ",e);
        }
        
        return sb.toString();
    }

    @Override
    public List<String> getTapanyagFajta(Map<String, String> params) {
        List<String> fajtak = new ArrayList<>();
        try {
            HttpURLConnection con = (HttpURLConnection) new URL(params.get("url")).openConnection();
            String result = getInputString(con.getInputStream());
            
            JSONObject obj = new JSONObject(result);
            JSONArray arr = obj.getJSONArray("tapanyagfajta");
            
            for (int i = 0; i < arr.length(); i++) {
                fajtak.add(arr.getString(i));
            }

        } catch (MalformedURLException ex) {
            Logger.getLogger(WebElelmiszerTolto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(WebElelmiszerTolto.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return fajtak;
    }
}