/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop19_ca2_jingsheng_moey;

import java.time.LocalDate;

/**
 *
 * @author HP
 */
public class Mammal extends Pet
{

    private boolean isNeutered;

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
     * @param isNeutered
     */
    public Mammal(String type, String name, String breed, int age, String colour, Gender gender, LocalDate regis_Date, String ownerID, String petID, boolean isNeutered)
    {
        super(name, type, breed, age, colour, gender, regis_Date, ownerID, petID);
        this.isNeutered = isNeutered;
    }

    /**
     *
     * @param name
     * @param type
     * @param breed
     * @param colour
     * @param age
     * @param gender
     * @param ownerID
     * @param isNeutered
     */
    public Mammal(String name, String type, String breed, String colour, int age, Gender gender, String ownerID, boolean isNeutered)
    {
        super(name, type, breed, colour, age, gender, ownerID);
        this.isNeutered = isNeutered;
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
    public Mammal(String ownerID, String petID, String name, String type, String breed, String colour, Gender gender, int age)
    {
        super(ownerID,petID, name, type, breed, colour, gender, age);
        this.isNeutered = isNeutered;
    }

    /**
     *
     * @return isNeutered
     */
    public boolean isIsNeutered()
    {
        return isNeutered;
    }

    /**
     *
     * @param isNeutered
     */
    public void setIsNeutered(boolean isNeutered)
    {
        this.isNeutered = isNeutered;
    }

    @Override
    public String toString()
    {
        return super.toString() + "Mammal{" + "isNeutered=" + isNeutered + '}';
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 41 * hash + (this.isNeutered ? 1 : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (super.equals(obj) == true)
        {
            final Mammal other = (Mammal) obj;
            if (this.isNeutered != other.isNeutered)
            {
                return false;
            }
            return true;
        }
        else
            return false;
    }

}
