/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ca2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author HP
 */
public class main
{

    public static Scanner input = new Scanner(System.in);
    public static final String INPUT_MISS_MATCH = "Input does not matched!";
    public static final int MINIMUM_AGE = 0;
    public static final int MAXIMUM_AGE = 100;

    /**
     *
     * @param args
     */
    public static void main(String[] args)
    {
        ArrayList<Pet> pets = new ArrayList<>();
        pets.add(new Pet("lucky", "dog", "bla", "black"));
        pets.add(new Mammal("m", "m", "m", "m", true));
        pets.add(new Bird("m", "m", "m", "m", 5, true));
        pets.add(new Fish("m", "m", "m", "m", WaterType.BRACKISH));

        try
        {
//        setAll(pets);
//        addPet(pets);
//            addMammal(pets);
//            addFish(pets);
//        addMammal(pets);
//        addFish(pets);
//        addBird(pets);
            System.out.println("another");
            displayById(pets,3);
            System.out.println("Herer");
            displayPets(pets);
        } catch (Exception e)
        {
            e.getMessage();
        }

    }

    /**
     *
     * @param pets arraylist of pet
     */
    public static void displayPets(List pets)
    {
        for (int i = 0; i < pets.size(); i++)
        {
            System.out.println(pets.get(i));
        }
    }

//    /**
//     * add pet and checking if name's duplicated!
//     * @param pets arraylist of pet
//     */
//    public static void addPet(ArrayList pets) // only name 
//    {
//        System.out.println("Enter Pet's name");
//        String name = input.nextLine();
//        int i = 0;
//        boolean found = false;
//        while (found != true && i < pets.size())
//        {
//            if (pets.get(i).equals(new Pet(name)))
//            {
//                found = true;
//            }
//            i++;
//        }
//        if (found != true)
//        {
//            pets.add((new Pet(name)));
//            System.out.println("Pet's added");
//        }
//        else
//        {
//            System.out.println("Found same!Pet's not added.");
//        }
//    }
    /**
     * check pet's name, type, breed, colour add it if not found same
     *
     * @param pets arraylist of pet
     */
    public static void addPet(ArrayList pets) // compare name, type, breed and colour 
    {
        System.out.println("Enter Pet's name");
        String name = input.nextLine();
        System.out.println("Enter new type");
        String type = input.nextLine();
        System.out.println("Enter new Breed");
        String breed = input.nextLine();
        System.out.println("Enter new Colour");
        String colour = input.nextLine();
        if (ifDuplicatePet(pets, name, type, breed, colour))
        {
            System.out.println("Found duplicate!");
        }
        else
        {
            pets.add(new Pet(name, type, breed, colour));
        }
    }

    /**
     * set pet's name, type, breed, age, colour, gender, owner's ID
     *
     * @param pets arraylist of pet
     */
    public static void setAll(ArrayList<Pet> pets)
    {
        System.out.println("Enter pet's id");
        int id = input.nextInt();
        input.nextLine();
        if (ifIdExist(pets, id))
        {
            setName(pets, id);
            setType(pets, id);
            setBreed(pets, id);
            setAge(pets, id);
            setColour(pets, id);
            setGender(pets, id);
            setOwnerID(pets, id);
        }
        else
        {
            System.out.println("Pet's ID not found!");
        }

    }

    /**
     * set pet's name
     *
     * @param pets arraylist of pet
     * @param id pet's id
     */
    public static void setName(ArrayList<Pet> pets, int id)
    {
        System.out.println("Enter new Name");
        String name = input.nextLine();
        pets.get(id).setName(name);
        System.out.println("Name set");
    }

    /**
     * set pet's type
     *
     * @param pets arraylist of pet
     * @param id pet's id
     */
    public static void setType(ArrayList<Pet> pets, int id)
    {
        System.out.println("Enter new type");
        String type = input.nextLine();
        pets.get(id).setType(type);
        System.out.println("Type set");
    }

    /**
     * set pet's breed
     *
     * @param pets arraylist of pet
     * @param id pet's id
     */
    public static void setBreed(ArrayList<Pet> pets, int id)
    {
        System.out.println("Enter new Breed");
        String breed = input.nextLine();
        pets.get(id).setBreed(breed);
        System.out.println("Breed set");
    }

