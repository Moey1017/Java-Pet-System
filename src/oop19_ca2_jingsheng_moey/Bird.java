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

    /**
     *
     * @param name
     * @param type
     * @param breed
     * @param age
     * @param colour
     * @param gender
     * @param regis_Date
     * @param ownerID
     * @param petID
     * @param hasWing
     * @param wingSpan
     */
    public Bird(String name, String type, String breed, int age, String colour, Gender gender, LocalDate regis_Date, String ownerID,String petID, boolean hasWing, double wingSpan)
    {
        super(name, type, breed, age, colour, gender, regis_Date, ownerID, petID);
        this.wingSpan = wingSpan;
        this.canFly = hasWing;
    }

    /**
     *
     * @param name
     * @param type
     * @param breed
     * @param colour
     * @param age
     * @param ownerID
     * @param gender
     * @param wingSpan
     * @param canFly
     */
    public Bird(String name, String type, String breed, String colour, int age, Gender gender, String ownerID, double wingSpan, boolean canFly)
    {
        super(name, type, breed, colour, age, gender, ownerID);
        this.wingSpan = wingSpan;
        this.canFly = canFly;
    }

    /**
     *
     * @param ownerID
     * @param petID
     * @param name
     * @param type
     * @param breed
     * @param colour
     * @param gender
     * @param age
     */
    public Bird(String ownerID, String petID, String name, String type, String breed, String colour, Gender gender, int age)
    {
        super(ownerID,petID, name, type, breed, colour, gender, age);
        this.wingSpan = wingSpan;
        this.canFly = canFly;
    }

    /**
     *
     * @return wingSpan
     */
    public double getWingSpan()
    {
        return wingSpan;
    }

    /**
     *
     * @return canFly
     */
    public boolean getCanFly()
    {
        return canFly;
    }

    /**
     * set wingSpan
     * @param wingSpan
     */
    public void setWingSpan(double wingSpan)
    {
        this.wingSpan = wingSpan;
    }

    /**
     * set hasWing
     * @param hasWing
     */
    public void setCanFly(boolean canFly)
    {
        this.canFly = canFly;
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
