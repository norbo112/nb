/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.norbo.projects.progj18edzesnaplo.dodata;

import com.norbo.projects.progj18edzesnaplo.data.Gyakorlat;
import com.norbo.projects.progj18edzesnaplo.data.IGyakorlat;
import com.norbo.projects.progj18edzesnaplo.data.Izomcsoport;
import com.norbo.projects.progj18edzesnaplo.example.MasikGyakImpl;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author igloi
 */
public class GyakorlatLista {
    public static List<IGyakorlat> getGyakorlatList() {
        List<IGyakorlat> result = new ArrayList<>();
        
        //csak tesz, két gyakorlatot kézzel adok hozzá
        //itt tölteném be mysqlből
        
        result.add(new Gyakorlat(1,"Fekvenyomás",
                Izomcsoport.MELL, 
                "Vizszintesen lefekszünk a padra...",
                "xsoUWuJglGc", 22));
        
        result.add(new Gyakorlat(2,"45°ba nyomás kétkezessel",
                Izomcsoport.MELL, 
                "45 fokos padon fekve...",
                "", 0));
        
        result.add(new Gyakorlat(3,"30°ba nyomás kétkezessel",
                Izomcsoport.MELL, 
                "30 fokba lefekszünk a padra...",
                "",0));
        
        result.add(new MasikGyakImpl(5, "Kétkezes evezés", Izomcsoport.HAT, "Pucsít", "", 0));
        
        return result;
    }
}
