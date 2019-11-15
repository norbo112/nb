package com.norbo.projects.progj18edzesnaplo.main;

import com.norbo.projects.progj18edzesnaplo.data.IGyakorlat;
import com.norbo.projects.progj18edzesnaplo.dodata.GyakorlatLista;
import java.util.List;

/**
 *
 * @author igloi
 */
public class Main {
    public static void main(String[] args) {
        List<IGyakorlat> gy = GyakorlatLista.getGyakorlatList();
        
        for(IGyakorlat igy: gy) {
            System.out.println(igy);
        }
    }
}
