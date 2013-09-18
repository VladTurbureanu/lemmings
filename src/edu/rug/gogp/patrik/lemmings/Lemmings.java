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
        try {
            field = new Field(25565);
            FieldView fv = new FieldView(field);
            fv.setVisible(true);
            field.dummy2();
        } catch (IOException ex) {
            Logger.getLogger(Lemmings.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
