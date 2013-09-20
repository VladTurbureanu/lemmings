package edu.rug.gogp.patrik.lemmings.model;

import edu.rug.gogp.patrik.lemmings.model.Field;
import edu.rug.gogp.patrik.lemmings.controller.FieldConnector;
import java.io.Serializable;

/**
 *
 * @author Rik Schaaf
 */
public class Lemming extends Thread implements Serializable {

    private FieldMap fieldMap;

    public void verhuis(Field fieldTo) {
        FieldConnector fc = new FieldConnector(Integer.parseInt(fieldTo.getPort()));
        fc.send(this);
    }

    @Override
    public String toString() {
        return "Lemming!";
    }
}
