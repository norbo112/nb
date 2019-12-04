/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.norbo.projects.csaladi.kassza;

import com.norbo.projects.csaladi.kassza.adatok.BeSzamla;
import com.norbo.projects.csaladi.kassza.adatok.Szamla;
import com.norbo.projects.csaladi.kassza.adatok.SzamlaHozzad;
import com.norbo.projects.csaladi.kassza.adatok.SzamlaAdatokDialog;
import com.norbo.projects.csaladi.kassza.adatok.SzamlakTableModel;
import com.norbo.projects.csaladi.kassza.adatok.utils.CskFilter;
import com.norbo.projects.csaladi.kassza.adatok.utils.CsvFeldolgozo;
import com.norbo.projects.csaladi.kassza.adatok.utils.Feldolgozo;
import com.norbo.projects.csaladi.kassza.adatok.utils.SzamlaMelos;
import com.norbo.projects.csaladi.kassza.adatok.utils.frissito.AdatFrissitoFigyelo;
import com.norbo.projects.csaladi.kassza.nyomtatas.BeSzamlaNyomat;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.time.LocalDateTime;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author igloi
 */
public class CsaladiKasszaMain extends javax.swing.JFrame implements AdatFrissitoFigyelo{
    private static final String VALASSZ = " -- Válassz -- ";
    private List<Szamla> szamlaLista;
    private DefaultComboBoxModel<String> cbmodel;
    private SzamlakTableModel tableModel;

