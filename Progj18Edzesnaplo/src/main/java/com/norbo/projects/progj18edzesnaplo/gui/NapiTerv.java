/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.norbo.projects.progj18edzesnaplo.gui;

import com.norbo.projects.progj18edzesnaplo.data.IGyakorlat;
import com.norbo.projects.progj18edzesnaplo.data.naplo.IdopontTableModel;
import com.norbo.projects.progj18edzesnaplo.data.naplo.MultiLineCellRenderer;
import com.norbo.projects.progj18edzesnaplo.data.naplo.MultiListCellRenderer;
import com.norbo.projects.progj18edzesnaplo.data.naplo.Sorozat;
import com.norbo.projects.progj18edzesnaplo.data.naplo.SorozatInterface;
import com.norbo.projects.progj18edzesnaplo.data.naplo.SorozatTableModel;
import com.norbo.projects.progj18edzesnaplo.data.naplo.diagram.GyakorlatDiagramInfo;
import com.norbo.projects.progj18edzesnaplo.data.naplo.diagram.GyakorlatDiagramTableModel;
import com.norbo.projects.progj18edzesnaplo.data.naplo.mentettnaplo.MentettNaplok;
import com.norbo.projects.progj18edzesnaplo.dodata.sorozat.ExcelSorozatTransform;
import com.norbo.projects.progj18edzesnaplo.dodata.sorozat.JsonSorozatTransform;
import com.norbo.projects.progj18edzesnaplo.dodata.sorozat.ObjTransform;
import com.norbo.projects.progj18edzesnaplo.dodata.sorozat.SorozatMento;
import com.norbo.projects.progj18edzesnaplo.gui.gyakorlatok.Gyakorlatok;
import com.norbo.projects.progj18edzesnaplo.gui.tapanyagtabla.TapanyagDialog;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.filechooser.FileFilter;
import org.json.JSONException;

/**
 *
 * @author igloi
 */
public class NapiTerv extends javax.swing.JFrame implements Gyakorlatok.GyakorlatValaszto {
    private final String VALASSZ = "válassz...";
    
    private List<IGyakorlat> gyakorlatList;
    private List<String> izomcsList;
    private SorozatTableModel sajatTableModel;
    private Sorozat actualSorozat;
    
    private int suly;
    private int ismetles;
    //timerhez
    private int minute = 0;
    private int second = 0;
    private IdopontTableModel sajatIdopontModel;
    
    private class MappaFileFilter extends FileFilter {
    
        @Override
        public boolean accept(File f) {
            return f.isDirectory();
        }

        @Override
        public String getDescription() {
            return "Csak mappákat lehet kijelölni, a mentés helyeként";
        }
    }
    
    private class SajatAdatFileFilter extends FileFilter {
    
        @Override
        public boolean accept(File f) {
            return f.getName().endsWith("_edzesnap.npl");
        }

        @Override
        public String getDescription() {
            return "_edzesnap.dat fájlok kijelölése";
        }
    }
    
    private class JsonFileFilter extends FileFilter {
    
        @Override
        public boolean accept(File f) {
            return f.getName().endsWith(".json");
        }

        @Override
        public String getDescription() {
            return "JSON fájlok megnyitása...";
        }
    }
    
    private class ExcelFileFilter extends FileFilter {
    
        @Override
        public boolean accept(File f) {
            return f.getName().endsWith(".xlsx");
        }

        @Override
        public String getDescription() {
            return "Excel fájlok megnyitása...";
        }
    }
    
    Timer stopper = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            second++;
            if(second == 60) {
                minute++;
                second = 0;
            }
            
