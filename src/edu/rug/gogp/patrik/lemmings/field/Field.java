/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.rug.gogp.patrik.lemmings.field;

import edu.rug.gogp.patrik.lemmings.view.FieldView;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author s2288842
 */
public class Field extends Observable implements Runnable {

    ServerSocket sSocket;

    public Field(int serverPort) throws IOException {
        this.sSocket = new ServerSocket(serverPort);
    }

    public void dummy() {
        try {
            int i = 1;
            while (true) {
                Socket incoming = sSocket.accept();
                System.out.println("Spawning " + i);
                Thread t = new InputHandler(incoming, i);
                t.start();
                i++;
            }
        } catch (IOException ex) {
            ex.printStackTrace();//Logger.getLogger(Field.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addObserver(FieldView aThis) {
        throw new UnsupportedOperationException("Not supported yet."); //TODO make this method
    }

    public String getCapacity() {
        throw new UnsupportedOperationException("Not supported yet."); //TODO make this method
    }

    public String getAddress() {
        throw new UnsupportedOperationException("Not supported yet."); //TODO make this method
    }

    public String getPort() {
        throw new UnsupportedOperationException("Not supported yet."); //TODO make this method
    }

    public String getNumberOfLemmings() {
        throw new UnsupportedOperationException("Not supported yet."); //TODO make this method
    }

    public String getLemmingsListing() {
        throw new UnsupportedOperationException("Not supported yet."); //TODO make this method
    }

    public String getFieldsListing() {
        throw new UnsupportedOperationException("Not supported yet."); //TODO make this method
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //TODO make this method
    }
}
