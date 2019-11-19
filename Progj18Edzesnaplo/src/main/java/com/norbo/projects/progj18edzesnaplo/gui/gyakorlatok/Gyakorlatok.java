/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.norbo.projects.progj18edzesnaplo.gui.gyakorlatok;

import com.norbo.projects.progj18edzesnaplo.data.IGyakorlat;
import com.norbo.projects.progj18edzesnaplo.data.Izomcsoport;
import com.norbo.projects.progj18edzesnaplo.dodata.CsvGyTransform;
import com.norbo.projects.progj18edzesnaplo.dodata.ExcelGyTransform;
import com.norbo.projects.progj18edzesnaplo.dodata.GyakorlatBetolto;
import com.norbo.projects.progj18edzesnaplo.dodata.GyakorlatListaKeszito;
import com.norbo.projects.progj18edzesnaplo.dodata.JSONGyTransform;
import com.norbo.projects.progj18edzesnaplo.gui.gyakorlatok.szuro.GyakorlatSzuro;
import java.io.File;
import java.util.Collections;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author igloi
 */
public class Gyakorlatok extends javax.swing.JFrame {
    private List<IGyakorlat> gyakorlats;
    private List<IGyakorlat> szurtlista; //ha esetleg csak ezt mentené az ember....
    private List<String> izomcsoportok;
    private DefaultTableModel sajatTableModel;
    
    private GyakorlatSzuro gyakorlatSzuro;
    
    private final String VALASSZ = "-- válassz --";

    public Gyakorlatok(List<IGyakorlat> gyaksik, List<String> izomcsoportok) {
        this.gyakorlats = gyaksik;
        this.izomcsoportok = izomcsoportok;
        initComponents();
        settings();
    }
    
    private void settings() {
        gyakorlatSzuro = new GyakorlatSzuro();
        final String[] oszlopNevek = new String[] {
            "ID","Izomcsoport","Megnevezés","Leírás","VideoLink","VideoStartPoz"
        };
        
        sajatTableModel = new DefaultTableModel(oszlopNevek, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                switch(columnIndex) {
                    case 1: return Integer.class;
                    case 2: return Izomcsoport.class;
                    case 3: return String.class;
                    case 4: return String.class;
                    case 5: return String.class;
                    case 6: return Integer.class;
                }
                
                return String.class;
            }
        };

        gyakorlatTabla.setModel(sajatTableModel);
        
