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
 * @author HP
 */
public class Pet
{
    private String      name;
    private String      type;
    private String      breed;
    private int         age = 1;
    private String      colour;
    private Gender      gender;
    private LocalDate   regis_Date;
    private String      petID = "PID";
    public  static int  current_pet = 0;
    private String      ownerID = "OID";

    public Pet(String name, String type, String breed, int age, String colour, Gender gender, LocalDate regis_Date, int numOwnerID) 
    {
        this.type = type;
        this.name = name;
        this.breed = breed;
        setAge(age);
        this.colour = colour;
        this.gender = gender;
        this.regis_Date = regis_Date;
        this.petID = petID + current_pet;
        current_pet++;
        this.ownerID = ownerID + numOwnerID;
    }

    public Pet(String name, String type, String breed, int age, String colour, Gender gender, LocalDate regis_Date)
    {
        this.type = type;
        this.name = name;
        this.breed = breed;
        setAge(age);
        this.colour = colour;
        this.gender = gender;
        this.regis_Date = regis_Date;
        this.petID = petID + current_pet;
        current_pet++;
    }

    //using this
    public Pet(String name, String type, String breed, String colour)
    {
        this.name = name;
        this.type = type;
        this.breed = breed;
        this.colour = colour;
        this.petID = petID + current_pet;
        current_pet++;
    }

    public Pet(String name) 
    {
        this.name = name;
        this.type = "";
        this.breed = "";
        setAge(age);
        this.colour = "";
        this.gender = gender;
        this.regis_Date = LocalDate.now();
        this.petID = petID + current_pet;
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

    public Gender getGender()
    {
        return gender;
    }

    public LocalDate getRegis_Date()
    {
        return regis_Date;
    }

    public String getPetID()
    {
        return petID;
    }

    public String getOwnerID()
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
        if(age < 0 || age > 100)
        {
            throw new IllegalArgumentException("IllegalArgumentException : Age can't be negative and More than 100.");
        }
        this.age = age;
    }

    public void setColour(String colour)
    {
        this.colour = colour;
    }

    public void setGender(Gender gender)
    {
        this.gender = gender;
    }

    public void setRegis_Date(LocalDate regis_Date)
    {
        this.regis_Date = regis_Date;
    }

    public void setOwnerID(int numOwnerID)
    {
        this.ownerID = "OID" + numOwnerID;
    }

    @Override
    public String toString()
    {
        return "Pet{" + "name=" + name + ", type=" + type + ", breed=" + breed + ", age=" + age + ", colour=" + colour + ", gender=" + gender + ", regis_Date=" + regis_Date + ", petID=" + petID + ", current_pet=" + current_pet + ", ownerID=" + ownerID + '}';
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
    
//    @Override
//    public boolean equals(Object obj)
//    {
//        if (this == obj)
//        {
//            return true;
//        }
//        if (obj == null)
//        {
//            return false;
//        }
//        if (getClass() != obj.getClass())
//        {
//            return false;
//        }
//        final Pet other = (Pet) obj;
//        if (this.age != other.age)
//        {
//            return false;
//        }
//        if (this.ownerID != other.ownerID)
//        {
//            return false;
//        }
//        if (!Objects.equals(this.name, other.name))
//        {
//            return false;
//        }
//        if (!Objects.equals(this.type, other.type))
//        {
//            return false;
//        }
//        if (!Objects.equals(this.breed, other.breed))
//        {
//            return false;
//        }
//        if (!Objects.equals(this.colour, other.colour))
//        {
//            return false;
//        }
//        if (this.gender != other.gender)
//        {
//            return false;
//        }
//        return true;
//    }
    
}
