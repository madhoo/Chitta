/**
 * 
 */
package net.chitta.cinema;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * @author Madhoo
 *
 */
public class Test {

	/**
	 * 
	 */
	public Test() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ConsoleIOUtil.getScreenInput ();
		

        Scanner sc = new Scanner(System.in);
     
//4        Screen screen;
           
            System.out.println("\ta - Title:");
            System.out.print("\t>> ");
            String title = sc.next();
//            String movie = null;
            if(title == null) {
                System.out.println("Movie name invalid");

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
               
            }
		}
	}

