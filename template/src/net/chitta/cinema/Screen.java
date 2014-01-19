package net.chitta.cinema;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.TreeSet;


/**
 * 8th April 2012
 */

// Data is serialised to a file
public class Screen  implements Serializable {
   // enum SCREEN_LAYOUT {LEFT, CENTRE, RIGHT};
//    private String title;
//    private String rating;
	private String screenName;
    private int screenNumber;
    private int noOfSeats;

//    private boolean allocated;
    
        // Mapping from seat number to a list of bookings for this screen.
//    protected HashMap<Integer, TreeSet<Booking>> seats = new HashMap<>();

    // Mapping from booking reference to booking object for this booking.
//    protected HashMap<String, Booking> bookings = new HashMap<>();

    // Constructor to set screen number.  ScreenNumberIn sets screen number.  
    // Throws exception if screen number is less than 0 or greater than 6,  screens 1 to 6 allowed.
    public Screen (int screenNumberIn) throws CinemaException {
//        if (screenNumberIn <1 && screenNumberIn >6)
//        {
//            throw new CinemaException ("Invalid Screen Number" +screenNumberIn);
//        }
//        screenNumber = screenNumberIn;
//        allocated = false; //screen number is available initially
    }

    public Screen (String screenNameIn, int screenNumberIn, int noOfSeatsIn)  {
    	screenName = screenNameIn;
    	screenNumber = screenNumberIn;
        noOfSeats = noOfSeatsIn;
   
    }
    
    
    //returns screen number
    public int getScreenNumber()
    {
        return screenNumber;
    }

    public int getNoOfSeats()
    {
        return noOfSeats;
    }
    
    public void setScreenName(String screenNameIn) {
        this.screenName = screenNameIn;
    }
    
    public void setNoOfSeats(int noOfSeatsIn) {
        this.noOfSeats = noOfSeatsIn;
    }
    
    public String validateScreen() {
    	if(this.screenNumber == 0 || this.screenNumber <1 || this.screenNumber >6) {
            return "Screen Number is out of Range.  Must be between 1 and 6";} 
    	else {
    	return null;       	
    	}
    }
    
/** 
    //returns screen number
    public int getScreenNumber()
    {
        return screenNumber;
    }
    
    // check to see if screen is already allocated
    // returns true if allocated, otherwise false
    public boolean isAllocated()
    {
        return allocated;
    }
    
    // screen is booked
    public void book()
    {
        allocated = true;
    }
    
    //screen is available
    public void available()
    {
        allocated = false;
    }
    
    public void setScreenNumber(int screenNumberIn)
    {
    	screenNumber = screenNumberIn;
  
    }
**/
}
//     
//     /**
//      * Constructs a screen with seat numbers as specified in seatNums.
//      * The seats are initially unbooked.
//   
//     public Screen (int[] seatNums) {
//         // Initialise the seat map.
//         for (int i = 0; i < seatNums.length; i++) {
//             seats.put(seatNums[i], new TreeSet<Booking>());
//         }
//     }
// 
//     /**
//      * Returns true if the seat seatNum is booked on any of the days
//      * specified in days, otherwise returns false.
//      */
//     boolean seatBooked(Calendar[] days, int seatNum) {
//         Arrays.sort(days);
//         // TreeSet iterator returns bookings for this seat ordered by the
//         // earliest day in the booking.
//         TreeSet<Booking> sbt = seats.get(seatNum);
// 
//         for (Booking booking : sbt) {
//             Calendar[] when = booking.dates;
//             // If the last day of this booking is before the first day of
//             // the new booking, skip it.
//             if (when[when.length - 1].before(days[0])) continue;
//             // If the first day of this booking is after the last day of the
//             // new booking, the room is free.
//             if (when[0].after(days[days.length - 1])) {
//                 return false;
//             } else {
//                 // The bookings may intersect.
//                 for (int j = 0; j < days.length; j++) {
//                     for (int k = 0; k < when.length; k++) {
//                         if (days[j] == when[k]) {
//                             return true;
//                         }
//                     }
//                 }
//             }
//         }
//         return false;
//     }
// }
// /*
//     /**
//      * Create a booking with reference bookingRef for the seat seatNum
//      * for each of the days specified in days. Returns true if it is possible
//      * to book the seat on the given days, otherwise (if the seat is booked
//      * on any of the specified days) returns false.
//      */
// 
//     boolean bookSeat(String bookingRef, Calendar[] dates, int screenNumber) {
//         // Check if the seat is already booked on the requested days.
//         if (!seatBooked(dates, screenNumber)) {
//             // Add the new booking to the current bookings.
//             Booking booking = new Booking(bookingRef, dates, screenNumber);
//             bookings.put(bookingRef, booking);
//             (seats.get(screenNumber)).add(booking);
//             return true;
//         }
//         return false;
//     }
// 
//     /**
//      * Updates the booking with reference bookingRef so that it now refers
//      * to the specified seatNum for each of the days specified in days.
//      * The previous booking under this booking reference is cancelled. If
//      * there is no booking with the specified reference throws
//      * NoSuchBookingException.
//      */
// 
//     boolean updateBooking(String bookingRef, Calendar[] dates, int screenNumber) throws CinemaException {
//         Booking booking = bookings.get(bookingRef);
//         if (booking == null) throw new CinemaException(bookingRef);
// 
//      //   Arrays.sort(dates);
// 
//         // returns bookings for this seat ordered by the earliest day in the booking.
//         TreeSet<Booking> sbt = seats.get(screenNumber);
// 
//         for (Booking otherBooking : sbt) {
//             // If this booking is the one we are updating, skip it.
//             if (otherBooking == booking) continue;
//             Calendar[] when = otherBooking.dates;
//             // If the last day of this booking is before the first day of
//             // the new booking, skip it.
//             if (when[when.length - 1].before(dates[0])) continue;
//             // If the first day of this booking is after the last day of the
//             // new booking, the room is free.
//             if (when[0].after(dates[dates.length - 1])) {
//                 break;
//             } else {
//                 // The bookings may intersect.
//                 for (int j = 0; j < dates.length; j++) {
//                     for (int k = 0; k < when.length; k++) {
//                         if (dates[j] == when[k]) {
//                             return false;
//                         }
//                     }
//                 }
//             }
//         }
// 
//         // If the new booking is for a different screen, remove the booking
//         // from the list of bookings for the previous screen and add it to the
//         // list for this screen.
//         if (booking.screen != screenNumber) {
//             (seats.get(booking.screen)).remove(booking);
//             (seats.get(screenNumber)).add(booking);
//         }
// 
//         // Update the booking.
//         booking.dates = dates;
//         booking.screen = screenNumber;
//         return true;
//     }
// 
//     /**
//      * Cancel the booking with reference bookingRef. The seat booked under
//      * this booking reference becomes unbooked for the days of the
//      * booking. If there is no booking with the specified reference throws
//      * NoSuchBookingException.
//      */
// 
//     void cancelBooking(String bookingRef) throws CinemaException {
//         Booking booking = bookings.get(bookingRef);
//         if (booking == null) throw new CinemaException(bookingRef);
// 
//         // Remove the booking from the bookings table and the list of
//         // bookings for this room.
//         bookings.remove(bookingRef);
//         seats.get(booking.screen).remove(booking);
//     }
// }
// 
// */
