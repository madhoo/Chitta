package net.chitta.cinema;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class PreLoad {
	private static final String FILENAME = "system.ser";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BookingSystem sys= new BookingSystem("VUE Cinema at Harrow : Booking System");
		//System.out.println(sys);
		
		sys.addManager("manager", "manager123");
		sys.addCustomer("customer1", "customer1");
		sys.addCustomer("customer2", "customer2");
		sys.addCustomer("customer3", "customer3");
		sys.addCustomer("customer4", "customer4");
		sys.addCustomer("customer5", "customer5");
		sys.addCustomer("customer6", "customer6");
				
		System.out.println("Data for Vue Cinema in Harrow will be initialised and saved to file");
		save(sys);
	}
	
	private static void save(BookingSystem sys) {
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
