/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.norbo.projects.csaladi.kassza.adatok;

import java.awt.Component;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author igloi
 */
public class SajatCheckBox extends JCheckBox implements TableCellRenderer {

    public SajatCheckBox() {
    }

    public SajatCheckBox(String text, boolean selected) {
        super(text, selected);
    }
    

    @Override
    public Component getTableCellRendererComponent(JTable arg0, Object arg1, boolean arg2, boolean arg3, int arg4, int arg5) {
        setHorizontalAlignment(SwingConstants.CENTER);
        
        if(((Boolean)arg1) == true) {
            setSelected(true);
        } else {
            setSelected(false);
        }
        
        if(arg2) {
            setBackground(UIManager.getColor("Table.selectionBackground"));
        } else {
            setBackground(UIManager.getColor("Table.background"));
        }
        
        return this;
    }
    
}
