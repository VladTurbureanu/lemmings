package edu.rug.gogp.patrik.lemmings.field;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author Rik Schaaf
 */
class InputHandler extends Thread {
    private Socket incoming;
    private int counter;
    
    public InputHandler(Socket incoming, int i) {
        this.incoming = incoming;
        this.counter = i;
    }

    @Override
    public void run() {
        try{
            ObjectInputStream in = new ObjectInputStream(incoming.getInputStream());
            System.out.println("lemmingsch!!!!!");
        } catch (IOException ex) {
            ex.printStackTrace();//Logger.getLogger(InputHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
