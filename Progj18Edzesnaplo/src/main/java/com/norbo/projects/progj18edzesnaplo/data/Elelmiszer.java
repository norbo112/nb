package com.norbo.projects.progj18edzesnaplo.data;

/**
 * Élelmiszert reprezentáló osztály
 * @author igloi
 */
public class Elelmiszer {
    private String nev;
    private String fajta;
    private int kj;
    private int kcal;
    private double feherje;
    private double zsir;
    private double szenhidrat;
    private double rost;

    public Elelmiszer(String nev, String fajta, int kj, int kcal, double feherje, double zsir, double szenhidrat, double rost) {
        this.nev = nev;
        this.fajta = fajta;
        this.kj = kj;
        this.kcal = kcal;
        this.feherje = feherje;
        this.zsir = zsir;
        this.szenhidrat = szenhidrat;
        this.rost = rost;
    }

    public String getNev() {
        return nev;
    }

    public String getFajta() {
        return fajta;
    }

    public int getKj() {
        return kj;
    }

    public int getKcal() {
        return kcal;
    }

    public double getFeherje() {
        return feherje;
    }

    public double getZsir() {
        return zsir;
    }

    public double getSzenhidrat() {
        return szenhidrat;
    }

    public double getRost() {
        return rost;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public void setFajta(String fajta) {
        this.fajta = fajta;
    }

    public void setKj(int kj) {
        this.kj = kj;
    }

    public void setKcal(int kcal) {
        this.kcal = kcal;
    }

    public void setFeherje(double feherje) {
        this.feherje = feherje;
    }

    public void setZsir(double zsir) {
        this.zsir = zsir;
    }

    public void setSzenhidrat(double szenhidrat) {
        this.szenhidrat = szenhidrat;
    }

    public void setRost(double rost) {
        this.rost = rost;
    }
    
}
