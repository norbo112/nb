/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.norbo.projects.progj18edzesnaplo.dodata;

import com.norbo.projects.progj18edzesnaplo.data.IGyakorlat;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
