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
    private static final int SLEEP = 2;
    private static final int[] POSIBLE_ACTIONS = {GET_CHILD, MOVE, SLEEP};
    private int lemmingNo;

    public Lemming(Field birthField) {
        this.currentField = birthField.getFieldAddress();
        fieldMap = new FieldMap();
        fieldMap.union(birthField.getFieldMap());
        this.birthPlace = birthField.getFieldName();
        this.start();
    }

    public AddressElement getCurrentField() {
        return currentField;
    }

    public synchronized boolean move(AddressElement fieldToAddress) {
        FieldConnector fieldToConnector = new FieldConnector(fieldToAddress);
        FieldConnector currentFieldConnector = new FieldConnector(currentField);
        FieldMap serverMap = currentFieldConnector.getFieldMap();
        currentFieldConnector.removeLemming(this);
        fieldMap.union(serverMap);
        if (!fieldToConnector.send(this)) {
            currentFieldConnector.closeConnection();
            fieldToConnector.closeConnection();
            return false;
        }
        fieldToConnector.setFieldMap(fieldMap);
        currentField = fieldToAddress;
        fieldToConnector.closeConnection();
        currentFieldConnector.closeConnection();
        return true;
    }

    @Override
    public String toString() {
        return "Lemming born in " + birthPlace + ":" + lemmingNo;
    }

    @Override
    public synchronized void run() {
        while (true) {
            Random rand = new Random();
            try {
                this.wait(rand.nextInt(2000) + 1000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            int randomAction = rand.nextInt(POSIBLE_ACTIONS.length);
            switch (randomAction) {
                case GET_CHILD:
                    System.out.println("a baby! " + birthPlace + ":" + lemmingNo);
                    FieldConnector currentFieldConnector = new FieldConnector(currentField);
                    if (!currentFieldConnector.askForChild(this)) {
                        System.out.println("need to make place for my baby " + birthPlace + ":" + lemmingNo);
                        currentFieldConnector.closeConnection();
                        return;
                    }
                    currentFieldConnector.closeConnection();
                    break;
                case MOVE:
                    System.out.println("Time to Move: " + birthPlace + ":" + lemmingNo);
                    int randomField = rand.nextInt(fieldMap.getServerAddresses().size());
                    if (!fieldMap.getServerAddress(randomField).equals(currentField)) {
                        System.out.println("found another field! " + birthPlace + ":" + lemmingNo);
                        if (!move(fieldMap.getServerAddress(randomField))) {
                            System.out.println("this field is full :( " + birthPlace + ":" + lemmingNo);
                            return;
                        }
                    }
                    break;
                case SLEEP:
                    System.out.println("i feel sleepy: " + birthPlace + ":" + lemmingNo);
                    try {
                    this.wait(rand.nextInt(10000));
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                    break;
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
            if (lemming.getLemmingNo() == lemmingNo) {
                return true;
            }
        }
        return false;
    }

    private String getBirthPlace() {
        return birthPlace;
    }

    public final void initLemmingNo(int lemmingNo) {
        this.lemmingNo = lemmingNo;
    }

    private int getLemmingNo() {
        return lemmingNo;
    }

    @Override
    public int hashCode() {
        return 1;
    }

}
