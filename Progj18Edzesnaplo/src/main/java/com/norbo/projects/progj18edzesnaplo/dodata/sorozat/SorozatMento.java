/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.norbo.projects.progj18edzesnaplo.dodata.sorozat;

import com.norbo.projects.progj18edzesnaplo.data.naplo.Sorozat;
import java.util.List;

/**
 *
 * @author igloi
 */
public class SorozatMento<T> {
    private SorozatTransform<T> sorozatTransform;
    private List<Sorozat> sorozats;

    public SorozatMento(SorozatTransform<T> sorozatTransform, List<Sorozat> sorozats) {
        this.sorozatTransform = sorozatTransform;
        this.sorozats = sorozats;
    }
    
    public boolean ment(T path) {
        return sorozatTransform.ment(sorozats, path);
    }
    
}
