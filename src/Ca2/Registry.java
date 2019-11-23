/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ca2;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author HP
 */
public class Registry
{

    public static String BOTH_FOUND = "Both Found";
    public static String OWNER_NOT_FOUND = "Owner not found";
    public static String PET_NOT_FOUND = "Pet not found";
    public static String BOTH_NOT_FOUND = "Both not found";
    private ArrayList<Owner> owners;

    public Registry()
    {
        owners = new ArrayList<>();
    }

    public void addOwner(Owner o)
    {
        owners.add(o);
    }

    public void setOwnerNameInRegis(String OID, String name)
    {
        int ownerPos = ownerIdExistInRegis(OID);
        owners.get(ownerPos).setName(name);
    }

    public void setOwnerEmailInRegis(String OID, String email)
    {
        int ownerPos = ownerIdExistInRegis(OID);
        owners.get(ownerPos).setEmail(email);
    }

    public void setOwnerTelephoneInRegis(String OID, String telephone)
    {
        int ownerPos = ownerIdExistInRegis(OID);
        owners.get(ownerPos).setTelephone(telephone);
    }

    public void setOwnerHomeAddressInRegis(String OID, String home_Address)
    {
        int ownerPos = ownerIdExistInRegis(OID);
        owners.get(ownerPos).setHome_Address(home_Address);
    }

    public void deleteOwnerByIdInRegis(String OID)
    {
        int ownerId = ownerIdExistInRegis(OID);
        if (ownerId != -1)
        {
            owners.get(ownerId).deleteAllPet();
            owners.remove(ownerId);
            System.out.println("Owners and Pets under this owner have been removed.");
        }
        else
        {
            System.out.println(OWNER_NOT_FOUND);
        }
    }

    public ArrayList<Owner> getOwners()
    {
        return owners;
    }

    public Owner getThisOwner(int OID)
    {
        return this.owners.get(OID);
    }

    @Override
    public String toString()
    {
        return "Registry{" + "owner=" + owners + '}';
    }

