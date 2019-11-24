/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.norbo.projects.progj18edzesnaplo.dodata.sorozat;

import com.norbo.projects.progj18edzesnaplo.data.naplo.Sorozat;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author igloi
 */
public class ObjTransform implements SorozatTransform<String>{

    @Override
    public boolean ment(List<Sorozat> sorozats, String path) {
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path))) {
            out.writeObject(sorozats);
            return true;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ObjTransform.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ObjTransform.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public List<Sorozat> betolt(String path) {
        List<Sorozat> sorozat = null;
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(path))) {
            return (List<Sorozat>) in.readObject();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ObjTransform.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ObjTransform.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ObjTransform.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
