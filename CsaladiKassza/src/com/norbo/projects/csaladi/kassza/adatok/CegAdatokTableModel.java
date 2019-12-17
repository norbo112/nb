package com.norbo.projects.csaladi.kassza.adatok;

import com.norbo.projects.csaladi.kassza.adatok.table.SzinkodLabel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * Számla cég adatok szerkesztésére, amit a részletek ablakban jelenítek meg
 * @author igloi
 */
public class CegAdatokTableModel extends AbstractTableModel {
    private List<Szamla> szamlak = new ArrayList<>();
    private final String[] COLUMN = new String[] {
            "Név","Számlaszám","Befizetési határidő","Várt összeg","Prioritás","Színkód"
    };

    public CegAdatokTableModel(List<Szamla> szamlak) {
        this.szamlak = szamlak;
    }
    
    public void addBeSzamla(Szamla Szamla) {
        szamlak.add(Szamla);
        fireTableDataChanged();
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch(columnIndex) {
            case 0: return String.class;
            case 1: return String.class;
            case 2: return String.class;
            case 3: return Integer.class;
            case 4: return String.class;
            case 5: return SzinkodLabel.class;
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
        Szamla sz = szamlak.get(arg0);
        switch (arg1) {
            case 0: return sz.getMegjelenoNev();
            case 1: return sz.getSzamlaSzam();
            case 2: return sz.getBefizetesHatarido();
            case 3: return String.format("%,.2f (Ft)", sz.getOsszeg());
            case 4: return Integer.valueOf(sz.getPrioritas().toString());
            case 5: return sz.getKijeloles();
        }
        return null;
    }

    public List<Szamla> getSzamlak() {
        return szamlak;
    }

    public void setSzamlak(List<Szamla> szamlak) {
        this.szamlak = szamlak;
        fireTableDataChanged();
    }
}
