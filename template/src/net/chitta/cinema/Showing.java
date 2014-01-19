package net.chitta.cinema;

import java.io.Serializable;
import java.util.Date;

  public class Showing implements Serializable
 {
//    private Screen screen;
//    private Movie movie;
    private Date showDate;
    private String movieTitle;
    private int screenNumber;
    private int noOfSeatsFree;
     
  public Showing (Date showDate, int screenNumberIn, String movieTitleIn, int noOfSeatsFreeIn)
  {
//  this.screen = screen;
//  this.movie = movie;
  this.showDate = showDate;
  this.screenNumber = screenNumberIn;
  this.movieTitle = movieTitleIn;
  this.noOfSeatsFree = noOfSeatsFreeIn;
  }
  
  public void setShowing (Date showDate, int screenNumberIn, String movieTitleIn, int noOfSeatsFreeIn)
  {
//  this.screen = screen;
//  this.movie = movie;
  this.showDate = showDate;
  this.screenNumber = screenNumberIn;
  this.movieTitle = movieTitleIn;
  }
  
//  public int getScreen(){
	  
//      return this.screen;
//      return this.screenNumber;     
//    }
    
   public void setScreen(int screenNumberIn) {
//       this.screen = screen;
       this.screenNumber = screenNumberIn;       
    }
    
    public String getMovieTitle(){
     return movieTitle;
    }
    
    public void setMovieTitle (String movieTitle){
        this.movieTitle = movieTitle;
    }
    
    public Date getShowDate(){
        return showDate;
    }
    
    public void setShowDate(Date showDate){
        this.showDate = showDate;
    }
             
  public int getScreenNumber() {
//		  throws CinemaException
//  {
//        if (screen == null)
//        {
//            throw new CinemaException ("Screen has not been allocated");
//        }
        return screenNumber;
  }
  
  public int getNoOfSeatsFree(){
      return noOfSeatsFree;
  }

}
