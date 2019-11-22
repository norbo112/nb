package com.norbo.projects.progj18edzesnaplo.data.naplo;

import com.norbo.projects.progj18edzesnaplo.data.naplo.Sorozat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class SorozatTableModel extends AbstractTableModel {
        private List<Sorozat> sorozatok;
        private final String[] colNames = {"Sorszám","Felvétel dátuma","Gyakorlat","Súly x Ismétlés","Időpont"};

        public SorozatTableModel() {
            sorozatok = new ArrayList<>();
        }

        public SorozatTableModel(List<Sorozat> sorozatok) {
            this.sorozatok = sorozatok;
        }
        
        @Override
        public int getRowCount() {
            return sorozatok.size();
        }

        @Override
        public int getColumnCount() {
            return 5;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            Sorozat sor = sorozatok.get(rowIndex);
            switch(columnIndex) {
                case 0 : return columnIndex+1;
                case 1 : sor.getGyakRogzitesIdopontja().toLocalDate();
                case 2 : sor.getGyakorlat().getMegnevezes();
                case 3 : {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < sor.getSulyList().size(); i++) {
                        sb.append(sor.getSulyList().get(i)).append("X").append(sor.getIsmList().get(i)).append("\n");
                    }
                    return sb.toString();
                }
                case 4 : {
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < sor.getIsmIdoList().size(); i++) {
                        sb.append(sor.getIsmIdoList().get(i).toString()).append("\n");
                    }
                    return sb.toString();
                }
            }
            return null;
        }
        
        public void add(Sorozat sor) {
            sorozatok.add(sor);
            fireTableRowsInserted(sorozatok.size() - 2, sorozatok.size() -2);
        }
        
        public void set(int idx, Sorozat sorozat) {
            sorozatok.set(idx, sorozat);
            fireTableRowsUpdated(idx, idx);
        }
    }
