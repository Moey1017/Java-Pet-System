/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ca2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author HP
 */
public class main2
{

    public static Registry r1 = new Registry();
    public static Scanner input = new Scanner(System.in);
    public static final String INPUT_MISS_MATCH = "Input does not matched!";
    public static final String ERROR_MESSAGE = "Something went wrong!Pls try again.";
    public static final String PET_NOT_FOUND = "Pet's ID not found!";
    public static final String OWNER_NOT_FOUND = "Owner'd ID not found!";
    public static final String BOTH_NOT_FOUND = "Both ID not found!";
    public static final int MINIMUM_AGE = 0;
    public static final int MAXIMUM_AGE = 100;

    public static void main(String[] args)
    {
        try
        {
            r1.loadOwnerData();
            System.out.println("Finish loading owner");
            r1.loadPetData();
            System.out.println("Finish loading pet");
            System.out.println("Display all owners");
            displayAllOwners2();
            System.out.println("Display all pets");
            displayAllPets();
        }catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    public static void mainMenu()
    {
        System.out.println("**********************************************************");
        System.out.println("**********************************************************");
    }
    
    public static void displayAllOwners()
    {
        for(Owner o: r1.getOwners())
        {
            System.out.println(o);
        }
    }

    public static void displayAllOwners2()
    {
        String name = "he";
        System.out.println("*****************************************************************************");
        for (Owner o : r1.getOwners())
        {
            System.out.printf(o.getOwnerID());
            System.out.println("");
        }
        System.out.println("*****************************************************************************");
    }

    public static void addOwner()
    {
        System.out.println("Enter name");
        String name = input.nextLine();
        System.out.println("Enter email");
        String email = input.nextLine();
        System.out.println("Enter Telephone number");
        String telephone = input.nextLine();
        System.out.println("Enter Home address");
        String home_Address = input.nextLine();

        Owner o = (new Owner(name, email, telephone, home_Address));
        if (r1.ownerExist(o))
        {
            System.out.println("Duplicate found");
        }
        else
        {
            r1.addOwner(new Owner(name, email, telephone, home_Address));
            System.out.println("Successfully added");
        }
    }

    /**
     * set attribute in owner
     *
     */
    public static void setOwnerAll()
    {
        System.out.println("Enter owner id");
        int inputOwnerId = input.nextInt();
        input.nextLine();
        int pos = r1.ownerIdExistInRegis("OID" + inputOwnerId);
        if (pos != -1)
        {
            String name = getOwnerName();
            r1.setOwnerNameInRegis("OID" + inputOwnerId, name);
            String email = getOwnerEmail();
            r1.setOwnerEmailInRegis("OID" + inputOwnerId, email);
            String telephone = getOwnerTelephone();
            r1.setOwnerTelephoneInRegis("OID" + inputOwnerId, telephone);
            String home_Address = getOwnerHome_Address();
            r1.setOwnerHomeAddressInRegis("OID" + inputOwnerId, home_Address);
        }
        else
        {
            System.out.println(OWNER_NOT_FOUND);
        }
    }

    /**
     * set owner's name
     *
     * @param OID owner's pos in arrayList
     */
    public static String getOwnerName()
    {
        System.out.println("Input owner name");
        String name = input.nextLine();
        return name;
    }

    /**
     * set owner's email
     *
     * @param OID owner's pos in arrayList
     */
    public static String getOwnerEmail()
    {
        System.out.println("Input owner email");
        String email = input.nextLine();
        return email;
    }

    /**
     * set owner's telephone
     *
     * @param OID owner's pos in arrayList
     */
    public static String getOwnerTelephone()
    {
        System.out.println("Input owner telephone");
        String telephone = input.nextLine();
        return telephone;
    }

    /**
     * set owner's home address
     *
     * @param OID owner's pos in arrayList
     */
    public static String getOwnerHome_Address()
    {
        System.out.println("Input owner Home Address");
        String home_Address = input.nextLine();
        return home_Address;
    }

    /**
     * delete owner and subtract the number of all owners
     *
     */
    public static void deleteOwner()
    {
        System.out.println("Enter owner id");
        int inputOwnerId = input.nextInt();
        r1.deleteOwnerByIdInRegis("OID" + inputOwnerId);
    }

    public static void deletePetById()
    {
        System.out.println("Enter Owner's id");
        int ownerId = input.nextInt();

        System.out.println("Enter Pet's id");
        int PID = input.nextInt();

        r1.deletePetByIdInRegis("OID" + ownerId, "PID" + PID);
    }

    /**
     * set pet's name, type, breed, age, colour, gender, owner's ID
     *
     * @param owners arraylist of ownerset
     */
    public static void setPetAll(ArrayList<Owner> owners)
    {
        try
        {
            System.out.println("Enter Owner's id");
            int OID = input.nextInt();
            System.out.println("Enter pet's id");
            int PID = input.nextInt();
            input.nextLine();
            int ownerId = r1.ownerIdExistInRegis("OID"+OID);
            int petId = r1.petIdExistInRegis("OID" + OID, "PID" + PID);
            String outcome = r1.findOwnerAndPetInThisOwner("OID" + OID,"PID" + PID);
            if (outcome.equals(Registry.BOTH_FOUND))
            {
                setPetOwnerId(OID, petId);
                r1.setPetNameInRegis(ownerId, petId, getPetName());
                r1.setPetTypeInRegis(ownerId, petId, getPetType());
                r1.setPetBreedInRegis(ownerId, petId, getPetBreed());
                r1.setPetAgeInRegis(ownerId, petId, getPetAge());
                r1.setPetColourInRegis(ownerId, petId, getPetColour());
                r1.setPetGenderInRegis(ownerId, petId, getPetGender());

                if (owners.get(ownerId).getThisPet(petId) instanceof Mammal)
                {
                    r1.setMammalNeuteredInRegis(ownerId, petId, getMammalNeutered());
                }
                else if (owners.get(ownerId).getThisPet(petId) instanceof Bird)
                {
                    r1.setBirdWingSpanInRegis(ownerId, petId, getBirdWingSpan());
                    r1.setBirdCanFlyInRegis(ownerId, petId, setBirdCanFly());
                }
                else if (owners.get(ownerId).getThisPet(petId) instanceof Fish)
                {
                    r1.setFishWaterTypeInRegis(ownerId, petId, getFishWaterType());
                }
            }
            else
            {
                System.out.println(outcome);
            }
        } catch (IllegalArgumentException e)
        {
            System.out.println(e.getMessage());
        } catch (InputMismatchException e)
        {
            System.out.println(INPUT_MISS_MATCH);
        }
    }

    /**
     * set pet's OwnerId
     *
     * @param OID owner's ID
     * @param PID pet's ID
     */
    public static void setPetOwnerId(int OID, int PID)
    {
        r1.setPetOwnerIDInRegis(OID, PID);
    }

    public static String getPetOwnerId()
    {
        System.out.println("Enter only numbers for Pet Owner Id");
        int OID = getValidInt(0, r1.getOwners().size() - 1);
        return "OID" + OID;
    }

    /**
     * get new pet name
     *
     * @return new pet name
     */
    public static String getPetName()
    {
        System.out.println("Enter new Name");
        String name = input.nextLine();
        return name;
    }

    /**
     * get new pet type
     *
     * @return new pet type
     */
    public static String getPetType()
    {
        System.out.println("Enter new type");
        String type = input.nextLine();
        return type;
    }

    /**
     * get new pet Breed
     *
     * @return new pet Breed
     */
    public static String getPetBreed()
    {
        System.out.println("Enter new Breed");
        String breed = input.nextLine();
        return breed;
    }

    /**
     * get new pet age
     *
     * @return new pet age
     */
    public static int getPetAge()
    {
        System.out.println("Enter the age (Range: " + MINIMUM_AGE + ", " + MAXIMUM_AGE + ")");
        return getValidInt(MINIMUM_AGE, MAXIMUM_AGE);
    }

    /**
     * get new pet colour
     *
     * @return new pet colour
     */
    public static String getPetColour()
    {
        System.out.println("Enter new Colour");
        String colour = input.nextLine();
        return colour;
    }

    /**
     * get new pet gender
     *
     * @return new pet gender
     */
    public static Gender getPetGender()
    {
        System.out.println("Enter new Gender(M/F)");
        String sGender = input.nextLine().toUpperCase();
        Gender gender;
        while (!sGender.equals("M") && !sGender.equals("F"))
        {
            System.out.println("Enter new Gender(M/F)");
            sGender = input.nextLine().toUpperCase();
        }
        if (sGender.startsWith("M"))
        {
            gender = Gender.MALE;
        }
        else
        {
            gender = Gender.FEMALE;
        }
        return gender;
    }

    /**
     * get new pet regis_Date
     *
     * @return new pet regis_Date
     */
    public static LocalDate getPetRegisDate()
    {
        LocalDate date;
        System.out.println("Enter year");
        int year = getValidInt(1900, LocalDate.now().getYear());
        System.out.println("Input month in number");
        int month = getValidInt(1, 12);
        System.out.println("Input day in number");
        int day = getValidInt(1, 31);
        date = LocalDate.of(year, month, day);
        return date;
    }

    /**
     * get new neutered state for pet
     *
     * @return pet's neutered state
     */
    public static boolean getMammalNeutered()
    {
        boolean validNeutered = false;
        boolean isNeutered = false;
        while (validNeutered != true)
        {
            try
            {
                System.out.println("Enter true or false to if it's neutered");
                isNeutered = input.nextBoolean();
                while (isNeutered != true && isNeutered != false)
                {
                    System.out.println("Enter true or false to if it's neutered");
                    isNeutered = input.nextBoolean();
                }
                validNeutered = true;
            } catch (IllegalArgumentException e)
            {
                System.out.println(e.getMessage());
                input.nextLine();
            } catch (InputMismatchException e)
            {
                System.out.println(INPUT_MISS_MATCH);
                input.nextLine();
            }
        }
        return isNeutered;
    }

    /**
     * @return pet's WaterType
     */
    public static WaterType getFishWaterType()
    {
        boolean validWater_Type = false;
        String stringWater_Type;
        WaterType water_Type = null;
        input.nextLine();
        while (validWater_Type != true)
        {
            try
            {

                System.out.println("Enter only f for freshwater, s for seawater and b for brackish");
                stringWater_Type = input.nextLine();
                while (stringWater_Type.matches("f|s|b") != true)
                {
                    System.out.println("Enter only f for freshwater, s for seawater and b for brackish");
                    stringWater_Type = input.nextLine();
                }
                if (stringWater_Type.startsWith("f"))
                {
                    water_Type = WaterType.FRESHWATER;
                }
                else if (stringWater_Type.startsWith("s"))
                {
                    water_Type = WaterType.SEAWATER;
                }
                else
                {
                    water_Type = WaterType.BRACKISH;
                }
                validWater_Type = true;
            } catch (IllegalArgumentException e)
            {
                System.out.println(e.getMessage());
                input.nextLine();
            } catch (InputMismatchException e)
            {
                System.out.println(INPUT_MISS_MATCH);
                input.nextLine();
            }
        }
        return water_Type;
    }

    /**
     * return pet's WingSpan
     */
    public static double getBirdWingSpan()
    {
        boolean validWingSpan = false;
        double wingSpan = 0;
        while (validWingSpan != true)
        {
            try
            {
                System.out.println("Enter Wing Span");
                wingSpan = input.nextDouble();
                validWingSpan = true;
            } catch (IllegalArgumentException e)
            {
                System.out.println(e.getMessage());
            } catch (InputMismatchException e)
            {
                System.out.println(INPUT_MISS_MATCH);
                input.nextLine();
            }
        }
        return wingSpan;
    }

    /**
     * return pet's boolean hasWing
     */
    public static boolean setBirdCanFly()
    {
        boolean validHasWing = false;
        boolean hasWing = false;
        while (validHasWing != true)
        {
            try
            {
                System.out.println("Enter true or false if can fly");
                hasWing = input.nextBoolean();
                while (hasWing != true && hasWing != false)
                {
                    System.out.println("Enter true or false if can fly");
                    hasWing = input.nextBoolean();
                }
                validHasWing = true;
            } catch (IllegalArgumentException e)
            {
                System.out.println(e.getMessage());
                input.nextLine();
            } catch (InputMismatchException e)
            {
                System.out.println(INPUT_MISS_MATCH);
                input.nextLine();
            }
        }
        return hasWing;
    }

    public static int getValidInt(int min, int max)
    {
        int user_input = -1;
        boolean isValidInput = false;
        System.out.println("Enter Action");
        while (isValidInput == false)
        {
            try
            {
                user_input = input.nextInt();
                input.nextLine();

                while ((user_input < min) || (user_input > max))
                {
                    System.out.println("Invalid - [" + min + "," + max + "] only");
                    user_input = input.nextInt();
                }
                isValidInput = true;

            } catch (Exception e)
            {
                input.nextLine();
                System.out.println("Something went wrong. Pls try again");
            }
        }
        return user_input;
    }

    public static boolean getValidBoolean()
    {
        boolean validated_Boolean = false;
        System.out.println("Input T/F");
        String user_input = input.nextLine();
        try
        {
            while (!user_input.toLowerCase().startsWith("t") || !user_input.toLowerCase().startsWith("f"))
            {
                System.out.println("Input T/F");
                user_input = input.nextLine();
            }
            if (user_input.startsWith("t"))
            {
                return validated_Boolean = true;
            }
            else
            {
                return validated_Boolean;
            }
        } catch (Exception e)
        {
            e.getMessage();
            input.nextLine();
        }
        return validated_Boolean;

    }

    public static List getAllPets()
    {
        List<Pet> allPets = new ArrayList<Pet>();
        for (int i = 0; i < r1.getOwners().size(); i++)
        {
            for (int j = 0; j < r1.getOwners().get(i).getPets().size(); j++)
            {
                Pet p = r1.getOwners().get(i).getThisPet(0);
                allPets.add(p);
            }
        }
        return allPets;
    }

    public static void displayAllPets()
    {
        List<Pet> allPets = getAllPets();
        for (Owner o : r1.getOwners())
        {
            for (Pet p : o.getPets())
            {
                System.out.println(p);
            }
        }
    }

    /**
     * display all pets or mammals, or birds or fishes in all owners
     */
    public static void displayAllPets2()
    {
        System.out.println("Enter the pet type u want to print(p|m|f|b)");
        String type = input.nextLine();
        while (type.toLowerCase().matches("p|m|f|b") != true)
        {
            System.out.println("Enter the pet type u want to print(p|m|f|b)");
            type = input.nextLine();
        }
        for (Owner o : r1.getOwners())
        {
            for (Pet p : o.getPets())
            {
                if (type.startsWith("f") && p instanceof Fish)
                {
                    System.out.println(p);
                }
                else if (type.startsWith("m") && p instanceof Mammal)
                {
                    System.out.println(p);
                }
                else if (type.startsWith("b") && p instanceof Bird)
                {
                    System.out.println(p);
                }
                else
                {
                    System.out.println(p);
                }
            }
        }
    }

    public static void displayAllPetsByNaturalOrder()
    {
        Collections.sort(getAllPets());
        System.out.println("Print by Pet ID");
        displayAllPets();

    }
//      make this all in switch 
//    public static void displayAllPetsByAge()
//    {
//        PetAgeComparator ageCompare = new PetAgeComparator();
//        Collections.sort(getAllPets(), ageCompare);
//        System.out.println("Print by Pet Age");
//        displayAllPets();
//    }
//
//    public static void displayAllPetsByGender()
//    {
//        PetGenderComparator genderCompare = new PetGenderComparator();
//        Collections.sort(getAllPets(), genderCompare);
//        System.out.println("Print by Pet Gender");
//        displayAllPets();
//    }
//    
//    public static void displayAllPetsByRegisDate()
//    {
//        PetDateComparator dateCompare = new PetDateComparator();
//        Collections.sort(getAllPets(), dateCompare);
//        System.out.println("Print by Pet Regis Date");
//        displayAllPets();
//    }
}
