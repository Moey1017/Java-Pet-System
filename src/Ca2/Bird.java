/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ca2;

/**
 *
 * @author D00217017
 */
public class Bird extends Pet
{
    private double wingSpan;
    private boolean hasWing;

    public Bird(String type, String name, String breed, int age, String colour, char gender, String regis_Date,int ownerID, boolean hasWing, double wingSpan) 
    {
        super(type, name, breed, age, colour, gender, regis_Date, ownerID);
        this.wingSpan = wingSpan;
        this.hasWing = hasWing;
    }
    
    public Bird(String type, String name, String breed, int age, String colour, char gender, String regis_Date, boolean hasWing, double wingSpan) 
    {
        super(type, name, breed, age, colour, gender, regis_Date);
        this.wingSpan = wingSpan;
        this.hasWing = hasWing;
    }

    public Bird()
    {
        super();
    }

    public double getWingSpan()
    {
        return wingSpan;
    }

    public boolean isHasWing()
    {
        return hasWing;
    }

    public void setWingSpan(double wingSpan)
    {
        this.wingSpan = wingSpan;
    }

    public void setHasWing(boolean hasWing)
    {
        this.hasWing = hasWing;
    }

    @Override
    public String toString()
    {
        return super.toString() + "Bird{" + "wingSpan=" + wingSpan + ", hasWing=" + hasWing + '}';
    }
    
    
}
