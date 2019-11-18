/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.norbo.projects.progj18edzesnaplo.dodata;

import com.norbo.projects.progj18edzesnaplo.data.IGyakorlat;
import com.norbo.projects.progj18edzesnaplo.dodata.alap.Keszito;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author igloi
 */
public class GyakorlatListaKeszito extends Keszito {
    private List<IGyakorlat> gyakorlatok;
    
    public List<IGyakorlat> getGyakorlatList(String url) throws MalformedURLException, IOException {
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
            JSONObject job = new JSONObject(inputstring);

            if(getOpt(job, "hgyakorlatlista").isPresent()) {
                System.out.println("Hiba történt az adatok fogadása közben: "+
                        getOpt(job,"hgyakorlatlista").get());
                return null;
            }

            GyakorlatBetolto<JSONObject> gyakorlatBetolto = new GyakorlatBetolto(new JSONGyTransform(url));
            gyakorlats = gyakorlatBetolto.betolt(job);
        } else {
            System.out.println("Nem lehetett elérni az adatokat a szerverről");
        }
        
        gyakorlatok = gyakorlats;
        return gyakorlats;
    }
 
    public List<IGyakorlat> getGyakorlatFromCSV(String fn) throws IOException {
        InputStream in = getClass().getClassLoader().getResourceAsStream(fn);
        String src = getStringFromInput(in);
        
        GyakorlatBetolto<String> gyakorlatBetolto = new GyakorlatBetolto<>(new CsvGyTranform(fn));
        gyakorlatok = gyakorlatBetolto.betolt(src);
        return gyakorlatok;
    }

    public List<String> getIzomCsoport() {
        Set<String> izomcsoportok = gyakorlatok.stream().map(f->f.getIzomcsoport().toString()).collect(
            Collectors.toSet());
        return new ArrayList<>(izomcsoportok);
    }
}
