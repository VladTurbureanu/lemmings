/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.rug.gogp.patrik.lemmings;

import java.io.Serializable;

/**
 *
 * @author s2288842
 */
public class AddressElement implements Serializable{

    private String serverName;
    private Integer serverPort;

     public AddressElement(String serverName, Integer serverPort) {
        this.serverName = serverName;
        this.serverPort = serverPort;
    }
    
    public void setElement(String serverName, Integer serverPort) {
        this.serverName = serverName;
        this.serverPort = serverPort;
    }

    public boolean hasServerName(String serverName) {
        if (this.serverName.equals(serverName)) {
            return true;
        }
        return false;
    }

    public boolean hasServerPort(Integer serverPort) {
        if (this.serverPort.equals(serverPort)) {
            return true;
        }
        return false;
    }

    public String getServerName() {
        return serverName;
    }

    public Integer getServerPort() {
        return serverPort;
    }

    @Override
    public String toString() {
        return serverName + ":" + serverPort;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof AddressElement)) {
            return false;
        }
        AddressElement address = (AddressElement) obj;
        if (address.hasServerName(serverName)) {
            if (address.hasServerPort(serverPort)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return serverPort;
    }
    
    
    
}
