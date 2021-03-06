/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.norbo.projects.csaladi.kassza.gui.naptar;

import com.norbo.projects.csaladi.kassza.adatok.BeSzamla;
import com.norbo.projects.csaladi.kassza.adatok.SzamlakTableModel;
import com.norbo.projects.csaladi.kassza.adatok.utils.GuiUtils;
import com.norbo.projects.csaladi.kassza.adatok.utils.szamlalista.SzamlaLista;
import com.norbo.projects.csaladi.kassza.nyomtatas.BeSzamlaNyomat;
import java.awt.Color;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JTable;

/**
 *
 * @author igloi
 */
public class SzamlaListaDialog extends javax.swing.JDialog {
    private SzamlaLista szamlaLista;
    private SzamlakTableModel tableModel;
    /**
     * Naptár gombra kattintáskor megjelenő ablak (ha létezik mentett számla az adott napon)
     * @param parent ahonnan megnyitották
     * @param modal modale
     * @param szamlaLista adott napon rögzített számlalista
     */
    public SzamlaListaDialog(JFrame parent, boolean modal, SzamlaLista szamlaLista) {
        super(parent, modal);
        this.szamlaLista = szamlaLista;
        initComponents();
        initMe();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        tableScollPane = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblOsszeg = new javax.swing.JLabel();
        btnNyomtat = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lblMentesiDatum = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Befizetés adatok");

        jPanel1.setBackground(new java.awt.Color(0, 102, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));

        jPanel2.setBackground(new java.awt.Color(0, 102, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 255)));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Elmentett befizetett számla adatai");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(0, 102, 153));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 204, 255)));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tableScollPane.setViewportView(table);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tableScollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 471, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tableScollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 228, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(0, 102, 153));
        jPanel4.setLayout(new java.awt.BorderLayout());

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Befizetések összege:");
        jPanel4.add(jLabel2, java.awt.BorderLayout.WEST);

        lblOsszeg.setForeground(new java.awt.Color(255, 255, 255));
        lblOsszeg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblOsszeg.setText("jLabel3");
        jPanel4.add(lblOsszeg, java.awt.BorderLayout.CENTER);

        btnNyomtat.setText("Nyomtatás");
        btnNyomtat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNyomtatActionPerformed(evt);
            }
        });
        jPanel4.add(btnNyomtat, java.awt.BorderLayout.LINE_END);

        jPanel5.setBackground(new java.awt.Color(0, 102, 153));
        jPanel5.setLayout(new java.awt.BorderLayout());

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Mentési dátum:");
        jPanel5.add(jLabel3, java.awt.BorderLayout.WEST);

        lblMentesiDatum.setForeground(new java.awt.Color(255, 255, 255));
        lblMentesiDatum.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMentesiDatum.setText("jLabel3");
        jPanel5.add(lblMentesiDatum, java.awt.BorderLayout.CENTER);

        jButton1.setText("OK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton1, java.awt.BorderLayout.LINE_END);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnNyomtatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNyomtatActionPerformed
        List<BeSzamla> szamlak = szamlaLista.getBeSzamlas();
        if(!szamlak.isEmpty()) {
            PrinterJob job = PrinterJob.getPrinterJob();
            job.setPrintable(new BeSzamlaNyomat(szamlak));
            boolean okey = job.printDialog();
            if(okey) {
                try {
                    job.print();
                } catch (PrinterException e) {
                    System.out.println("Nem tudtam nyomtatni! "+e);
                }
            }
        }
    }//GEN-LAST:event_btnNyomtatActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNyomtat;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel lblMentesiDatum;
    private javax.swing.JLabel lblOsszeg;
    private javax.swing.JTable table;
    private javax.swing.JScrollPane tableScollPane;
    // End of variables declaration//GEN-END:variables

    private void initMe() {
        tableModel = new SzamlakTableModel();
        table.setModel(tableModel);
        tableModel.setSzamlak(szamlaLista.getBeSzamlas());
        GuiUtils.coloriseTablaHeader(new JTable[]{table}, GuiUtils.THBGCOLOR, GuiUtils.THFGCOLOR);
        GuiUtils.coloriseTable(tableScollPane, GuiUtils.DEFTABLEBGCOLOR, Color.WHITE);
        
        double osszeg = szamlaLista.getBeSzamlas().stream().mapToDouble(o->o.getOsszeg()).sum();
        lblOsszeg.setText(String.format("%,.2f (Ft)", osszeg));
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("YYYY-M-dd H:m:s");
        lblMentesiDatum.setText(szamlaLista.getLastModified().atZone(ZoneId.of("GMT")).format(formatter));
    }
}
