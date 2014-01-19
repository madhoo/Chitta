package net.chitta.cinema;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.text.*;
import java.util.*;
import java.util.Date;

/**
 * Class to provide the main functionality of the cinema system
 * 
 * Fehmida Mohamedali
 * MSc Informatics
 * Student ID: 12800659
 * 9th April 2012 @1200
 * 
 */

public class BookingSystem implements Serializable {
    private static final String EXIT = "x";

    enum ACCESS_LEVELS { MANAGER, CUSTOMER, NOTHING};
    
    private String name;

    private Cinema cinema;
    private ArrayList<Person> users;
//    static ArrayList<Person> users;    
    private ArrayList<Booking> bookings;
    //private Map<Showing,Booking> bookings;

    private Person loggedPerson; 

    private static Scanner sc;

//    DateFormat df = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, Locale.UK);  

    public BookingSystem() {
        this("default");
    }

    public BookingSystem(String s) {
        name = s;
        cinema = new Cinema();
        users = new ArrayList<Person>();
    }
// Called from BookingSystemMain to initiate login and actions; output saved to Utilities
// enable serialization
    void run() {
        sc = new Scanner(System.in);   
        loggedPerson = loginScreen();
        performActions();       
        Utilities.save(this);
    }

  public String toString() {
     return name + " " + cinema + users;
    }
// Input login data and check if userid and password exists; if not offer choice to input again.
    private Person loginScreen() {
        String name, pw;        
        Person person;
        do {
            System.out.print("User Id:\n");
            name = sc.nextLine();           
            System.out.print("Password:\n");
            pw = sc.nextLine();

            person = isUserExist(new Person(name,pw));
        } while (person == null);
        return person;
    }

    public Person isUserExist(Person person){   
        for (Person p : users){
            if (p.equals(person)){
                return p;
            }
        }
        return null;
    }

    public void uiEntryPoint(Person person){   
        loggedPerson = person;
        sc = new Scanner(System.in);
        performActions();       
        Utilities.save(this);
    }
// carry out actions according to access levels assigned
    private void performActions() {
        String str;
        do {
            System.out.println("\tMenu");
            System.out.println();

            if (loggedPerson.getAccessLevel().equals(ACCESS_LEVELS.MANAGER)){
                // Menu for Manager
                System.out.println("\tu - User Management");
                System.out.println("\ts - Screen Management");
                System.out.println("\tm - Movie Management");
                System.out.println("\tb - Booking Management");
                System.out.println("\tx - exit");
                System.out.print("\t>>Enter your choice of letter or press x to EXIT:  ");
                str = sc.next();

                if (str.equals("u"))
                    processUserManagement();
                else if (str.equals("s"))
                    processScreenManagement();
                else if (str.equals("m"))    
                    processMovieManagement();
                else if (str.equals("b"))    
                    processBookingManagement();
                else if (str.equals(EXIT))
                    return;
                else
                    System.out.println("sorry!, invalid reply [" + str + "]");
            } 
            else {
                // Menu for customers
                System.out.println("\tm - Display Movie Information");
                System.out.println("\ts - Display Weekly Showings of all Movies");
                System.out.println("\tf - Cinema Facilities");
                System.out.println("\tp - Cinema Prices");
                System.out.println("\tr - Display Payments and Refunds policies");
                System.out.println("\tb - Process Booking");
                System.out.println("\ta - Amend Personal Details");
                System.out.println("\tx - exit");
                System.out.print("\t>>Enter your choice of letter or press x to EXIT:  ");
                str = sc.next();

                if (str.equals("m"))
                    processShowMovies();
                else if (str.equals("s"))
                    processShowShowings();
                else if (str.equals("f"))
                    processCinemaFacilities();
                else if (str.equals("p"))
                    processCinemaPrices();
                else if (str.equals("r"))
                    processPaymentsRefundsInfo();
                else if (str.equals("b"))
                    processBooking();
                else if (str.equals("a"))
                    processAmendPersonalDetails();
                else if (str.equals(EXIT))
                    return;
                else
                    System.out.println("sorry!, invalid reply [" + str + "]");
            }
        } while (true);
    }

