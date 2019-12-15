package com.norbo.projects.progj18edzesnaplo.data;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author igloi
 */
public class ElelmiszerTableModel extends AbstractTableModel {
    private List<Elelmiszer> tapok;
    private final String[] COLNAMES = new String[] {
        "Név", "Fajta", "KJ", "Kcal", "Fehérje",
        "Szénhidrát", "Zsír", "Rost"
    };

    public ElelmiszerTableModel(List<Elelmiszer> tapok) {
        this.tapok = tapok;
    }

    @Override
    public String getColumnName(int column) {
        return COLNAMES[column];
    }
    
    @Override
    public int getRowCount() {
        return tapok.size();
    }

    @Override
    public int getColumnCount() {
        return COLNAMES.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Elelmiszer el = tapok.get(rowIndex);
        switch(columnIndex) {
            case 0: return el.getNev();
            case 1: return el.getFajta();
            case 2: return el.getKj();
            case 3: return el.getKcal();
            case 4: return el.getFeherje();
            case 5: return el.getSzenhidrat();
            case 6: return el.getZsir();
            case 7: return el.getRost();
        }
        return null;
    }

    public void setTapok(List<Elelmiszer> tapok) {
        this.tapok = tapok;
        fireTableDataChanged();
    }
}
