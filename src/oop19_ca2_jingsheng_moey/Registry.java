/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop19_ca2_jingsheng_moey;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author HP
 */
public class Registry
{

    public static String BOTH_FOUND = "Both Found.";
    public static String OWNER_NOT_FOUND = "Owner not found.";
    public static String PET_NOT_FOUND = "Pet not found.";
    public static String BOTH_NOT_FOUND = "Both not found.";
    public static String DUPLICATE_FOUND = "Duplicate Found.";
    public static String SUCCESSFULLY_ADDED = "successfully added.";
    private ArrayList<Owner> owners;

    public Registry()
    {
        owners = new ArrayList<>();
    }

    public void addOwnerInRegis(Owner o)
    {
        if (this.owners.contains(o))
        {
            System.out.println(DUPLICATE_FOUND);
        }
        else
        {
            owners.add(o);
            System.out.println("Owner " + SUCCESSFULLY_ADDED);
        }
    }

    public void setOwnerNameInRegis(String OID, String name)
    {
        int ownerPos = getOwnerIdExistInRegis(OID);
        this.owners.get(ownerPos).setName(name);
    }

    public void setOwnerEmailInRegis(String OID, String email)
    {
        int ownerPos = getOwnerIdExistInRegis(OID);
        this.owners.get(ownerPos).setEmail(email);
    }

    public void setOwnerTelephoneInRegis(String OID, String telephone)
    {
        int ownerPos = getOwnerIdExistInRegis(OID);
        this.owners.get(ownerPos).setTelephone(telephone);
    }

    public void setOwnerHomeAddressInRegis(String OID, String home_Address)
    {
        int ownerPos = getOwnerIdExistInRegis(OID);
        this.owners.get(ownerPos).setHome_Address(home_Address);
    }

    public void deleteOwnerByIdInRegis(String OID)
    {
        int ownerId = getOwnerIdExistInRegis(OID);
        if (ownerId != -1)
        {
            this.owners.get(ownerId).deleteAllPet();
            this.owners.remove(ownerId);
            System.out.println("Owners and Pets under this owner have been removed.");
        }
        else
        {
            System.out.println(OWNER_NOT_FOUND);
        }
    }

    public ArrayList<Owner> getOwners()
    {
        return this.owners;
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

    public void readFileOut(String filePath)
    {
        try
        {
            ObjectOutputStream out = new ObjectOutputStream(
                    new FileOutputStream(filePath));
            out.writeObject(this.owners);
            out.close();
        } catch (Exception e)
        {
            System.out.println(e);
        }
    }

    public void readFileIn(String filePath)
    {
        try
        {
            File f = new File(filePath);
            if (f.exists())
            {
                ObjectInputStream in = new ObjectInputStream(
                        new FileInputStream(f));
                ArrayList<Owner> o = (ArrayList<Owner>) in.readObject();
                this.owners = o;
                in.close();
            }
            else
            {
                loadOwnerData();
                loadPetData();
            }
        } catch (Exception e)
        {
            System.out.println(e);
        }
    }
    
    public void loadOwnerData()
    {
        try (Scanner input = new Scanner(new File("Owner Data.txt")))
        {
            int nextOwnerId = input.nextInt();
            Owner.setOwners_registered(nextOwnerId);
            input.useDelimiter("[;\n\r]+");
            Owner o = null;
            while (input.hasNext())
            {
                String OID = input.next();
                String name = input.next();
                String email = input.next();
                String telephone = input.next();
                String address = input.next();
                o = new Owner(OID, name, email, telephone, address);
                this.addOwnerInRegis(o);
            }
            System.out.println("Finish loading owner data\n");
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
            input.useDelimiter("[;\n\r]+");
            Pet p = null;
            while (input.hasNext())
            {
                String OID = input.next();
                int ownerId = getOwnerIdExistInRegis(OID);
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
                    boolean isNeutered = Utilities.getBoolean(sIsNeutered);
                    p = new Mammal(name, type, breed, age, colour, gender, regis_Date, OID, PID, isNeutered);
                }
                else if (creature.equals("Bird"))
                {
                    double wingSpan = input.nextDouble();
                    String sCanFly = input.next();
                    boolean canFly = Utilities.getBoolean(sCanFly);
                    p = new Bird(name, type, breed, age, colour, gender, regis_Date, OID, PID, canFly, wingSpan);
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
                    p = new Fish(name, type, breed, age, colour, gender, regis_Date, OID, PID, water_Type);
                }
                else
                {
                    p = new Pet(name, type, breed, age, colour, gender, regis_Date, OID, PID);
                }
                if (ownerId == -1)
                {
                    System.out.println(OWNER_NOT_FOUND + "[!]");
                }
                else
                {
                    addPetToOwnerInRegis(p, OID);
                }
            }
            System.out.println("Finish loading pet date\n");
        } catch (FileNotFoundException e)
        {
            System.out.println(e.getMessage());
        }
    }