    public void loadOwnerData()
    {
        try (Scanner input = new Scanner(new File("Owner Data.txt")))
        {
            int nextOwnerId = input.nextInt();
            Owner.setOwners_registered(nextOwnerId);
            input.useDelimiter("[;]");
            Owner o = null;
            while (input.hasNext())
            {
                String OID = input.next();
                String name = input.next();
                String email = input.next();
                String telephone = input.next();
                String address = input.next();
                o = new Owner(OID, name, email, telephone, address);
                this.addOwner(o);
            }
        } catch (FileNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public void loadPetData()
    {
        try (Scanner input = new Scanner(new File("Pet Data.txt")))
        {
            int nextPetId = input.nextInt();
            Pet.setPets_registered(nextPetId);
            input.useDelimiter("[;]");
            Pet p = null;
            while (input.hasNext())
            {
                String OID = input.next();
                int ownerId = ownerIdExistInRegis(OID);
                String PID = input.next();
                String creature = input.next();
                String name = input.next();
                String type = input.next();
                String breed = input.next();
                String colour = input.next();
                int age = input.nextInt();
                String sDate = input.next();
                LocalDate regis_Date = LocalDate.parse(sDate);
                String sGender = input.next();
                Gender gender;
                if (sGender.toLowerCase().startsWith("m"))
                {
                    gender = Gender.MALE;
                }
                else
                {
                    gender = Gender.FEMALE;
                }
                if (creature.equals("Mammal"))
                {
                    String sIsNeutered = input.next();
                    boolean isNeutered = getBoolean(sIsNeutered);
                    p = new Mammal(name, type, breed, age, colour, gender, regis_Date, OID, isNeutered);
                }
                else if (creature.equals("Bird"))
                {
                    double wingSpan = input.nextDouble();
                    String sCanFly = input.next();
                    boolean canFly = getBoolean(sCanFly);
                    p = new Bird(name, type, breed, age, colour, gender, regis_Date, OID, canFly, wingSpan);
                }
                else if (creature.equals("Fish"))
                {
                    String waterTypeInString = input.next();
                    WaterType water_Type = null;
                    if (waterTypeInString.startsWith("B"))
                    {
                        water_Type = WaterType.BRACKISH;
                    }
                    else if (waterTypeInString.startsWith("F"))
                    {
                        water_Type = WaterType.FRESHWATER;
                    }
                    else if (waterTypeInString.startsWith("S"))
                    {
                        water_Type = WaterType.SEAWATER;
                    }
                    p = new Fish(name, type, breed, age, colour, gender, regis_Date, OID, water_Type);
                }
                else
                {
                    p = new Pet(name, type, breed, age, colour, gender, regis_Date, OID);
                }
                if(ownerId == -1)
                {
                    System.out.println(OWNER_NOT_FOUND + "[!]");
                }
                else
                {
                    System.out.println(p);
                }
            }
        } catch (FileNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public boolean ownerExist(Owner o)
    {
        return owners.contains(o);
    }

    public int ownerIdExistInRegis(String OID)
    {
        int pos = -1;
        int i = 0;
        while (i < this.owners.size() && pos == -1)
        {
            if (this.owners.get(i).getOwnerID().equalsIgnoreCase(OID))
            {
                pos = i;
            }
            i++;
        }
        return pos;
    }

    public boolean ifOwnerIdExistInRegis(String OID)
    {
        if (ownerIdExistInRegis(OID) == -1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    // In owner
    public int petIdExistInRegis(String OID, String PID)
    {
        int OwnerPos = ownerIdExistInRegis(OID);
        int PetPos = -1;
        if (OwnerPos != -1)
        {
            PetPos = owners.get(OwnerPos).PetExistID(PID);

        }
        return PetPos;
    }

    // In owner
    public boolean ifPetIdExistInRegis(String OID, String PID)
    {
        int pos = petIdExistInRegis(OID, PID);
        if (pos != -1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    // in all pets 
    public int petIdExistInRegis(String PID)
    {
        int petPos = -1;
        for (int i = 0; i < owners.size(); i++)
        {
            for (int j = 0; j < owners.get(i).getPetSize(); j++)
            {
                if (owners.get(i).getPets().get(j).getPetID().equals(PID))
                {
                    petPos = j;
                }
            }
        }
        return petPos;
    }

    //in all pets 
    public boolean ifPetIdExistInRegis(String PID)
    {
        int pos = petIdExistInRegis(PID);
        if (pos != -1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    public void addPetToOwnerInRegis(Pet p, String OID)
    {
        int pos = ownerIdExistInRegis(OID);
        if (pos == -1)
        {
            System.out.println("Duplicated found. Pet is not added.");
        }
        else
        {
            this.owners.get(pos).addPet(p);
            System.out.println("Pet successfully added");
        }

    }

    public void deletePetByIdInRegis(String OID, String PID)
    {
        int ownerId = ownerIdExistInRegis(OID);
        int petId = petIdExistInRegis(PID);
        String outcome = findOwnerAndPetInThisOwner(OID, PID);
        if (outcome.equals(BOTH_FOUND))
        {
            owners.get(ownerId).getPets().remove(petId);
            System.out.println("Pet successfully removed.");
        }
        else
        {
            System.out.println(outcome);
        }
    }

    public String findOwnerAndPetInThisOwner(String OID, String PID)
    {
        int ownerPos = ownerIdExistInRegis(OID);
        int petPos = petIdExistInRegis(OID, PID);

        String outcome;
        if (ownerPos == -1 && petPos == -1)
        {
            outcome = BOTH_NOT_FOUND;
        }
        else if (ownerPos != -1 && petPos == -1)
        {
            outcome = PET_NOT_FOUND;
        }
        else if (ownerPos == -1 && petPos != -1)
        {
            outcome = OWNER_NOT_FOUND;
        }
        else
        {
            outcome = BOTH_FOUND;
        }
        return outcome;
    }

    public void setPetOwnerIDInRegis(int OID, int PID)
    {
        String sOID = owners.get(OID).getOwnerID();
        owners.get(OID).setPetOwnerId(PID, sOID);
    }

    public void setPetNameInRegis(int OID, int PID, String name)
    {
        owners.get(OID).setPetName(PID, name);
    }

    public void setPetTypeInRegis(int OID, int PID, String type)
    {
        owners.get(OID).setPetType(PID, type);
    }

    public void setPetBreedInRegis(int OID, int PID, String breed)
    {
        owners.get(OID).setPetBreed(PID, breed);
    }

    public void setPetColourInRegis(int OID, int PID, String colour)
    {
        owners.get(OID).setPetColour(PID, colour);
    }

    public void setPetAgeInRegis(int OID, int PID, int age)
    {
        owners.get(OID).setPetAge(PID, age);
    }

    public void setPetGenderInRegis(int OID, int PID, Gender gender)
    {
        owners.get(OID).setPetGender(PID, gender);
    }

    public void setBirdWingSpanInRegis(int OID, int PID, double wingSpan)
    {
        owners.get(OID).setPetWingSpan(PID, wingSpan);
    }

    public void setBirdCanFlyInRegis(int OID, int PID, boolean canFly)
    {
        owners.get(OID).setPetCanFly(PID, canFly);
    }

    public void setMammalNeuteredInRegis(int OID, int PID, boolean neutered)
    {
        owners.get(OID).setPetNeutered(PID, neutered);
    }

    public void setFishWaterTypeInRegis(int OID, int PID, WaterType water_Type)
    {
        owners.get(OID).setPetWaterType(PID, water_Type);
    }
    
    public boolean getBoolean(String b)
    {
        if(b.toLowerCase().startsWith("t"))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

}