    /**
     * set pet's age
     *
     * @param pets arraylist of pet
     * @param id pet's id
     */
    public static void setAge(ArrayList<Pet> pets, int id)
    {
        boolean validAge = false;
        while (validAge != true)
        {
            int age;
            try
            {
                System.out.println("Enter new Age(Only positive and lesser than 100)");
                age = input.nextInt();
                while (age < MINIMUM_AGE || age > MAXIMUM_AGE)
                {
                    System.out.println("Enter new Age(Only positive and lesser than 100)");
                    age = input.nextInt();
                }
                pets.get(id).setAge(age);
                validAge = true;
            } catch (IllegalArgumentException e)
            {
                System.out.println(e.getMessage());
            } catch (InputMismatchException e)
            {
                System.out.println(INPUT_MISS_MATCH);
            }
            input.nextLine();
        }

        System.out.println("New Age set");
    }

    /**
     * set pet's colour
     *
     * @param pets arrayList of pet
     * @param id pet's id
     */
    public static void setColour(ArrayList<Pet> pets, int id)
    {
        System.out.println("Enter new Colour");
        String colour = input.nextLine();
        pets.get(id).setColour(colour);
        System.out.println("New Colour set");
    }

    /**
     * set pet's gender
     *
     * @param pets arrayList of pet
     * @param id pet's id
     */
    public static void setGender(ArrayList<Pet> pets, int id)
    {
        System.out.println("Enter new Gender(M/F)");
        String gender = input.nextLine().toUpperCase();
        while (!gender.equals("M") && !gender.equals("F"))
        {
            System.out.println("Enter new Gender(M/F)");
            gender = input.nextLine().toUpperCase();
        }
        if (gender.startsWith("M"))
        {
            pets.get(id).setGender(Gender.MALE);
        }
        else
        {
            pets.get(id).setGender(Gender.FEMALE);
        }
        System.out.println("New Gender set");
    }

    /**
     * Set owner's id
     *
     * @param pets arrayList of pet
     * @param id pet's id
     */
    public static void setOwnerID(ArrayList<Pet> pets, int id)
    {
        System.out.println("Enter new Owner Id");
        int ownerID = input.nextInt();
        pets.get(id).setOwnerID(ownerID);
        System.out.println("New Owner Id set");
    }

    /**
     *
     * @param pets arrayList of pet
     */
    public static void addMammal(ArrayList<Pet> pets)
    {
        boolean isNeutered = false;
        boolean insertNeutered = false;

        System.out.println("Enter Mammal's name");
        String name = input.nextLine();
        System.out.println("Enter new type");
        String type = input.nextLine();
        System.out.println("Enter new Breed");
        String breed = input.nextLine();
        System.out.println("Enter new Colour");
        String colour = input.nextLine();
        while (insertNeutered != true)
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
                insertNeutered = true;
            } catch (IllegalArgumentException e)
            {
                System.out.println(e.getMessage());
            } catch (InputMismatchException e)
            {
                System.out.println(INPUT_MISS_MATCH);
            }
            input.nextLine();
        }
        if (ifDuplicateMammal(pets, name, type, breed, colour, isNeutered))
        {
            System.out.println("Found duplicate!");
        }
        else
        {
            pets.add(new Mammal(name, type, breed, colour, isNeutered));
        }
    }

