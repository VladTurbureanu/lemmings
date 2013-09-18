package edu.rug.gogp.patrik.lemmings;

import edu.rug.gogp.patrik.lemmings.field.Field;
import edu.rug.gogp.patrik.lemmings.field.FieldConnector;
import java.io.Serializable;

/**
 *
 * @author Rik Schaaf
 */
public class Lemming extends Thread implements Serializable {
    public void verhuis(Field field){
        FieldConnector fc = new FieldConnector(Integer.parseInt(field.getPort()));
        fc.send(this);
    }

    @Override
    public String toString() {
        return "Lemming!";
    }
    
    
}
