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

    public static final int MOVE_LEMMING = 1;
    private Socket incoming;
    private Field field;

    public InputHandler(Socket incoming, Field field) {
        this.incoming = incoming;
        this.field = field;
        System.out.println("hier");
    }

    @Override
    public void run() {
        try {
            ObjectInputStream in = new ObjectInputStream(incoming.getInputStream());
                System.out.println("daar");
                System.out.println("lemmingsch!!!!!" + in.readInt());
        } catch (IOException ex) {
            ex.printStackTrace();//Logger.getLogger(InputHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
