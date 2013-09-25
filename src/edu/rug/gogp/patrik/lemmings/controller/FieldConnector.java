package edu.rug.gogp.patrik.lemmings.controller;

import edu.rug.gogp.patrik.lemmings.model.FieldMap;
import edu.rug.gogp.patrik.lemmings.model.Lemming;
import java.io.IOException;
import java.io.ObjectInputStream;
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
            
            out.writeInt(InputHandler.MOVE_LEMMING);
            out.close();
        } catch (UnknownHostException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    } 
    
    public FieldMap getFieldMap() {
        Socket s;
        try {
            s = new Socket(address, port);
            ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
            ObjectInputStream in = new ObjectInputStream(s.getInputStream());
            out.writeInt(InputHandler.MOVE_LEMMING);
            out.close();
            return (FieldMap) in.readObject();
        } catch (UnknownHostException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}