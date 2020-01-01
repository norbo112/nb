/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.norbo.projects.csaladi.kassza.adatok;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JCheckBox;
import javax.swing.table.AbstractTableModel;

/**
 * Befizetett számlák tábla modellje
 * @author igloi
 */
public class SzamlakTableModel extends AbstractTableModel {
    private List<BeSzamla> szamlak = new ArrayList<>();
    private double szamlakOsszege = 0.0;
    private final String[] COLUMN = new String[] {
            "Név","Befizetés ideje","Befizetett összeg","Állapot"
    };
    
    public void addBeSzamla(BeSzamla beSzamla) {
        szamlak.add(beSzamla);
        fireTableDataChanged();
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch(columnIndex) {
            case 0: return String.class;
            case 1: return String.class;
            case 2: return String.class;
            case 3: return Boolean.class;
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return COLUMN[column];
    }
     
    @Override
    public int getRowCount() {
        return szamlak.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMN.length;
    }

    @Override
    public Object getValueAt(int arg0, int arg1) {
        BeSzamla sz = szamlak.get(arg0);
        switch (arg1) {
            case 0:  {
                if(sz!=null && sz.getSzamla() != null)
                    return sz.getSzamla().getMegjelenoNev();
                
                return "Ismeretlen";
            }
            case 1: {
                LocalDateTime loc = sz.getBefizetesiido();
                return loc.toString().replace('T', ' ').substring(0, loc.toString().lastIndexOf('.'));
            }
            case 2: return String.format("%,.2f (Ft)", sz.getOsszeg());
            case 3: return sz.getBefizetve();
        }
        return null;
    }

    public List<BeSzamla> getSzamlak() {
        return szamlak;
    }
    
    public BeSzamla getSzamlaByName(String megjelenoNev) {
        for (BeSzamla be : szamlak) {
            if(be.getSzamla().getMegjelenoNev().equals(megjelenoNev)) {
                return be;
            }
        }
        
        return null;
    }

    public void setSzamlak(List<BeSzamla> szamlak) {
        this.szamlak = szamlak;
        fireTableDataChanged();
    }
    
    public void removeItem(int row) {
        szamlak.remove(row);
        fireTableDataChanged();
    }
    
    private void szamlakOsszegeSzamol() {
        szamlakOsszege = 0;
        for (BeSzamla beSzamla : szamlak) {
            szamlakOsszege += beSzamla.getOsszeg();
        }
    }

    @Override
    public void fireTableDataChanged() {
        szamlakOsszegeSzamol();
        super.fireTableDataChanged();
    }

    public double getSzamlakOsszege() {
        return szamlakOsszege;
    }
}
