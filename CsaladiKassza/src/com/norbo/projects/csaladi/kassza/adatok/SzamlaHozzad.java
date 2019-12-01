/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.norbo.projects.csaladi.kassza.adatok;

import com.norbo.projects.csaladi.kassza.adatok.utils.SzamlaMelos;
import java.time.LocalDate;
import java.time.Month;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author igloi
 */
public class SzamlaHozzad extends javax.swing.JDialog {
    private Szamla szamla;

    /**
     * Creates new form SzamlaHozzad
     */
    public SzamlaHozzad(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        setIconImage(new ImageIcon(getClass().getClassLoader().getResource("resources/ikons/kassza_edit.png")).getImage());
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        tfSzamlaszam = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        cbPrioritas = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        tfEv = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfHonap = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        tfNap = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        tfMegjNev = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        tfVartOsszeg = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        tfUjSzamlaMegNev = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Hozzáadás");
        setIconImage(null);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Számla hozzáadása"));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Választott számla adatai"));
        jPanel3.setLayout(new java.awt.GridLayout(5, 2, 5, 5));

        jPanel8.setLayout(new java.awt.GridLayout(1, 2));

        jLabel8.setText("Számlaszám: ");
        jPanel8.add(jLabel8);
        jPanel8.add(tfSzamlaszam);

        jPanel3.add(jPanel8);

        jPanel7.setLayout(new java.awt.GridLayout(1, 2));

        jLabel7.setText("Prioritás: ");
        jPanel7.add(jLabel7);

        cbPrioritas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Alacsony", "Közepes", "Magas" }));
        jPanel7.add(cbPrioritas);

        jPanel3.add(jPanel7);

        jPanel6.setLayout(new java.awt.GridLayout(1, 2));

        jLabel6.setText("Befizetési határidő:");
        jPanel6.add(jLabel6);

        jPanel10.setLayout(new java.awt.GridBagLayout());

        jLabel10.setText("Év:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        jPanel10.add(jLabel10, gridBagConstraints);

        tfEv.setText("1994");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        jPanel10.add(tfEv, gridBagConstraints);

        jLabel3.setText("Hónap:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        jPanel10.add(jLabel3, gridBagConstraints);

        tfHonap.setText("11");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 0;
        jPanel10.add(tfHonap, gridBagConstraints);

        jLabel11.setText("Nap:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 0;
        jPanel10.add(jLabel11, gridBagConstraints);

        tfNap.setText("05");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 0;
        jPanel10.add(tfNap, gridBagConstraints);

        jPanel6.add(jPanel10);

        jPanel3.add(jPanel6);

        jPanel4.setLayout(new java.awt.GridLayout(1, 2));

        jLabel4.setText("Megjelenített név:");
        jPanel4.add(jLabel4);
        jPanel4.add(tfMegjNev);

        jPanel3.add(jPanel4);

        jPanel5.setLayout(new java.awt.GridLayout(1, 2));

        jLabel5.setText("Befizetésre várt összeg:");
        jPanel5.add(jLabel5);
        jPanel5.add(tfVartOsszeg);

        jPanel3.add(jPanel5);

        jLabel1.setText("Hozzáadni kívánt számla neve:");

        jButton1.setText("Mégse");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Hozzáad");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 544, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfUjSzamlaMegNev))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfUjSzamlaMegNev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)))
        );

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //hibakezelés és majd szamla változó beállítása
        if (validateFields()) {
            szamla = new Szamla(tfSzamlaszam.getText(),
            tfMegjNev.getText(), SzamlaMelos.getPrior(cbPrioritas.getSelectedItem().toString()),
                    LocalDate.parse(tfEv.getText() + "-" + tfHonap.getText() + "-" + tfNap.getText()),
                    Integer.parseInt(tfVartOsszeg.getText()));
            setVisible(false);
        } else {
            JOptionPane.showMessageDialog(this, "Üres mezőket adtál meg, kötelező kitölteni mind", "Számla",
                    JOptionPane.ERROR_MESSAGE);
        }
;
        
        
    }//GEN-LAST:event_jButton2ActionPerformed


    public Szamla getSzamla() {
        return szamla;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbPrioritas;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JTextField tfEv;
    private javax.swing.JTextField tfHonap;
    private javax.swing.JTextField tfMegjNev;
    private javax.swing.JTextField tfNap;
    private javax.swing.JTextField tfSzamlaszam;
    private javax.swing.JTextField tfUjSzamlaMegNev;
    private javax.swing.JTextField tfVartOsszeg;
    // End of variables declaration//GEN-END:variables

    private boolean validateFields() {
        try {
            if(tfEv.getText().length() == 0 || !tfEv.getText().matches("[0-9]+")) {
                return false;
            }

            if(tfHonap.getText().length() == 0 || !tfHonap.getText().matches("[0-9]+")) {
                return false;
            }

            if(tfNap.getText().length() == 0 || !tfNap.getText().matches("[0-9]+")) {
                return false;
            }

            if(tfSzamlaszam.getText().length() == 0 ||
                    tfMegjNev.getText().length() == 0 ||
                    tfVartOsszeg.getText().length() == 0 ||
                    tfUjSzamlaMegNev.getText().length() == 0) {
                return false;
            }
        } catch (NullPointerException e) {
            return false;
        }
        
        return true;
    }
}
