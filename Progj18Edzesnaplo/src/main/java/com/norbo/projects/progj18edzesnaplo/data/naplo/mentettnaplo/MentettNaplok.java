/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.norbo.projects.progj18edzesnaplo.data.naplo.mentettnaplo;

import com.norbo.projects.progj18edzesnaplo.data.naplo.MultiLineCellRenderer;
import com.norbo.projects.progj18edzesnaplo.data.naplo.SorozatInterface;
import com.norbo.projects.progj18edzesnaplo.data.naplo.SorozatTableModel;
import com.norbo.projects.progj18edzesnaplo.dodata.sorozat.JsonSorozatTransform;
import java.awt.Color;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractListModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.SwingWorker;

/**
 * A Mentett naplók megtekintése
 * @author igloi
 */
public class MentettNaplok extends javax.swing.JDialog implements PropertyChangeListener{
    private SorozatTableModel sorozatTableModel;
    private MentettNaplokListModel naploListModel;
    
    /**
     * A Listában megjelenő mentett napló adata, displaystring jelenik meg
     * majd lekérdezésnél az elérési út adná vissza a fájl helyét
     * 
     * ezt lehetséges hogy cserélem majd specifikusabb osztályra pl Pathsra
     */
    private class MentettNaploModel {
        String displaystring;
        String eleresiut;

        public MentettNaploModel(String displaystring, String eleresiut) {
            this.displaystring = displaystring;
            this.eleresiut = eleresiut;
        }
        
        public String getDisplaystring() {
            return displaystring;
        }

        public void setDisplaystring(String displaystring) {
            this.displaystring = displaystring;
        }

        public String getEleresiut() {
            return eleresiut;
        }

        public void setEleresiut(String eleresiut) {
            this.eleresiut = eleresiut;
        }
        
    }

    /**
     * JList listamodelje
     */
    private class MentettNaplokListModel extends AbstractListModel<String> {
        private List<MentettNaploModel> lista;

        public MentettNaplokListModel(List<MentettNaploModel> ujLista) {
            this.lista = ujLista;
        }
        
        @Override
        public int getSize() {
            return lista.size();
        }

        @Override
        public String getElementAt(int index) {
            return lista.get(index).getDisplaystring();
        }
        
        public MentettNaploModel getNaploModel(int index) {
            return lista.get(index);
        }
    };
    
    /**
     * SwingWorker a napló betöltésére, külön szálon biztosítva
     */
    private class NaploBetolto extends SwingWorker<List<SorozatInterface>, String> {
        private List<SorozatInterface> sorozat;
        private MentettNaploModel naplomodel;

        public NaploBetolto() {
            sorozat = new ArrayList<>();
        }
        
        @Override
        protected List<SorozatInterface> doInBackground() throws Exception {
            statusPanel.setVisible(true);
            naplomodel = naploListModel.getNaploModel(naploList.getSelectedIndex());
//            List<SorozatInterface> sorozatlista = new ObjTransform().betolt(naplomodel.getEleresiut());
            List<SorozatInterface> sorozatlista = 
                    new JsonSorozatTransform().betolt(naplomodel.getEleresiut());
            publish(naplomodel.getDisplaystring()+" fájl feldolgozása");
            setProgress(sorozatlista.size());
            sorozat = sorozatlista;
            Thread.sleep(5000);
            return sorozatlista;
        }

        @Override
        protected void done() {
            statusPanel.setVisible(false);
            sorozatTableModel.setSorozatok(sorozat);
            if(naplomodel != null)  {
                File f = new File(naplomodel.getEleresiut());
                lblNaploMeret.setText(Long.toString(f.length())+" bájt");
                lblNaploTime.setText(Instant.ofEpochMilli(f.lastModified()).atZone(ZoneId.of("GMT+1"))
                        .format(DateTimeFormatter.ofPattern("YYYY-M-dd H:m:s")));
                lblNaploOsszsuly.setText(""+getOsszSuly(sorozat)+" Kg");
            }
            JOptionPane.showMessageDialog(MentettNaplok.this, "Betöltés befejeződött!");
        }

