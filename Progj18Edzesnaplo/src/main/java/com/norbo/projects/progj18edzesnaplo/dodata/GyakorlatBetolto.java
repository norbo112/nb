/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.norbo.projects.progj18edzesnaplo.dodata;

import com.norbo.projects.progj18edzesnaplo.data.IGyakorlat;
import java.util.List;

/**
 *
 * @author igloi
 * @param <T> Bármely objektum amit átszeretnénk konvertálni gyakorlat listává
 */
public class GyakorlatBetolto {
    private final AbstractTransform transformer;

    public GyakorlatBetolto(AbstractTransform transformer) {
        this.transformer = transformer;
    }
    
    public List<IGyakorlat> betolt(String path) {
        return transformer.betolt(path);
    }
    
    public boolean ment(List<IGyakorlat> gyks, String path) {
        return transformer.gyakorlatMent(gyks, path);
    }
}
