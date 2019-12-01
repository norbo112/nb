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
public interface AdatFeldolgozas<T, E> {
    public boolean ment(T path, E obj);
    public E betolt(T path);
}