    private void processUserManagement() {
        String reply;
        do {            
            System.out.println("\tMenu");
            System.out.println();
            System.out.println("\ts - Show all Users");
            System.out.println("\tx - return to previous menu");
            System.out.print("\t>>Enter your choice of letter or press x to EXIT:   ");
            reply = sc.next();

            if (reply.equals("s")) { // validation on inputs
                processShowUsers();
            } // else other options
            else if (reply.equals(EXIT))
                return;
            else
                System.out.println("sorry, invalid reply [" + reply + "]");
        } while (true);
    }

    private void processShowUsers() {
        String reply;
        do {            
            System.out.println("\tMenu");
            System.out.println();

            for (Person person : users )  {

                System.out.println("\t" + person.getUserId() + "\t" + person.getPassword() + "\t" + person.getAccessLevel());
            }
            System.out.println("\tx - return to previous menu");
            System.out.print("\t>>Enter your choice of letter or press x to EXIT:   ");
            reply = sc.next();

            if (reply.equals("x")) { // validation on inputs
                break;
            } // else other options
            else
                System.out.println("sorry!, invalid reply [" + reply + "]");
        } while (true);
    }

    private void processScreenManagement(){
        String reply;
        do {            
            System.out.println("\tMenu");
            System.out.println();
            System.out.println("\tc - Add screens and capacity");
            System.out.println("\ts - Show showings for a specific screen");
            System.out.println("\ta - Add showing for screen");
            System.out.println("\tu - Update showing for screen");
            System.out.println("\td - Delete showing for screen");
            System.out.println("\tx - return to previous menu");
            System.out.print("\t>>Enter your choice of letter or press x to EXIT:   ");
            reply = sc.next();

            if (reply.equals("s")   ) { // validation on inputs
                processShowShowings();
            } // else other options
            else if (reply.equals("a")) { // validation on inputs
                processAddShowing();
            } 
            else if (reply.equals("u")) { // validation on inputs
                processUpdateShowing();
            }   
            else if (reply.equals("d")) { // validation on inputs
                processDeleteShowing();           
            }
            else if (reply.equals("c")) { // validation on inputs
                processAddScreen();           
            }
            else if (reply.equals(EXIT))
                return;
            else
                System.out.println("sorry!, invalid reply [" + reply + "]");
        } 
        while (true);
    }

    private void processMovieManagement() {
        String reply;
        do {            
            System.out.println("\tMenu");
            System.out.println();
            System.out.println("\ts - Show all Movies");
            System.out.println("\ta - Add New Movie");
            System.out.println("\tu - Update a Movie");
            System.out.println("\td - Delete a Movie");
            System.out.println("\tx - return to previous menu");
            System.out.print("\t>>Enter your choice of letter or press x to EXIT:   ");
            reply = sc.next();

            if (reply.equals("s")) { // validation on inputs
                processShowMovies();
            }
            else if (reply.equals("a")) { // validation on inputs
                processAddMovies();
            }
            else if (reply.equals("u")) { // validation on inputs
                processUpdateMovies();
            }
            else if (reply.equals("d")) { // validation on inputs
                processDeleteMovies();
            }    
            else if (reply.equals(EXIT))
                return;
            else
                System.out.println("sorry, invalid reply [" + reply + "]");
        } while (true);
    }

    private void processAddMovies(){

        boolean keepContinue = true;  
        String reply;

        do {   
            System.out.println("\ta - Add a Movies");
            System.out.println("\ta - Title:");
            System.out.print("\t>> ");
            String title = sc.next();

            System.out.println("\ta - Rating:");
            System.out.print("\t>> ");
            String rating = sc.nextLine();

            System.out.println("\ta - Director:");
            System.out.print("\t>> ");
            String director = sc.next();

            System.out.println("\ta - Main Cast:");
            System.out.print("\t>> ");
            String actors = sc.next();

            System.out.println("\ta - Synopsis:");
            System.out.print("\t>> ");
            String synopsis = sc.next();

            System.out.println("\ta - Clip:");
            System.out.print("\t>> ");
            String clip = sc.next();

            boolean success = cinema.addMovie(title, rating, director, actors, synopsis, clip);
            if (success) {
                System.out.println("Movie " + title + " is added");
            }else {
                System.out.println("Movie " + title + " is already there");
            }

            while(true) {
                System.out.println("\ta Do you want to add Another Movie:");
                System.out.print("\t>>Enter a for adding another movie or press x to EXIT:   ");
                reply = sc.next();

                if (reply.equals("a")){
                    break;
                } else if (reply.equals(EXIT)){
                    keepContinue = false;
                    break;
                } else{
                    System.out.println("sorry, invalid reply [" + reply + "]");
                }
            }

        } while (keepContinue);

    }

