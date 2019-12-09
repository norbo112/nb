package com.norbo.projects.csaladi.kassza.gui.naptar;

import com.norbo.projects.csaladi.kassza.adatok.Szamla;
import com.norbo.projects.csaladi.kassza.adatok.utils.GuiUtils;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 *  Saját naptár panel megvílósítás a Befizetések határidejének nyomonkövetésére
 * @author igloi
 */
public class CsaladiKasszaNaptar extends javax.swing.JPanel implements ActionListener {
    private Color kijelolt = Color.green;
    private Color defHatter = new Color(60,63,65);
    
    private final LocalDate most = LocalDate.now();
    
    private LocalDate datum = LocalDate.now();
    private List<JComponent> buttons;
    private List<Szamla> szamlak;
    
    /**
     * Creates new form CsaladiKasszaNaptar
     */
    public CsaladiKasszaNaptar() {
        this.szamlak = new ArrayList<>();
        initComponents();
        initMe();
    }
    
    public CsaladiKasszaNaptar(List<Szamla> szamlak) {
        this.szamlak = szamlak;
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

        napokPanel = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        lblHonapNeve = new javax.swing.JLabel();
        btnPrevMonth = new javax.swing.JButton();
        btnNextMonth = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(0, 102, 153));

        napokPanel.setBackground(new java.awt.Color(0, 153, 204));
        napokPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 2, 2, 2));
        napokPanel.setLayout(new java.awt.GridLayout(0, 7, 5, 5));

        jPanel3.setBackground(new java.awt.Color(0, 153, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));

        lblHonapNeve.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        lblHonapNeve.setForeground(new java.awt.Color(0, 0, 0));
        lblHonapNeve.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblHonapNeve.setText("Hónap neve");

        btnPrevMonth.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnPrevMonth.setText("<");
        btnPrevMonth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevMonthActionPerformed(evt);
            }
        });

        btnNextMonth.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        btnNextMonth.setText(">");
        btnNextMonth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextMonthActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(68, Short.MAX_VALUE)
                .addComponent(btnPrevMonth)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblHonapNeve, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnNextMonth)
                .addGap(80, 80, 80))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(lblHonapNeve)
                .addComponent(btnPrevMonth)
                .addComponent(btnNextMonth))
        );

        jPanel1.setBackground(new java.awt.Color(0, 153, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(2, 2, 2, 2));
        jPanel1.setLayout(new java.awt.GridLayout(1, 7));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("H");
        jPanel1.add(jLabel1);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("K");
        jPanel1.add(jLabel2);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Sze");
        jPanel1.add(jLabel3);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Cs");
        jPanel1.add(jLabel4);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("P");
        jPanel1.add(jLabel5);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Szo");
        jPanel1.add(jLabel6);

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("V");
        jPanel1.add(jLabel7);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(napokPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(napokPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnNextMonthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextMonthActionPerformed
        datum = datum.plusMonths(1);
        initMe();
    }//GEN-LAST:event_btnNextMonthActionPerformed

    private void btnPrevMonthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevMonthActionPerformed
        datum = datum.minusMonths(1);
        initMe();
    }//GEN-LAST:event_btnPrevMonthActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNextMonth;
    private javax.swing.JButton btnPrevMonth;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblHonapNeve;
    private javax.swing.JPanel napokPanel;
    // End of variables declaration//GEN-END:variables

    private void initMe() {
        buttons = new ArrayList<>();
        napokPanel.removeAll();
        
        lblHonapNeve.setText(datum.getMonth().name());
        int napokszama = datum.lengthOfMonth();
        
        LocalDate honap = LocalDate.of(datum.getYear(), datum.getMonth(), 1);
        int elsoNapHetNapja = honap.getDayOfWeek().getValue();
        
        int elozohonapszam = honap.minusMonths(1).lengthOfMonth();

        int el = elozohonapszam-(elsoNapHetNapja-2);
        //panel feltöltése a gombokkal
        for (int i = 1; i < elsoNapHetNapja; i++) {
            JLabel lb = new JLabel(""+(el++));
            lb.setForeground(Color.white);
            lb.setHorizontalAlignment(SwingUtilities.CENTER);
            lb.setSize(30, 30);
            buttons.add(lb);
        }
        
        for (int i = 1; i <= napokszama; i++) {
            NapButton b = new NapButton(""+i);
            b.setSize(30, 30);
            defHatter = b.getBackground();
            //mai nap kijelzése
            if(i == most.getDayOfMonth() && most.getMonth().equals(datum.getMonth())) {
                b.setBorder(BorderFactory.createLineBorder(Color.yellow, 1));
            }
            buttons.add(b);
        }
        
        //multhavi dátumok kijelzése, vagy épp a következőhavi, csak teszt, szóval köv havi
        LocalDate temp = LocalDate.of(datum.getYear(), datum.getMonth(), napokszama);
        int utso = temp.getDayOfWeek().getValue();
        for (int i = 1; i <= 7 - utso; i++) {
            JLabel lb = new JLabel(""+i);
            lb.setForeground(Color.white);
            lb.setHorizontalAlignment(SwingUtilities.CENTER);
            lb.setSize(30, 30);
            buttons.add(lb);
        }
        //köv honap labelje, teszt vége
        
        for(int i=0; i<buttons.size(); i++) {
            napokPanel.add(buttons.get(i));
        }
        
        //ha a számlalista nem üres, akkor inicilizálja a kijelölést
        for(Szamla sz: szamlak) {
            hataridotKijelol(sz);
        }
    }
    
    /**
     * Kijelöli a számlához tartozó befizetési határidő napját
     * a naptáron
     * @param szamla 
     */
    public void hataridotKijelol(Szamla szamla) {
        for(JComponent c : buttons) {
            if(c instanceof NapButton && ((NapButton)c).getText().equals(
                Integer.toString(szamla.getBefizetesHatarido().getDayOfMonth()))) {
                ((NapButton)c).setBackground(GuiUtils.parseColor(szamla.getKijeloles()));
                ((NapButton)c).setKijelolve(true);
                ((NapButton)c).addActionListener(this);
            }
        }
    }
    
    public void setHataridoKijeloltSzamla(Szamla szamla) {
        for(JComponent c: buttons) {
            if(c instanceof NapButton) {
                NapButton nb = ((NapButton)c);
                int nap = Integer.parseInt(nb.getText());
                if(nap == szamla.getBefizetesHatarido().getDayOfMonth() || 
                        (nap == most.getDayOfMonth() && 
                        lblHonapNeve.getText().equals(most.getMonth().toString()))) {
                    c.setBorder(BorderFactory.createLineBorder(kijelolt, 1));
                } else {
                    c.setBorder(BorderFactory.createEmptyBorder());
                }
            }
        }
    }
    
    public void clearHataridoKijeloltSzamlak() {
        for(JComponent c: buttons) {
            if(c instanceof NapButton) {
                NapButton nb = ((NapButton)c);
                int nap = Integer.parseInt(nb.getText());
                if(nap == most.getDayOfMonth()) {
                    c.setBorder(BorderFactory.createLineBorder(kijelolt, 1));
                } else {
                    c.setBorder(BorderFactory.createEmptyBorder());
                }
            }
        }
    }

    public void setSzamlak(List<Szamla> szamlak) {
        this.szamlak = szamlak;
        initMe();
        revalidate();
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        NapButton b = ((NapButton)event.getSource());
        if(b.isKijelolve()) {
            Szamla sz = getSzamlaByNap(Integer.parseInt(b.getText()));
            if(sz != null) {
                JOptionPane.showMessageDialog(this, sz.getMegjelenoNev()+" számlának befizetési határideje","Befizetés ideje",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
    
    private Szamla getSzamlaByNap(int nap) {
        for(Szamla sz: szamlak) {
            if(sz.getBefizetesHatarido().getDayOfMonth() == nap) {
                return sz;
            }
        }
        return null;
    }
}
