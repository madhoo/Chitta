package net.chitta.products.price;

/**
 * To test price
 * 
 * Madhoo Soodan
 * 01/03/2011
 */

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Date;

// import price.Price;


public class TestPrice {


	public static void main(String[] args) {
		DecimalFormat df = new DecimalFormat( "###,##0.00" );
        Price spoon = new Price(4, 255);
        Price fork = new Price(5, 60);
        System.out.println("Spoon =" + spoon.getfullPrice() + "p  ; Fork =  " + fork.getfullPrice() + "p");
        int spoon_pound = spoon.setPounds(12);
        spoon.setPounds(12);
        String spoon_pence = spoon.setPence(715); 
        System.out.println(spoon.getPounds());
        System.out.println(spoon.getPence());       
        double spoon_price = spoon.getfullPrice();      
        System.out.println("pounds set to  "+spoon_pound+",  pence set to  "+spoon_pence+",  price is set at  £"+df.format(spoon_price/100));
        System.out.println(spoon_price/100);
        System.out.println(spoon.getPounds());
        System.out.println(spoon.getPence()); 
        System.out.println(spoon.setPoPe(5,125));
        System.out.println(fork.setPoPe(5,345)); 
        
        System.out.println(NumberFormat.getCurrencyInstance().format(fork.pounds)); 
        System.out.println(fork.pence);
        System.out.println(Math.sqrt(fork.pounds));
        System.out.println(System.currentTimeMillis());
        System.out.println(new Date());
          
        
	}

}
