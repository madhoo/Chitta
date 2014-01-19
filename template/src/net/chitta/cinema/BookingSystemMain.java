package net.chitta.cinema;

import java.util.Scanner;

/**
 * @author Fehmida Mohamedali
 * MSC Informatics
 * Student ID 12800659
 * 10th April 2012 @0830
 */
public class BookingSystemMain {
    
    private static BookingSystem sys;
    /**
     * @param args
     */
    public static void main(String[] args) {
        sys = (BookingSystem) Utilities.initialise();
        
        sys.run();
    }
}
