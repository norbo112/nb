package com.norbo.projects.progj18edzesnaplo.data.naplo;

import com.norbo.projects.progj18edzesnaplo.data.IGyakorlat;
import com.norbo.projects.progj18edzesnaplo.data.naplo.Sorozat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class SorozatTableModel extends AbstractTableModel {

    private List<Sorozat> sorozatok;
    private final String[] colNames = {
        "Sorszám", "Felvétel dátuma","Izomcsoport", "Gyakorlat", "Súly x Ismétlés", "Időpont"};

    public SorozatTableModel() {
        sorozatok = new ArrayList<>();
    }

    public SorozatTableModel(List<Sorozat> sorozatok) {
        this.sorozatok = sorozatok;
    }

    public boolean addSorozatAdat(IGyakorlat gyakorlat, int suly, int ism) {
        for (Sorozat sorozat : sorozatok) {
            if (sorozat.getGyakorlat().getMegnevezes().equals(gyakorlat.getMegnevezes())) {
                sorozat.addSuly(suly);
                sorozat.addIsm(ism);
                sorozat.addIsmIdo(LocalTime.now());
                fireTableDataChanged();
                return true;
            }
        }

        return false;
    }
    
    public List<Sorozat> getSorozat() {
        return sorozatok;
    }
    
    public void removeSorozatRow(int index) {
        sorozatok.remove(index);
        fireTableDataChanged();
    }
    
    public void removeAllSorozat() {
        sorozatok.clear();
        fireTableDataChanged();
    }

    @Override
    public String getColumnName(int column) {
        return colNames[column];
    }

    @Override
    public int getRowCount() {
        return sorozatok.size();
    }
    
    public int getSorCount(int index) {
        if(!sorozatok.isEmpty()) {
            return sorozatok.get(index).getSulyList().size();
        }
        return 0;
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }
    
    

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Sorozat sor = sorozatok.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return rowIndex + 1;
            case 1:
                return sor.getGyakRogzitesIdopontja().toLocalDate();
            case 2: return sor.getGyakorlat().getIzomcsoport().toString();
            case 3:
                return sor.getGyakorlat().getMegnevezes();
            case 4: {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < sor.getSulyList().size(); i++) {
                    sb.append(sor.getSulyList().get(i)).append("X").append(sor.getIsmList().get(i)).append("\n");
                }
                return sb.toString();
            }
            case 5: {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < sor.getIsmIdoList().size(); i++) {
                    String ismidopont = sor.getIsmIdoList().get(i).toString();
                    sb.append(ismidopont.substring(0, ismidopont.lastIndexOf('.'))).append("\n");
                }
                return sb.toString();
            }
        }
        return null;
    }
    
    public int getOsszSuly() {
        int ossz = 0;
        for (Sorozat sorozat : sorozatok) {
            ossz += sorozat.getOsszSuly();
        }
        return ossz;
    }

    public void add(Sorozat sor) {
        sorozatok.add(sor);
        fireTableRowsInserted(sorozatok.size() - 2, sorozatok.size() - 2);
    }

    public void set(int idx, Sorozat sorozat) {
        sorozatok.set(idx, sorozat);
        fireTableRowsUpdated(idx, idx);
    }

    public boolean contains(Sorozat s) {
        return sorozatok.contains(s);
    }
}
