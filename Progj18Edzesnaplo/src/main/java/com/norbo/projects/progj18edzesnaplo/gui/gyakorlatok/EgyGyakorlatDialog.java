/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.norbo.projects.progj18edzesnaplo.gui.gyakorlatok;

import com.norbo.projects.progj18edzesnaplo.data.IGyakorlat;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 *
 * @author igloi
 */
public class EgyGyakorlatDialog extends JDialog {
    private IGyakorlat egyGyak;

    public EgyGyakorlatDialog(IGyakorlat egyGyak, JFrame owner) {
        super(owner, true);
        this.egyGyak = egyGyak;
        setIconImage(new ImageIcon(getClass().getClassLoader().getResource("enlogo.png")).getImage());
        initComponent();
    }
    
    private void initComponent() {
        setTitle("Gyakorlat információ");
        setLayout(new BorderLayout(5,5));
        add(new EgyGyakDialogPanel(this, egyGyak));
        setMinimumSize(new Dimension(850, 500));
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
