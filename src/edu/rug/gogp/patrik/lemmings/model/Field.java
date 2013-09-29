package edu.rug.gogp.patrik.lemmings.model;

import edu.rug.gogp.patrik.lemmings.AddressElement;
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

    private int capacity = 5;
    private ServerSocket serverSocket;
    private FieldMap fieldMap;
    private Set<Lemming> lemmings = new HashSet<>();
    private String name;
    private int counter;

    public Field(int serverPort, String name) throws IOException {
        this.serverSocket = new ServerSocket(serverPort);
        fieldMap = new FieldMap();
        fieldMap.addServer(getFieldAddress());
        this.name = name;
    }

    @Deprecated
    public void dummy2() {
        this.setChanged();
        this.notifyObservers();
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

    public String getLemmingsListing() {
        String returnString = "";
        for (Lemming lemming : lemmings) {
            returnString += lemming.toString() + "\n";
        }
        return returnString;
    }

    public String getFieldsListing() {
        String returnString = "";
        for (AddressElement addressElement : fieldMap.getServerAddresses()) {
            returnString += addressElement.toString() + "\n";
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
            ex.printStackTrace();
        }
    }

    public FieldMap getFieldMap() {
        return fieldMap;
    }

    @Deprecated
    public void addLemming(Lemming lemming) {
        lemmings.add(lemming);
        dummy2();
    }

    public synchronized void unionFieldMap(FieldMap fieldMap) {
        this.fieldMap.union(fieldMap);
        dummy2();
    }

    public AddressElement getFieldAddress() {
        return new AddressElement(getAddress(), getPortAsInteger());
    }

    public String getFieldName() {
        return name;
    }

    public synchronized boolean newClild() {
        System.out.println("hier");
        lemmings.add(new Lemming(this,counter));
        dummy2();
        if (lemmings.size() >= capacity) {
            return false;
        }
        return true;
    }
}
