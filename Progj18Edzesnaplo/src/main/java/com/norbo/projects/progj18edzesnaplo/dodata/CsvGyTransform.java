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
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author igloi
 */
public class CsvGyTransform extends AbstractTransform {
    @Override
    public List<IGyakorlat> betolt(String path) {
        String source = null;
        try {
            source = getString(path, null);
        } catch (MalformedURLException ex) {
            Logger.getLogger(CsvGyTransform.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CsvGyTransform.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        List<IGyakorlat> gyakorlats = new ArrayList<>();
        String[] sorok = source.split("\n");
        for (String string : sorok) {
            String[] egysor = string.split(";",7);
            gyakorlats.add(new Gyakorlat(Integer.parseInt(egysor[0]), egysor[2],
                    Izomcsoport.getIzomCsoport(egysor[1]), egysor[3], egysor[4],
                    egysor[5].length() != 0 ? Integer.parseInt(egysor[5]) : 0 ));
        }
        
        return gyakorlats;
    }

    @Override
    public boolean gyakorlatMent(List<IGyakorlat> gyks, String path) {
        try(BufferedWriter br = new BufferedWriter(new FileWriter(path))) {
            for (IGyakorlat gyk : gyks) {
                br.append(gyk.makeCsvForm());
                br.append("\n");
            }
            
            return true;
        } catch (IOException ex) {
            Logger.getLogger(CsvGyTransform.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
}