        @Override
        protected void process(List<String> chunks) {
            lblFajlFeldolgoz.setText(chunks.get(0));
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
//        if(evt.getPropertyName().equals("progress")) {
//            prgFeldolgoz.setValue((int)evt.getNewValue());
//        }
    }
    
    private int getOsszSuly(List<SorozatInterface> sorozat) {
        int s = 0;
        for (SorozatInterface sor : sorozat) {
            s += sor.getOsszSuly();
        }
        return s;
    }
            
    /**
     * Creates new form MentettNaplok
     */
    public MentettNaplok(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        initMyCompontents();
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
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        naploList = new javax.swing.JList<>();
        statusPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblFajlFeldolgoz = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        sorozatTabla = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblNaploMeret = new javax.swing.JLabel();
        lblNaploOsszsuly = new javax.swing.JLabel();
        lblNaploTime = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Mentett Naplók");
        setSize(new java.awt.Dimension(800, 500));

        jPanel1.setBackground(new java.awt.Color(0, 102, 204));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 255, 255), 1, true));

        jPanel2.setBackground(new java.awt.Color(0, 102, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));

        jPanel4.setBackground(new java.awt.Color(136, 207, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)), "Napló kiválasztása", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        naploList.setBackground(new java.awt.Color(255, 255, 255));
        naploList.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        naploList.setForeground(new java.awt.Color(0, 0, 0));
        naploList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        naploList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                naploListMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(naploList);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        statusPanel.setBackground(new java.awt.Color(0, 102, 204));
        statusPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        statusPanel.setForeground(new java.awt.Color(0, 0, 0));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Adatok betöltése");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Fájl amin épp dolgozunk:");

        lblFajlFeldolgoz.setForeground(new java.awt.Color(255, 255, 255));
        lblFajlFeldolgoz.setText("Kiválasztott fájl");

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/loader.gif"))); // NOI18N

        javax.swing.GroupLayout statusPanelLayout = new javax.swing.GroupLayout(statusPanel);
        statusPanel.setLayout(statusPanelLayout);
        statusPanelLayout.setHorizontalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblFajlFeldolgoz, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addGroup(statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(statusPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        statusPanelLayout.setVerticalGroup(
            statusPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statusPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblFajlFeldolgoz)
                .addContainerGap(65, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(0, 102, 204));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 276, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 46, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(statusPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(statusPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel5.setBackground(new java.awt.Color(136, 207, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)), "Megtekintő", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(0, 0, 0))); // NOI18N

        sorozatTabla.setBackground(new java.awt.Color(255, 255, 255));
        sorozatTabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
            },
            new String [] {
                "Sorszám","Felvétel dátuma","Gyakorlat","Súly x Ismétlés","Időpont"
            }
        ));
        sorozatTabla.setShowGrid(false);
        jScrollPane1.setViewportView(sorozatTabla);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 605, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel7.setBackground(new java.awt.Color(136, 207, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Információ", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(0, 0, 0))); // NOI18N

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Napló mentés mérete:");
        jLabel4.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));
        jLabel4.setOpaque(true);

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Napló mentés ideje:");
        jLabel5.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));
        jLabel5.setOpaque(true);

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Összesen megmozgatott súly: ");
        jLabel6.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));
        jLabel6.setOpaque(true);

        lblNaploMeret.setBackground(new java.awt.Color(255, 255, 255));
        lblNaploMeret.setForeground(new java.awt.Color(0, 0, 0));
        lblNaploMeret.setText(" ");
        lblNaploMeret.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));
        lblNaploMeret.setOpaque(true);

        lblNaploOsszsuly.setBackground(new java.awt.Color(255, 255, 255));
        lblNaploOsszsuly.setForeground(new java.awt.Color(0, 0, 0));
        lblNaploOsszsuly.setText(" ");
        lblNaploOsszsuly.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));
        lblNaploOsszsuly.setOpaque(true);

        lblNaploTime.setBackground(new java.awt.Color(255, 255, 255));
        lblNaploTime.setForeground(new java.awt.Color(0, 0, 0));
        lblNaploTime.setText(" ");
        lblNaploTime.setBorder(javax.swing.BorderFactory.createEmptyBorder(3, 3, 3, 3));
        lblNaploTime.setOpaque(true);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNaploMeret, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblNaploOsszsuly, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblNaploTime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(lblNaploMeret))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lblNaploTime))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(lblNaploOsszsuly))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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

    private void naploListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_naploListMouseClicked
        if(evt.getClickCount() == 2) {
//            MentettNaploModel naplomodel = naploListModel.getNaploModel(naploList.getSelectedIndex());
//            List<SorozatInterface> sorozatlista = new ObjTransform().betolt(naplomodel.getEleresiut());
//            sorozatTableModel.setSorozatok(sorozatlista);
            NaploBetolto naploBetolto = new NaploBetolto();
            naploBetolto.addPropertyChangeListener(this);
            naploBetolto.execute();
        }
    }//GEN-LAST:event_naploListMouseClicked

    /**
     * @param frame parentFrame
     */
    public static void showDialog(final JFrame frame) {
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
            java.util.logging.Logger.getLogger(MentettNaplok.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MentettNaplok.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MentettNaplok.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MentettNaplok.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MentettNaplok dialog = new MentettNaplok(frame, false);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        dialog.setVisible(false);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblFajlFeldolgoz;
    private javax.swing.JLabel lblNaploMeret;
    private javax.swing.JLabel lblNaploOsszsuly;
    private javax.swing.JLabel lblNaploTime;
    private javax.swing.JList<String> naploList;
    private javax.swing.JTable sorozatTabla;
    private javax.swing.JPanel statusPanel;
    // End of variables declaration//GEN-END:variables

    private void initMyCompontents() {
        //Táblázat
        sorozatTableModel = new SorozatTableModel();
        sorozatTabla.setModel(sorozatTableModel);
        //sorozatTabla.setDefaultRenderer(String.class, new MultiLineCellRenderer());
        sorozatTabla.getColumnModel().getColumn(4).setCellRenderer(new MultiLineCellRenderer());
        sorozatTabla.getColumnModel().getColumn(5).setCellRenderer(new MultiLineCellRenderer());
        sorozatTableModel.addTableModelListener((event) -> {
            SwingUtilities.invokeLater(() -> {
                for (int i = 0; i < sorozatTabla.getRowCount(); i++) {
                    sorozatTabla.setRowHeight(i, 16*sorozatTableModel.getSorCount(i));
                }
            });
        });
        
        //Lista
        List<MentettNaploModel> naplok = null;
        try {
            naplok = getMentettNaploLista();
        } catch (IOException ex) {
            Logger.getLogger(MentettNaplok.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(naplok != null) {
            naploList.setModel(naploListModel = new MentettNaplokListModel(naplok));
        } else {
            naploList.setModel(naploListModel = new MentettNaplokListModel(new ArrayList<MentettNaploModel>()));
        }
        
        
        //adatok feldolgozása és kijelzése
        statusPanel.setVisible(false);
        
        jScrollPane1.getViewport().setBackground(new Color(101,199,255));
    }
    
    /**
     * user.dir mappa végigjárása a fájlok keresése az _edzesnap.npl-re
     * @return Mentett naplók listája
     * @throws IOException 
     */
    private List<MentettNaploModel> getMentettNaploLista() throws IOException {
        List<MentettNaploModel> lists = new ArrayList<>();
        java.nio.file.Path userhome = Paths.get(System.getProperty("user.dir"));
        
        try (DirectoryStream<java.nio.file.Path> dstream = Files.newDirectoryStream((java.nio.file.Path) userhome)) {
            for (java.nio.file.Path path : dstream) {
                java.nio.file.Path name = path.getName(path.getNameCount()-1);
//                System.out.println(ps);
                if(path.toString().endsWith("_edzesnap.npl")) {
                    String namestr = name.toString();
                    lists.add(new MentettNaploModel(namestr.substring(0, namestr.lastIndexOf('_')), path.toString()));
                }
            }
        }
        
        return lists;
    }
}
