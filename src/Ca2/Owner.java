/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ca2;

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
    public static int owners_registered = 0;
    private ArrayList<Pet> pets;

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

    public Owner(String OID, String name, String email, String telephone, String home_Address)
    {
        this.ownerID = OID;
        this.name = name;
        this.email = email;
        this.telephone = telephone;
        this.home_Address = home_Address;
        this.pets = new ArrayList<>();
    }

    public Owner(String name)
    {
        this.name = name;
        this.ownerID = "OID" + owners_registered;
        owners_registered++;
        this.pets = new ArrayList<>();
    }

    public Owner()
    {
        this.pets = new ArrayList<Pet>();
    }

    public String getName()
    {
        return name;
    }

    public String getOwnerID()
    {
        return ownerID;
    }

    public String getEmail()
    {
        return email;
    }

    public String getTelephone()
    {
        return telephone;
    }

    public String getHome_Address()
    {
        return home_Address;
    }

    public static void setOwners_registered(int nextId)
    {
        Owner.owners_registered = nextId;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setOwnerID(int id)
    {
        this.ownerID = "OID" + id;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public void setTelephone(String telephone)
    {
        this.telephone = telephone;
    }

    public void setHome_Address(String home_Address)
    {
        this.home_Address = home_Address;
    }

    public void addPet(Pet p)
    {
        this.pets.add(p);
    }

    public int getPetAmount()
    {
        return pets.size();
    }

    public Pet thisPets(int PID)
    {
        return pets.get(PID);
    }

    public void displayOwnerPets()
    {
        for (int i = 0; i < pets.size(); i++)
        {
            System.out.println(pets.get(i));
        }
    }

    public Pet getThisPet(int PID)
    {
        return this.pets.get(PID);
    }

    @Override
    public String toString()
    {
        return "Owner{" + "name=" + name + ", email=" + email + ", telephone=" + telephone + ", home_Address=" + home_Address + ", ownerID=" + ownerID + ", pets=" + pets + '}';
    }

    public ArrayList<Pet> getPets()
    {
        return pets;
    }

    public boolean duplicate(Pet p)
    {
        return pets.contains(p);
    }

    public void setPetOwnerId(int petPos, String OID)
    {
        pets.get(petPos).setOwnerID(OID);
    }

    public void setPetName(int petPos, String name)
    {
        pets.get(petPos).setName(name);
    }

    public void setPetType(int petPos, String type)
    {
        pets.get(petPos).setType(type);
    }

    public void setPetBreed(int petPos, String breed)
    {
        pets.get(petPos).setBreed(breed);
    }

    public void setPetColour(int petPos, String colour)
    {
        pets.get(petPos).setColour(colour);
    }

    public void setPetAge(int petPos, int age)
    {
        pets.get(petPos).setAge(age);
    }

    public void setPetGender(int petPos, Gender gender)
    {
        pets.get(petPos).setGender(gender);
    }

    public void setPetRegisDate(int petPos, LocalDate regisDate)
    {
        pets.get(petPos).setRegis_Date(regisDate);
    }

    public void setPetWingSpan(int petPos, double wingSpan)
    {
        ((Bird) pets.get(petPos)).setWingSpan(wingSpan);
    }

    public void setPetCanFly(int petPos, boolean hasWing)
    {
        ((Bird) pets.get(petPos)).setHasWing(hasWing);
    }

    public void setPetNeutered(int petPos, boolean isNeutered)
    {
        ((Mammal) pets.get(petPos)).setIsNeutered(isNeutered);
    }

    public void setPetWaterType(int petPos, WaterType water_Type)
    {
        ((Fish) pets.get(petPos)).setWater_Type(water_Type);
    }

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

    public void deleteAllPet()
    {
        pets.removeAll(pets);
    }

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
    public double percentageOfFish()
    {
        int fishNum = getFishNum();
        int totalPets = this.getPetAmount();
        return fishNum / (int) totalPets;
    }
    
    //not used 
    public double percentageOfBird()
    {
        int birdNum = getBirdNum();
        int totalPets = this.getPetAmount();
        return birdNum / (int) totalPets;
    }
    
    //not used
    public double percentageOfMammal()
    {
        int mammalNum = getMammalNum();
        int totalPets = this.getPetAmount();
        return mammalNum / (int) totalPets;
    }

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

    public void sortPet(Pet other)
    {
        Collections.sort(pets);
    }

}
