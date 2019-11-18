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
 * @param <T>
 */
public class GyakorlatBetolto<T> {
    private final AbstractTrasform<T> transformer;

    public GyakorlatBetolto(AbstractTrasform<T> transformer) {
        this.transformer = transformer;
    }
    
    public List<IGyakorlat> betolt(T src) {
        return transformer.betolt(src);
    }
}
