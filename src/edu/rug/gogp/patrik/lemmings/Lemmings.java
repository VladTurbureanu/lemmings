/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.rug.gogp.patrik.lemmings;

import edu.rug.gogp.patrik.lemmings.field.Field;
import edu.rug.gogp.patrik.lemmings.view.FieldView;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author s2288842
 */
public class Lemmings {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         Field field;
         Field field2;
        try {
            field = new Field(25565);
            Thread t = new Thread(field);
            t.start();
            field2 = new Field(25566);
            Thread t2 = new Thread(field2);
            t2.start();
            FieldView fv = new FieldView(field);
            
            FieldView fv2 = new FieldView(field2);
            fv.setVisible(true);
            fv2.setVisible(true);
            field.dummy2();
            field2.dummy2();
            Lemming l = new Lemming();
            l.verhuis(field2);
        } catch (IOException ex) {
            Logger.getLogger(Lemmings.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
