/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop19_ca2_jingsheng_moey;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author HP
 */
public class Pet implements Serializable, Comparable<Pet>
{

    private String name;
    private String type;
    private String breed;
    private int age = 1;
    private String colour;
    private Gender gender;
    private LocalDate regis_Date;
    private String petID;

    public static int pets_registered = 0;
    private String ownerID;

    /**
     * use to load file
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
     */
    public Pet(String name, String type, String breed, int age, String colour, Gender gender, LocalDate regis_Date, String ownerID, String petID)
    {
        this.type = type;
        this.name = name;
        this.breed = breed;
        setAge(age);
        this.colour = colour;
        this.gender = gender;
        this.regis_Date = regis_Date;
        this.petID = petID;
        this.ownerID = ownerID;
    }

    /**
     * using this to add Pet in main
     *
     * @param name
     * @param type
     * @param breed
     * @param colour
     * @param age
     * @param ownerID
     */
    public Pet(String name, String type, String breed, String colour, int age, String ownerID)
    {
        this.name = name;
        this.type = type;
        this.breed = breed;
        this.colour = colour;
        this.age = age;
        this.regis_Date = LocalDate.now();
        this.gender = Gender.MALE;
        this.ownerID = ownerID;
        this.petID = "PID" + pets_registered;
        pets_registered++;
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
    public Pet(String ownerID, String petID, String name, String type, String breed, String colour, Gender gender, int age)
    {
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.ownerID = ownerID;
        this.petID = petID + pets_registered;
        pets_registered++;
    }

    /**
     *
     * @return type
     */
    public String getType()
    {
        return type;
    }

    /**
     *
     * @return name
     */
    public String getName()
    {
        return name;
    }

    /**
     *
     * @return breed
     */
    public String getBreed()
    {
        return breed;
    }

    /**
     *
     * @return age
     */
    public int getAge()
    {
        return age;
    }

    /**
     *
     * @return colour
     */
    public String getColour()
    {
        return colour;
    }

    /**
     *
     * @return gender
     */
    public Gender getGender()
    {
        return gender;
    }

    /**
     *
     * @return regis_Date
     */
    public LocalDate getRegis_Date()
    {
        return regis_Date;
    }

    /**
     *
     * @return petID
     */
    public String getPetID()
    {
        return petID;
    }

    /**
     *
     * @return ownerID
     */
    public String getOwnerID()
    {
        return ownerID;
    }

    /**
     * set next pet id
     *
     * @param nextPetID
     */
    public static void setPets_registered(int nextPetID)
    {
        Pet.pets_registered = nextPetID;
    }

    /**
     * set type
     *
     * @param type
     */
    public void setType(String type)
    {
        this.type = type;
    }

    /**
     * set name
     *
     * @param name
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * set breed
     *
     * @param breed
     */
    public void setBreed(String breed)
    {
        this.breed = breed;
    }

    /**
     * set age
     *
     * @param age
     */
    public void setAge(int age)
    {
        if (age < 0 || age > 100)
        {
            throw new IllegalArgumentException("IllegalArgumentException : Age can't be negative and More than 100.");
        }
        this.age = age;
    }

    /**
     * set color
     *
     * @param colour
     */
    public void setColour(String colour)
    {
        this.colour = colour;
    }

    /**
     * set gender
     *
     * @param gender
     */
    public void setGender(Gender gender)
    {
        this.gender = gender;
    }

    /**
     * set regis_Date
     *
     * @param regis_Date
     */
    public void setRegis_Date(LocalDate regis_Date)
    {
        this.regis_Date = regis_Date;
    }

    /**
     * set OID
     *
     * @param OID
     */
    public void setOwnerID(String OID)
    {
        this.ownerID = OID;
    }

    @Override
    public String toString()
    {
        return "Pet{" + "name=" + name + ", type=" + type + ", breed=" + breed + ", age=" + age + ", colour=" + colour + ", gender=" + gender + ", regis_Date=" + regis_Date + ", petID=" + petID + ", ownerID=" + ownerID + '}';
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.name);
        hash = 17 * hash + Objects.hashCode(this.type);
        hash = 17 * hash + Objects.hashCode(this.breed);
        hash = 17 * hash + this.age;
        hash = 17 * hash + Objects.hashCode(this.colour);
        hash = 17 * hash + Objects.hashCode(this.gender);
        hash = 17 * hash + Objects.hashCode(this.ownerID);
        return hash;
    }

    @Override
    public boolean equals(Object obj)
    {
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
        final Pet other = (Pet) obj;
        if (!Objects.equals(this.name, other.name))
        {
            return false;
        }
        if (!Objects.equals(this.type, other.type))
        {
            return false;
        }
        if (!Objects.equals(this.breed, other.breed))
        {
            return false;
        }
        if (!Objects.equals(this.colour, other.colour))
        {
            return false;
        }
        if (!Objects.equals(this.ownerID, other.ownerID))
        {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Pet other)
    {
        return this.petID.compareTo(other.petID);
    }
}
