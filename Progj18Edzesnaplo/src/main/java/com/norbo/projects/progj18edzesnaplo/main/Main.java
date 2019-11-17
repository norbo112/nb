package com.norbo.projects.progj18edzesnaplo.main;

import com.norbo.projects.progj18edzesnaplo.data.IGyakorlat;
import com.norbo.projects.progj18edzesnaplo.dodata.GyakorlatLista;
import com.norbo.projects.progj18edzesnaplo.gui.gyakorlatok.Gyakorlatok;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

/**
 *
 * @author igloi
 */
public class Main {
    private static final Comparator<IGyakorlat> COMP_IZOMCSOP = 
            (o1,o2)-> o1.getIzomcsoport().compareTo(o2.getIzomcsoport());
    
    public static void main(String[] args) {
        try {
            List<IGyakorlat> gyfromurl = GyakorlatLista.getGyakorlatList(GyakorlatLista.GYAKURL);
//            for(IGyakorlat g: gyfromurl) {
//                System.out.println(g);
//            }
            gyfromurl.sort(COMP_IZOMCSOP);
            new Gyakorlatok(gyfromurl).showFrame();
        } catch (IOException ex) {
            System.out.println("Hiba törént az adatok elérése közben: "+ex);
        }
        
    }
}
