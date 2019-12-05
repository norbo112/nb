/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.norbo.projects.csaladi.kassza.adatok.table;

import com.norbo.projects.csaladi.kassza.adatok.utils.GuiUtils;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author igloi
 */
public class SzinkodLabel extends JLabel implements TableCellRenderer {

    public SzinkodLabel() {
        setOpaque(true);
    }

    @Override
    public Component getTableCellRendererComponent(JTable arg0, Object arg1, boolean arg2, boolean arg3, int arg4, int arg5) {
        String szinkod = (String) arg1;
        setBackground(GuiUtils.parseColor(szinkod));
        return this;
    }
}
