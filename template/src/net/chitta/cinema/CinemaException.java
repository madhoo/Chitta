package net.chitta.cinema;

public class CinemaException extends Exception{

	public CinemaException(){
		super("Error: Cinema System Violation");
	}
	
	public CinemaException (String msg){
		super(msg);
	}
	
}
