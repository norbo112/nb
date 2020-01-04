package com.norbo.projects.progj18edzesnaplo.sugo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.RowFilter;

/**
 *
 * @author igloi
 */
public final class HelpFileParser {
    private final String RESFILENAME = "sugo/sugo.help";
    
    private final String PROGRAM = "Program";
    private final String LINKS = "Links";
    
    private final Map<String, String> programinfo;
    private final List<String> helplinks;
    private final Map<String, String> helpcontext;
    
    public HelpFileParser() throws IOException {
        helplinks = getLinksFromRes();
        programinfo = getProgramInfoFromRes();
        helpcontext = getLinkContextFromRes();
    }
    
    /**
     * Felépíti a Linkekhez tartozó tartalmat, 
     * elöbb mindenképp felkell építenia linkek listáját
     * @return ContextList
     * @throws IOException 
     */
    private Map<String, String> getLinkContextFromRes() throws IOException {
        Map<String, String> context = new HashMap<>();
        
        InputStream input = getClass().getClassLoader().getResourceAsStream(RESFILENAME);
        BufferedReader br = new BufferedReader(new InputStreamReader(input, "UTF-8"));
        
        if(helplinks != null) {
            String line;
            while((line = br.readLine()) != null) {
                for(String s: helplinks) {
                    try {
                        if (line.equals("[" + s + "]")) {
                            StringBuilder sb = new StringBuilder();
                            while (!(line = br.readLine()).equals("[/" + s + "]")) {
                                sb.append(line);
                            }
                            context.put(s, sb.toString());
                        }
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
            input.close();
            br.close();
        } else {
            throw new IOException("Nem volt betöltve a link lista");
        }
        
        return context;
    }
    
    private Map<String, String> getProgramInfoFromRes() throws IOException {
        Map<String, String> pi = new HashMap<>();
        
        InputStream input = getClass().getClassLoader().getResourceAsStream(RESFILENAME);
        BufferedReader br = new BufferedReader(new InputStreamReader(input, "UTF-8"));
        
        String line;
        while((line = br.readLine()) != null) {
            if(line.equals("["+PROGRAM+"]")) {
                while(!(line = br.readLine()).equals("[/"+PROGRAM+"]")) {
                    String[] splitted = line.split("=");
                    pi.put(splitted[0], splitted[1]);
                }
            }
        }
        
        input.close();
        br.close();
        
        return pi;
    }
    
    private List<String> getLinksFromRes() throws IOException {
        List<String> lista = new ArrayList<>();
        InputStream input = getClass().getClassLoader().getResourceAsStream(RESFILENAME);
        
        BufferedReader br = new BufferedReader(new InputStreamReader(input, "UTF-8"));
        
        String line;
        while((line = br.readLine()) != null) {
            if(line.equals("["+LINKS+"]")) {
                while(!(line = br.readLine()).equals("[/"+LINKS+"]")) {
                    lista.add(line);
                }
            }
        }

        input.close();
        br.close();  
        
        return lista;
    }

    public Map<String, String> getPrograminfo() {
        return programinfo;
    }

    public List<String> getHelplinks() {
        return helplinks;
    }

    public Map<String, String> getHelpcontext() {
        return helpcontext;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Linkek és hozzá tartozó tartalmak").append("\n");
        for(Map.Entry e: helpcontext.entrySet()) {
            sb.append(e.getKey()).append("\n");
            sb.append("------------").append("\n");
            sb.append(e.getValue()).append("\n");
        }
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
        System.out.println("HelpFileParser test");
        System.out.println("");
        try {
            HelpFileParser helpFileParser = new HelpFileParser();
            System.out.println(helpFileParser);
            
        } catch (IOException ex) {
            Logger.getLogger(HelpFileParser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
