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
    
    public void verhuis(Field fieldTo) {
        FieldConnector fieldToConnector = new FieldConnector(fieldTo.getFieldAddress());
        FieldConnector currentFieldConnector = new FieldConnector(currentField);
        System.out.println("verhuised!");
        FieldMap serverMap = currentFieldConnector.getFieldMap();
        System.out.println("verhuised!");
        fieldMap.union(serverMap);
        System.out.println("verhuised123!");
        fieldToConnector.send(this);
        System.out.println("verhuised!");
        fieldToConnector.setFieldMap(fieldMap);
        System.out.println("verhuised!");
    }
    
    @Override
    public String toString() {
        return "Lemming!";
    }
}
