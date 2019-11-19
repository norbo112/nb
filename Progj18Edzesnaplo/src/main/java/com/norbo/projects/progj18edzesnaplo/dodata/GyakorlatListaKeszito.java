/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.norbo.projects.progj18edzesnaplo.dodata;

import com.norbo.projects.progj18edzesnaplo.data.IGyakorlat;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

/**
 *
 * @author igloi
 */
public class GyakorlatListaKeszito {
    private List<IGyakorlat> gyakorlatok;

    public GyakorlatListaKeszito() {
    }

    public void setGyakorlatok(List<IGyakorlat> gyakorlatok) {
        this.gyakorlatok = gyakorlatok;
    }
    
    public List<IGyakorlat> getGyakorlatListJSON(String url) throws MalformedURLException, IOException {
        List<IGyakorlat> gyakorlats = new ArrayList<>();
        
        GyakorlatBetolto betolto = new GyakorlatBetolto(new JSONGyTransform());
        gyakorlats = betolto.betolt(url);
        gyakorlatok = gyakorlats;
        return gyakorlats;
    }
    
    public List<IGyakorlat> getGyakorlatExcel(String fn) throws IOException, InvalidFormatException {
        GyakorlatBetolto gyakorlatBetolto = new GyakorlatBetolto(new ExcelGyTransform());
        return gyakorlatBetolto.betolt(fn);
    }
 
    public List<IGyakorlat> getGyakorlatCSV(String fn) throws IOException {
        InputStream in = getClass().getClassLoader().getResourceAsStream(fn);
        
        GyakorlatBetolto gyakorlatBetolto = new GyakorlatBetolto(new CsvGyTransform());
        gyakorlatok = gyakorlatBetolto.betolt(fn);
        return gyakorlatok;
    }

    public List<String> getIzomCsoport() {
        Set<String> izomcsoportok = gyakorlatok.stream().map(f->f.getIzomcsoport().toString()).collect(
            Collectors.toSet());
        return new ArrayList<>(izomcsoportok);
    }
}
