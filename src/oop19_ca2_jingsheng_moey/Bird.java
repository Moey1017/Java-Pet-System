/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop19_ca2_jingsheng_moey;

import java.time.LocalDate;

/**
 *
 * @author D00217017
 */
public class Bird extends Pet
{

    private double wingSpan;
    private boolean canFly;

    public Bird(String name, String type, String breed, int age, String colour, Gender gender, LocalDate regis_Date, String ownerID,String petID, boolean hasWing, double wingSpan)
    {
        super(name, type, breed, age, colour, gender, regis_Date, ownerID, petID);
        this.wingSpan = wingSpan;
        this.canFly = hasWing;
    }

    public Bird(String name, String type, String breed, String colour, int age, String ownerID, double wingSpan, boolean canFly)
    {
        super(name, type, breed, colour, age, ownerID);
        this.wingSpan = wingSpan;
        this.canFly = canFly;
    }

    public Bird(String name)
    {
        super(name);
        this.wingSpan = wingSpan;
        this.canFly = canFly;
    }

    public Bird(String ownerID, String petID, String name, String type, String breed, String colour, Gender gender, int age)
    {
        super(ownerID,petID, name, type, breed, colour, gender, age);
        this.wingSpan = wingSpan;
        this.canFly = canFly;
    }

    public double getWingSpan()
    {
        return wingSpan;
    }

    public boolean getCanFly()
    {
        return canFly;
    }

    public void setWingSpan(double wingSpan)
    {
        this.wingSpan = wingSpan;
    }

    public void setHasWing(boolean hasWing)
    {
        this.canFly = hasWing;
    }

    @Override
    public String toString()
    {
        return super.toString() + "Bird{" + "wingSpan=" + wingSpan + ", canFly=" + canFly + '}';
    }

    @Override
    public int hashCode()
    {
        int hash = 3;
        hash = 71 * hash + (int) (Double.doubleToLongBits(this.wingSpan) ^ (Double.doubleToLongBits(this.wingSpan) >>> 32));
        hash = 71 * hash + (this.canFly ? 1 : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (super.equals(obj))
        {
            if (obj instanceof Bird)
            {
                final Bird other = (Bird) obj;
                if (Double.doubleToLongBits(this.wingSpan) != Double.doubleToLongBits(other.wingSpan))
                {
                    return false;
                }
                if (this.canFly != other.canFly)
                {
                    return false;
                }
                return true;
            }
        }
        return false;
    }

}
