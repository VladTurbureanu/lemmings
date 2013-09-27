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
            System.out.println(addressElement + ":" + address);
            if (addressElement.hasServerPort(address.getServerPort())) {
                if (addressElement.hasServerName(address.getServerName())) {
                    System.out.println("true");
                    return true;
                }
            }
        }
        System.out.println("false");
        return false;
    }

    public ArrayList<AddressElement> getServerAddresses() {
        return serverAdresses;
    }

    public void setServerAddresses(ArrayList<AddressElement> addresses) {
        serverAdresses = addresses;
    }

    public synchronized void union(FieldMap fieldMap) {
        System.out.println("\n\n:begin\n");
        for (AddressElement addressElement : serverAdresses) {
            System.out.println(addressElement);
        }
        for (AddressElement addressElement : fieldMap.getServerAddresses()) {
            if (!hasServer(addressElement)) {
                addServer(addressElement);
            }
        }
        System.out.println("\n\n:end\n");
        for (AddressElement addressElement : serverAdresses) {
            System.out.println(addressElement);
        }
    }
}
