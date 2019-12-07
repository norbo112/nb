package com.norbo.projects.csaladi.kassza.adatok.table;

import com.norbo.projects.csaladi.kassza.adatok.utils.GuiUtils;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 * Táblázatban megjelenített, string típusu (saját) színkod szerinti háttérel
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
