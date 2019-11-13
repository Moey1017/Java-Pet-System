/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ca2;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author D00217017
 */
public class Fish extends Pet
{
    private WaterType water_Type;

    public Fish(String type, String name, String breed, int age, String colour, Gender gender, LocalDate regis_Date,int ownerID, WaterType water_Type)
    {
        super(name, type, breed, age, colour, gender, regis_Date, ownerID);
        this.water_Type = water_Type;
    }
    
    public Fish(String type, String name, String breed, int age, String colour, Gender gender, LocalDate regis_Date, WaterType water_Type)
    {
        super(name, type, breed, age, colour, gender, regis_Date);
        this.water_Type = water_Type;
    }
    
    public Fish(String name, String type, String breed, String colour, WaterType water_Type)
    {
        super(name, type, breed, colour);
        this.water_Type = water_Type;
    }
    
    public Fish(String name)
    {
        super(name);
        this.water_Type = water_Type;
    }

    public WaterType getWater_Type()
    {
        return water_Type;
    }

    public void setWater_Type(WaterType water_Type)
    {
        this.water_Type = water_Type;
    }

    @Override
    public String toString()
    {
        return super.toString() + "Fish{" + "water_Type=" + water_Type + '}';
    }

    @Override
    public int hashCode()
    {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.water_Type);
        return hash;
    }

    @Override
    public boolean equals(Object obj)
    {
        super.equals(obj);
        if (this == obj)
        {
            return true;
        }
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        final Fish other = (Fish) obj;
        if (this.water_Type != other.water_Type)
        {
            return false;
        }
        return true;
    }
    
}