    private void processUpdateMovies(){

        boolean keepContinue = true;  
        String reply;

        do {   
            System.out.println("\ta - Update Movie");
            System.out.println("\ta - Title:");
            System.out.print("\t>> ");
            String title = sc.next();
            Movie movie = cinema.getMovie(title);
            if(movie == null) {
                System.out.println("Movie name invalid");
                continue;
            }

            System.out.println("\ta - Rating:");
            System.out.print("\t>> ");
            String rating = sc.next();

            System.out.println("\ta - Director:");
            System.out.print("\t>> ");
            String director = sc.next();

            System.out.println("\ta - Main Cast:");
            System.out.print("\t>> ");
            String actors = sc.next();

            System.out.println("\ta - Synopsis:");
            System.out.print("\t>> ");
            String synopsis = sc.next();

            System.out.println("\ta - Clip:");
            System.out.print("\t>> ");
            String clip = sc.next();

            boolean success = cinema.updateMovie(movie, rating, director, actors, synopsis, clip);
            if (success) {
                System.out.println("Movie " + title + " is updated");
            }else {
                System.out.println("Movie " + title + " is not changed");
            }

            while(true) {
                System.out.println("\ta Do you want to update Another Movie ?");
                System.out.print("\t>> Enter letter a to update another movie or press x to EXIT:  ");
                reply = sc.next();

                if (reply.equals("a")){
                    break;
                } else if (reply.equals(EXIT)){
                    keepContinue = false;
                    break;
                } else{
                    System.out.println("sorry, invalid reply [" + reply + "]");
                }
            }

        } while (keepContinue);

    }

    private void processDeleteMovies(){

        boolean keepContinue = true;  
        String reply;

        do {   
            System.out.println("\ta - Delete Movie");
            System.out.println("\ta - Title:");
            System.out.print("\t>> ");
            String title = sc.next();
            Movie movie = cinema.getMovie(title);
            if(movie == null) {
                System.out.println("Movie name invalid");
                continue;
            }

            boolean success = cinema.removeMovie(title);
            if (success) {
                System.out.println("Movie " + title + " is deleted");
            }else {
                System.out.println("Movie " + title + " is not deleted");
            }

            while(true) {
                System.out.println("\ta Do you want to delete another Movie ?");
                System.out.print("\t>> Enter letter a to delete another movie or press x to EXIT:  ");
                reply = sc.next();

                if (reply.equals("a")){
                    break;
                } else if (reply.equals(EXIT)){
                    keepContinue = false;
                    break;
                } else{
                    System.out.println("sorry, invalid reply [" + reply + "]");
                }
            }

        } while (keepContinue);

    }

