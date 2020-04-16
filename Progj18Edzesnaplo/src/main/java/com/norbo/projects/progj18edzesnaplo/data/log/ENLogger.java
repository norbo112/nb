package com.norbo.projects.progj18edzesnaplo.data.log;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.logging.XMLFormatter;

/**
 * Saját log fájl írásakor használt Logger osztály
 * @author igloi
 */
public class ENLogger {
    private static final Logger LOGG = Logger.getLogger("EDZESNAPLO");
    private static Handler handler;
//    private final Map<String, String> parameterek;
    
//    public ENLogger(Map<String, String> params) {
//        this.parameterek = params;
//        init();
//    }

    static {
        boolean consolelog = false;
        
        LOGG.setUseParentHandlers(false);
        LOGG.setLevel(Level.FINEST);

        try {
            //handler = new FileHandler(parameterek.get("logfile"), true);
            handler = new FileHandler(System.getProperty("user.home")+"/ennaplo.html", false);
        } catch (SecurityException | IOException e) {
            handler = new ConsoleHandler();
            consolelog = true;
        }
        
        handler.setFormatter(new HTMLFormatter());
        try {
            handler.setEncoding("UTF-8");
        } catch (SecurityException | UnsupportedEncodingException ex) {
            Logger.getLogger(ENLogger.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        LOGG.addHandler(handler);
        if(consolelog) {
            LOGG.warning("Nem lehetett inicializálni a napló fájlt...");
        }
    }
    
    public static void loginfo(String msg) {
        LOGG.log(Level.INFO, msg);
    }
    
    public static void logex(String msg, Exception ex) {
        LOGG.log(Level.SEVERE, msg, ex);
    }
}
