/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop19_ca2_jingsheng_moey;

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
public class MainMenu
{

    public static Registry r1 = new Registry();
    public static Scanner input = new Scanner(System.in);
    public static final String INPUT_MISS_MATCH = "Input does not matched!";
    public static final String ERROR_MESSAGE = "Something went wrong!Pls try again.";
    public static final String PET_NOT_FOUND = "Pet's ID not found!";
    public static final String OWNER_NOT_FOUND = "Owner'd ID not found!";
    public static final String BOTH_NOT_FOUND = "Both ID not found!";
    public static final String QUIT_SYSTEM = "Enter 0 to Quit the system.";
    public static final String ENTER_SHOW_MENU = "Press Enter to continue.";
    public static final int MINIMUM_VALUE = 0;
    public static final int MINIMUM_AGE = 0;
    public static final int MAXIMUM_AGE = 100;

    public static void main(String[] args)
    {
        try
        {
//            r1.loadOwnerData();
//            r1.loadPetData();
            r1.readFileIn("Owner.dat");
            
            System.out.println("Hello! Welcome to the Registration.");
            mainMenu();
            int select = Utilities.getValidInt(0, 9, "Input the number to select the options!");
            while (select != 0)
            {
                try
                {
                    switch (select)
                    {
                        case 1:
                            addPet();
                            break;
                        case 2:
                            displayAllPetMenu();
                            displayPetOption();
                            break;
                        case 3:
                            setPetAll();
                            break;
                        case 4:
                            deletePetById();
                            break;
                        case 5:
                            petStatisticMenu();
                            displayStatisticOption();
                            break;
                        case 6:
                            addOwner();
                            break;
                        case 7:
                            displayAllOwners();
                            break;
                        case 8:
                            setOwnerAll();
                            break;
                        default:
                            deleteOwnerById();
                            break;
                    }
                    System.out.print(ENTER_SHOW_MENU);
                    input.nextLine();
                    mainMenu();
                    select = Utilities.getValidInt(0, 9, "Input the number to select the options!");
                } catch (InputMismatchException e)
                {
                    System.out.println(INPUT_MISS_MATCH);
                    input.nextLine();
                }
            }
            r1.readFileOut("Owner.dat");
            System.out.println("\nEXIT.Goodbye");
        } catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }

    public static void mainMenu()
    {
        Utilities.printLine("*", 150);
        System.out.println("Pet");
        System.out.println("1. Add Pet");
        System.out.println("2. Display all Pets");
        System.out.println("3. Set Pet's all attribute");
        System.out.println("4. Delete Pet");
        System.out.println("5. Pet statistic ");
        System.out.println("Owner");
        System.out.println("6. Add Owner");
        System.out.println("7. Display all owners");
        System.out.println("8. Set Owner's all attribute");
        System.out.println("9. Delete Owner");
        System.out.println(QUIT_SYSTEM);
        Utilities.printLine("*", 150);
    }

    public static void displayAllPetMenu()
    {
        Utilities.printLine("*", 150);
        System.out.println("1. Display All pets in natural order");
        System.out.println("2. Display All pets based on Gender");
        System.out.println("3. Display All pets based on Age");
        System.out.println("4. Display All pets based on Time order");
        System.out.println("5. Display only Pets/Mammals/Birds/Fishes");
        System.out.println(QUIT_SYSTEM);
        Utilities.printLine("*", 150);
    }

    public static void petStatisticMenu()
    {
        Utilities.printLine("*", 150);
        System.out.println("1. Display Pet statistic");
        System.out.println("2. Display Bird statistic");
        System.out.println("3. Display Fish statistic");
        System.out.println("4. Display Mammal statistic");
        System.out.println(QUIT_SYSTEM);
        Utilities.printLine("*", 150);
    }

    public static void displayAllOwners()
    {
        System.out.println("Owner Table");
        Utilities.printLine("*", 150);
        System.out.printf("%-10s%-15s%-30s%-15s%-35s%10s\n", "OwnerID", "Name", "Email", "Telephone", "Home Address", "Pet Amount");
        for (Owner o : r1.getOwners())
        {
            System.out.printf("%-10s%-15s%-30s%-15s%-40s%-10s", o.getOwnerID(), o.getName(), o.getEmail(), o.getTelephone(), o.getHome_Address(), o.getPetAmount());
            System.out.println("");
        }
        Utilities.printLine("*", 150);
    }