    // Options for Customers and Manager    
    private void processShowMovies() {
        String reply;
        do {            
            System.out.println("\tMenu");
            System.out.println();

            for (Movie movie : cinema.getAllMovies())  {

                System.out.println("\t" + movie.getTitle() + "\t" + movie.getRating() + "\t" + movie.getDirector());
            }

            System.out.println("\tx - return to previous menu");
            System.out.print("\t>>");
            reply = sc.next();

            if (reply.equals("x")) { // validation on inputs

                break;
            } // else other options
            else
                System.out.println("sorry!, invalid reply [" + reply + "]");
        } while (true);
    }
    //processUserManagement();
    private void processAddShowing(){

        boolean keepContinue = true;  
        String reply;

        do {   
            System.out.println("\ta - Screen Number:");
            System.out.print("\t>> ");
            int screenNumber = sc.nextInt();
            String valid = cinema.getScreen(screenNumber).validateScreen();
           if(valid != null) {
                System.out.println(valid);
                continue;
            }
           Screen screen = cinema.getScreen(screenNumber);
           
            System.out.println("\ta - Title:");
            System.out.print("\t>> ");
            String title = sc.next();
            Movie movie = cinema.getMovie(title);
            if(movie == null) {
                System.out.println("Movie name invalid");
                continue;
            }

            System.out.println("\ta - Which Date:");
            System.out.print("\t>> ");
            String showDateStr = sc.next(); 
            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy:HH.mm");
            Date showDate = null;

            try {
                showDate = format.parse(showDateStr);
            }catch(Exception e){
                System.out.println("The date format should be dd-MM-yyyy:HH.mm");
                continue;
            }
            
            int noOfSeatsFree = cinema.getScreen(screenNumber).getNoOfSeats();
            boolean success = cinema.addShowing(showDate,screenNumber, title, noOfSeatsFree);
            if (success) {
                System.out.println("The movie " + title + " is added to screen " + screenNumber + " for " + showDate +" ");
            }
            else {
                System.out.println("The movie " + title + " is already scheduled to screen " + screenNumber + " for" + showDate +" ");
            }

            while(true) {
                System.out.println("\ta Do you want to schedule another movie ? ");
                System.out.print("\t>> Enter letter a to schedule another movie or press x to EXIT:   ");
                reply = sc.next();

                if (reply.equals("a")){
                    break;
                } else if (reply.equals(EXIT)){
                    keepContinue = false;
                    break;
                } else{
                    System.out.println("sorry, invalid reply [" + reply + "]");
                }
            }

        } while (keepContinue);

    }
    // Options for Manager and Customers
    private void processShowShowings() {
        String reply;
        do {            
            System.out.println("\tMenu");
            System.out.println();
        	System.out.println("\t Movies \t Screen  \t  Seats Free \t    Date and Time  \n" );                           
            for (Showing showing : cinema.getAllShowings())  {
              //  System.out.println("The movie " + title + " is added to screen " + screenNumber + " for" + showDate +" ");
              //  System.out.println("\t" + showing.getMovie().getTitle() + "\t" + showing.getScreen().getScreenNumber() + "\t" + showing.getShowDate());
            	System.out.println("\t" + showing.getMovieTitle() + "\t" + showing.getScreenNumber() + "\t" + showing.getNoOfSeatsFree() + "\t" + showing.getShowDate());
            }

            System.out.println("\tx - return to previous menu");
            System.out.print("\t>> ");
            reply = sc.next();

            if (reply.equals("x")) { // validation on inputs

                break;
            } // else other options
            else
                System.out.println("sorry!, invalid reply [" + reply + "]");
        } while (true);

    }

