package edu.rug.gogp.patrik.lemmings.field;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

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
            BufferedReader in = new BufferedReader(new InputStreamReader(incoming.getInputStream()));
            PrintWriter out = new PrintWriter(incoming.getOutputStream(), true);
        } catch (IOException ex) {
            ex.printStackTrace();//Logger.getLogger(InputHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

}
