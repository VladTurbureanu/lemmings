package edu.rug.gogp.patrik.lemmings.model;

import edu.rug.gogp.patrik.lemmings.controller.InputHandler;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Observable;

/**
 *
 * @author s2288842
 */
public class Field extends Observable implements Runnable {

    private ServerSocket serverSocket;
    private FieldMap fieldMap;

    public Field(int serverPort) throws IOException {
        this.serverSocket = new ServerSocket(serverPort);
    }

    public void dummy2() {
        this.setChanged();
        this.notifyObservers();
    }

    public String getCapacity() {
        return "0";
    }

    public String getAddress() {
        return serverSocket.getInetAddress().getCanonicalHostName();
    }

    public String getPort() {
        return serverSocket.getLocalPort() + "";
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
                Socket incoming = serverSocket.accept();
                Thread t = new InputHandler(incoming, i, this);
                t.start();
                i++;
            }
        } catch (IOException ex) {
            ex.printStackTrace();//Logger.getLogger(Field.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public FieldMap getFieldMap() {
        return fieldMap;
    }

    public void addLemming(Lemming lemming) {
        throw new UnsupportedOperationException("Not supported yet."); //TODO make this method
    }
}
