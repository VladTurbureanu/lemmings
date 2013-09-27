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
        if (this.serverName == serverName) {
            return true;
        }
        return false;
    }

    public boolean hasServerPort(Integer serverPort) {
        if (serverPort == serverPort) {
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
}
