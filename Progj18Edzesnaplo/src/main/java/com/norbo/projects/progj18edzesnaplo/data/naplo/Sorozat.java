package com.norbo.projects.progj18edzesnaplo.data.naplo;

import com.norbo.projects.progj18edzesnaplo.data.IGyakorlat;
import java.time.LocalTime;
import java.util.List;

/**
 *
 * @author igloi
 */
public class Sorozat extends AbstractSorozat {

    public Sorozat(IGyakorlat gyakorlat) {
        super(gyakorlat);
    }

    public Sorozat(List<Integer> sulyList, List<Integer> ismList, IGyakorlat gyakorlat, List<LocalTime> ismIdoList) {
        super(sulyList, ismList, gyakorlat, ismIdoList);
    }
    
}
