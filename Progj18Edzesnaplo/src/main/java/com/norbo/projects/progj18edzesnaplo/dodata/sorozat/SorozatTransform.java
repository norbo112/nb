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
public interface SorozatTransform<T> {
    public boolean ment(List<Sorozat> sorozats, T path);
}
