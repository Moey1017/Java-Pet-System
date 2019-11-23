/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ca2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

/**
 *
 * @author HP
 */
public class Owner implements Comparable<Owner>
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
    
    public int getPetSize()
    {
        return pets.size();
    }
    
    public Pet thisPets(int PID)
    {
        return pets.get(PID);
    }
    
    public int petsSize()
    {
        return pets.size();
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

    public void setPetOwnerId(int PID, String OID)
    {
        pets.get(PID).setOwnerID(OID);
    }
    
    public void setPetName(int PID, String name)
    {
        pets.get(PID).setName(name);
    }

    public void setPetType(int PID, String type)
    {
        pets.get(PID).setType(type);
    }

    public void setPetBreed(int PID, String breed)
    {
        pets.get(PID).setBreed(breed);
    }

    public void setPetColour(int PID, String colour)
    {
        pets.get(PID).setColour(colour);
    }

    public void setPetAge(int PID, int age)
    {
        pets.get(PID).setAge(age);
    }

    public void setPetGender(int PID, Gender gender)
    {
        pets.get(PID).setGender(gender);
    }

    public void setPetWingSpan(int PID, double wingSpan)
    {
        ((Bird) pets.get(PID)).setWingSpan(wingSpan);
    }
    
    public void setPetCanFly(int PID, boolean hasWing)
    {
        ((Bird) pets.get(PID)).setHasWing(hasWing);
    }
    
    public void setPetNeutered(int PID, boolean isNeutered)
    {
        ((Mammal) pets.get(PID)).setIsNeutered(isNeutered);
    }
    
    public void setPetWaterType(int PID, WaterType water_Type)
    {
        ((Fish) pets.get(PID)).setWater_Type(water_Type);
    }
    
    public int PetExistID(String PID)
    {
        int pos = -1;
        for(int i = 0 ; i < pets.size(); i++)
        {
            if(pets.get(i).getPetID().equals(PID))
            {
                return i;
            }
        }
        return pos;
    }
    
    public boolean ifPetExist(String PID)
    {
        if(PetExistID(PID) == -1)
            return false;
        else 
            return true;
    }
    
    public void deletePetById(String PID)
    {
        int pos = PetExistID(PID);
        if( pos == -1)
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
