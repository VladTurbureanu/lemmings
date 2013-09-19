package edu.rug.gogp.patrik.lemmings.field;

import edu.rug.gogp.patrik.lemmings.Lemming;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

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

    public void send(Lemming l) {
        try {
            s = new Socket(address, port);
            ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
            out.writeObject(l);
        } catch (UnknownHostException ex) {
            Logger.getLogger(FieldConnector.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FieldConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
