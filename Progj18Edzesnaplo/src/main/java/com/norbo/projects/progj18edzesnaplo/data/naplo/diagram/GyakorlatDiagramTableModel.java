/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.norbo.projects.progj18edzesnaplo.data.naplo.diagram;

import com.norbo.projects.progj18edzesnaplo.data.naplo.SorozatInterface;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author igloi
 */
public class GyakorlatDiagramTableModel extends AbstractTableModel {
    private final String[] COLUMNNAME = new String[]{
      "Rögzítésí dátum","Megmozgatott súly (kg)","(%)"
    };
    private List<SorozatInterface> sorozatLista;

    public GyakorlatDiagramTableModel() {
        sorozatLista = new ArrayList<>();
    }

    public void setSorozatLista(List<SorozatInterface> sorozatLista) {
        this.sorozatLista = sorozatLista;
        if(sorozatLista.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nincs ilyen gyakorlat rögzítve","Info",
                    JOptionPane.ERROR_MESSAGE);
        }
        fireTableDataChanged();
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch(columnIndex) {
            case 0 : return String.class;
            case 1 : return Integer.class;
            case 2 : return int[].class;
        }
        return String.class;
    }

    @Override
    public int getRowCount() {
        return sorozatLista.size();
    }

    @Override
    public int getColumnCount() {
        return COLUMNNAME.length;
    }

    @Override
    public String getColumnName(int column) {
        return COLUMNNAME[column];
    }
    
    

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        SorozatInterface sorozatInterface = sorozatLista.get(rowIndex);
        switch(columnIndex) {
            case 0 : return sorozatInterface.getRogzitesIdopont().toLocalDate()+" "+
                    sorozatInterface.getRogzitesIdopont().toLocalTime().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
            case 1 : return sorozatInterface.getOsszSuly();
            case 2 : {
                int[] ertek = new int[2];
                ertek[0] = getAllOsszSuly();
                ertek[1] = sorozatInterface.getOsszSuly();
                return ertek;
            }
        }
        return null;
    }
    
    private int getAllOsszSuly() {
        int res = 0;
        for (SorozatInterface sor: sorozatLista) {
            res += sor.getOsszSuly();
        }
        return res;
    }
    
}
