package edu.rug.gogp.patrik.lemmings.controller;

import edu.rug.gogp.patrik.lemmings.Lemming;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author Rik Schaaf
 */
public class FieldConnector {

    Socket s;
    private String address = "localhost";
    private int port;

    public FieldConnector(int port) {
        this.port = port;
    }

    public void send(Lemming lemming) {
        try {
            s = new Socket(address, port);
            ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
            out.writeObject(lemming);
        } catch (UnknownHostException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
