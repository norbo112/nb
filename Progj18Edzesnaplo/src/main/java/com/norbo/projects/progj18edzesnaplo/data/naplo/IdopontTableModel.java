/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.norbo.projects.progj18edzesnaplo.data.naplo;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author igloi
 */
public class IdopontTableModel extends AbstractTableModel {
    private List<SorozatInterface> sorozatok;
    private final String[] colNames = {
        "Sorszám", "Gyakorlat", "Időpont"};

    public IdopontTableModel() {
        sorozatok = new ArrayList<>();
    }
    
    public IdopontTableModel(List<SorozatInterface> sorozatok) {
        this.sorozatok = sorozatok;
    }

    public void setSorozatok(List<SorozatInterface> sorozatok) {
        this.sorozatok = sorozatok;
        fireTableDataChanged();
    }
    
    

    @Override
    public int getRowCount() {
        return sorozatok.size();
    }

    @Override
    public int getColumnCount() {
        return colNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return colNames[column];
    }
    
    

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        SorozatInterface s = sorozatok.get(rowIndex);
        switch(columnIndex) {
            case 0: return rowIndex+1;
            case 1: return s.getGyakorlat().getMegnevezes();
            case 2: 
                String time = s.getIsmRogzitesIdopontja().get(s.getIsmRogzitesIdopontja().size()-1).toString();
                int last = time.lastIndexOf('.');
                return last != -1 ? time.substring(0, last) : time;
            default: return "";
        }
    }

    
}
