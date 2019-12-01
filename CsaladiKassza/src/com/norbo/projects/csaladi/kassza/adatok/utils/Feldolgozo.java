/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.norbo.projects.csaladi.kassza.adatok.utils;

/**
 *
 * @author igloi
 */
public class Feldolgozo<T, E> {
    private AdatFeldolgozas<T, E> adatFeldolgozas;

    public Feldolgozo(AdatFeldolgozas<T, E> adatFeldolgozas) {
        this.adatFeldolgozas = adatFeldolgozas;
    }
    
    public boolean ment(T path, E data) {
        return adatFeldolgozas.ment(path, data);
    }
    
    public E betolt(T path) {
        return adatFeldolgozas.betolt(path);
    }
}
