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

    public synchronized void dummy2() {
        this.setChanged();
        this.notifyObservers();
    }

    public String getCapacity() {
        return "0";
    }

    public String getAddress() {
        return sSocket.getInetAddress().getHostAddress().toString();
    }

    public String getPort() {
        return sSocket.getLocalPort() + "";
    }

    public String getNumberOfLemmings() {
        return "0";
    }

    public String getLemmingsListing() {
        return "<geen lemmingen>";
    }

    public String getFieldsListing() {
        return "<geen velden>";
    }

    @Override
    public void run() {
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
}
