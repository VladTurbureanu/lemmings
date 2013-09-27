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
    private AddressElement currentField;
    
    public Lemming(AddressElement address) {
        this.currentField = address;
        fieldMap = new FieldMap();
        fieldMap.addServer(address);
    }
    
    public synchronized void verhuis(Field fieldTo) {
        FieldConnector fieldToConnector = new FieldConnector(fieldTo.getFieldAddress());
        FieldConnector currentFieldConnector = new FieldConnector(currentField);
        FieldMap serverMap = currentFieldConnector.getFieldMap();
        fieldMap.union(serverMap);
        fieldToConnector.send(this);
        fieldToConnector.setFieldMap(fieldMap);
        currentField = fieldTo.getFieldAddress();
    }
    
    @Override
    public String toString() {
        return "Lemming!";
    }
}
