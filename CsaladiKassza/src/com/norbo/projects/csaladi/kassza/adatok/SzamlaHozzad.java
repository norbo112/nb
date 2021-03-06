/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.norbo.projects.csaladi.kassza.adatok;

import com.norbo.projects.csaladi.kassza.adatok.utils.GuiUtils;
import com.norbo.projects.csaladi.kassza.adatok.utils.DBMelos;
import com.norbo.projects.csaladi.kassza.adatok.utils.frissito.AdatFrissitoFigyelo;
import java.awt.Color;
import java.time.LocalDate;
import javax.swing.ImageIcon;
import javax.swing.JColorChooser;
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
        jLabel11 = new javax.swing.JLabel();
        tfNap = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        tfMegjNev = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        tfVartOsszeg = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnSzinKod = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        tfUjSzamlaMegNev = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        btnHozzaad = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Hozzáadás");
        setIconImage(null);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 102, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Számla hozzáadása", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        jPanel3.setBackground(new java.awt.Color(0, 102, 153));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Választott számla adatai", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel3.setLayout(new java.awt.GridLayout(6, 1, 5, 5));

        jPanel8.setLayout(new java.awt.GridLayout(1, 2));

        jLabel8.setBackground(new java.awt.Color(0, 102, 153));
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Számlaszám: ");
        jLabel8.setOpaque(true);
        jPanel8.add(jLabel8);

        tfSzamlaszam.setBackground(new java.awt.Color(0, 102, 153));
        tfSzamlaszam.setForeground(new java.awt.Color(255, 255, 255));
        jPanel8.add(tfSzamlaszam);

        jPanel3.add(jPanel8);

        jPanel7.setLayout(new java.awt.GridLayout(1, 2));

        jLabel7.setBackground(new java.awt.Color(0, 102, 153));
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Prioritás: ");
        jLabel7.setOpaque(true);
        jPanel7.add(jLabel7);

        cbPrioritas.setBackground(new java.awt.Color(0, 102, 153));
        cbPrioritas.setForeground(new java.awt.Color(255, 255, 255));
        cbPrioritas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Alacsony", "Közepes", "Magas" }));
        jPanel7.add(cbPrioritas);

        jPanel3.add(jPanel7);

        jPanel6.setLayout(new java.awt.GridLayout(1, 2));

        jLabel6.setBackground(new java.awt.Color(0, 102, 153));
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Befizetési határidő:");
        jLabel6.setOpaque(true);
        jPanel6.add(jLabel6);

        jPanel10.setBackground(new java.awt.Color(0, 102, 153));
        jPanel10.setForeground(new java.awt.Color(255, 255, 255));

        jLabel11.setBackground(new java.awt.Color(0, 153, 204));
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Befizetés határidő napja");

        tfNap.setBackground(new java.awt.Color(0, 102, 153));
        tfNap.setForeground(new java.awt.Color(255, 255, 255));
        tfNap.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfNap.setText("05");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfNap, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfNap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(13, 13, 13))
        );

        jPanel6.add(jPanel10);

        jPanel3.add(jPanel6);

        jPanel4.setLayout(new java.awt.GridLayout(1, 2));

        jLabel4.setBackground(new java.awt.Color(0, 102, 153));
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Megjelenített név:");
        jLabel4.setOpaque(true);
        jPanel4.add(jLabel4);

        tfMegjNev.setBackground(new java.awt.Color(0, 102, 153));
        tfMegjNev.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(tfMegjNev);

        jPanel3.add(jPanel4);

        jPanel5.setLayout(new java.awt.GridLayout(1, 2));

        jLabel5.setBackground(new java.awt.Color(0, 102, 153));
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Befizetésre várt összeg:");
        jLabel5.setOpaque(true);
        jPanel5.add(jLabel5);

        tfVartOsszeg.setBackground(new java.awt.Color(0, 102, 153));
        tfVartOsszeg.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.add(tfVartOsszeg);

        jPanel3.add(jPanel5);

        jPanel2.setBackground(new java.awt.Color(0, 102, 153));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Színkód kiválasztása:");

        btnSzinKod.setText("Színkód");
        btnSzinKod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSzinKodActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSzinKod, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSzinKod, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel3.add(jPanel2);

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Hozzáadni kívánt számla neve:");

        jButton1.setText("Mégse");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnHozzaad.setText("Hozzáad");
        btnHozzaad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHozzaadActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfUjSzamlaMegNev))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnHozzaad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfUjSzamlaMegNev, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 351, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(btnHozzaad)))
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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnHozzaadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHozzaadActionPerformed
        //hibakezelés és majd szamla változó beállítása
        if (validateFields()) {
            //id lényegtelen, mert amikor hozzáadom a táblához, akkor ezt figyelmen kivül hagyom és automatikusan gerenál egyet
            //számla id-je a szerkesztéshez szükséges
            Color vlszin = btnSzinKod.getBackground();
            szamla = new Szamla(0,tfSzamlaszam.getText(),
            tfMegjNev.getText(), DBMelos.getPrior(cbPrioritas.getSelectedItem().toString()),
                    Integer.parseInt(tfNap.getText()),
                    Integer.parseInt(tfVartOsszeg.getText()), 
                    GuiUtils.getColorStr(vlszin.getRed(), vlszin.getGreen(), vlszin.getBlue()));
            
            if(!DBMelos.addSzamlaToDB(DBMelos.CONNURL, szamla)) {
                JOptionPane.showMessageDialog(this, "Sikertelen adatbázis beszúrás!", "Számla",
                    JOptionPane.ERROR_MESSAGE);
            } else {
                ((AdatFrissitoFigyelo)getParent()).adatFrissites(getClass().getSimpleName());
            }
            
            setVisible(false);
        } else {
            JOptionPane.showMessageDialog(this, "Üres mezőket adtál meg, kötelező kitölteni mind", "Számla",
                    JOptionPane.ERROR_MESSAGE);
        }
;
        
        
    }//GEN-LAST:event_btnHozzaadActionPerformed

    private void btnSzinKodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSzinKodActionPerformed
        Color valasztottSzin = JColorChooser.showDialog(null, "Számla színkódjának kiválasztása", Color.green);
        if(valasztottSzin != null) {
            btnSzinKod.setBackground(valasztottSzin);
        }
    }//GEN-LAST:event_btnSzinKodActionPerformed


    public Szamla getSzamla() {
        return szamla;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHozzaad;
    private javax.swing.JButton btnSzinKod;
    private javax.swing.JComboBox<String> cbPrioritas;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JTextField tfMegjNev;
    private javax.swing.JTextField tfNap;
    private javax.swing.JTextField tfSzamlaszam;
    private javax.swing.JTextField tfUjSzamlaMegNev;
    private javax.swing.JTextField tfVartOsszeg;
    // End of variables declaration//GEN-END:variables

    private boolean validateFields() {
        try {
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