    private void processUpdateShowing(){

        boolean keepContinue = true;  
        String reply;

        do {   
            System.out.println("\ta - Current Screen Number:");
            System.out.print("\t>> ");
            int currentScreenNumber = sc.nextInt();

            System.out.println("\ta - Title:");
            System.out.print("\t>> ");
            String currentTitle = sc.next();

            System.out.println("\ta - Which Date:");
            System.out.print("\t>> ");
            String currentShowDateStr = sc.next(); 
            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy:HH.mm");
            Date currentShowDate;

            try {
                currentShowDate = format.parse(currentShowDateStr);
            }catch(Exception e){
                System.out.println("The date format should be dd-MM-yyyy:HH.mm");
                continue;
            }

            Showing showing = cinema.getShowing(currentScreenNumber, currentShowDate);
            if (showing == null) {
                System.out.println("Invalid SHOWING");
                continue;
            }

            System.out.println("\ta - Screen Number:");
            System.out.print("\t>> ");
            int screenNumber = sc.nextInt();
            Screen screen = cinema.getScreen(screenNumber);
            if(screen == null) {
                System.out.println("Screen number invalid");
                continue;
            }

            System.out.println("\ta - Title:");
            System.out.print("\t>> ");
            String title = sc.next();
            Movie movie = cinema.getMovie(title);
            if(movie == null) {
                System.out.println("Movie name invalid");
                continue;
            }

            System.out.println("\ta - Which Date:");
            System.out.print("\t>> ");
            String showDateStr = sc.next(); 

            Date showDate;

            try {
                showDate = format.parse(showDateStr);
            }catch(Exception e){
                System.out.println("The date format should be dd-MM-yyyy:HH.mm");
                continue;
            }
            int noOfSeatsFree = cinema.getShowing(screenNumber, showDate).getNoOfSeatsFree();
            boolean success = cinema.updateShowing(showDate, screenNumber, title, noOfSeatsFree);
            if (success) {
                System.out.println("The movie " + title + " is added to screen " + screenNumber + " for" + showDate +" ");
            }
            else {
                System.out.println("The movie " + title + " is already scheduled to screen " + screenNumber + " for" + showDate +" ");
            }

            while(true) {
                System.out.println("\ta Do you want to schedule another movie ? ");
                System.out.print("\t>> ");
                reply = sc.next();

                if (reply.equals("a")){
                    break;
                } else if (reply.equals(EXIT)){
                    keepContinue = false;
                    break;
                } else{
                    System.out.println("sorry, invalid reply [" + reply + "]");
                }
            }

        } while (keepContinue);
    }

    private void processDeleteShowing(){

        boolean keepContinue = true;  
        String reply;

        do {   
            System.out.println("\ta - Delete Show");
            System.out.println("\ta - Screen Number:");
            System.out.print("\t>> ");
            int screenNumber = sc.nextInt();

            System.out.println("\ta - Title:");
            System.out.print("\t>> ");
            String title = sc.next();

            System.out.println("\ta - Which Date:");
            System.out.print("\t>> ");
            String showDateStr = sc.next(); 

            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy:HH.mm");

            Date showDate;

            try {
                showDate = format.parse(showDateStr);
            }catch(Exception e){
                System.out.println("The date format should be dd-MM-yyyy:HH.mm");
                continue;
            }

            Showing showing = cinema.getShowing(screenNumber, showDate);
            if (showing == null) {
                System.out.println("Invalid SHOWING");
                continue;
            }

            boolean success = cinema.removeShowing(showing);
            if (success) {
                System.out.println("Movie " + title + " is deleted from screen " +screenNumber+ " for "+showDate+ " ");
            }else {
                System.out.println("Show for " + title + "on screen " +screenNumber+ "scheduled for "+showDate+ "is not deleted");
            }

            while(true) {
                System.out.println("\ta Do you want to delete another show ?");
                System.out.print("\t>>Enter letter a to delete another movie or press x to EXIT:  ");
                reply = sc.next();

                if (reply.equals("a")){
                    break;
                } else if (reply.equals(EXIT)){
                    keepContinue = false;
                    break;
                } else{
                    System.out.println("sorry, invalid reply [" + reply + "]");
                }
            }

        } while (keepContinue);
    }
    
    private void processBookingManagement() {
        String reply;
        do {            
            System.out.println("\tMenu");
            System.out.println();
            System.out.println("\ts - Show all Bookings");
            System.out.println("\tr - Authorise Refunds");
            System.out.println("\tx - return to previous menu");
            System.out.print("\t>>Enter your choice of letter or press x to EXIT:   ");
            reply = sc.next();

            if (reply.equals("s")) { // validation on inputs
                processShowBookings(); //display bookRef, show, seats booked and payment status
            } // else other options
            else if (reply.equals("r")) {
                processAuthoriseRefunds(); // follow refund policy rules
            }
            else if (reply.equals(EXIT))
                return;
            else
                System.out.println("sorry, invalid reply [" + reply + "]");
        } while (true);
    }

