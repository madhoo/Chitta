package net.chitta.products.price;
/**
 * To calculate price
 * 
 * Madhoo Soodan
 * 01/03/2011
 */
public class Price
{
    public int pounds;
    public int pence;


    Price()
    {
        pounds = 0;
        pence = 0;
    }
    
    Price (int po, int pe)
    {

        pence = pe%100;
        pounds = po+(pe-pence)/100;
    }
    
    public int setPounds(int po)
    {
        pounds = po;
        return pounds;
    }
    
    public String setPence(int pe)
    {
        pence = pe%100;
        pounds = pounds+(pe-pence)/100;

        return ("£" + pounds + "." + pence);
    }
    
    public String setPoPe(int po, int pe)
    {
        pence = pe%100;
        pounds = po+(pe-pence)/100;
        return ("£" + pounds + "." + pence);     
    }

    public int getPounds()
    {
        return pounds;
    }
    
    public int getPence()
    {
        return pence;
    }
    
    public double getfullPrice()
    {
        double fullPrice = ((pounds * 100) + pence);
        return fullPrice;
    }
    

}
