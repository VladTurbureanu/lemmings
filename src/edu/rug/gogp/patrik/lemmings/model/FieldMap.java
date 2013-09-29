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

  

    public synchronized void addServer(AddressElement address) {
       serverAdresses.add(address);
       
    }

    

    public synchronized boolean hasServer(AddressElement address) {
        for (AddressElement addressElement : serverAdresses) {
            if (addressElement.hasServerPort(address.getServerPort())) {
                if (addressElement.hasServerName(address.getServerName())) {
                    return true;
                }
            }
        }
        return false;
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

    public AddressElement getServerAddress(int randomField) {
        return serverAdresses.get(randomField);
    }
}
