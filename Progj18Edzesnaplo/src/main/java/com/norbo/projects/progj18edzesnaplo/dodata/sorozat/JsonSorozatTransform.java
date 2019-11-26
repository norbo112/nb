/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.norbo.projects.progj18edzesnaplo.dodata.sorozat;

import com.norbo.projects.progj18edzesnaplo.data.Gyakorlat;
import com.norbo.projects.progj18edzesnaplo.data.Izomcsoport;
import com.norbo.projects.progj18edzesnaplo.data.naplo.Sorozat;
import com.norbo.projects.progj18edzesnaplo.data.naplo.SorozatInterface;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
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
     *
     * @param sorozats sorozatok mint paraméter
     * @param path fájl útvonala
     * @return true ha sikeres volt a fájl mentés, false ha nem
     */
    @Override
    public boolean ment(List<SorozatInterface> sorozats, String path) {
        JSONObject obj = new JSONObject();
        JSONArray arr = new JSONArray(sorozats);
        obj.append("edzesnap", arr);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path))) {
            obj.write(bw);
            return true;
        } catch (JSONException ex) {
            Logger.getLogger(JsonSorozatTransform.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(JsonSorozatTransform.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public List<SorozatInterface> betolt(String path) throws JSONException {
        List<SorozatInterface> sorozat = new ArrayList<>();

        String source = null;
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

            source = sb.toString();
        } catch (IOException ex) {
            Logger.getLogger(JsonSorozatTransform.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (source != null) {
            JSONObject job = new JSONObject(source);
            JSONArray arr = job.getJSONArray("edzesnap");

            for (int i = 0; i < arr.getJSONArray(0).length(); i++) {
                JSONObject ijob = arr.getJSONArray(0).getJSONObject(i);

                JSONObject gyakjob = ijob.getJSONObject("gyakorlat");

                Gyakorlat gy = new Gyakorlat();
                gy.setId(gyakjob.getInt("id"));
                gy.setIzomcsoport(Izomcsoport.getCsoportFromJSON(gyakjob.getString("izomcsoport")));
                gy.setMegnevezes(gyakjob.getString("megnevezes"));
                gy.setLeiras(gyakjob.getString("leiras"));
                gy.setVideolink(gyakjob.getString("videolink"));
                gy.setVideostartpoz(gyakjob.getInt("videostartpoz"));
                Sorozat s = new Sorozat(gy);
                s.setGyakRogzitesIdopontja(LocalDateTime.parse(ijob.getString("gyakRogzitesIdopontja")));

                List<Integer> list = getIntList(ijob.getJSONArray("sulyList"));
                s.setSulyList(list);
                list = getIntList(ijob.getJSONArray("ismList"));
                s.setIsmList(list);
                List<LocalTime> times = getTimeList(ijob.getJSONArray("ismIdoList"));
                s.setIsmIdoList(times);
                sorozat.add(s);
            }
        }

        return sorozat;
    }

    private List<Integer> getIntList(JSONArray arr) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < arr.length(); i++) {
            result.add(arr.getInt(i));
        }
        return result;
    }

    private List<LocalTime> getTimeList(JSONArray arr) {
        List<LocalTime> result = new ArrayList<>();
        for (int i = 0; i < arr.length(); i++) {
            result.add(LocalTime.parse(arr.getString(i)));
        }
        return result;
    }
}
