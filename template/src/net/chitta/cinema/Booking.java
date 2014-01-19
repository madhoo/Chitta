package net.chitta.cinema;

//import java.beans.Transient;
import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

// 9th April 2012


 public class Booking implements Serializable {
    private Showing show;
    //private int bookingNumber;
    private boolean bookingAllocated;
    private Person p;

    enum ACCESS_LEVELS { MANAGER, CUSTOMER, NOTHING};
    
    private String bookingRef;
    private Date cancelationDate;

  public Booking (Showing show, Person p, String bookingRef)
  {
      this.show = show;
      this.p = p;
      this.bookingRef = bookingRef;
  }
  
  public Showing getShowing()
  {
      return this.show;
  }
  
  public void setShowing(Showing show)
  {
      this.show = show;
  }
  
  public Person getPerson()
  {
      return p;
  }
  
  public void setPerson(Person p)
  {
      this.p = p;
  }
  
  public String getBookingRef()
  {
      return bookingRef;
  }
  
  public void setString(String bookingRef)
  {
      this.bookingRef = bookingRef;
  }
  
  /*
  public boolean addBooking(Showing show, Person p, String bookingRef);
          try {             
             Booking booking = new Booking(show, p, bookingRef);
             return addBooking(booking);
        } catch (Exception e){
            return false;
        }
        
    } 
 
    private boolean addBooking(Booking bookingIn)
    {
         bookings.add(bookingIn);
          return true;
    } 
*/
} 
    
/*    
import java.util.Arrays;
import java.util.Calendar;

public class Booking implements Comparable<Booking> {
    String reference;
    Calendar[] dates;
    int screen;
    
    private Showing show;
	private int bookingNumber;
	private boolean bookingAllocated;
	private Person p;

    public Booking(String reference, Calendar[] dates, int screen) {
        Arrays.sort(dates);

        this.reference = reference;
        this.dates = dates;
        this.screen = screen;
    }

    // We assume that the dates for each booking are in ascending order, and
    // order bookings by the earliest (i.e. first) date in the booking
    public int compareTo(Booking otherBooking) {
        if (dates[0].before(otherBooking.dates[0])) return -1;
        if (otherBooking.dates[0].before(dates[0])) return 1;
        // Ensure the order is consistent with equals.  This isn't strictly
        // necessary, since we should never have two bookings for the same
        // room which have the same start date (or any date).
        return reference.compareTo(otherBooking.reference);
    }

}

    
  
  public Booking (int bookingNumberIn) throws CinemaException 
  {
    if (bookingNumberIn <= 0)
    {
        throw new CinemaException ("Invalid Booking Number" +bookingNumberIn);
    }
    bookingNumber = bookingNumberIn;
    bookingAllocated = false; //booking is acceptable
 }
 
  public int getBookingNumber()
  {
      return bookingNumber;
  }
  
  // check to see if booking is allocated
  public boolean isBookingAllocated()
  {
      return bookingAllocated;
  }
  
  // booking allocated
  public void booked()
  {
      bookingAllocated =  true;
  }
  
  //booking is available
  public void bookingAvailable ()
  {
      bookingAllocated = false;
  }
 }
*/

 