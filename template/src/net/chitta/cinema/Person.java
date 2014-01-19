package net.chitta.cinema;

import java.io.Serializable;
import java.util.ArrayList;

public class Person implements Serializable{
	private String userId;
	private String password;
	private BookingSystem.ACCESS_LEVELS accessLevel; // consider an enumerated type for this
	private ArrayList<Booking> bookings;
	
	private String address;
	
	private String email;
	private String telephone;
	
	public Person(String name, String pw){
		this(name, pw, BookingSystem.ACCESS_LEVELS.NOTHING);
	}
	
	public Person(String name, String pw, BookingSystem.ACCESS_LEVELS accessLevel){
		userId = name;
		password = pw;
		this.accessLevel = accessLevel;
	}
	
	public boolean equals(Object o){        
		if (o instanceof Person){
			Person p = (Person)o;
			return p.getUserId().equals(this.userId) && 
					p.getPassword().equals(this.password);
		}
		return false;
	}
	
	public String toString(){
		return "UserId: " + userId + " Password: " + password + " Access Level " + accessLevel;
	}
	
	String getUserId(){
		return userId;
	}
	
	String getPassword(){
		return password;
	}
	
	BookingSystem.ACCESS_LEVELS getAccessLevel(){
		return accessLevel;
	}
	
}