        loadGyaksik(gyakorlats);
        loadIzomcsoportok(izomcsoportok);
    }
    
    private void loadIzomcsoportok(List<String> izomcsops) {
        cbIzomcsop.removeAllItems();
        cbIzomcsop.addItem(VALASSZ);
        for (String csoport : izomcsops) {
            cbIzomcsop.addItem(csoport);
        }
    }
    
    private void loadGyaksik(List<IGyakorlat> gyaksik) {
        while(sajatTableModel.getRowCount()>0) {
                sajatTableModel.removeRow(0);
        }
        
        gyaksik.forEach((iGyakorlat) -> {
            sajatTableModel.addRow(new Object[]{
                iGyakorlat.getId(),iGyakorlat.getIzomcsoport(),iGyakorlat.getMegnevezes(),
                iGyakorlat.getLeiras(),iGyakorlat.getVideolink(), iGyakorlat.getVideostartpoz()
            });
        });
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
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cbIzomcsop = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        gyakorlatTabla = new javax.swing.JTable();
        lbCimsor = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        btnJson = new javax.swing.JButton();
        btnCsv = new javax.swing.JButton();
        btnExcel = new javax.swing.JButton();
        cbSzurte = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gyakorlatok");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Gyakorlat Szűrő"));

        jLabel1.setText("Izomcsoport");

        cbIzomcsop.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- válassz --" }));
        cbIzomcsop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbIzomcsopActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(cbIzomcsop, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbIzomcsop, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(69, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Gyakorlatok"));

        gyakorlatTabla.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(gyakorlatTabla);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1))
        );

        lbCimsor.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lbCimsor.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCimsor.setText("Gyakorlatok");

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Opciók"));

        jButton1.setText("Fájl betöltése");
        jButton1.setEnabled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Export"));

        btnJson.setIcon(new javax.swing.ImageIcon(getClass().getResource("/json.png"))); // NOI18N
        btnJson.setText("JSON");
        btnJson.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJsonActionPerformed(evt);
            }
        });

        btnCsv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/csv.png"))); // NOI18N
        btnCsv.setText("CSV");
        btnCsv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCsvActionPerformed(evt);
            }
        });

        btnExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/excel.png"))); // NOI18N
        btnExcel.setText("Excel");
        btnExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcelActionPerformed(evt);
            }
        });

        cbSzurte.setText("Szűrt lista mentése?");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnExcel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCsv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnJson, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(cbSzurte)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbSzurte)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnJson)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCsv)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnExcel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(218, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbCimsor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbCimsor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbIzomcsopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbIzomcsopActionPerformed

        if(cbIzomcsop.getSelectedIndex() > 0) {
            while(sajatTableModel.getRowCount()>0) {
                sajatTableModel.removeRow(0);
            }
            Izomcsoport izomcsoportNev = Izomcsoport.getIzomCsoport(cbIzomcsop.getSelectedItem().toString());
            gyakorlatSzuro.setIzomcsoport(izomcsoportNev);
            List<IGyakorlat> pszurtLista = gyakorlatSzuro.pszures(gyakorlats);
            pszurtLista.forEach((iGyakorlat) -> {
                sajatTableModel.addRow(new Object[]{
                    iGyakorlat.getId(), iGyakorlat.getIzomcsoport(), iGyakorlat.getMegnevezes(),
                    iGyakorlat.getLeiras(), iGyakorlat.getVideolink(), iGyakorlat.getVideostartpoz()
                });
            });
            
            szurtlista = pszurtLista;
            //ha véletlen a kiválasztott gyakorlatokat akarja az ember kimenteni
            cbSzurte.setSelected(true);
        } else {
            loadGyaksik(gyakorlats);
            cbSzurte.setSelected(false);
        }
    }//GEN-LAST:event_cbIzomcsopActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        List<IGyakorlat> gyaklista = null;
        JFileChooser jFileChooser = new JFileChooser();
        int select = jFileChooser.showOpenDialog(jPanel1);
        if (select == JFileChooser.APPROVE_OPTION) {
            File f = jFileChooser.getSelectedFile();
            String path = f.getAbsolutePath();
            System.out.println(path);
            if (path.endsWith(".json")) {
                GyakorlatBetolto betolto = new GyakorlatBetolto(new JSONGyTransform());
                gyaklista = betolto.betolt(path);
            } else if (path.endsWith(".xlsx")) {
                GyakorlatBetolto betolto = new GyakorlatBetolto(new ExcelGyTransform());
                gyaklista = betolto.betolt(path);
            } else if (path.endsWith(".csv")) {
                GyakorlatBetolto betolto = new GyakorlatBetolto(new CsvGyTransform());
                gyaklista = betolto.betolt(path);
            }
            
            GyakorlatListaKeszito gyk = new GyakorlatListaKeszito();
            gyk.setGyakorlatok(gyaklista);
            gyakorlats = gyaklista;
            Collections.sort(gyakorlats, (IGyakorlat o1, IGyakorlat o2) -> o1.getIzomcsoport().toString().compareTo(
                    o2.getIzomcsoport().toString()));
            loadGyaksik(gyaklista);
            loadIzomcsoportok(gyk.getIzomCsoport());
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcelActionPerformed

        String filename = JOptionPane.showInputDialog("Kérem a fájl nevét\ndokumentumokba való mentéshez");

        if (filename != null) {
            GyakorlatBetolto bt = new GyakorlatBetolto(new ExcelGyTransform());
            if (bt.ment(cbSzurte.isSelected() ? szurtlista : gyakorlats, System.getProperty("user.home")
                + System.getProperty("file.separator") + "Dokumentumok"
                + System.getProperty("file.separator") + filename + ".xlsx")) {
            JOptionPane.showMessageDialog(rootPane, "Sikeres fájl export");
            } else {
                JOptionPane.showMessageDialog(rootPane, "Hiba történt a fájl mentése közben");
            }
        }
    }//GEN-LAST:event_btnExcelActionPerformed

    private void btnCsvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCsvActionPerformed

        String filename = JOptionPane.showInputDialog("Kérem a fájl nevét\n(dokumentumokba lesz mentve)");
        
        if (filename != null) {
            GyakorlatBetolto bt = new GyakorlatBetolto(new CsvGyTransform());
            if (bt.ment(cbSzurte.isSelected() ? szurtlista : gyakorlats, System.getProperty("user.home")
                    + System.getProperty("file.separator") + "Dokumentumok"
                    + System.getProperty("file.separator") + filename + ".csv")) {
                JOptionPane.showMessageDialog(rootPane, "Sikeres fájl export");
            } else {
                JOptionPane.showMessageDialog(rootPane, "Hiba történt a fájl mentése közben");
            }
        }
    }//GEN-LAST:event_btnCsvActionPerformed

    private void btnJsonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJsonActionPerformed
        String filename = JOptionPane.showInputDialog("Kérem a fájl nevét\ndokumentumokba való mentéshez");
        if (filename != null) {
            GyakorlatBetolto bt = new GyakorlatBetolto(new JSONGyTransform());
            if (bt.ment(cbSzurte.isSelected() ? szurtlista : gyakorlats, System.getProperty("user.home")
                + System.getProperty("file.separator") + "Dokumentumok"
                + System.getProperty("file.separator") + filename + ".json")) {
            JOptionPane.showMessageDialog(rootPane, "Sikeres fájl export");
            } else {
                JOptionPane.showMessageDialog(rootPane, "Hiba történt a fájl mentése közben");
            }
        }
    }//GEN-LAST:event_btnJsonActionPerformed
                                   
    public void showFrame() {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Gyakorlatok.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gyakorlatok.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gyakorlatok.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gyakorlatok.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCsv;
    private javax.swing.JButton btnExcel;
    private javax.swing.JButton btnJson;
    private javax.swing.JComboBox<String> cbIzomcsop;
    private javax.swing.JCheckBox cbSzurte;
    private javax.swing.JTable gyakorlatTabla;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbCimsor;
    // End of variables declaration//GEN-END:variables

}
