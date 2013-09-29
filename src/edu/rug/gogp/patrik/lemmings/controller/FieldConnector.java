package edu.rug.gogp.patrik.lemmings.controller;

import edu.rug.gogp.patrik.lemmings.AddressElement;
import edu.rug.gogp.patrik.lemmings.model.FieldMap;
import edu.rug.gogp.patrik.lemmings.model.Lemming;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author Rik Schaaf
 */
public class FieldConnector {

    private Socket s;

    public FieldConnector(AddressElement address) {
        try {
            s = new Socket(address.getServerName(), address.getServerPort());
        } catch (UnknownHostException ex) {
            System.out.println("Could not initialize a host.");
            System.out.println(ex.getCause() + "\n" + ex.getMessage() + "\n" + ex.fillInStackTrace());
        } catch (IOException ex) {
            System.out.println("A error accured when reading or writing.");
            System.out.println("More information follows.");
            System.out.println(ex.getCause() + "\n" + ex.getMessage() + "\n" + ex.fillInStackTrace());
        }
    }

    public boolean send(Lemming lemming) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
            out.writeInt(InputHandler.MOVE_LEMMING);
            out.writeObject(lemming);
            out.flush();
            ObjectInputStream in = new ObjectInputStream(s.getInputStream());
            return in.readBoolean();
        } catch (UnknownHostException ex) {
            System.out.println("Could not initialize a host.");
            System.out.println(ex.getCause() + "\n" + ex.getMessage() + "\n" + ex.fillInStackTrace());
        } catch (IOException ex) {
            System.out.println("A error accured when reading or writing.");
            System.out.println("More information follows.");
            System.out.println(ex.getCause() + "\n" + ex.getMessage() + "\n" + ex.fillInStackTrace());
        }
        return false;
    }

    public FieldMap getFieldMap() {
        try {
            ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
            out.writeInt(InputHandler.GET_FIELDMAP);
            out.flush();
            ObjectInputStream in = new ObjectInputStream(s.getInputStream());
            return (FieldMap) in.readObject();
        } catch (IOException ex) {
            System.out.println("A error accured when reading or writing.");
            System.out.println("More information follows.");
            System.out.println(ex.getCause() + "\n" + ex.getMessage() + "\n" + ex.fillInStackTrace());
        } catch (ClassNotFoundException ex) {
            System.out.println("The object read was not in the format exspected.");
            System.out.println(ex.getCause() + "\n" + ex.getMessage() + "\n" + ex.fillInStackTrace());
        }
        return null;
    }

    public void setFieldMap(FieldMap fieldMap) {

        try {
            ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
            out.writeInt(InputHandler.SET_FIELDMAP);
            out.writeObject(fieldMap);
            out.flush();
        } catch (IOException ex) {
            System.out.println("A error accured when reading or writing.");
            System.out.println("More information follows.");
            System.out.println(ex.getCause() + "\n" + ex.getMessage() + "\n" + ex.fillInStackTrace());
        }
    }

    public boolean askForChild(Lemming lemming) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
            out.writeInt(InputHandler.NEW_CHILD);
            out.writeObject(lemming);
            out.flush();
            ObjectInputStream in = new ObjectInputStream(s.getInputStream());
            return in.readBoolean();
        } catch (IOException ex) {
            System.out.println("A error accured when reading or writing.");
            System.out.println("More information follows.");
            System.out.println(ex.getCause() + "\n" + ex.getMessage() + "\n" + ex.fillInStackTrace());
        }
        return false;
    }

    public void closeConnection() {
        try {
            ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
            out.writeInt(InputHandler.CLOSE_CONNECTION);
            out.flush();
            s.close();
        } catch (IOException ex) {
            System.out.println("A error accured when reading or writing.");
            System.out.println("More information follows.");
            System.out.println(ex.getCause() + "\n" + ex.getMessage() + "\n" + ex.fillInStackTrace());
        }
    }

    public void removeLemming(Lemming lemming) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
            out.writeInt(InputHandler.REMOVE_LEMMING);
            out.writeObject(lemming);
            out.flush();
        } catch (IOException ex) {
            System.out.println("A error accured when reading or writing.");
            System.out.println("More information follows.");
            System.out.println(ex.getCause() + "\n" + ex.getMessage() + "\n" + ex.fillInStackTrace());
        }
    }

    public String getName() {
        try {
            ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
            out.writeInt(InputHandler.GET_NAME);
            out.flush();
            ObjectInputStream in = new ObjectInputStream(s.getInputStream());
            return (String) in.readObject();
        } catch (IOException ex) {
            System.out.println("A error accured when reading or writing.");
            System.out.println("More information follows.");
            System.out.println(ex.getCause() + "\n" + ex.getMessage() + "\n" + ex.fillInStackTrace());
        } catch (ClassNotFoundException ex) {
            System.out.println("The object read was not in the format exspected.");
            System.out.println(ex.getCause() + "\n" + ex.getMessage() + "\n" + ex.fillInStackTrace());
        }
        return "";
    }
}
