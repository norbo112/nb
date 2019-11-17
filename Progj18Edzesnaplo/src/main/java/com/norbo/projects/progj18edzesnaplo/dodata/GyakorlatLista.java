/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.norbo.projects.progj18edzesnaplo.dodata;

import com.norbo.projects.progj18edzesnaplo.data.Gyakorlat;
import com.norbo.projects.progj18edzesnaplo.data.IGyakorlat;
import com.norbo.projects.progj18edzesnaplo.data.Izomcsoport;
import com.norbo.projects.progj18edzesnaplo.example.MasikGyakImpl;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author igloi
 */
public class GyakorlatLista {
    public static final String GYAKURL = "http://www.edzesnaplo.eu/android/naplolistause.php";
    public static List<IGyakorlat> getGyakorlatList() {
        List<IGyakorlat> result = new ArrayList<>();
        
        //csak tesz, két gyakorlatot kézzel adok hozzá
        //itt tölteném be mysqlből
        
        result.add(new Gyakorlat(1,"Fekvenyomás",
                Izomcsoport.MELL, 
                "Vizszintesen lefekszünk a padra...",
                "xsoUWuJglGc", 22));
        
        result.add(new Gyakorlat(2,"45°ba nyomás kétkezessel",
                Izomcsoport.MELL, 
                "45 fokos padon fekve...",
                "", 0));
        
        result.add(new Gyakorlat(3,"30°ba nyomás kétkezessel",
                Izomcsoport.MELL, 
                "30 fokba lefekszünk a padra...",
                "",0));
        
        result.add(new MasikGyakImpl(5, "Kétkezes evezés", Izomcsoport.HAT, "Pucsít", "", 0));
        
        return result;
    }
    
    public static List<IGyakorlat> getGyakorlatList(String url) throws MalformedURLException, IOException {
        List<IGyakorlat> gyakorlats = new ArrayList<>();
        HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
        con.setRequestMethod("POST");
        con.setDoOutput(true);
        
        String params = "keres=GYAKLISTALEKER";
        
        try (OutputStreamWriter out = new OutputStreamWriter(con.getOutputStream())) {
            out.write(params);
        }
        
        if(con.getResponseCode() == HttpURLConnection.HTTP_OK) {
            String inputstring = getStringFromInput(con.getInputStream());
//            System.out.println(inputstring);
            JSONObject job = new JSONObject(inputstring);

            if(getOpt(job, "hgyakorlatlista").isPresent()) {
                System.out.println("Hiba történt az adatok fogadása közben: "+
                        getOpt(job,"hgyakorlatlista").get());
                return null;
            }

            JSONArray josarr = job.getJSONArray("gyakorlatlista");
            for (int i = 0; i < josarr.length(); i++) {
                Gyakorlat gyaksi = new Gyakorlat();
                gyaksi.loadGyakorlatFromJson(josarr.getJSONObject(i));
                gyakorlats.add(gyaksi);
            } 
        } else {
            System.out.println("Nem lehetett elérni az adatokat a szerverről");
        }
        
        return gyakorlats;
    }
    
    private static String getStringFromInput(InputStream in) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader bin = new BufferedReader(new InputStreamReader(in));
        String line;
        while((line = bin.readLine()) != null) {
            sb.append(line);
        }
        
        return sb.toString();
    }
    
    private static Optional<String> getOpt(JSONObject obj, String key) {
        Optional<String> res = Optional.empty();
        try {
            res = Optional.ofNullable(obj.getString(key));
        } catch (JSONException e) {
            System.out.println("Hiba történt: loggolni való lesz: "+e.getMessage());
        }
        return res;
    }
}
