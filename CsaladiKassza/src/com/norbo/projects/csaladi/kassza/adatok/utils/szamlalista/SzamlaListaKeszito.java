/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.norbo.projects.csaladi.kassza.adatok.utils.szamlalista;

import com.norbo.projects.csaladi.kassza.adatok.BeSzamla;
import com.norbo.projects.csaladi.kassza.adatok.utils.AdatFeldolgozas;
import com.norbo.projects.csaladi.kassza.adatok.utils.Feldolgozo;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author igloi
 * @param <T> File vagy ehhez hasonló objektum
 * @param <E> kívánt eredmény
 */
public class SzamlaListaKeszito<T, E> {
    private final String konyvtar;
    private final AdatFeldolgozas<T, E> feldolgozo;

    public SzamlaListaKeszito(String konyvtar, AdatFeldolgozas<T, E> feldolgozo) {
        this.konyvtar = konyvtar;
        this.feldolgozo = feldolgozo;
    }

    public String getKonyvtar() {
        return konyvtar;
    }

    public AdatFeldolgozas<T,E> getFeldolgozo() {
        return feldolgozo;
    }
    
    public List<SzamlaLista> getSzamlaListas() {
        DirectoryStream.Filter<Path> filter = (Path entry) -> entry.toString().endsWith(".csk");
                
        List<SzamlaLista> szamlaListas = new ArrayList<>();
        
        Path path = Paths.get(konyvtar);
        System.out.println("Könyvtár: "+konyvtar);
        try(DirectoryStream<Path> stream = Files.newDirectoryStream(path, filter)) {
            Iterator<Path> iterator = stream.iterator();
            while(iterator.hasNext()) {
                Path f = iterator.next();
                List<BeSzamla> beszamla = (List<BeSzamla>) feldolgozo.betolt((T) f.toFile());
                BasicFileAttributes attributes = Files.readAttributes(f, BasicFileAttributes.class);
                szamlaListas.add(new SzamlaLista(f.toString(), 
                        attributes.lastModifiedTime().toInstant(),
                        beszamla));
            }
        } catch (IOException ex) {
            Logger.getLogger(SzamlaListaKeszito.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return szamlaListas;
    }
}
