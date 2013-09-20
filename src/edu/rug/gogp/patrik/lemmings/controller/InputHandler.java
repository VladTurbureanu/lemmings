package edu.rug.gogp.patrik.lemmings.controller;

import edu.rug.gogp.patrik.lemmings.model.Field;
import edu.rug.gogp.patrik.lemmings.model.Lemming;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

/**
 *
 * @author Rik Schaaf
 */
public class InputHandler extends Thread {

    private Socket incoming;
    private int counter;
    private Field field;

    public InputHandler(Socket incoming, int i, Field field) {
        this.incoming = incoming;
        this.counter = i;
        this.field = field;
    }

    @Override
    public void run() {
        try {
            ObjectInputStream in = new ObjectInputStream(incoming.getInputStream());
                System.out.println("lemmingsch!!!!!" + (Lemming) in.readObject());
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();//Logger.getLogger(InputHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
