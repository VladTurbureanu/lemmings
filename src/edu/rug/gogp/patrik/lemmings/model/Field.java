package edu.rug.gogp.patrik.lemmings.model;

import edu.rug.gogp.patrik.lemmings.AddressElement;
import edu.rug.gogp.patrik.lemmings.controller.FieldConnector;
import edu.rug.gogp.patrik.lemmings.controller.InputHandler;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.Observable;
import java.util.Set;

/**
 *
 * @author s2288842
 */
public class Field extends Observable implements Runnable {

    private int capacity = 10;
    private ServerSocket serverSocket;
    private FieldMap fieldMap;
    private Set<Lemming> lemmings = new HashSet<>();
    private String name;
    private int counter = 1;
    private int deadLemming = 0;

    public Field(int serverPort, String name) throws IOException {
        this.serverSocket = new ServerSocket(serverPort);
        fieldMap = new FieldMap();
        fieldMap.addServer(getFieldAddress());
        this.name = name;
    }

    public synchronized int getCounter() {
        return counter;
    }

    public synchronized void incCounter() {
        this.counter++;
    }

    public String getCapacity() {
        return capacity + "";
    }

    public String getAddress() {
        return serverSocket.getInetAddress().getHostAddress();
    }

    public String getPort() {
        return serverSocket.getLocalPort() + "";
    }

    public int getPortAsInteger() {
        return serverSocket.getLocalPort();
    }

    public String getNumberOfLemmings() {
        return lemmings.size() + "";
    }

    public String getDeadLemmings() {
        return deadLemming + "";
    }

    public synchronized String getLemmingsListing() {
        String returnString = "";
        for (Lemming lemming : lemmings) {
            returnString += lemming.toString() + "\n";
        }
        return returnString;
    }

    public synchronized String getFieldsListing() {
        String returnString = "";
        for (AddressElement addressElement : fieldMap.getServerAddresses()) {
            FieldConnector fc = new FieldConnector(addressElement);
            returnString += fc.getName() + "\n";
            fc.closeConnection();
        }
        return returnString;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Socket incoming = serverSocket.accept();
                Thread t = new InputHandler(incoming, this);
                t.start();
            }
        } catch (IOException ex) {
            System.out.println("A connection could not be established");
            System.out.println(ex.getCause() + "\n" + ex.getMessage() + "\n" + ex.fillInStackTrace());
            ex.printStackTrace();
        }
    }

    public FieldMap getFieldMap() {
        return fieldMap;
    }

    public synchronized boolean addLemming(Lemming lemming) {
        if (lemmings.size() >= capacity) {
            deadLemming++;
            return false;
        }
        lemmings.add(lemming);
        this.setChanged();
        this.notifyObservers();
        return true;
    }

    public synchronized void removeLemming(Lemming lemming) {
        lemmings.remove(lemming);
        this.setChanged();
        this.notifyObservers();
    }

    public synchronized void unionFieldMap(FieldMap fieldMap) {
        this.fieldMap.union(fieldMap);
        this.setChanged();
        this.notifyObservers();
    }

    public AddressElement getFieldAddress() {
        return new AddressElement(getAddress(), getPortAsInteger());
    }

    public String getFieldName() {
        return name;
    }

    public synchronized boolean newClild(Lemming lemming) {
        Lemming newLemming = new Lemming(this);
        newLemming.initLemmingNo(counter);
        lemmings.add(newLemming);
        counter++;
        if (lemmings.size() > capacity) {
            lemmings.remove(lemming);
            deadLemming++;
            this.setChanged();
            this.notifyObservers();
            return false;
        }
        this.setChanged();
        this.notifyObservers();
        return true;
    }

    public synchronized void addServer(AddressElement fieldAddress) {
        FieldMap newFM = new FieldMap();
        newFM.addServer(fieldAddress);
        fieldMap.union(newFM);
        this.setChanged();
        this.notifyObservers();
    }
}
