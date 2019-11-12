/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ca2;

/**
 *
 * @author HP
 */
public class Pet
{
    private String type;
    private String name;
    private String breed;
    private int    age;
    private String colour;
    private char gender;
    private String regis_Date;
    private int petID;
    public int current_pet = 0;
    private int ownerID;

    public Pet(String type, String name, String breed, int age, String colour, char gender, String regis_Date, int ownerID) 
    {
        this.type = type;
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.colour = colour;
        this.gender = gender;
        this.regis_Date = regis_Date;
        this.petID = current_pet;
        current_pet++;
        this.ownerID = ownerID;
    }

    public Pet(String type, String name, String breed, int age, String colour, char gender, String regis_Date)
    {
        this.type = type;
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.colour = colour;
        this.gender = gender;
        this.regis_Date = regis_Date;
        this.petID = current_pet;
        current_pet++;
    }
    
    public Pet() 
    {
        this.petID = current_pet;
        current_pet++;
    }

    public String getType()
    {
        return type;
    }

    public String getName()
    {
        return name;
    }

    public String getBreed()
    {
        return breed;
    }

    public int getAge()
    {
        return age;
    }

    public String getColour()
    {
        return colour;
    }

    public char getGender()
    {
        return gender;
    }

    public String getRegis_Date()
    {
        return regis_Date;
    }

    public int getPetID()
    {
        return petID;
    }

    public int getOwnerID()
    {
        return ownerID;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setBreed(String breed)
    {
        this.breed = breed;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public void setColour(String colour)
    {
        this.colour = colour;
    }

    public void setGender(char gender)
    {
        this.gender = gender;
    }

    public void setRegis_Date(String regis_Date)
    {
        this.regis_Date = regis_Date;
    }

    public void setOwnerID(int ownerID)
    {
        this.ownerID = ownerID;
    }

    @Override
    public String toString()
    {
        return "Pet{" + "type=" + type + ", name=" + name + ", breed=" + breed + ", age=" + age + ", colour=" + colour + ", gender=" + gender + ", regis_Date=" + regis_Date + ", petID=" + petID + ", ownerID=" + ownerID + '}';
    }
    
    
}
