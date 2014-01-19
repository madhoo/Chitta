package net.chitta.cinema;

import java.io.*;// for IOException
import java.util.*;
import java.text.*;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;


/**
 * Class to provide the functionality of cinema management
 * 
 * Fehmida Mohamedali
 * MSc Information Technology
 * Student ID: 12800659
 * 8th Apr 2012
 */

public class Cinema implements Serializable{
  
    ArrayList<Showing> showings;   
    Map<Integer, Screen> screens;  
    Map<String, Movie> movies;
//    String movieTitle;
//    int screenNumber;

    public Cinema()
    {
        movies = new HashMap <String, Movie> ();
        screens = new HashMap <Integer, Screen> ();
        showings = new ArrayList<Showing>(); 
    }
     
   public boolean addMovie(String title, String rating, String director, String actors, String synopsis, String clip)
    {
       Movie movie = new Movie(title, rating, director, actors, synopsis, clip);
       return addMovie(movie);
    }
    
    public boolean updateMovie(Movie movie, String rating, String director, String actors, String synopsis, String clip)
    {       
       if (rating != null && !rating.trim().equals("")){
            movie.setRating(rating);
        }
       
        if (director != null && !director.trim().equals("")){
            movie.setDirector(director);
        }
        
        if (actors != null && !actors.trim().equals("")){
            movie.setActors(actors);
        }
        
        if (synopsis != null && !synopsis.trim().equals("")){
            movie.setSynopsis(synopsis);
        }
        
        if (clip != null && !clip.trim().equals("")){
            movie.setClip(clip);
        }
               
       return true;
    }
    
    private boolean addMovie (Movie movieIn)
    {
        String titleIn = movieIn.getTitle();
        if (movies.containsKey(titleIn))
        {
            return false;
        }
        else
        {
            movies.put(titleIn, movieIn);
            return true;
        }
    }
    
    public boolean removeMovie (String title)
    {
        if (movies.remove(title)!= null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
       
     public Set <Movie> getAllMovies()
    {
        Set <Movie> movieSet = new HashSet<Movie> ();
        Set <String> theKeys = movies.keySet();
        for (String title : theKeys)
        {
            Movie theMovie = movies.get(title);
            movieSet.add(theMovie);
        }
        return movieSet;
   }
   
   public Movie getMovie(String title) {
       Movie movie = movies.get(title);
       return movie;
    }
    
        
    public Screen getScreen(int screenNumber){
        return screens.get(screenNumber);
    }
 
    public boolean addShowing(Date showDate, int screenNumberIn, String movieTitleIn, int noOfSeatsFreeIn){
        
        try {             
             Showing showing = new Showing(showDate, screenNumberIn, movieTitleIn, noOfSeatsFreeIn);
             return addShowing(showing);
        } catch (Exception e){
            return false;
        }
    }
 
    private boolean addShowing(Showing showingIn)
    {
            showings.add(showingIn);
            return true; 
    } 
    public Showing getShowing(int screenNumberIn, Date showDateIn){
        
        for (Showing showing :showings){            
            if(showing != null
                && showing.getScreenNumber()==screenNumberIn
                && showing.getShowDate()!= null 
                && showing.getShowDate().compareTo(showDateIn) == 0  ) {
                return showing;    
            }
        }
        
        return null;
    }
    
    public boolean updateShowing(Date showDateIn, int screenNumberIn, String movieTitleIn, int noOfSeatsFreeIn){

        for (Showing showing :showings){            
            if(showing != null
                && showing.getScreenNumber()==screenNumberIn  
                && showing.getShowDate()!= null 
                && showing.getShowDate().compareTo(showDateIn) == 0  ) {
            	showing.setShowing(showDateIn, screenNumberIn, movieTitleIn, noOfSeatsFreeIn);
                return true;    
            }
        }
        System.out.println("\ta Showing does not exist ");
        return true;
    }
    
     public boolean removeShowing (Showing showing)
    {
        if (showings.remove(showing))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public ArrayList<Showing> getAllShowings()
    {        
        return showings;
   }

    public boolean addScreen(String screenNameIn, int screenNumberIn, int noOfSeatsIn)
    {
    	Screen screen = new Screen(screenNameIn, screenNumberIn, noOfSeatsIn);
       return addScreen(screen);
    }
    
    private boolean addScreen (Screen screenIn)
    {
        int screenNumber = screenIn.getScreenNumber();
        if (screens.containsKey(screenNumber))
        {
            return false;
        }
        else
        {
        	screens.put(screenNumber, screenIn);
            return true;
        }
    }
    
    public boolean updateScreen(Screen screenIn,String screenNameIn, int screenNumberIn, int noOfSeatsIn)
    
    {       
       if (screenNameIn != null && !screenNameIn.trim().equals("")){
    	   screenIn.setScreenName(screenNameIn);
        }
       
        if (noOfSeatsIn > 0 && noOfSeatsIn <= 100){
        	screenIn.setNoOfSeats(noOfSeatsIn);
        }
               
       return true;
    }
    

    public boolean removeScreen (int screenNumberIn)
    {
        if (screens.remove(screenNumberIn)!= null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
       
     public Set <Screen> getAllScreen()
    {
        Set <Screen> screenSet = new HashSet<Screen> ();
        Set<Integer> theKeys = screens.keySet();
        for (int screenNumber : theKeys)
        {
        	Screen theScreen = screens.get(screenNumber);
        	screenSet.add(theScreen);
        }
        return screenSet;
   }
   
    //cinema facilities: paragraph of text
//   public void getCinemaFacilities()
/*    public void getCinemaFacilities(String[] args) {
        try {
         BufferedReader in = new BufferedReader
         (new FileReader("c:\\filename"));
         String str;
         while ((str = in.readLine()) != null) {
            System.out.println(str);
         }
         System.out.println(str);
         }
         catch (IOException e) {
         }
    }       
   

   public void getCinemaPrices()
    {
        //cinema prices: table of prices
    }

   public void getPayments()
    {
        //Process payments
    } 
      
   public void getRefunds()
    {
        //Process refunds
    }  
    
*/    
}  
  