    private void processShowBookings() {
        String reply;
        do {            
            System.out.println("\tMenu");
            System.out.println();

              // for (Booking booking : bookings) {
 
              //   System.out.println("\t" + booking.getBookingRef() + "\t" + booking.getPerson() + "\t" + booking.getShowing());
              // }
            System.out.println("\tx - return to previous menu");
            System.out.print("\t>>Enter your choice of letter or press x to EXIT:   ");
            reply = sc.next();

            if (reply.equals("x")) { // validation on inputs
                break;
            } // else other options
            else
                System.out.println("sorry!, invalid reply [" + reply + "]");
        } while (true);
    }
    
    
     private void processAuthoriseRefunds() {
        String reply;
        do {            
            System.out.println("\tMenu");
            System.out.println();
          // Calculate refunds based on refund policies
         //             
            System.out.println("\tx - return to previous menu");
            System.out.print("\t>>Enter your choice of letter or press x to EXIT:   ");
            reply = sc.next();

            if (reply.equals("x")) { // validation on inputs
                break;
            } // else other options
            else
                System.out.println("sorry!, invalid reply [" + reply + "]");
        } while (true);
    }
    
    
    // Options for customers
    private void processCinemaFacilities() {
        String reply;
        do {            
            System.out.println("\tMenu");
            System.out.println("\t Cinema Facilities");
            System.out.println("\t ************************");
            System.out.println("\ts - Screen information");
            System.out.println("\tc - Cinema experience");
            System.out.println("\td - Facilities for the disabled");
            System.out.println("\tp - Parking Facilities");
            System.out.println("\tx - Exit");
            System.out.print("\t>>Enter your choice of letter or press x to EXIT:  ");
            reply = sc.next();
              if (reply.equals("s")){
                System.out.println("\t Screen information");
                System.out.println("\t ************************" );
                System.out.println("\t A choice of 6 screens with stepped stadium style seating.");
                System.out.println("\t Seats are allocated to the left, centre or right of the auditorium.");
                System.out.println("\t Each screen can accomodate 200 seats ");
                System.out.println("\t ************************" );
              }
              else if (reply.equals("c")){
                System.out.println("\t Cinema experience");
                System.out.println("\t ************************" );
                System.out.println("\t The Sony 4K digital picture quality and 3D vision.");
                System.out.println("\t Dolby profound sound system immersed in the on-screen action.");
                System.out.println("\t ************************" );    
              }
              else if (reply.equals("d")){
                System.out.println("\t Facilities for the disabled");
                System.out.println("\t ************************" );
                System.out.println("\t Wheelchair access throughout the cinema.");
                System.out.println("\t Hearing assistance: Infra-red installed in all theatres.");
                System.out.println("\t Visually impared: Audio desription facilities available.");
                System.out.println("\t ************************" );    
              }
              else if (reply.equals("p")) {
                System.out.println("\t Parking facilities");
                System.out.println("\t ************************" );
                System.out.println("\t Use of St George's car park.");
                System.out.println("\t 50 Designated disabled bays.");
                System.out.println("\t ************************" ); 
              }
              else if (reply.equals(EXIT)) {
                return;
            }
            else
                System.out.println("sorry, invalid reply [" + reply + "]");
        } 
        while (true);
    }          

    private void processCinemaPrices() {
        String reply;
        do {            
            System.out.println("\tMenu");
            System.out.println();
            System.out.println("\t Cinema Prices");
            System.out.println("\t ************************");
            System.out.println("\t Adult: 6.50");
            System.out.println("\t Child(2 to 12 years): 4.00");
            System.out.println("\t Teen(13 to 18 years): 5.00");
            System.out.println("\t Student: 5.50");
            System.out.println("\t Senior: 4.20");
            System.out.println("\t Family of 4 (2 adults and 2 children): 18.50");
            System.out.println("\t ************************" );
            System.out.println("\tx - return to previous menu");
            System.out.print("\t>>Enter your choice of letter or press x to EXIT:  ");
            reply = sc.next();
            if (reply.equals("x")) { // validation on inputs
                break;
            } // else other options
            else
                System.out.println("sorry!, invalid reply [" + reply + "]");
        } while (true);
    }          

