package edu.rug.gogp.patrik.lemmings.model;

import edu.rug.gogp.patrik.lemmings.AddressElement;
import edu.rug.gogp.patrik.lemmings.controller.FieldConnector;
import java.io.Serializable;

/**
 *
 * @author Rik Schaaf
 */
public class Lemming extends Thread implements Serializable {

    private FieldMap fieldMap;
    private FieldConnector currentField;
    
    public void verhuis(Field fieldTo) {
        FieldConnector fc = new FieldConnector(Integer.parseInt(fieldTo.getPort()));
        FieldMap serverMap = fc.getFieldMap();
        for (AddressElement addressElement : serverMap.getServerAddresses()) {
            if (!fieldMap.hasServer(addressElement)) {
                fieldMap.addServer(addressElement);
            }
        }
        fc.send(this);
    }

    @Override
    public String toString() {
        return "Lemming!";
    }
}