    /**
     * Creates new form CsaladiKasszaMain
     */
    public CsaladiKasszaMain() {
        initComponents();
        
        setIconImage(new ImageIcon(getClass().getClassLoader().getResource("resources/ikons/kassza.png")).getImage());
        
        initContent();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tableSzamlak = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cbSzamlaLista = new javax.swing.JComboBox<>();
        tfBefizetesOsszeg = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lbVartOsszeg = new javax.swing.JLabel();
        btnAddBeSzamla = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        lblHatarIdo = new javax.swing.JLabel();
        csaladiKasszaNaptar2 = new com.norbo.projects.csaladi.kassza.gui.naptar.CsaladiKasszaNaptar();
        jMenuBar1 = new javax.swing.JMenuBar();
        menufile = new javax.swing.JMenu();
        menuBetoltes = new javax.swing.JMenuItem();
        menuMentes = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        menuPrint = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        menuReszletek = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Családi Kassza");
        setBackground(new java.awt.Color(0, 51, 102));

        jPanel1.setBackground(new java.awt.Color(0, 102, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));

        jPanel3.setBackground(new java.awt.Color(0, 102, 153));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Befizetett számlák", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        tableSzamlak.setFont(new java.awt.Font("Dialog", 0, 15)); // NOI18N
        tableSzamlak.setModel(new javax.swing.table.DefaultTableModel(
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
        tableSzamlak.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tableSzamlak.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tableSzamlak);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1162, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(0, 102, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Befizetés", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Számla kiválasztása: ");

        cbSzamlaLista.setForeground(new java.awt.Color(255, 255, 255));
        cbSzamlaLista.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        tfBefizetesOsszeg.setForeground(new java.awt.Color(0, 0, 0));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Befizeni kívánt összeg:");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Várt összeg:");

        lbVartOsszeg.setForeground(new java.awt.Color(255, 255, 255));
        lbVartOsszeg.setText("0,00 Ft");

        btnAddBeSzamla.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/ikons/kassza_ok.png"))); // NOI18N
        btnAddBeSzamla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddBeSzamlaActionPerformed(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Befizetési határidő:");

        lblHatarIdo.setForeground(new java.awt.Color(255, 255, 255));
        lblHatarIdo.setText("1900-01-01");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbSzamlaLista, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblHatarIdo, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfBefizetesOsszeg, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbVartOsszeg, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAddBeSzamla, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(cbSzamlaLista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfBefizetesOsszeg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(lbVartOsszeg)
                            .addComponent(jLabel4)
                            .addComponent(lblHatarIdo)))
                    .addComponent(btnAddBeSzamla))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(csaladiKasszaNaptar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(csaladiKasszaNaptar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        menufile.setText("File");

        menuBetoltes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/ikons/kassza_open.png"))); // NOI18N
        menuBetoltes.setText("Betöltés");
        menuBetoltes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuBetoltesActionPerformed(evt);
            }
        });
        menufile.add(menuBetoltes);

        menuMentes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/ikons/kassza_save.png"))); // NOI18N
        menuMentes.setText("Mentés");
        menuMentes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuMentesActionPerformed(evt);
            }
        });
        menufile.add(menuMentes);
        menufile.add(jSeparator2);

        menuPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/ikons/kassza_print.png"))); // NOI18N
        menuPrint.setText("Nyomtatás");
        menuPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuPrintActionPerformed(evt);
            }
        });
        menufile.add(menuPrint);
        menufile.add(jSeparator1);

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/ikons/kassza_exit.png"))); // NOI18N
        jMenuItem1.setText("Kilépés");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        menufile.add(jMenuItem1);

        jMenuBar1.add(menufile);

        jMenu2.setText("Szerkeszt");

        jMenuItem3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/ikons/kassza_edit.png"))); // NOI18N
        jMenuItem3.setText("Hozzáadás");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        menuReszletek.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/ikons/kassza_szamla.png"))); // NOI18N
        menuReszletek.setText("Részletek");
        menuReszletek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuReszletekActionPerformed(evt);
            }
        });
        jMenu2.add(menuReszletek);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void menuReszletekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuReszletekActionPerformed
        SzamlaAdatokDialog.showDialog(this);
    }//GEN-LAST:event_menuReszletekActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        SzamlaHozzad szamlaHozzad = new SzamlaHozzad(this, true);
        szamlaHozzad.setVisible(true);
        
        Szamla sz = szamlaHozzad.getSzamla();
        if (sz != null) {
            JOptionPane.showMessageDialog(this, "Számla hozzáadása megtörtént: " + sz.getMegjelenoNev(), "Számla",
                    JOptionPane.INFORMATION_MESSAGE);
            szamlaLista.add(sz);
            cbmodel.addElement(sz.getMegjelenoNev());
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void btnAddBeSzamlaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddBeSzamlaActionPerformed
        if(!cbSzamlaLista.getSelectedItem().toString().equals(VALASSZ)) {
            Szamla szamla = szamlaLista.get(cbSzamlaLista.getSelectedIndex() - 1);
            if(tfBefizetesOsszeg.getText().matches("[0-9]+")) {
                int osszeg = Integer.parseInt(tfBefizetesOsszeg.getText().trim());
                tableModel.addBeSzamla(new BeSzamla(szamla, LocalDateTime.now(), osszeg));
            } else {
                JOptionPane.showMessageDialog(this, "Csak számot fogadok el!", "Számla",
                    JOptionPane.ERROR_MESSAGE);
            }
            
        } else {
            JOptionPane.showMessageDialog(this, "Nincs kiválasztva hogy kinek megy az összeg", "Számla",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAddBeSzamlaActionPerformed

    private void menuMentesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuMentesActionPerformed
        if(!tableModel.getSzamlak().isEmpty()) {
            String opt = JOptionPane.showInputDialog("Kérem a fájl nevét");
            if(opt != null) {
                File f = new File(System.getProperty("user.home")+File.separator+opt+".csk");
                Feldolgozo<File, List<BeSzamla>> feldolgozo = new Feldolgozo<>(new CsvFeldolgozo());
                if(feldolgozo.ment(f, tableModel.getSzamlak())) {
                    JOptionPane.showMessageDialog(this, "Sikeres mentés!", "Mentés",
                        JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Sikertelen mentés", "Mentés",
                        JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Nincs mit elmenteni", "Mentés",
                        JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_menuMentesActionPerformed

    private void menuBetoltesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuBetoltesActionPerformed
        JFileChooser jfc = new JFileChooser(System.getProperty("user.home"));
        jfc.setFileFilter(new CskFilter());
        if(jfc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            Feldolgozo<File, List<BeSzamla>> feldolgozo = new Feldolgozo<>(new CsvFeldolgozo());
            List<BeSzamla> szamla = feldolgozo.betolt(jfc.getSelectedFile());
            if(szamla != null) {
                tableModel.setSzamlak(szamla);
            }
        }
    }//GEN-LAST:event_menuBetoltesActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        int ok = JOptionPane.showConfirmDialog(this, "Biztosan kiakarsz lépni!", "Kilépés",
                JOptionPane.OK_CANCEL_OPTION);
        if(ok == JOptionPane.OK_OPTION) {
            setVisible(false);
            System.exit(0);
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void menuPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuPrintActionPerformed
        List<BeSzamla> pszamlak = tableModel.getSzamlak();
        if(!pszamlak.isEmpty()) {
            PrinterJob job = PrinterJob.getPrinterJob();
            job.setPrintable(new BeSzamlaNyomat(pszamlak));
            boolean okey = job.printDialog();
            if(okey) {
                try {
                    job.print();
                } catch (PrinterException e) {
                    System.out.println("Nem tudtam nyomtatni! "+e);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Üres listát nem lehet nyomtatni", "Nyomtatás",
                        JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_menuPrintActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(CsaladiKasszaMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CsaladiKasszaMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CsaladiKasszaMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CsaladiKasszaMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CsaladiKasszaMain().setVisible(true);
            }
        });
    }
    
    private void initContent() {
        initSzamlaComboBox();
        
        tableModel = new SzamlakTableModel();
        tableSzamlak.setModel(tableModel);
        //tableSzamlak.getColumnModel().getColumn(3).setCellRenderer(new SajatCheckBox());
    }

    private void initSzamlaComboBox() {
        cbSzamlaLista.removeAllItems();
        
        szamlaLista = SzamlaMelos.getSzamlakFromDB();
        cbmodel = new DefaultComboBoxModel<>();
        cbSzamlaLista.setModel(cbmodel);
        
        cbmodel.addElement(VALASSZ);
        szamlaLista.forEach(o -> cbmodel.addElement(o.getMegjelenoNev()));
        
        cbSzamlaLista.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                if(cbSzamlaLista.getSelectedIndex() != -1) {
                    if(!cbSzamlaLista.getSelectedItem().toString().equals(VALASSZ)) {
                        Szamla szamla = szamlaLista.get(cbSzamlaLista.getSelectedIndex() - 1);
                        lbVartOsszeg.setText(String.format("%,.2f Ft", szamla.getOsszeg()));
                        lblHatarIdo.setText(szamla.getBefizetesHatarido().toString());
                    } else {
                        lbVartOsszeg.setText(String.format("%,.2f Ft", 0.0));
                        lblHatarIdo.setText("1900-01-01");
                    }
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddBeSzamla;
    private javax.swing.JComboBox<String> cbSzamlaLista;
    private com.norbo.projects.csaladi.kassza.gui.naptar.CsaladiKasszaNaptar csaladiKasszaNaptar2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JLabel lbVartOsszeg;
    private javax.swing.JLabel lblHatarIdo;
    private javax.swing.JMenuItem menuBetoltes;
    private javax.swing.JMenuItem menuMentes;
    private javax.swing.JMenuItem menuPrint;
    private javax.swing.JMenuItem menuReszletek;
    private javax.swing.JMenu menufile;
    private javax.swing.JTable tableSzamlak;
    private javax.swing.JTextField tfBefizetesOsszeg;
    // End of variables declaration//GEN-END:variables

    @Override
    public void adatFrissites(String classname) {
        if(classname.equals(SzamlaAdatokDialog.class.getSimpleName())) {
            initSzamlaComboBox();
        }
    }

}
