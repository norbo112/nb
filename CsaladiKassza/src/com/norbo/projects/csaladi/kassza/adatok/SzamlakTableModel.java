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
 *
 * @author igloi
 */
public class SzamlakTableModel extends AbstractTableModel {
    private List<BeSzamla> szamlak = new ArrayList<>();
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
            case 0: return sz.getSzamla().getMegjelenoNev();
            case 1: {
                LocalDateTime loc = sz.getBefizetesiido();
                String date = loc.toLocalDate().toString();
                String time = loc.toLocalTime().toString();
                return date + " "+ time.substring(0, time.lastIndexOf('.'));
            }
            case 2: return String.format("%,.2f (Ft)", sz.getOsszeg());
            case 3: return sz.getBefizetve();
        }
        return null;
    }
    
}
