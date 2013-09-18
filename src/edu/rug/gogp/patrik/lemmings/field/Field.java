package edu.rug.gogp.patrik.lemmings.field;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Observable;

/**
 *
 * @author s2288842
 */
public class Field extends Observable implements Runnable {

    ServerSocket serverSocket;

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
                Thread t = new InputHandler(incoming, i);
                t.start();
                i++;
            }
        } catch (IOException ex) {
            ex.printStackTrace();//Logger.getLogger(Field.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
