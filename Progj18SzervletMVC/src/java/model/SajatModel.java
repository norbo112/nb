package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import kereskedelem.aru.Cikk;

/**
 *
 * @author igloi
 */
public class SajatModel implements ArukeresoModel {
    private List<Cikk> cikkek;
    private String[] mennyisegiEgysegek;
    
    public SajatModel() {
        cikkek = kereskedelem.Bolt.createCikkek();
        mennyisegiEgysegek = adatok.CikkAdatok.ME;
    }
    

    @Override
    public List<Cikk> kereses(Map<String, String[]> parameterek) {
        List<Predicate<Cikk>> szuro = new ArrayList<>();
        String[] nevtomb = parameterek.get("megnevezes");
        
        final String megnevezes = nevtomb != null ? nevtomb[0] : null;
        
        String[] megysegek = parameterek.get("megyseg");
        final Integer minAr = parameterek.get("minAr") != null ? 
                Integer.parseInt(parameterek.get("minAr")[0]) : null;
        final Integer maxAr = parameterek.get("maxAr") != null ? 
                Integer.parseInt(parameterek.get("maxAr")[0]) : null;
        
        if(megnevezes != null && megnevezes.length() > 0) {
            szuro.add((o) -> o.getMegnevezes().toUpperCase().contains(megnevezes.toUpperCase()));
        }
        
        if(megysegek != null) {
            Predicate<Cikk> pred = x->false;
            for(String m: megysegek) {
                pred = pred.or((o)-> o.getMennyisegiEgyseg().equals(m));
            }
            szuro.add(pred);
        }
        
        if(minAr != null && minAr != 0) {
            szuro.add((o) -> o.getEladasiAr() > minAr);
        }
        
        if(maxAr != null && maxAr != 0) {
            szuro.add((o) -> o.getEladasiAr() < maxAr);
        }
        
        return szures(cikkek, szuro);
    }

    @Override
    public String[] mennyisegiEgysegek() {
        return mennyisegiEgysegek;
    }
    
}
