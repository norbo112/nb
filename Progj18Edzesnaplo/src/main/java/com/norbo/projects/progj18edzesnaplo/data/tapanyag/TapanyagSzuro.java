package com.norbo.projects.progj18edzesnaplo.data.tapanyag;

import com.norbo.projects.progj18edzesnaplo.data.Elelmiszer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

/**
 *
 * @author igloi
 */
public class TapanyagSzuro {
    public static List<Elelmiszer> getSzurtLista(List<Elelmiszer> lista, List<Predicate<Elelmiszer>> szuro) {
        Predicate<Elelmiszer> szuroPred = x -> true;
        for(Predicate<Elelmiszer> p: szuro) {
            szuroPred = szuroPred.and(p);
        }
        
        return szures(lista, szuroPred);
    }
    
    private static <T> List<T> szures(List<T> lista, Predicate<T> feltetel) {
        List<T> szurt = new ArrayList<>();
        for (T element : lista) {
            if (feltetel.test(element)) {
                szurt.add(element);
            }
        }
        return szurt;
    }
}
