package com.norbo.projects.progj18edzesnaplo.main;

import com.norbo.projects.progj18edzesnaplo.data.IGyakorlat;
import com.norbo.projects.progj18edzesnaplo.dodata.GyakorlatListaKeszito;
import com.norbo.projects.progj18edzesnaplo.gui.gyakorlatok.Gyakorlatok;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

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
            List<IGyakorlat> gyfromurl = gyakorlatLista.getGyakorlatListWeb(GyakorlatListaKeszito.GYAKURL);
            gyfromurl.sort(COMP_IZOMCSOP);
            List<String> izomcsoportok = gyakorlatLista.getIzomCsoport();
            
            List<IGyakorlat> csvgyfromurl = gyakorlatLista.getGyakorlatCSV(GyakorlatListaKeszito.CSVFILE);
            csvgyfromurl.sort(COMP_IZOMCSOP);
            List<String> csvizomcsoportok = gyakorlatLista.getIzomCsoport();
            
            List<IGyakorlat> excelgyfromurl = gyakorlatLista.getGyakorlatExcel(GyakorlatListaKeszito.EXCELFILE);
            csvgyfromurl.sort(COMP_IZOMCSOP);
            List<String> excelizomcsoportok = gyakorlatLista.getIzomCsoport();
            
            new Gyakorlatok("JSON-ból felépített gyakorlat", gyfromurl, izomcsoportok).showFrame();
            new Gyakorlatok("CSV fájlból felépített gyakorlat", csvgyfromurl, csvizomcsoportok).showFrame();
            new Gyakorlatok("Excel fájlból felépített gyakorlat", excelgyfromurl, excelizomcsoportok).showFrame();
            
        } catch (IOException ex) {
            System.out.println("Hiba törént az adatok elérése közben: "+ex);
        } catch (InvalidFormatException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