            if(minute == 60) minute = 0;
            lblStopper.setText((Integer.toString(minute).length()==1 ? 0+""+minute : minute) + ":" + 
                    (Integer.toString(second).length()==1 ? 0+""+second : second));
        }
    });
    
    /**
     * Creates new form NapiTerv
     * @param gyklist Betöltött gyakorlat lista
     * @param izomcsoports gyakorlatlista alapján elkészített izomcsoport lista
     */
    public NapiTerv(List<IGyakorlat> gyklist, List<String> izomcsoports) {
        this.izomcsList = izomcsoports;
        this.gyakorlatList = gyklist;
        initComponents();
        
        setIconImage(new ImageIcon(getClass().getClassLoader().getResource("enlogo.png")).getImage());
        
        initMyCumok();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sorozatTablePopup = new javax.swing.JPopupMenu();
        tableMenuRemove = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        tableMenuOsszesTorol = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        cbGyakorlatLista = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        textSuly = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        textIsm = new javax.swing.JTextField();
        btnHozzaad = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        cbIzomcsoportLista = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        lblStopper = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        sorozatTable = new javax.swing.JTable();
        lblOsszes = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        idopontokTable = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuMentes = new javax.swing.JMenuItem();
        menuBetoltes = new javax.swing.JMenuItem();
        jSeparator3 = new javax.swing.JPopupMenu.Separator();
        jMenu5 = new javax.swing.JMenu();
        importJsonMenu = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        excelImportMenu = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        naplokMenu = new javax.swing.JMenuItem();
        menuDiagram = new javax.swing.JMenuItem();
        jSeparator4 = new javax.swing.JPopupMenu.Separator();
        menuTapanyagTabla = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();

        tableMenuRemove.setText("Sorozat törlése");
        tableMenuRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tableMenuRemoveActionPerformed(evt);
            }
        });
        sorozatTablePopup.add(tableMenuRemove);
        sorozatTablePopup.add(jSeparator2);

        tableMenuOsszesTorol.setText("Mind töröl");
        tableMenuOsszesTorol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tableMenuOsszesTorolActionPerformed(evt);
            }
        });
        sorozatTablePopup.add(tableMenuOsszesTorol);

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Edzésnapló");
        setBackground(new java.awt.Color(0, 0, 0));

        jPanel1.setBackground(new java.awt.Color(0, 102, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));

        jPanel2.setBackground(new java.awt.Color(48, 108, 147));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Vezérlő", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel2.setForeground(new java.awt.Color(0, 0, 0));

        jPanel4.setBackground(new java.awt.Color(136, 207, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Gyakorlat hozzáadása", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(0, 0, 0))); // NOI18N
        jPanel4.setForeground(new java.awt.Color(0, 0, 0));

        cbGyakorlatLista.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbGyakorlatLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbGyakorlatListaActionPerformed(evt);
            }
        });

        jLabel1.setText("Súly");

        textSuly.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        textSuly.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textSuly.setActionCommand("<Not Set>");
        textSuly.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textSulyActionPerformed(evt);
            }
        });

        jLabel2.setText("Ismétlés");

        textIsm.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        textIsm.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        textIsm.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        textIsm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textIsmActionPerformed(evt);
            }
        });

        btnHozzaad.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.darkShadow"));
        btnHozzaad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/addicon.png"))); // NOI18N
        btnHozzaad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHozzaadActionPerformed(evt);
            }
        });

        btnClear.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.darkShadow"));
        btnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/removeicon.png"))); // NOI18N
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        cbIzomcsoportLista.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbIzomcsoportLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbIzomcsoportListaActionPerformed(evt);
            }
        });

        jLabel4.setText("Izomcsoport");

        jLabel5.setText("Gyakorlat");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbGyakorlatLista, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbIzomcsoportLista, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textSuly)
                            .addComponent(textIsm))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnHozzaad, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnClear, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbIzomcsoportLista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbGyakorlatLista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(textSuly)
                            .addComponent(btnHozzaad, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnClear, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(textIsm))
                        .addGap(26, 26, 26))))
        );

        jPanel5.setBackground(new java.awt.Color(101, 199, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Információ", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(0, 0, 0))); // NOI18N
        jPanel5.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 272, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 225, Short.MAX_VALUE)
        );

        jPanel8.setBackground(new java.awt.Color(136, 207, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Időmérő", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(0, 0, 0))); // NOI18N
        jPanel8.setForeground(new java.awt.Color(0, 0, 0));

        lblStopper.setBackground(new java.awt.Color(0, 102, 204));
        lblStopper.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        lblStopper.setForeground(new java.awt.Color(0, 0, 0));
        lblStopper.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStopper.setText("00:00");
        lblStopper.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblStopperMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblStopper, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addComponent(lblStopper, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(48, 108, 147));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Napi terv", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel3.setForeground(new java.awt.Color(126, 189, 247));

        jPanel6.setBackground(new java.awt.Color(101, 199, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sorozatok", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(0, 0, 0))); // NOI18N
        jPanel6.setForeground(new java.awt.Color(0, 0, 0));

        sorozatTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
            },
            new String [] {
                "Sorszám","Felvétel dátuma","Gyakorlat","Súly x Ismétlés","Időpont"
            }
        ));
        jScrollPane1.setViewportView(sorozatTable);

        lblOsszes.setForeground(new java.awt.Color(0, 0, 0));
        lblOsszes.setText("Összesen...");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 593, Short.MAX_VALUE)
                    .addComponent(lblOsszes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addGap(3, 3, 3)
                .addComponent(lblOsszes)
                .addContainerGap())
        );

        jPanel7.setBackground(new java.awt.Color(101, 199, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Időpontok", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 12), new java.awt.Color(0, 0, 0))); // NOI18N
        jPanel7.setForeground(new java.awt.Color(0, 0, 0));

        idopontokTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Sorszám","Gyakorlat","útolsó ismétlés"
            }
        ));
        jScrollPane2.setViewportView(idopontokTable);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jMenu1.setMnemonic('F');
        jMenu1.setText("Fájl");

        menuMentes.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        menuMentes.setText("Mentés");
        menuMentes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuMentesActionPerformed(evt);
            }
        });
        jMenu1.add(menuMentes);

        menuBetoltes.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        menuBetoltes.setText("Betöltés");
        menuBetoltes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuBetoltesActionPerformed(evt);
            }
        });
        jMenu1.add(menuBetoltes);
        jMenu1.add(jSeparator3);

        jMenu5.setText("Import");

        importJsonMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fjson.png"))); // NOI18N
        importJsonMenu.setText("JSON");
        importJsonMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                importJsonMenuActionPerformed(evt);
            }
        });
        jMenu5.add(importJsonMenu);

        jMenuItem10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fcsv.png"))); // NOI18N
        jMenuItem10.setText("CSV");
        jMenu5.add(jMenuItem10);

        excelImportMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fexcel.png"))); // NOI18N
        excelImportMenu.setText("Excel");
        excelImportMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                excelImportMenuActionPerformed(evt);
            }
        });
        jMenu5.add(excelImportMenu);

        jMenu1.add(jMenu5);

        jMenu4.setText("Export");

        jMenuItem6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fjson.png"))); // NOI18N
        jMenuItem6.setText("JSON");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem6);

        jMenuItem7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fcsv.png"))); // NOI18N
        jMenuItem7.setText("CSV");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem7);

        jMenuItem8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fexcel.png"))); // NOI18N
        jMenuItem8.setText("Excel");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem8);

        jMenu1.add(jMenu4);
        jMenu1.add(jSeparator1);

        jMenuItem5.setText("Kilépés");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuBar1.add(jMenu1);

        jMenu2.setMnemonic('A');
        jMenu2.setText("Ablak");

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem3.setText("Gyakorlatok");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        naplokMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.ALT_MASK));
        naplokMenu.setText("Naplók");
        naplokMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                naplokMenuActionPerformed(evt);
            }
        });
        jMenu2.add(naplokMenu);

        menuDiagram.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.ALT_MASK));
        menuDiagram.setText("Diagram");
        menuDiagram.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuDiagramActionPerformed(evt);
            }
        });
        jMenu2.add(menuDiagram);
        jMenu2.add(jSeparator4);

        menuTapanyagTabla.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.ALT_MASK));
        menuTapanyagTabla.setText("Tápanyagtábla");
        menuTapanyagTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuTapanyagTablaActionPerformed(evt);
            }
        });
        jMenu2.add(menuTapanyagTabla);

        jMenuBar1.add(jMenu2);

        jMenu3.setMnemonic('S');
        jMenu3.setText("Súgó");

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_I, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem4.setText("About");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem4);

        jMenuBar1.add(jMenu3);

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

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        new Gyakorlatok(this, gyakorlatList, izomcsList).showFrame();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void textIsmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textIsmActionPerformed
        String bevitel = textIsm.getText();
        if(! bevitel.matches("[0-9]+")) {
            JOptionPane.showMessageDialog(this, "Csak a számokat szeretem!");
        } else {
            ismetles = Integer.parseInt(bevitel);
            btnHozzaad.requestFocus();
        }
    }//GEN-LAST:event_textIsmActionPerformed

    private void textSulyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textSulyActionPerformed
        String bevitel = textSuly.getText();
        if(! bevitel.matches("[0-9]+")) {
            JOptionPane.showMessageDialog(this, "Csak a számokat szeretem!");
        } else {
            suly = Integer.parseInt(bevitel);
            textIsm.setText("");
            textIsm.requestFocus();
        }
    }//GEN-LAST:event_textSulyActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        textSuly.setText("");
        textIsm.setText("");
    }//GEN-LAST:event_btnClearActionPerformed

    private void cbIzomcsoportListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbIzomcsoportListaActionPerformed
        initGyakLista();
    }//GEN-LAST:event_cbIzomcsoportListaActionPerformed

    private void btnHozzaadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHozzaadActionPerformed
        stopperReset();
        if(! ellenorzes(textSuly, textIsm)) {
            JOptionPane.showMessageDialog(this, "Csak számokat tartalmazhat a suly és ismétlés mezők");
            return;
        } 
        
        IGyakorlat valasztott = getGyakorlatByName(cbGyakorlatLista.getSelectedItem().toString());
        Sorozat s = new Sorozat(valasztott);
        if(sajatTableModel.contains(s)) {
            if(!sajatTableModel.addSorozatAdat(valasztott, 
                    Integer.parseInt(textSuly.getText()), 
                    Integer.parseInt(textIsm.getText()))) {
                JOptionPane.showMessageDialog(null, "Nem sikerült frissíteni a sorozatot","Sorozat",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            s = new Sorozat(valasztott);
            s.setGyakRogzitesIdopontja(LocalDateTime.now());
            s.addIsm(Integer.parseInt(textIsm.getText()));
            s.addSuly(Integer.parseInt(textSuly.getText()));
            s.addIsmIdo(LocalTime.now());
            sajatTableModel.add(s);
        }
        
        //timer elindítása
        stopper.start();
        setOsszesenMegmozgatottSuly();
    }//GEN-LAST:event_btnHozzaadActionPerformed

    private void cbGyakorlatListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbGyakorlatListaActionPerformed

    }//GEN-LAST:event_cbGyakorlatListaActionPerformed

    private void tableMenuRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tableMenuRemoveActionPerformed
        int index = sorozatTable.getSelectedRow();
        if(index != -1) {
            sajatTableModel.removeSorozatRow(index);
        } else {
            JOptionPane.showMessageDialog(null, "Válaszd ki a törlendő sort!","Sorozat",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_tableMenuRemoveActionPerformed

    private void tableMenuOsszesTorolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tableMenuOsszesTorolActionPerformed
        sajatTableModel.removeAllSorozat();
    }//GEN-LAST:event_tableMenuOsszesTorolActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        if(JOptionPane.showConfirmDialog(this, "Biztosan ki akarsz lépni?","Kilépés",JOptionPane.YES_NO_OPTION) == 
                JOptionPane.OK_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private boolean exportToJSON() throws HeadlessException {
        List<SorozatInterface> sorlist = sajatTableModel.getSorozat();
        if (sorlist.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nincs mit menteni!","Export - Mentés",
                    JOptionPane.ERROR_MESSAGE);
            return true;
        }
        SorozatMento<String> sorozatMento = new SorozatMento<>(new JsonSorozatTransform(), sorlist);
        JFileChooser jfc = new JFileChooser(userDir);
        jfc.setFileFilter(new MappaFileFilter());
        if(jfc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            sorozatMento.ment(jfc.getSelectedFile().toString()+".json");
            JOptionPane.showMessageDialog(null, "Sikeres export!","Export - Mentés",
                    JOptionPane.INFORMATION_MESSAGE);
        }
        return false;
    }

    private void exportToCSV() throws HeadlessException {
        JOptionPane.showMessageDialog(this, "Még fejlesztés alatt áll","Funkció",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private boolean exportToExcel() throws HeadlessException {
        List<SorozatInterface> sorlist = sajatTableModel.getSorozat();
        if (sorlist.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nincs mit menteni!","Export - Mentés",
                    JOptionPane.ERROR_MESSAGE);
            return true;
        }
        SorozatMento<File> sorozatMento = new SorozatMento<>(
                new ExcelSorozatTransform(), sorlist);
        JFileChooser jfc = new JFileChooser(userDir);
        jfc.setFileFilter(new MappaFileFilter());
        if(jfc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            sorozatMento.ment(jfc.getSelectedFile());
            JOptionPane.showMessageDialog(null, "Sikeres export!","Export - Mentés",
                    JOptionPane.INFORMATION_MESSAGE);
        }
        return false;
    }

    private void menuMentesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuMentesActionPerformed
        // TODO kimentem objectstreammel a sorozatok listáját, napidatum_edzesnap.dat néven
        List<SorozatInterface> sorlist = sajatTableModel.getSorozat();
        if(sorlist.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nincs mit menteni!","Export - Mentés",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        JFileChooser jfc = new JFileChooser(userDir);
        jfc.setFileFilter(new MappaFileFilter());
        if(jfc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            String mappa = jfc.getSelectedFile().getAbsolutePath();
            mappa += "_"+LocalDate.now()+"_edzesnap.npl";
            
            //SorozatMento<String> sorozatMento = new SorozatMento<>(new ObjTransform(), sorlist);
            SorozatMento<String> sorozatMento = new SorozatMento<>(new JsonSorozatTransform(),
                sorlist);
            if(sorozatMento.ment(mappa)) {
                JOptionPane.showMessageDialog(null, "Sikeres mentés!","Export - Mentés",
                    JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }//GEN-LAST:event_menuMentesActionPerformed

    private void menuBetoltesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuBetoltesActionPerformed
        JFileChooser jfc = new JFileChooser(userDir);
        jfc.setFileFilter(new SajatAdatFileFilter());
        if(jfc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
//            List<SorozatInterface> sorlist = 
//                    new ObjTransform().betolt(jfc.getSelectedFile().getAbsolutePath());
            List<SorozatInterface> sorlist = 
                    new JsonSorozatTransform().betolt(jfc.getSelectedFile().getAbsolutePath());
            if(sorlist != null) {
                sajatTableModel.setSorozatok(sorlist);
                setOsszesenMegmozgatottSuly();
            } else {
                JOptionPane.showMessageDialog(null, "Sikertelen fájl betöltés!","Betöltés...",
                    JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_menuBetoltesActionPerformed
    private final String userDir = System.getProperty("user.dir");

    private void lblStopperMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblStopperMouseClicked
        stopper.stop();
        lblStopper.setText("00:00");
    }//GEN-LAST:event_lblStopperMouseClicked

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        //AboutDialog.showDialog();
        HelpDialog.showHelpDialog();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        exportToJSON();
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        exportToCSV();
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        exportToExcel();
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void importJsonMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_importJsonMenuActionPerformed
        JFileChooser jfc = new JFileChooser(userDir);
        jfc.setFileFilter(new JsonFileFilter());
        if(jfc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            try {
                List<SorozatInterface> sorlist = new JsonSorozatTransform().betolt(jfc.getSelectedFile().getAbsolutePath());
                if (sorlist != null) {
                    sajatTableModel.setSorozatok(sorlist);
                    setOsszesenMegmozgatottSuly();
                } else {
                    JOptionPane.showMessageDialog(null, "Sikertelen fájl betöltés!", "Betöltés...",
                            JOptionPane.ERROR_MESSAGE);
                }
            } catch (JSONException e) {
                JOptionPane.showMessageDialog(this, "JSON formátum hiba\n "+e.getMessage(),"Hiba",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_importJsonMenuActionPerformed

    private void excelImportMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_excelImportMenuActionPerformed
        JFileChooser jfc = new JFileChooser(userDir);
        jfc.setFileFilter(new ExcelFileFilter());
        if(jfc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            List<SorozatInterface> sorlist = new ExcelSorozatTransform().betolt(jfc.getSelectedFile());
            if (sorlist != null) {
                sajatTableModel.setSorozatok(sorlist);
                setOsszesenMegmozgatottSuly();
            } else {
                JOptionPane.showMessageDialog(null, "Sikertelen fájl betöltés!", "Betöltés...",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_excelImportMenuActionPerformed

    private void naplokMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_naplokMenuActionPerformed
        MentettNaplok.showDialog(this);
    }//GEN-LAST:event_naplokMenuActionPerformed

    private void menuDiagramActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuDiagramActionPerformed
        GyakorlatDiagramInfo.showDialog(this, gyakorlatList);
    }//GEN-LAST:event_menuDiagramActionPerformed

    private void menuTapanyagTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuTapanyagTablaActionPerformed
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                TapanyagDialog tp = new TapanyagDialog(new JFrame(), true);
                tp.setVisible(true);
            }
        });
    }//GEN-LAST:event_menuTapanyagTablaActionPerformed

    /**
     * 
     */
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
            java.util.logging.Logger.getLogger(NapiTerv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NapiTerv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NapiTerv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NapiTerv.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnHozzaad;
    private javax.swing.JComboBox<String> cbGyakorlatLista;
    private javax.swing.JComboBox<String> cbIzomcsoportLista;
    private javax.swing.JMenuItem excelImportMenu;
    private javax.swing.JTable idopontokTable;
    private javax.swing.JMenuItem importJsonMenu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JPopupMenu.Separator jSeparator3;
    private javax.swing.JPopupMenu.Separator jSeparator4;
    private javax.swing.JLabel lblOsszes;
    private javax.swing.JLabel lblStopper;
    private javax.swing.JMenuItem menuBetoltes;
    private javax.swing.JMenuItem menuDiagram;
    private javax.swing.JMenuItem menuMentes;
    private javax.swing.JMenuItem menuTapanyagTabla;
    private javax.swing.JMenuItem naplokMenu;
    private javax.swing.JTable sorozatTable;
    private javax.swing.JPopupMenu sorozatTablePopup;
    private javax.swing.JMenuItem tableMenuOsszesTorol;
    private javax.swing.JMenuItem tableMenuRemove;
    private javax.swing.JTextField textIsm;
    private javax.swing.JTextField textSuly;
    // End of variables declaration//GEN-END:variables

    private void initMyCumok() {
        sajatTableModel = new SorozatTableModel();
        sajatIdopontModel = new IdopontTableModel();
        idopontokTable.setModel(sajatIdopontModel);
        sorozatTable.setModel(sajatTableModel);
        sorozatTable.setDefaultRenderer(String.class, new MultiLineCellRenderer());
//        sorozatTable.setDefaultRenderer(String[].class, new MultiListCellRenderer());
        sajatTableModel.addTableModelListener((event) -> {
            SwingUtilities.invokeLater(() -> {
                sajatIdopontModel.setSorozatok(sajatTableModel.getSorozat());
                for (int i = 0; i < sorozatTable.getRowCount(); i++) {
                    sorozatTable.setRowHeight(i, 16*sajatTableModel.getSorCount(i));
                }
            });
        });
        sorozatTable.setComponentPopupMenu(sorozatTablePopup);
        
        jScrollPane1.getViewport().setBackground(new Color(101,199,255));
        jScrollPane2.getViewport().setBackground(new Color(101,199,255));
        
        initIzomCsopLista();
    }

    private void initIzomCsopLista() {
        cbIzomcsoportLista.removeAllItems();
        izomcsList.sort((o1,o2)->o1.compareTo(o2));
        izomcsList.forEach(s -> cbIzomcsoportLista.addItem(s));
    }

    private void initGyakLista() {
        cbGyakorlatLista.removeAllItems();
        int index = cbIzomcsoportLista.getSelectedIndex();
        gyakorlatList.stream().filter((gyak) -> (gyak.getIzomcsoport().toString().equals(
        index != -1 ? izomcsList.get(index) : izomcsList.get(0)
        ))).forEachOrdered((gyak) -> {
            cbGyakorlatLista.addItem(gyak.getMegnevezes());
        });
        
        actualSorozat = new Sorozat(getGyakorlatByName(cbGyakorlatLista.getSelectedItem().toString()));
    }
    
    private void setOsszesenMegmozgatottSuly() {
        SwingUtilities.invokeLater(() -> {
            lblOsszes.setText("Összesen megmozgatott súly: "+sajatTableModel.getOsszSuly()+" kg");
        });   
    }

    private boolean ellenorzes(JTextField ...textfileds) {
        for (int i = 0; i < textfileds.length; i++) {
            JTextField textfiled = textfileds[i];
            if(!textfiled.getText().matches("[0-9]+") && textfiled.getText().length() <= 0) {
                return false;
            }
        }
        
        return true;
    }
    
    private IGyakorlat getGyakorlatByName(String gyaknev) {
        for (IGyakorlat iGyakorlat : gyakorlatList) {
            if(iGyakorlat.getMegnevezes().equals(gyaknev)) {
                return iGyakorlat;
            }
        }
        
        return null;
    }
    
    public void stopperReset() {
        stopper.stop();
        minute = 0;
        second = 0;
        lblStopper.setText("00:00");
    }

    @Override
    public void gyakKivalaszt(String izomcsop, String gyaknev) {
        cbIzomcsoportLista.setSelectedItem(izomcsop);
        cbGyakorlatLista.setSelectedItem(gyaknev);
    }
}
