package com.norbo.projects.progj18edzesnaplo.data.tapanyag;

import com.norbo.projects.progj18edzesnaplo.data.Elelmiszer;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Predicate;
import java.util.logging.Level;
import javassist.compiler.JvstCodeGen;

/**
 *
 * @author igloi
 */
public class TapanyagSzuro {
    private static final java.util.logging.Logger LOG = java.util.logging.Logger.getLogger(TapanyagSzuro.class.getName());
    
    public static List<Elelmiszer> getSzurtLista(List<Elelmiszer> lista, List<Predicate<Elelmiszer>> szuro) {
        Predicate<Elelmiszer> szuroPred = x -> true;
        for(Predicate<Elelmiszer> p: szuro) {
            szuroPred = szuroPred.and(p);
        }
        
        return szures(lista, szuroPred);
    }
    
    public static CompletableFuture<List<Elelmiszer>> getSzurtListaCF(List<Elelmiszer> lista, 
             List<Predicate<Elelmiszer>> szuro) {
        CompletableFuture<List<Elelmiszer>> cflist = new CompletableFuture<>();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    cflist.complete(getSzurtLista(lista, szuro));
                } catch (Exception e) {
                    LOG.log(Level.SEVERE, "CF method error", e);
                }
            }
            
        }).start();
        
        return cflist;
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
