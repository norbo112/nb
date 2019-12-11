package model;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import kereskedelem.aru.Cikk;

public interface ArukeresoModel {

    default <T> List<T> szures(List<T> lista, List<Predicate<T>> feltetelek) {
        List<T> szurtLista = new LinkedList<>();
        lista.forEach((elem) -> {
            Iterator<Predicate<T>> iterator = feltetelek.iterator();
            boolean ok = true;
            while (iterator.hasNext() && (ok = iterator.next().test(elem)));
            if (ok) {
                szurtLista.add(elem);
            }
        });
        return szurtLista;
    }

    /**
     * A szűrési feltételeket tartalmazó map.
     * HTTP kérésnél lehet pl. a kérés paramétereinek map-je
     *      request.getParameterMap
     * @param parameterek 
     * @return a paraméterek szerinti szűrés eredménye
     */
    List<Cikk> kereses(Map<String, String[]> parameterek);
    
    /**
     * A keresés során kiválasztható mennyiségi egységek.
     * @return mennyisdégi egységek tömbje 
     */
    String[] mennyisegiEgysegek();
}
