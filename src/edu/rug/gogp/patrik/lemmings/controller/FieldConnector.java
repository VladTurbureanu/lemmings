package edu.rug.gogp.patrik.lemmings.controller;

import edu.rug.gogp.patrik.lemmings.model.Lemming;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author Rik Schaaf
 */
public class FieldConnector implements Serializable {

    private String address = "localhost";
    private int port;

    public FieldConnector(int port) {
        this.port = port;
    }

    public void send(Lemming lemming) {
        Socket s;
        try {
            s = new Socket(address, port);
            ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
            System.out.println("lala");
            out.writeInt(InputHandler.MOVE_LEMMING);
        } catch (UnknownHostException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}