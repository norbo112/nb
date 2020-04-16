package com.norbo.projects.progj18edzesnaplo.sugo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

/**
 * súgó ablakot megvalósító osztály
 * @author igloi
 */
public class SugoDialog extends JPanel {
    private HelpFileParser helpFileParser;
    private JEditorPane editorPane;

    public SugoDialog() {
        initFrame();
    }

    private void initFrame() {
        initHelpFile();
        setLayout(new BorderLayout(5, 5));
        setPreferredSize(new Dimension(500, 400));
        setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        setBackground(new Color(0,102,204));
        
        JPanel topPanel = getTopPanel();
        JPanel centerPanel = getContextPanel();
        
        add(topPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
    }

    private JPanel getTopPanel() {
        JPanel panelTop = new JPanel(new BorderLayout());
        panelTop.setBackground(new Color(101,199,255));
        JTextArea taProgramInfo = new JTextArea(); //5,30
        taProgramInfo.setFont(new Font(Font.DIALOG, Font.PLAIN, 17));
        taProgramInfo.setEditable(false);
        Map<String, String> programinfo = helpFileParser.getPrograminfo();
        
        programinfo.entrySet().forEach(e -> {
            taProgramInfo.append(e.getKey()+": "+e.getValue()+"\n");
        });
        
        panelTop.add(new JScrollPane(taProgramInfo), BorderLayout.CENTER);
        
        return panelTop;
    }

    private void initHelpFile() {
        try {
            helpFileParser = new HelpFileParser();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Hiba a súgó megnyitásakor", "Súgó",
                    JOptionPane.ERROR_MESSAGE);
            setVisible(false);
        }
    }

    private JPanel getContextPanel() {
        JPanel centerpanel = new JPanel(new BorderLayout());
        
        JPanel links = makeLinksPanel();
        links.setBackground(new Color(101,199,255));
        
        centerpanel.add(links, BorderLayout.WEST);
        
        editorPane = new JEditorPane();
        editorPane.setPreferredSize(new Dimension(100, 100));
        editorPane.setContentType("text/html");
        editorPane.setText("<h1>Üdvözlet az Edzésnaplóban!</h1><p>Bal oldalon választhatsz néhány <i>leírásból</i></p>");
        editorPane.setEditable(false);
        centerpanel.add(new JScrollPane(editorPane), BorderLayout.CENTER);
        
        return centerpanel;
    }

    private JPanel makeLinksPanel() {
        GridBagLayout gridLayout = new GridBagLayout();
        JPanel panel = new JPanel(new BorderLayout());
        
        JPanel links = new JPanel(gridLayout);
        GridBagConstraints gbc = new GridBagConstraints();
        List<String> helplinks = helpFileParser.getHelplinks();
        gbc.gridx = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        for (int i = 0; i < helplinks.size(); i++) {
            gbc.gridy = i;
            JButton b = new JButton(helplinks.get(i));
            b.addActionListener(buttonLinkListener);
            links.add(b, gbc);
        }
        
        panel.add(new JScrollPane(links), BorderLayout.NORTH);
        return panel;
    }
    
    ActionListener buttonLinkListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String linkparam = e.getActionCommand();
            editorPane.setText(helpFileParser.getHelpcontext().get(linkparam));
        }
    };
//    
//    HyperlinkListener linkListener = new HyperlinkListener() {
//        @Override
//        public void hyperlinkUpdate(HyperlinkEvent e) {
//            if(e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
//                
//            }
//        }
//    }
    
    public static void main(String[] args) {
        System.out.println("Help Dialog TEst");
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Help Dialog test");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.add(new SugoDialog());
            frame.pack();
            frame.setVisible(true);
        });
    }
}
