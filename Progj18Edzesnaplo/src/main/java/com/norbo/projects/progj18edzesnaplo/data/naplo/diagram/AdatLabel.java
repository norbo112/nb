package com.norbo.projects.progj18edzesnaplo.data.naplo.diagram;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.TableCellRenderer;

/**
 * int[] típusú cella adatainak megjeleníése úgy mintha egy vizszintes diagram lenne
 * a megfelelő adatokkal.
 * @author igloi
 */
public class AdatLabel extends JLabel implements TableCellRenderer {
    public enum Orient {
        HORIZONTAL, VERTICAL;
    }
    
    private Color hatter = Color.GREEN;
    private int szazalekErtek = 100;
    private int osszSuly;
    private Orient orientation = Orient.HORIZONTAL;

    public void setOsszSuly(int osszSuly) {
        this.osszSuly = osszSuly;
    }

    public void setSzazalekErtek(int szazalekErtek) {
        this.szazalekErtek = szazalekErtek;
        invalidate();
        repaint();
    }

    public void setHatter(Color hatter) {
        this.hatter = hatter;
        invalidate();
        repaint();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        g.setColor(hatter);
        if(orientation == Orient.HORIZONTAL) {
            g.fillRect(0, 0, getWidth() * szazalekErtek / osszSuly, getHeight());
        } else {
            g.fillRect(0, 0, getWidth(), getHeight() * szazalekErtek / osszSuly);
        }
    }

    /**
     * value egy kételemű tömb lesz, az első elem a kiválasztott naplók össz gyakorlat megmozgatott súéya
     * a második eleme pedig a egyes naplókban lévő gyakorlat össz megmozgatott súlya
     * @param table
     * @param value int[] típusú adat a táblázatból
     * @param isSelected
     * @param hasFocus
     * @param row
     * @param column
     * @return AdatLabel osztály mint komponens
     */
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        if(isSelected) {
            setBackground(UIManager.getColor("Table.selectionBackground"));
        } else {
            setBackground(UIManager.getColor("Table.background"));
        }
        
        setOsszSuly(((int[])value)[0]);
        setSzazalekErtek(((int[])value)[1]);
        return this;
    }
    
    
}
