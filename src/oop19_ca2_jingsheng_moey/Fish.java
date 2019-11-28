/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop19_ca2_jingsheng_moey;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author D00217017
 */
public class Fish extends Pet
{

    private WaterType water_Type;

    /**
     *
     * @param type
     * @param name
     * @param breed
     * @param age
     * @param colour
     * @param gender
     * @param regis_Date
     * @param ownerID
     * @param petID
     * @param water_Type
     */
    public Fish(String type, String name, String breed, int age, String colour, Gender gender, LocalDate regis_Date, String ownerID,String petID, WaterType water_Type)
    {
        super(name, type, breed, age, colour, gender, regis_Date, ownerID, petID);
        this.water_Type = water_Type;
    }

    /**
     *
     * @param name
     * @param type
     * @param breed
     * @param colour
     * @param age
     * @param ownerID
     * @param water_Type
     */
    public Fish(String name, String type, String breed, String colour, int age, String ownerID, WaterType water_Type)
    {
        super(name, type, breed, colour, age, ownerID);
        this.water_Type = water_Type;
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
    public Fish(String ownerID, String petID, String name, String type, String breed, String colour, Gender gender, int age)
    {
        super(ownerID,petID, name, type, breed, colour, gender, age);
        this.water_Type = water_Type;
    }

    /**
     *
     * @return water_Type
     */
    public WaterType getWater_Type()
    {
        return water_Type;
    }

    /**
     *
     * @param water_Type
     */
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
        if (super.equals(obj) == true)
        {
            final Fish other = (Fish) obj;
            if (this.water_Type != other.water_Type)
            {
                return false;
            }
            return true;
        }
        else
            return false;
    }

}
