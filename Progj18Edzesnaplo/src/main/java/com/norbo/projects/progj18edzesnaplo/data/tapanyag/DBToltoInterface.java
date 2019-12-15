package com.norbo.projects.progj18edzesnaplo.data.tapanyag;

import com.norbo.projects.progj18edzesnaplo.data.Elelmiszer;
import java.util.List;
import java.util.Map;

/**
 *
 * @author igloi
 */
public interface DBToltoInterface {
    /**
     * Betölti a paraméterlistában megadott dburl, tabla, user, pass - adatokat
     * @param parameters
     * @return élelmiszer lista
     */
    public List<Elelmiszer> getElelmiszerList(Map<String, String> parameters);
    
    /**
     * Tápanyag fajtájának listáját készíti el
     * @param params
     * @return 
     */
    public List<String> getTapanyagFajta(Map<String, String> params);
}
