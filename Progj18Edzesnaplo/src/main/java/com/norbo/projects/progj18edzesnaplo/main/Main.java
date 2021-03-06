package com.norbo.projects.progj18edzesnaplo.main;

import com.norbo.projects.progj18edzesnaplo.data.IGyakorlat;
import com.norbo.projects.progj18edzesnaplo.data.log.ENLogger;
import com.norbo.projects.progj18edzesnaplo.dodata.AbstractTransform;
import com.norbo.projects.progj18edzesnaplo.dodata.GyakorlatListaKeszito;
import com.norbo.projects.progj18edzesnaplo.gui.NapiTerv;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author igloi
 */
public class Main {
    private static final Comparator<IGyakorlat> COMP_IZOMCSOP = 
            (o1,o2)-> o1.getIzomcsoport().compareTo(o2.getIzomcsoport());
    
    public static void main(String[] args) {
        try {
            GyakorlatListaKeszito gyakorlatLista = new GyakorlatListaKeszito();
            List<IGyakorlat> gyfromurl = gyakorlatLista.getGyakorlatListJSON(AbstractTransform.GYAKURL);
            gyfromurl.sort(COMP_IZOMCSOP);
            List<String> izomcsoportok = gyakorlatLista.getIzomCsoport();

            NapiTerv napiTerv = new NapiTerv(gyfromurl, izomcsoportok);
            napiTerv.showFrame();
        } catch (IOException ex) {
            System.out.println("Hiba törént az adatok elérése közben: "+ex);
        }
        
        ENLogger.loginfo("Saját formázás létrehozása, tesztelése");
        ENLogger.loginfo("Működik csak még néhány kisebb módosítás");
    }
}
