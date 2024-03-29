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
    public static final int REMOVE_LEMMING = 5;
    public static final int GET_NAME = 6;
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
                    return;
                }
                ObjectInputStream in = new ObjectInputStream(incoming.getInputStream());
                ObjectOutputStream out;
                int inputInt = in.readInt();
                switch (inputInt) {
                    case MOVE_LEMMING:
                        out = new ObjectOutputStream(incoming.getOutputStream());
                        out.writeBoolean(field.addLemming((Lemming) in.readObject()));
                        out.flush();
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
                        out = new ObjectOutputStream(incoming.getOutputStream());
                        out.writeBoolean(field.newClild((Lemming) in.readObject()));
                        out.flush();
                        break;
                    case REMOVE_LEMMING:
                        field.removeLemming((Lemming) in.readObject());
                        break;
                    case GET_NAME:
                        out = new ObjectOutputStream(incoming.getOutputStream());
                        out.writeObject(field.getFieldName());
                        out.flush();
                        break;
                    case CLOSE_CONNECTION:
                        incoming.close();
                        return;
                }
            } catch (IOException ex) {
                System.out.println("A error occured when writing or reading.");
                System.out.println("The next lines give more information about this error:");
                System.out.println(ex.getCause() + "\n" + ex.getMessage() + "\n" + ex.fillInStackTrace());
                ex.printStackTrace();
            } catch (ClassNotFoundException ex) {
                System.out.println("The object read was not in the format exspected.");
                System.out.println(ex.getCause() + "\n" + ex.getMessage() + "\n" + ex.fillInStackTrace());
                ex.printStackTrace();
            }
        }
    }
}
