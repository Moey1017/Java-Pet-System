/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop19_ca2_jingsheng_moey;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

/**
 *
 * @author HP
 */
public class Owner implements Serializable, Comparable<Owner>
{

    private String name;
    private String email;
    private String telephone;
    private String home_Address;
    private String ownerID;

    /**
     *
     */
    public static int owners_registered = 0;
    private ArrayList<Pet> pets;

    /**
     * Constructor
     *
     * @param name
     * @param email
     * @param telephone
     * @param home_Address
     */
    public Owner(String name, String email, String telephone, String home_Address)
    {
        this.name = name;
        this.email = email;
        this.telephone = telephone;
        this.home_Address = home_Address;
        this.ownerID = "OID" + owners_registered;
        owners_registered++;
        this.pets = new ArrayList<>();
    }

    /**
     * Constructor
     *
     * @param OID
     * @param name
     * @param email
     * @param telephone
     * @param home_Address
     */
    public Owner(String OID, String name, String email, String telephone, String home_Address)
    {
        this.ownerID = OID;
        this.name = name;
        this.email = email;
        this.telephone = telephone;
        this.home_Address = home_Address;
        this.pets = new ArrayList<>();
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
     * @return ownerID
     */
    public String getOwnerID()
    {
        return ownerID;
    }

    /**
     *
     * @return email
     */
    public String getEmail()
    {
        return email;
    }

    /**
     *
     * @return telephone
     */
    public String getTelephone()
    {
        return telephone;
    }

    /**
     *
     * @return home_Address
     */
    public String getHome_Address()
    {
        return home_Address;
    }

    /**
     * set nextId
     *
     * @param nextId
     */
    public static void setOwners_registered(int nextId)
    {
        Owner.owners_registered = nextId;
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
     * setOwnerID
     *
     * @param id
     */
    public void setOwnerID(int id)
    {
        this.ownerID = "OID" + id;
    }

    /**
     * setEmail
     *
     * @param email
     */
    public void setEmail(String email)
    {
        this.email = email;
    }

    /**
     * setTelephone
     *
     * @param telephone
     */
    public void setTelephone(String telephone)
    {
        this.telephone = telephone;
    }

    /**
     * setHome_Address
     *
     * @param home_Address
     */
    public void setHome_Address(String home_Address)
    {
        this.home_Address = home_Address;
    }

    /**
     * addPet into owner's pet arrayList
     *
     * @param p
     */
    public void addPet(Pet p)
    {
        this.pets.add(p);
    }

    /**
     *
     * @return getPetAmount
     */
    public int getPetAmount()
    {
        return pets.size();
    }

    /**
     *
     * @param PID
     * @return thisPets
     */
    public Pet thisPets(int PID)
    {
        return pets.get(PID);
    }

    /**
     * display Owner Pets
     */
    public void displayOwnerPets()
    {
        for (int i = 0; i < pets.size(); i++)
        {
            System.out.println(pets.get(i));
        }
    }

    /**
     *
     * @param PID
     * @return ThisPet
     */
    public Pet getThisPet(int PID)
    {
        return this.pets.get(PID);
    }

    @Override
    public String toString()
    {
        return "Owner{" + "name=" + name + ", email=" + email + ", telephone=" + telephone + ", home_Address=" + home_Address + ", ownerID=" + ownerID + ", pets=" + pets + '}';
    }

    /**
     *
     * @return this pet ArrayList
     */
    public ArrayList<Pet> getPets()
    {
        return pets;
    }

    /**
     * setPetOwnerId
     *
     * @param petPos
     * @param OID
     */
    public void setPetOwnerId(int petPos, String OID)
    {
        pets.get(petPos).setOwnerID(OID);
    }

    /**
     * setPetName
     *
     * @param petPos
     * @param name
     */
    public void setPetName(int petPos, String name)
    {
        pets.get(petPos).setName(name);
    }

    /**
     * setPetType
     *
     * @param petPos
     * @param type
     */
    public void setPetType(int petPos, String type)
    {
        pets.get(petPos).setType(type);
    }

    /**
     * setPetBreed
     *
     * @param petPos
     * @param breed
     */
    public void setPetBreed(int petPos, String breed)
    {
        pets.get(petPos).setBreed(breed);
    }

    /**
     * setPetColour
     *
     * @param petPos
     * @param colour
     */
    public void setPetColour(int petPos, String colour)
    {
        pets.get(petPos).setColour(colour);
    }

    /**
     * setPetAge
     *
     * @param petPos
     * @param age
     */
    public void setPetAge(int petPos, int age)
    {
        pets.get(petPos).setAge(age);
    }

    /**
     * setPetGender
     *
     * @param petPos
     * @param gender
     */
    public void setPetGender(int petPos, Gender gender)
    {
        pets.get(petPos).setGender(gender);
    }

    /**
     * setPetRegisDate
     *
     * @param petPos
     * @param regisDate
     */
    public void setPetRegisDate(int petPos, LocalDate regisDate)
    {
        pets.get(petPos).setRegis_Date(regisDate);
    }

    /**
     * setPetWingSpan
     *
     * @param petPos
     * @param wingSpan
     */
    public void setPetWingSpan(int petPos, double wingSpan)
    {
        ((Bird) pets.get(petPos)).setWingSpan(wingSpan);
    }

    /**
     * setPetCanFly
     *
     * @param petPos
     * @param canFly
     */
    public void setPetCanFly(int petPos, boolean canFly)
    {
        ((Bird) pets.get(petPos)).setCanFly(canFly);
    }

    /**
     * setPetNeutered
     *
     * @param petPos
     * @param isNeutered
     */
    public void setPetNeutered(int petPos, boolean isNeutered)
    {
        ((Mammal) pets.get(petPos)).setIsNeutered(isNeutered);
    }

    /**
     * setPetWaterType
     *
     * @param petPos
     * @param water_Type
     */
    public void setPetWaterType(int petPos, WaterType water_Type)
    {
        ((Fish) pets.get(petPos)).setWater_Type(water_Type);
    }

    /**
     * GetPetExistID
     *
     * @param PID
     * @return
     */
    public int GetPetExistID(String PID)
    {
        int pos = -1;
        for (int i = 0; i < pets.size(); i++)
        {
            if (pets.get(i).getPetID().equals(PID))
            {
                return i;
            }
        }
        return pos;
    }

    /**
     * check ifPetExist
     *
     * @param PID
     * @return true of false if pet exist
     */
    public boolean ifPetExist(String PID)
    {
        if (GetPetExistID(PID) == -1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    /**
     * deletePetById
     *
     * @param PID
     */
    public void deletePetById(String PID)
    {
        int pos = GetPetExistID(PID);
        if (pos == -1)
        {
            System.out.println("Pet not found");
        }
        else
        {
            pets.remove(pos);
            System.out.println("Pet's removed");
        }
    }

    /**
     * deleteAllPet in this owner
     */
    public void deleteAllPet()
    {
        pets.removeAll(pets);
    }

    /**
     * get Mammal number
     *
     * @return number of mammal
     */
    public int getMammalNum()
    {
        int mammalNum = 0;
        for (Pet p : this.pets)
        {
            if (p instanceof Mammal)
            {
                mammalNum++;
            }
        }
        return mammalNum;
    }

    /**
     * get bird number
     *
     * @return bird numbers
     */
    public int getBirdNum()
    {
        int birdNum = 0;
        for (Pet p : this.pets)
        {
            if (p instanceof Bird)
            {
                birdNum++;
            }
        }
        return birdNum;
    }

    /**
     * get fish number
     *
     * @return fish number
     */
    public int getFishNum()
    {
        int fishNum = 0;
        for (Pet p : this.pets)
        {
            if (p instanceof Fish)
            {
                fishNum++;
            }
        }
        return fishNum;
    }

    //not used
    /**
     * calculate percentageOfFish
     *
     * @return percentageOfFish
     */
    public double percentageOfFish()
    {
        int fishNum = getFishNum();
        int totalPets = this.getPetAmount();
        return fishNum / (int) totalPets;
    }

    //not used 
    /**
     * calculate percentageOfBird
     *
     * @return percentageOfBird
     */
    public double percentageOfBird()
    {
        int birdNum = getBirdNum();
        int totalPets = this.getPetAmount();
        return birdNum / (int) totalPets;
    }

    //not used
    /**
     * calculate percentageOfMammal
     *
     * @return percentageOfMammal
     */
    public double percentageOfMammal()
    {
        int mammalNum = getMammalNum();
        int totalPets = this.getPetAmount();
        return mammalNum / (int) totalPets;
    }

    /**
     * get total wing span
     *
     * @return total wing span
     */
    public double getTotalBirdWingSpan()
    {
        double totalWingSpan = 0;
        for (Pet p : this.pets)
        {
            if (p instanceof Bird)
            {
                totalWingSpan = totalWingSpan + ((Bird) p).getWingSpan();
            }
        }
        return totalWingSpan;
    }

    /**
     * get Number of Bird that Can Fly
     *
     * @return Number of Bird that Can Fly
     */
    public int getNumBirdCanFly()
    {
        int canFlyNum = 0;
        for (Pet p : this.pets)
        {
            if (p instanceof Bird)
            {
                if (((Bird) p).getCanFly() == true)
                {
                    canFlyNum++;
                }
            }
        }
        return canFlyNum;
    }

    /**
     * get Num Mammal Neutered
     *
     * @return number of mammal is neutered
     */
    public int getNumMammalNeutered()
    {
        int neuteredNum = 0;
        for (Pet p : this.pets)
        {
            if (p instanceof Mammal)
            {
                if (((Mammal) p).isIsNeutered() == true)
                {
                    neuteredNum++;
                }
            }
        }
        return neuteredNum;
    }

    /**
     * get Number of Male Pet
     *
     * @return number of male pet
     */
    public int getNumMalePet()
    {
        int maleNum = 0;
        for (Pet p : this.pets)
        {
            if (p.getGender().toString().equalsIgnoreCase("male"))
            {
                maleNum++;
            }
        }
        return maleNum;
    }

    /**
     * sort pet in natural order
     *
     * @param other
     */
    public void sortPet(Pet other)
    {
        Collections.sort(pets);
    }

    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.name);
        hash = 59 * hash + Objects.hashCode(this.email);
        hash = 59 * hash + Objects.hashCode(this.home_Address);
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
        final Owner other = (Owner) obj;
        if (!Objects.equals(this.name, other.name))
        {
            return false;
        }
        if (!Objects.equals(this.email, other.email))
        {
            return false;
        }
        if (!Objects.equals(this.home_Address, other.home_Address))
        {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(Owner other)
    {
        return this.ownerID.compareTo(other.ownerID);
    }

}
