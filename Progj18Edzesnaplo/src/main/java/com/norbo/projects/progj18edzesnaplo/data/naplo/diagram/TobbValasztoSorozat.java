/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.norbo.projects.progj18edzesnaplo.data.naplo.diagram;

import com.norbo.projects.progj18edzesnaplo.data.naplo.SorozatInterface;
import java.util.List;

/**
 *
 * @author igloi
 */
public class TobbValasztoSorozat {
    private List<SorozatInterface> sorozatok;
    private String name;

    public TobbValasztoSorozat(List<SorozatInterface> sorozatok, String name) {
        this.sorozatok = sorozatok;
        this.name = name;
    }

    public List<SorozatInterface> getSorozatok() {
        return sorozatok;
    }

    public String getName() {
        return name;
    }
}
