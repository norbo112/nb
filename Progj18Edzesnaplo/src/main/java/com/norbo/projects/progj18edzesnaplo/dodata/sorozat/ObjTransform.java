package com.norbo.projects.progj18edzesnaplo.dodata.sorozat;

import com.norbo.projects.progj18edzesnaplo.data.naplo.SorozatInterface;
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
 * Ha nem exportáljuk az adatokat, akkor saját Adatforrást készítek el
 * ami Objectumot ment majd tölt be
 * @author igloi
 */
public class ObjTransform implements SorozatTransform<String>{

    @Override
    public boolean ment(List<SorozatInterface> sorozats, String path) {
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
    
    @Override
    public List<SorozatInterface> betolt(String path) {
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(path))) {
            return (List<SorozatInterface>) in.readObject();
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