    public static void addOwner()
    {
        String name = getOwnerName();
        String email = getOwnerEmail();
        //reference from https://emailregex.com/
        String telephone = getOwnerTelephone();
        String home_Address = Utilities.getValidString("Enter Home address", "[0-9|A-Z|a-z| |,|.|#|-|_|/]{2,100}");
        Owner o = (new Owner(name, email, telephone, home_Address));
        r1.addOwnerInRegis(o);
    }

    /**
     * set attribute in owner
     *
     */
    public static void setOwnerAll()
    {
        System.out.println("Enter owner id(Only Number)");
        int inputOwnerId = input.nextInt();
        input.nextLine();
        int pos = r1.getOwnerIdExistInRegis("OID" + inputOwnerId);
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
            System.out.println("Owner's set.");
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
        return Utilities.getValidString("Input owner name", "[A-Z|a-z][A-Z|a-z| |-]{2,55}");
    }

    /**
     * set owner's email
     *
     * @param OID owner's pos in arrayList
     */
    public static String getOwnerEmail()
    {
        return Utilities.getValidString("Input owner email", "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])");
    }

    /**
     * set owner's telephone
     *
     * @param OID owner's pos in arrayList
     */
    public static String getOwnerTelephone()
    {
        return Utilities.getValidString("Input owner phone Number", "[0-9]{8,20}");
    }

    /**
     * set owner's home address
     *
     * @param OID owner's pos in arrayList
     */
    public static String getOwnerHome_Address()
    {
        return Utilities.getValidString("Enter Home address", "[A-Z|a-z][0-9|A-Z|a-z| |,|.|#|-|_|/]{3,100}");
    }

    /**
     *
     */
    public static void deleteOwnerById()
    {
        int inputOwnerId = Utilities.getValidInt(0, "Enter owner Id(Only Number)");
        r1.deleteOwnerByIdInRegis("OID" + inputOwnerId);
    }

    public static void deletePetById()
    {
        int ownerId = Utilities.getValidInt(MINIMUM_VALUE, "Enter Owner's id(Only Number)");
        int PID = Utilities.getValidInt(MINIMUM_VALUE, "Enter Pet's id(Only Number)");

        r1.deletePetByIdInRegis("OID" + ownerId, "PID" + PID);
    }

    public static void addPet()
    {
        Pet p = null;
        int inputOwnerID = Utilities.getValidInt(MINIMUM_VALUE, "Enter Owner's id(Only Number)");
        int ownerPos = r1.getOwnerIdExistInRegis("OID" + inputOwnerID);
        if (ownerPos != -1)
        {
            String ownerID = r1.getThisOwner(ownerPos).getOwnerID();
            String name = Utilities.getValidString("Enter Pet's name", "[A-Z|a-z][A-Z|a-z| ]{2,55}");
            String type = Utilities.getValidString("Enter Pet's type", "[A-Z|a-z][A-Z|a-z| ]{2,55}");
            String breed = Utilities.getValidString("Enter Pet's Breed", "[A-Z|a-z][A-Z|a-z| ]{2,55}");
            String colour = Utilities.getValidString("Enter Pet's Colour", "[A-Z|a-z][A-Z|a-z| ]{2,55}");
            int age = Utilities.getValidInt(MINIMUM_AGE, MAXIMUM_AGE, "Enter age(No lesser than 0 and larger than 100)");

            String typee = Utilities.getValidString("Enter pet type(p,b,f,m)", "[p|b|f|m|P|B|F|M]");
            if (typee.toLowerCase().startsWith("b"))
            {
                double wingSpan = getBirdWingSpan();
                boolean hasWing = setBirdCanFly();
                p = new Bird(name, type, breed, colour, age, ownerID, wingSpan, hasWing);
            }
            else if (typee.toLowerCase().startsWith("f"))
            {
                WaterType water_Type = getFishWaterType();
                p = new Fish(name, type, breed, colour, age, ownerID, water_Type);
            }
            else if (typee.toLowerCase().startsWith("m"))
            {
                boolean isNeutered = getMammalNeutered();
                p = new Mammal(name, type, breed, colour, age, ownerID, isNeutered);
            }
            else
            {
                p = new Pet(name, type, breed, colour, age, ownerID);
            }
            r1.addPetToOwnerInRegis(p, "OID" + inputOwnerID);
        }
        else
        {
            System.out.println(OWNER_NOT_FOUND);
        }
    }

