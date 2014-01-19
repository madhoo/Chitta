package net.chitta.cinema;

import java.io.*;

public class Utilities {
    private static final String FILENAME = "system.ser";

    //=================================================
    /**
     * read the state of the booking system into the VM
     */
        
    public static Object initialise() {

        FileInputStream fis = null;
        ObjectInputStream in = null;
        Object sys = null;
        try {
            fis = new FileInputStream(FILENAME);
            in = new ObjectInputStream(fis);
            sys = in.readObject();
            in.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return sys;
    }

    public static void save(Object sys) {
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        try {
            fos = new FileOutputStream(FILENAME);
            out = new ObjectOutputStream(fos);
            out.writeObject(sys);
            out.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
