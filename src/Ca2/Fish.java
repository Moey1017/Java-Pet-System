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
public class Fish extends Pet
{
    private String water_Type;

    public Fish(String type, String name, String breed, int age, String colour, char gender, String regis_Date,int ownerID, String water_Type)
    {
        super(type, name, breed, age, colour, gender, regis_Date, ownerID);
        this.water_Type = water_Type;
    }
    
    public Fish(String type, String name, String breed, int age, String colour, char gender, String regis_Date, String water_Type)
    {
        super(type, name, breed, age, colour, gender, regis_Date);
        this.water_Type = water_Type;
    }
    
    public Fish()
    {
        super();
    }

    public String getWater_Type()
    {
        return water_Type;
    }

    public void setWater_Type(String water_Type)
    {
        this.water_Type = water_Type;
    }

    @Override
    public String toString()
    {
        return super.toString() + "Fish{" + "water_Type=" + water_Type + '}';
    }

    
    
}
