package edu.rug.gogp.patrik.lemmings.model;

import edu.rug.gogp.patrik.lemmings.AddressElement;
import edu.rug.gogp.patrik.lemmings.controller.FieldConnector;
import java.io.Serializable;
import java.util.Random;

/**
 *
 * @author Rik Schaaf
 */
public class Lemming extends Thread implements Serializable {

    private FieldMap fieldMap;
    private AddressElement currentField;
    private String birthPlace;
    private static final int GET_CHILD = 0;
    private static final int MOVE = 1;
    private static final int[] POSIBLE_ACTIONS = {GET_CHILD, MOVE};
    private int lemmingNo;

    public Lemming(Field birthField, int lemmingNo) {
        this.currentField = birthField.getFieldAddress();
        fieldMap = new FieldMap();
        fieldMap.addServer(birthField.getFieldAddress());
        this.lemmingNo = lemmingNo;
        this.birthPlace = birthField.getFieldName();
        this.start();
    }

    public synchronized void move(AddressElement fieldToAddress) {
        FieldConnector fieldToConnector = new FieldConnector(fieldToAddress);
        FieldConnector currentFieldConnector = new FieldConnector(currentField);
        FieldMap serverMap = currentFieldConnector.getFieldMap();
        fieldMap.union(serverMap);
        if(fieldToConnector.send(this)){
            
        }
        fieldToConnector.setFieldMap(fieldMap);
        currentField = fieldToAddress;
        fieldToConnector.closeConnection();
        currentFieldConnector.closeConnection();
    }

    @Override
    public String toString() {
        return "Lemming born in " + birthPlace + ":" + lemmingNo;
    }

    @Override
    public synchronized void run() {
        while (true) {
            Random rand = new Random();
            FieldConnector currentFieldConnector = new FieldConnector(currentField);
            int randomAction = rand.nextInt(POSIBLE_ACTIONS.length);
            switch (randomAction) {
                case GET_CHILD:
                    if (!currentFieldConnector.askForChild(this)) {
                    this.interrupt();
                    currentFieldConnector.closeConnection();
                    return;
                }
                    break;
                case MOVE:
                    int randomField = rand.nextInt(fieldMap.getServerAddresses().size());
                    if (fieldMap.getServerAddress(randomField) != currentField) {
                        move(fieldMap.getServerAddress(randomField));
                    }
                    break;
            }
            currentFieldConnector.closeConnection();
            try {
                this.wait(3000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Lemming)) {
            return false;
        }
        Lemming lemming = (Lemming) obj;
        if (lemming.getBirthPlace().equals(birthPlace)) {
            if (lemming.lemmingNo() == lemmingNo) {
                return true;
            }
        }
        return false;
    }

    private String getBirthPlace() {
        return birthPlace;
    }

    private int lemmingNo() {
        return lemmingNo;
    }

    @Override
    public int hashCode() {
        return 1;
    }

}
