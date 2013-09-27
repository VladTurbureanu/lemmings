package edu.rug.gogp.patrik.lemmings.model;

import edu.rug.gogp.patrik.lemmings.AddressElement;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Rik Schaaf
 */
public class FieldMap implements Serializable {
    private ArrayList<AddressElement> serverAdresses = new ArrayList<>();

    public synchronized void addServer(String serverName, int serverPort) {
        AddressElement newElement = new AddressElement(serverName, serverPort);
        serverAdresses.add(newElement);
    }

    public void addServer(AddressElement address) {
        addServer(address.getServerName(), address.getServerPort());
    }

    public synchronized boolean hasServer(String serverName, int serverPort) {
        for (AddressElement linkedElement : serverAdresses) {
            if (linkedElement.hasServerName(serverName)) {
                if (linkedElement.hasServerPort(serverPort)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean hasServer(AddressElement address) {
        return hasServer(address.getServerName(), address.getServerPort());
    }

    public ArrayList<AddressElement> getServerAddresses() {
        return serverAdresses;
    }

    public void setServerAddresses(ArrayList<AddressElement> addresses) {
        serverAdresses = addresses;
    }

    public synchronized void union(FieldMap fieldMap) {
        for (AddressElement addressElement : fieldMap.getServerAddresses()) {
            if (!hasServer(addressElement)) {
                addServer(addressElement);
            }
        }
    }
}