//    public static void setNeutered(ArrayList<Pet> pets)
//    {
//        System.out.println("Enter pet's id");
//        int id = input.nextInt();
//        input.nextLine();
//        if (ifIdExist(pets, id))
//        {
//            pets.get(id).get
//        }
//        while (!neutered.toLowerCase().startsWith("t") || !neutered.toLowerCase().startsWith("f"))
//        {
//
//        }
//        if (neutered.toLowerCase().startsWith("t"))
//        {
//            this.isNeutered = true;
//        }
//        else
//        {
//            this.isNeutered = false;
//        }
//    }
    /**
     *
     * @param pets arrayList of pet
     */
    public static void addFish(ArrayList<Pet> pets)
    {
        boolean insertWater_Type = false;
        String stringWater_Type = "";
        WaterType water_Type = WaterType.FRESHWATER;;

        System.out.println("Enter Fish's name");
        String name = input.nextLine();
        System.out.println("Enter new type");
        String type = input.nextLine();
        System.out.println("Enter new Breed");
        String breed = input.nextLine();
        System.out.println("Enter new Colour");
        String colour = input.nextLine();
        while (insertWater_Type != true)
        {
            try
            {
                System.out.println("Enter only freshwater, seawater and brackish");
                stringWater_Type = input.nextLine();
                while (!stringWater_Type.toLowerCase().equals("freshwater") && !stringWater_Type.toLowerCase().equals("seawater") && !stringWater_Type.toLowerCase().equals("brackish"))
                {
                    System.out.println("Enter only freshwater, seawater and brackish");
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
                insertWater_Type = true;
            } catch (IllegalArgumentException e)
            {
                System.out.println(e.getMessage());
            } catch (InputMismatchException e)
            {
                System.out.println(INPUT_MISS_MATCH);
            }
        }
        if (ifDuplicateFish(pets, name, type, breed, colour, water_Type))
        {
            System.out.println("Found duplicate!");
        }
        else
        {
            pets.add(new Fish(name, type, breed, colour, water_Type));
        }
    }

    /**
     *
     * @param pets arrayList of pet
     */
    public static void addBird(ArrayList<Pet> pets)
    {
        boolean insertcanFly = false;
        boolean canFly = false;
        boolean insertWingSpan = false;
        int wingSpan = 0;
        System.out.println("Enter Bird's name");
        String name = input.nextLine();
        System.out.println("Enter new type");
        String type = input.nextLine();
        System.out.println("Enter new Breed");
        String breed = input.nextLine();
        System.out.println("Enter new Colour");
        String colour = input.nextLine();

        while (insertWingSpan != true)
        {
            try
            {
                System.out.println("Enter Wing Span");
                wingSpan = input.nextInt();
                insertWingSpan = true;
            } catch (IllegalArgumentException e)
            {
                System.out.println(e.getMessage());
            } catch (InputMismatchException e)
            {
                System.out.println(INPUT_MISS_MATCH);
            }
            input.nextLine();
        }

        while (insertcanFly != true)
        {
            try
            {
                System.out.println("Enter true or false if can fly");
                canFly = input.nextBoolean();
                while (canFly != true && canFly != false)
                {
                    System.out.println("Enter true or false if can fly");
                    canFly = input.nextBoolean();
                }
                insertcanFly = true;
            } catch (IllegalArgumentException e)
            {
                System.out.println(e.getMessage());
            } catch (InputMismatchException e)
            {
                System.out.println(INPUT_MISS_MATCH);
            }
            input.nextLine();
        }
        if (ifDuplicateBird(pets, name, type, breed, colour, wingSpan, canFly))
        {
            System.out.println("Found duplicate!");
        }
        else
        {
            pets.add(new Bird(name, type, breed, colour, wingSpan, canFly));
        }
    }

    /**
     * see if there's any duplicate
     *
     * @param pets arraylist of pet
     * @param name pet's name
     * @param type pet's type
     * @param breed pet's breed
     * @param colour pet's colour
     * @return true of false if duplicate found
     */
    public static boolean ifDuplicatePet(ArrayList pets, String name, String type, String breed, String colour)
    {
        return pets.contains(new Pet(name, type, breed, colour));
    }

    public static boolean ifDuplicateMammal(ArrayList pets, String name, String type, String breed, String colour, boolean isNeutered)
    {
        return pets.contains(new Mammal(name, type, breed, colour, isNeutered));
    }

    public static boolean ifDuplicateBird(ArrayList pets, String name, String type, String breed, String colour, int wingSpan, boolean canFly)
    {
        return pets.contains(new Bird(name, type, breed, colour, wingSpan, canFly));
    }

    public static boolean ifDuplicateFish(ArrayList pets, String name, String type, String breed, String colour, WaterType water_Type)
    {
        return pets.contains(new Fish(name, type, breed, colour, water_Type));
    }

    /**
     * to see if current pet's id exist in the arrayList
     *
     * @param pets arrayList of pet
     * @param id pet's id
     * @return true of false if exist
     */
    public static boolean ifIdExist(ArrayList<Pet> pets, int id)
    {
        if(IdExist(pets, id) == -1)
            return false;
        else
            return true;
    }
    
    public static int IdExist(ArrayList<Pet> pets, int id)
    {
        int pos = -1;
        int i = 0;
        while (i < pets.size() && pos == -1)
        {
            if (pets.get(i).getPetID().equals("PID" + id))
            {
                pos = i;
            }
            i++;
        }
        return pos;
    }
    
    public static void displayById(ArrayList<Pet> pets,  int id)
    {
        if(ifIdExist(pets, id))
        {
            System.out.println(pets.get(id));
        }
        else
            System.out.println("Id not found!");
        
    }
    
    public static void deleteById(ArrayList<Pet> pets,  int id)
    {
        if(ifIdExist(pets, id))
        {
            pets.remove(IdExist(pets,id));
        }
        else
            System.out.println("Id not found!");
    }
}
