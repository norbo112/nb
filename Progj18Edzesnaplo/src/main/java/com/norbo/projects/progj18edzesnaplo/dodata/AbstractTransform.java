/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.norbo.projects.progj18edzesnaplo.dodata;

import com.norbo.projects.progj18edzesnaplo.data.IGyakorlat;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.JSONObject;

/**
 *
 * @author igloi
 * @param <T>
 */
public abstract class AbstractTransform implements IGyTramsform {
    protected static final String KERES_GYAKLEKER = "keres=GYAKLISTALEKER";
    public static final String GYAKURL = "http://www.edzesnaplo.eu/android/naplolistause.php";
    protected static final String CSVFILE = "gyakorlat.csv";
    protected static final String EXCELFILE = "gyakorlatok.xlsx";
    
    @Override
    public abstract List<IGyakorlat> betolt(String path);
    
    protected String getString(String path, String query) throws MalformedURLException, IOException {
        if(path.startsWith("http://")) {
            return getStringFromNet(path, query);
        }
        
        return getStringFromFile(path);
    }
    
    private String getStringFromFile(String path) {
        StringBuilder sb = new StringBuilder();
        
        try(BufferedReader br = new BufferedReader(new InputStreamReader(
                new FileInputStream(path)))) {
            String line;
            while((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
        } catch (IOException ex) {
            Logger.getLogger(CsvGyTransform.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return sb.toString();
    }
    
    private String getStringFromNet(String path, String query) throws MalformedURLException, IOException {
        HttpURLConnection con = (HttpURLConnection) new URL(path).openConnection();
        con.setRequestMethod("POST");
        con.setDoOutput(true);
        
        if(query != null) {
            try (OutputStreamWriter out = new OutputStreamWriter(con.getOutputStream())) {
                out.write(query);
            }
        }
        
        if(con.getResponseCode() == HttpURLConnection.HTTP_OK) {
            return getStringFromInput(con.getInputStream());
        } else {
            Logger.getLogger(AbstractTransform.class.getName()).log(Level.SEVERE, "Nem lehetett elérni az adatokat");
        }
        
        return null;
    }

    private String getStringFromInput(InputStream inputStream) {
        StringBuilder sb = new StringBuilder();
        try(BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while((line = br.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException ex) {
            Logger.getLogger(AbstractTransform.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return sb.toString();
    }
}
