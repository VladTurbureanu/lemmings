package edu.rug.gogp.patrik.lemmings.controller;

import edu.rug.gogp.patrik.lemmings.model.Field;
import edu.rug.gogp.patrik.lemmings.model.Lemming;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author Rik Schaaf
 */
public class InputHandler extends Thread {

    public static final int MOVE_LEMMING = 0;
    public static final int GET_FIELDMAP = 1;
    private Socket incoming;
    private Field field;

    public InputHandler(Socket incoming, Field field) {
        this.incoming = incoming;
        this.field = field;
    }

    @Override
    public void run() {
        try {
            ObjectInputStream in = new ObjectInputStream(incoming.getInputStream());
            int inputInt = in.readInt();
            switch (inputInt){
                case MOVE_LEMMING:
                    System.out.println("Bla");    
                    break;
                case GET_FIELDMAP:
                    ObjectOutputStream out = new ObjectOutputStream(incoming.getOutputStream()); 
                    out.writeObject(field.getFieldMap());
                    out.close();
                    break;
            }
        } catch (IOException ex) {
            ex.printStackTrace();//Logger.getLogger(InputHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