    private void  processPaymentsRefundsInfo(){

        boolean keepContinue = true;  
        String reply;

        do {   
            System.out.println("\tMenu");
            System.out.println();
            System.out.println("\tp - Payments");
            System.out.println("\tr - Refunds");
            System.out.println("\tx - return to previous menu");
            System.out.print("\t>> ");
            reply = sc.next();

            if (reply.equals("p")) { // validation on inputs
              //  FileReader.printFile("PaymentPolicy.txt");   
                // processPaymentsInfo(); 

            }
            else if (reply.equals("r")) { // validation on inputs
                //FileReader.printFile("RefundPolicy.txt"); 
                //  processRefundsInfo();
            }
            else if (reply.equals(EXIT))
                return;
            else
                System.out.println("sorry, invalid reply [" + reply + "]");
        } while (true);
    }

    private void  processBooking(){

        boolean keepContinue = true;  
        String reply;
        
        do {   
            System.out.println("\tMenu");
            System.out.println();
            System.out.println("\ta - Add Booking");
            System.out.println("\tu - Update Booking");
            System.out.println("\tc - Cancel Booking");
            System.out.println("\tx - return to previous menu");
            System.out.print("\t>> ");
            reply = sc.next();
            
            if (reply.equals("a")) { // validation on inputs
               processAddBooking();
            }
            else if (reply.equals("u")) { // validation on inputs
            //    processUpdateBooking();
            }
            else if (reply.equals("c")) { // validation on inputs
            //    processCancelBooking();
            }
            else if (reply.equals(EXIT))
                return;
            else
                System.out.println("sorry, invalid reply [" + reply + "]");
        } while (true);
    }
    
    private void  processAmendPersonalDetails(){

        boolean keepContinue = true;  
        String reply;
        
        do {   
           //processAmendPersonalDetails   //Change password, address
        } while (true);
    }
    
    
         
    
    boolean addManager(String name, String pw){
        users.add(new Person(name, pw, BookingSystem.ACCESS_LEVELS.MANAGER));
        return true;
    }

    boolean addCustomer(String name, String pw){
        users.add(new Person(name, pw, BookingSystem.ACCESS_LEVELS.CUSTOMER));
        return true;
    }

    // public Person getPerson(String username){

    //}

    //processUserManagement();
    
    
    private void processAddScreen(){

        boolean keepContinue = true;  
        String reply;

        do {   
            System.out.println("\ta - Add a Screen");
            System.out.println("\tEnter Screen Number:");
            System.out.print("\t>> ");
            int screenNumber = sc.nextInt();
            if (cinema.getScreen(screenNumber) != null){
            	System.out.println("screen already exist");
            	continue;
            	
            }
            Screen screen = cinema.getScreen(screenNumber);
            String valid = screen.validateScreen();
           if(valid != null) {
                System.out.println(valid);
                continue;
            }
//           Screen screen = cinema.getScreen(screenNumber);
            
            System.out.println("\tEnter Screen Name:");
            System.out.print("\t>> ");
            String screenName = sc.next();

            System.out.println("\tNumber of Seats available:");
            System.out.print("\t>> ");
            int noOfSeats = sc.nextInt();

            boolean success = cinema.addScreen(screenName, screenNumber, noOfSeats);
            if (success) {
                System.out.println("Screen" + screenName + " is added");
            }else {
                System.out.println("Screen " + screenName + " is already there");
            }

            while(true) {
                System.out.println("\ta Do you want to add Another Movie:");
                System.out.print("\t>>Enter a for adding another screen or press x to EXIT:   ");
                reply = sc.next();

                if (reply.equals("a")){
                    break;
                } else if (reply.equals(EXIT)){
                    keepContinue = false;
                    break;
                } else{
                    System.out.println("sorry, invalid reply [" + reply + "]");
                }
            }

        } while (keepContinue);

    }
    