    /**
     * set pet's name, type, breed, age, colour, gender, owner's ID
     *
     * @param owners arraylist of ownerset
     */
    public static void setPetAll() // need to test this
    {
        try
        {
            int OID = Utilities.getValidInt(MINIMUM_VALUE, "Enter Owner's id(Only Number)");
            int PID = Utilities.getValidInt(MINIMUM_VALUE, "Enter pet's id(Only Number)");
            int ownerPos = r1.getOwnerIdExistInRegis("OID" + OID);
            int petPos = r1.petIdExistInRegis("OID" + OID, "PID" + PID);
            String outcome = r1.findOwnerAndPetInThisOwner("OID" + OID, "PID" + PID);
            if (outcome.equals(Registry.BOTH_FOUND))
            {
                r1.setPetOwnerIDInRegis(ownerPos, petPos);
                r1.setPetNameInRegis(ownerPos, petPos, getPetName());
                r1.setPetTypeInRegis(ownerPos, petPos, getPetType());
                r1.setPetBreedInRegis(ownerPos, petPos, getPetBreed());
                r1.setPetAgeInRegis(ownerPos, petPos, getPetAge());
                r1.setPetColourInRegis(ownerPos, petPos, getPetColour());
                r1.setPetGenderInRegis(ownerPos, petPos, getPetGender());
                r1.setPetRegisDateInRegis(ownerPos, petPos, getPetRegisDate());

                if (r1.getThisOwner(ownerPos).getThisPet(petPos) instanceof Mammal)
                {
                    r1.setMammalNeuteredInRegis(ownerPos, petPos, getMammalNeutered());
                }
                else if (r1.getThisOwner(ownerPos).getThisPet(petPos) instanceof Bird)
                {
                    r1.setBirdWingSpanInRegis(ownerPos, petPos, getBirdWingSpan());
                    r1.setBirdCanFlyInRegis(ownerPos, petPos, setBirdCanFly());
                }
                else if (r1.getThisOwner(ownerPos).getThisPet(petPos) instanceof Fish)
                {
                    r1.setFishWaterTypeInRegis(ownerPos, petPos, getFishWaterType());
                }
                System.out.println("Pet successfully added." );
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

    public static String getPetOwnerId()
    {
        int OID = Utilities.getValidInt(MINIMUM_VALUE, "Enter only numbers for Pet Owner Id");
        return "OID" + OID;
    }

    /**
     * get new pet name
     *
     * @return new pet name
     */
    public static String getPetName()
    {
        String name = Utilities.getValidString("Enter new Name", "[A-Z|a-z][A-Z|a-z| ]{2,55}");
        return name;
    }

    /**
     * get new pet type
     *
     * @return new pet type
     */
    public static String getPetType()
    {
        String type = Utilities.getValidString("Enter new Type", "[A-Z|a-z][A-Z|a-z| ]{2,55}");
        return type;
    }

    /**
     * get new pet Breed
     *
     * @return new pet Breed
     */
    public static String getPetBreed()
    {
        String breed = Utilities.getValidString("Enter new Breed", "[A-Z|a-z][A-Z|a-z| ]{2,55}");
        return breed;
    }

    /**
     * get new pet age
     *
     * @return new pet age
     */
    public static int getPetAge()
    {
        return Utilities.getValidInt(MINIMUM_AGE, MAXIMUM_AGE, "Enter the age (Range: " + MINIMUM_AGE + ", " + MAXIMUM_AGE + ")");
    }

    /**
     * get new pet colour
     *
     * @return new pet colour
     */
    public static String getPetColour()
    {
        String colour = Utilities.getValidString("Enter new Colour", "[A-Z|a-z][A-Z|a-z| ]{2,55}");
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
        int year = Utilities.getValidInt(1900, LocalDate.now().getYear(), "Enter year");
        int month = Utilities.getValidInt(1, 12, "Input month in number");
        int day = Utilities.getValidInt(1, 31, "Input day in number");
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
        return Utilities.getValidBoolean("Input T/F if it's neutered.");
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

                stringWater_Type = Utilities.getValidString("Enter only f for freshwater, s for seawater and b for brackish", "[f|s|b|F|S|B]");
                while (stringWater_Type.toLowerCase().matches("f|s|b") != true)
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
        return Utilities.getValidDouble(0.1, 100.00, "Enter new Wing Span(CM)");
    }

    /**
     * return pet's boolean hasWing
     */
    public static boolean setBirdCanFly()
    {
        return Utilities.getValidBoolean("Enter T/F if bird can fly.");
    }

    public static void getStatistic()
    {
        System.out.println("Pet statistic");
        Utilities.printLine("*", 150);
        System.out.printf("%-10s%-10s%-15s\n", "Type", "Amount", "Percentage(%)");
        System.out.printf("%-10s%-10d%-15s\n", "Pet", r1.getTotalPetAmountInRegis(), "100.00");
        System.out.printf("%-10s%-10d%-15.2f\n", "Mammal", r1.getMammalNumInRegis(), r1.getMammalPercentageInRegis());
        System.out.printf("%-10s%-10d%-15.2f\n", "Bird", r1.getBirdNumInRegis(), r1.getBirdPercentageInRegis());
        System.out.printf("%-10s%-10d%-15.2f\n", "Fish", r1.getFishNumInRegis(), r1.getFishPercentageInRegis());
        System.out.printf("%.2f%% of pet are Male.\n", r1.getPercentageMalePetInRegis());
        Utilities.printLine("*", 150);
    }

    public static void birdStatistic()
    {
        System.out.printf("Average Wing Span : %.2f\n", r1.getAverageBirdWingSpanInRegis());
        System.out.printf("Percentage bird can fly : %.2f%%\n", r1.getPercentageOfBirdCanFlyInRegis());
    }

    public static void mammalStatistic()
    {
        System.out.printf("Percentage of mammal that are neutered : %.2f%%\n", r1.getPercentageOfMammalNeuteredInRegis());
    }

    public static List getAllPetsIntoNewList()
    {
        return r1.getAllPetsIntoNewListInRegis();
    }

    public static void displayAllPets(List<Pet> allPets)
    {
        Utilities.printLine("*", 150);
        System.out.printf("%-10s%-10s%-10s%-15s%-20s%-25s%-10s%-10s%-15s\n", "OwnerId", "Id", "Name", "Type", "Breed", "Colour", "Age", "Gender", "Regis_Date");
        for (Pet p : allPets)
        {
            System.out.printf("%-10s%-10s%-10s%-15s%-20s%-25s%-10d%-10s%-15s\n", p.getOwnerID(), p.getPetID(), p.getName(), p.getType(), p.getBreed(), p.getColour(), p.getAge(), p.getGender().toString(), p.getRegis_Date());
        }
        Utilities.printLine("*", 150);
    }

    /**
     * display all pets or mammals, or birds or fishes in all owners
     */
    public static void displayAllPets2(List<Pet> allPets)
    {
        String type = Utilities.getValidString("Enter the pet type u want to print(p|m|f|b)", "[p|m|f|b]");
        Utilities.printLine("*", 150);
        System.out.printf("%-10s%-10s%-10s%-15s%-20s%-25s%-10s%-10s%-15s", "OwnerId", "Id", "Name", "Type", "Breed", "Colour", "Age", "Gender", "Regis_Date");
        if (type.equals("f"))
        {
            System.out.printf("%-10s\n", "WaterType");
        }
        else if (type.equals("m"))
        {
            System.out.printf("%-10s\n", "IsNeutered");
        }
        else if (type.equals("b"))
        {
            System.out.printf("%-15s%-10s\n", "Fly Ability", "Wing Span");
        }
        else if (type.equals("p"))
        {
            System.out.println("");
        }

        for (Pet p : allPets)
        {
            if (type.equals("f") && p instanceof Fish)
            {
                System.out.printf("%-10s%-10s%-10s%-15s%-20s%-25s%-10d%-10s%-15s%-10s\n", p.getOwnerID(), p.getPetID(), p.getName(), p.getType(), p.getBreed(), p.getColour(), p.getAge(), p.getGender().toString(), p.getRegis_Date(), ((Fish) p).getWater_Type().toString());
            }
            else if (type.equals("m") && p instanceof Mammal)
            {
                System.out.printf("%-10s%-10s%-10s%-15s%-20s%-25s%-10d%-10s%-15s%-10s\n", p.getOwnerID(), p.getPetID(), p.getName(), p.getType(), p.getBreed(), p.getColour(), p.getAge(), p.getGender().toString(), p.getRegis_Date(), ((Mammal) p).isIsNeutered());
            }
            else if (type.equals("b") && p instanceof Bird)
            {
                System.out.printf("%-10s%-10s%-10s%-15s%-20s%-25s%-10d%-10s%-15s%-15s%-10.2f\n", p.getOwnerID(), p.getPetID(), p.getName(), p.getType(), p.getBreed(), p.getColour(), p.getAge(), p.getGender().toString(), p.getRegis_Date(), ((Bird) p).getCanFly(), ((Bird) p).getWingSpan());
            }
            else if (type.equals("p"))
            {
                System.out.printf("%-10s%-10s%-10s%-15s%-20s%-25s%-10d%-10s%-15s\n", p.getOwnerID(), p.getPetID(), p.getName(), p.getType(), p.getBreed(), p.getColour(), p.getAge(), p.getGender().toString(), p.getRegis_Date());
            }
        }
        Utilities.printLine("*", 150);
    }

    public static void displayPetOption()
    {
        int select2;
        select2 = Utilities.getValidInt(0, 5, "Input the number to select the options!");
        while (select2 != 0)
        {
            List<Pet> allPets = getAllPetsIntoNewList();
            Collections.sort(allPets);
            switch (select2)
            {
                case 1:
                    Collections.sort(allPets);
                    displayAllPets(allPets);
                    break;
                case 2:
                    PetGenderComparator genderCompare = new PetGenderComparator();
                    Collections.sort(allPets, genderCompare);
                    System.out.println("Print by Pet Gender");
                    displayAllPets(allPets);
                    break;
                case 3:
                    PetAgeComparator ageCompare = new PetAgeComparator();
                    Collections.sort(allPets, ageCompare);
                    System.out.println("Print by Pet Age");
                    displayAllPets(allPets);
                    break;
                case 4:
                    PetDateComparator dateCompare = new PetDateComparator();
                    Collections.sort(allPets, dateCompare);
                    System.out.println("Print by Pet Regis Date");
                    displayAllPets(allPets);
                    break;
                case 5:
                    PetOwnerIDComparator ownerIdCompare = new PetOwnerIDComparator();
                    Collections.sort(allPets, ownerIdCompare);
                    displayAllPets2(allPets);
                    break;
                default:
                    break;
            }
            displayAllPetMenu();
            select2 = Utilities.getValidInt(0, 5, "Input the number to select the options!");
        }
    }

    public static void displayStatisticOption()
    {
        int select3;
        select3 = Utilities.getValidInt(0, 4, "Input the number to select the options!");
        while (select3 != 0)
        {
            switch (select3)
            {
                case 1:
                    getStatistic();
                    break;
                case 2:
                    birdStatistic();
                    break;
                case 3:
                    fishStatistic();
                    break; 
                default:
                    mammalStatistic();
                    break;
            }
            petStatisticMenu();
            select3 = Utilities.getValidInt(0, 4, "Input the number to select the options!");
        }
    }
    
    public static void fishStatistic()
    {
        r1.getFishWaterTypeStatisticInRegis();
    }
}