    public boolean ownerExist(Owner o)
    {
        return owners.contains(o);
    }

    public int getOwnerIdExistInRegis(String OID)
    {
        int pos = -1;
        int i = 0;
        while (i < this.owners.size() && pos == -1)
        {
            if (this.owners.get(i).getOwnerID().equals(OID))
            {
                pos = i;
            }
            i++;
        }
        return pos;
    }

    public boolean ifgetOwnerIdExistInRegis(String OID)
    {
        if (getOwnerIdExistInRegis(OID) == -1)
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
        int OwnerPos = getOwnerIdExistInRegis(OID);
        int PetPos = -1;
        if (OwnerPos != -1)
        {
            PetPos = owners.get(OwnerPos).GetPetExistID(PID);

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
            for (int j = 0; j < owners.get(i).getPetAmount(); j++)
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

    public void addPetToOwnerInRegis(Pet p, String OID) // diff owner can have all same attribute pet
    {
        int ownerPos = getOwnerIdExistInRegis(OID);
        if (ownerPos == -1)
        {
            System.out.println(OWNER_NOT_FOUND);
        }
        else
        {
            if (this.owners.get(ownerPos).getPets().contains(p))
            {
                System.out.println(DUPLICATE_FOUND);
            }
            else
            {
                this.owners.get(ownerPos).addPet(p);
                System.out.println("Pet " + SUCCESSFULLY_ADDED);
            }
        }

    }

    public void deletePetByIdInRegis(String OID, String PID)
    {
        int ownerId = getOwnerIdExistInRegis(OID);
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
        int ownerPos = getOwnerIdExistInRegis(OID);
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

    public void setPetOwnerIDInRegis(int ownerPos, int petPos)
    {
        String sOID = owners.get(ownerPos).getOwnerID();
        owners.get(ownerPos).setPetOwnerId(petPos, sOID);
    }

    public void setPetNameInRegis(int ownerPos, int petPos, String name)
    {
        owners.get(ownerPos).setPetName(petPos, name);
    }

    public void setPetTypeInRegis(int ownerPos, int petPos, String type)
    {
        owners.get(ownerPos).setPetType(petPos, type);
    }

    public void setPetBreedInRegis(int ownerPos, int petPos, String breed)
    {
        owners.get(ownerPos).setPetBreed(petPos, breed);
    }

    public void setPetColourInRegis(int ownerPos, int petPos, String colour)
    {
        owners.get(ownerPos).setPetColour(petPos, colour);
    }

    public void setPetAgeInRegis(int ownerPos, int petPos, int age)
    {
        owners.get(ownerPos).setPetAge(petPos, age);
    }

    public void setPetGenderInRegis(int ownerPos, int petPos, Gender gender)
    {
        owners.get(ownerPos).setPetGender(petPos, gender);
    }

    public void setPetRegisDateInRegis(int ownerPos, int petPos, LocalDate regisDate)
    {
        owners.get(ownerPos).setPetRegisDate(petPos, regisDate);
    }

    public void setBirdWingSpanInRegis(int ownerPos, int petPos, double wingSpan)
    {
        owners.get(ownerPos).setPetWingSpan(petPos, wingSpan);
    }

    public void setBirdCanFlyInRegis(int ownerPos, int petPos, boolean canFly)
    {
        owners.get(ownerPos).setPetCanFly(petPos, canFly);
    }

    public void setMammalNeuteredInRegis(int ownerPos, int petPos, boolean neutered)
    {
        owners.get(ownerPos).setPetNeutered(petPos, neutered);
    }

    public void setFishWaterTypeInRegis(int ownerPos, int petPos, WaterType water_Type)
    {
        owners.get(ownerPos).setPetWaterType(petPos, water_Type);
    }

    public int getTotalPetAmountInRegis()
    {
        int totalPet = 0;
        for (Owner o : this.owners)
        {
            totalPet = totalPet + o.getPetAmount();
        }
        return totalPet;
    }

    public int getMammalNumInRegis()
    {
        int totalMammal = 0;
        for (Owner o : this.owners)
        {
            totalMammal = totalMammal + o.getMammalNum();
        }
        return totalMammal;
    }

    public int getFishNumInRegis()
    {
        int totalFish = 0;
        for (Owner o : this.owners)
        {
            totalFish = totalFish + o.getFishNum();
        }
        return totalFish;
    }

    public int getBirdNumInRegis()
    {
        int totalBird = 0;
        for (Owner o : this.owners)
        {
            totalBird = totalBird + o.getBirdNum();
        }
        return totalBird;
    }

    public double getFishPercentageInRegis()
    {
        int fishNum = getFishNumInRegis();
        int totalPet = getTotalPetAmountInRegis();
        return fishNum / (double) totalPet * 100;
    }

    public double getMammalPercentageInRegis()
    {
        int mammalNum = getMammalNumInRegis();
        int totalPet = getTotalPetAmountInRegis();
        return mammalNum / (double) totalPet * 100;
    }

    public double getBirdPercentageInRegis()
    {
        int birdNum = getBirdNumInRegis();
        int totalPet = getTotalPetAmountInRegis();
        return birdNum / (double) totalPet * 100;
    }

    public List getAllPetsIntoNewListInRegis()
    {
        List<Pet> allPets = new ArrayList<Pet>();
        for (int i = 0; i < this.owners.size(); i++)
        {
            for (int j = 0; j < this.owners.get(i).getPetAmount(); j++)
            {
                Pet p = this.owners.get(i).getThisPet(j);
                allPets.add(p);
            }
        }
        return allPets;
    }

    public double getAverageBirdWingSpanInRegis()
    {
        double totalWingSpan = 0;
        for (Owner o : this.owners)
        {
            totalWingSpan = totalWingSpan + o.getTotalBirdWingSpan();
        }
        return totalWingSpan / getBirdNumInRegis();
    }

    public double getPercentageOfBirdCanFlyInRegis()
    {
        int canFlyNum = 0;
        for (Owner o : this.owners)
        {
            canFlyNum = canFlyNum + o.getNumBirdCanFly();
        }
        return canFlyNum / (double) getBirdNumInRegis() * 100;
    }

    public double getPercentageOfMammalNeuteredInRegis()
    {
        int neuteredNum = 0;
        for (Owner o : this.owners)
        {
            neuteredNum = neuteredNum + o.getNumMammalNeutered();
        }
        return neuteredNum / (double) getMammalNumInRegis() * 100;
    }

    public double getPercentageMalePetInRegis()
    {
        int numMalePet = 0;
        for (Owner o : this.owners)
        {
            numMalePet = numMalePet + o.getNumMalePet();
        }
        return numMalePet / (double) getTotalPetAmountInRegis() * 100;
    }

    public void getFishWaterTypeStatisticInRegis()
    {
        int fishInBrackish = 0;
        int fishInFresh = 0;
        int fishInSea = 0;
        for (Owner o : this.owners)
        {
            for (Pet p : o.getPets())
            {
                if (p instanceof Fish)
                {
                    switch (((Fish) p).getWater_Type())
                    {
                        case BRACKISH:
                            fishInBrackish++;
                            break;
                        case FRESHWATER:
                            fishInFresh++;
                            break;
                        default:
                            fishInSea++;
                            break;
                    }
                }
            }
        }
        System.out.println("There are " + fishInBrackish + " fishes in brackish, " + fishInFresh + " fishes in freshwater and " + fishInSea + " fishes in sea.");
    }
}