    private void processUpdateScreen(){

        boolean keepContinue = true;  
        String reply;

        do {   
            System.out.println("\ta - Add a Screen");
            System.out.println("\tEnter Screen Number:");
            System.out.print("\t>> ");
            int screenNumber = sc.nextInt();
            
            Screen screen = cinema.getScreen(screenNumber);
            if(screen == null) {
                System.out.println("Screen number is invalid");
                continue;}

            System.out.println("\tEnter Screen Name:");
            System.out.print("\t>> ");
            String screenName = sc.next();

            System.out.println("\tNumber of Seats available:");
            System.out.print("\t>> ");
            int noOfSeats = sc.nextInt();

            boolean success = cinema.addScreen(screenName, screenNumber, noOfSeats);
            if (success) {
                System.out.println("Screen" + screenName + " is added");
            }else {
                System.out.println("Screen " + screenName + " is already there");
            }

            while(true) {
                System.out.println("\ta Do you want to add Another Movie:");
                System.out.print("\t>>Enter a for adding another screen or press x to EXIT:   ");
                reply = sc.next();

                if (reply.equals("a")){
                    break;
                } else if (reply.equals(EXIT)){
                    keepContinue = false;
                    break;
                } else{
                    System.out.println("sorry, invalid reply [" + reply + "]");
                }
            }

        } while (keepContinue);

    }
    
    private void processAddBooking(){

        boolean keepContinue = true;  
        String reply;
        
        for (Showing showing : cinema.getAllShowings())  {
//   System.out.println("\t" + showing.getMovie().getTitle() + "\t" + showing.getScreen().getScreenNumber() + "\t" + showing.getShowDate());
        System.out.println("\t" + showing.getMovieTitle() + "\t" + showing.getScreenNumber() + "\t"  + "\t"  + showing.getShowDate());

          }
        System.out.println("\n\n  Please Select the Movie you wish to book from the above list\n");
        do {   
            System.out.println("\ta - Enter Screen Number:");
            System.out.print("\t>> ");
            int screenNumber = sc.nextInt();
            if(screenNumber == 0 || screenNumber <1 || screenNumber >6) {
                System.out.println("Screen number invalid. Screen number has to be between 1 and 6");
                continue;
            }

            System.out.println("\ta - Which Date:");
            System.out.print("\t>> ");
            String showDateStr = sc.next(); 
            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy:HH.mm");
            Date showDate = null;

            try {
                showDate = format.parse(showDateStr);
            }catch(Exception e){
                System.out.println("The date format should be dd-MM-yyyy:HH.mm");
                continue;
            }

            
            Showing showing = cinema.getShowing(screenNumber, showDate);
            
            if(showing == null) {
                System.out.println("Showing is  invalid. Please Check and re enter");
                continue;
            } else {
            	
            System.out.println("You have Selected Movie " + showing.getMovieTitle()  + "Showing at " + showing.getShowDate() + "Please Confirm");

            System.out.print("\t>> Enter letter a to schedule another movie or press x to EXIT:   ");
            reply = sc.next();

            if (reply.equals("a")){
                break;
            } else if (reply.equals(EXIT)){
                keepContinue = false;
                break;
            } else{
                System.out.println("sorry, invalid reply [" + reply + "]");
            }          
            
            }
            
            System.out.println("\ta - Enter Movie Title:");
            System.out.print("\t>> ");
            String title = sc.next();
            Movie movie = cinema.getMovie(title);
            if(movie == null) {
                System.out.println("Movie name invalid");
                continue;
            }
            int noOfSeatsFree = cinema.getShowing(screenNumber, showDate).getNoOfSeatsFree();
            boolean success = cinema.addShowing(showDate,screenNumber, title,noOfSeatsFree);
            if (success) {
                System.out.println("The movie " + title + " is added to screen " + screenNumber + " for " + showDate +" ");
            }
            else {
                System.out.println("The movie " + title + " is already scheduled to screen " + screenNumber + " for" + showDate +" ");
            }

            while(true) {
                System.out.println("\ta Do you want to schedule another movie ? ");
                System.out.print("\t>> Enter letter a to schedule another movie or press x to EXIT:   ");
                reply = sc.next();

                if (reply.equals("a")){
                    break;
                } else if (reply.equals(EXIT)){
                    keepContinue = false;
                    break;
                } else{
                    System.out.println("sorry, invalid reply [" + reply + "]");
                }
            }

        } while (keepContinue);

    }


}   

