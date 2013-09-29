package edu.rug.gogp.patrik.lemmings.controller;

import edu.rug.gogp.patrik.lemmings.model.Field;
import edu.rug.gogp.patrik.lemmings.model.FieldMap;
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
    public static final int SET_FIELDMAP = 2;
    public static final int NEW_CHILD = 3;
    public static final int CLOSE_CONNECTION = 4;
    private Socket incoming;
    private Field field;

    public InputHandler(Socket incoming, Field field) {
        this.incoming = incoming;
        this.field = field;
    }

    @Override
    public void run() {
        while (true) {
            try {
                if (incoming.isClosed()) {
                    this.interrupt();
                    return;
                }
                ObjectInputStream in = new ObjectInputStream(incoming.getInputStream());
                ObjectOutputStream out;
                int inputInt = in.readInt();
                switch (inputInt) {
                    case MOVE_LEMMING:
                        field.addLemming((Lemming) in.readObject());
                        break;
                    case GET_FIELDMAP:
                        out = new ObjectOutputStream(incoming.getOutputStream());
                        out.writeObject(field.getFieldMap());
                        out.flush();
                        break;
                    case SET_FIELDMAP:
                        field.unionFieldMap((FieldMap) in.readObject());
                        break;
                    case NEW_CHILD:
                        System.out.println("hier2");
                        out = new ObjectOutputStream(incoming.getOutputStream());
                        if (!field.newClild()) {
                            out.writeBoolean(false);
                        } else {
                            out.writeBoolean(true);
                        }
                        out.flush();

                        break;
                    case CLOSE_CONNECTION:
                        incoming.close();
                        break;
                }
            } catch (IOException ex) {
                ex.printStackTrace();//Logger.getLogger(InputHandler.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
            }
        }
    }
}
