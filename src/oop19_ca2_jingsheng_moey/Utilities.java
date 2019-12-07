/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop19_ca2_jingsheng_moey;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author HP
 */
public class Utilities
{
    public static String INPUT_MISS_MATCH = "Input doesn't Match!";
    public static String ERROR_MESSAGE = "Something went wrong, pls try again!";

    /**
     * ask user to enter a integer check if it's valid or in range
     *
     * @param min minimum value of the range
     * @param max maximum value of the range
     * @param msg Message that ask user to input
     * @return a valid integer in range of min and max
     */
    public static int getValidInt(int min, int max, String msg)
    {
        Scanner input = new Scanner(System.in);
        int user_input = -1;
        boolean isValidInput = false;
        while (isValidInput != true)
        {
            try
            {
                System.out.println(msg);
                user_input = input.nextInt();
                input.nextLine();
                while ((user_input < min) || (user_input > max))
                {
                    System.out.println("Invalid - [" + min + "," + max + "] only");
                    user_input = input.nextInt();
                    input.nextLine();
                }
                isValidInput = true;
            } catch (InputMismatchException e)
            {
                input.nextLine();
                System.out.println(INPUT_MISS_MATCH);
            }
        }
        return user_input;
    }

    /**
     * ask user to enter a integer check if it's valid or in range
     *
     * @param min minimum value of the range
     * @param msg Message that ask user to input
     * @returna a valid integer in no lesser than min
     */
    public static int getValidInt(int min, String msg)
    {
        Scanner input = new Scanner(System.in);
        int user_input = -1;
        boolean isValidInput = false;
        while (isValidInput != true)
        {
            try
            {
                System.out.println(msg);
                user_input = input.nextInt();
                input.nextLine();
                while (user_input < min)
                {
                    System.out.println("Invalid, Pls Enter at lease more than " + min);
                    user_input = input.nextInt();
                    input.nextLine();
                }
                isValidInput = true;
            } catch (InputMismatchException e)
            {
                input.nextLine();
                System.out.println(INPUT_MISS_MATCH);
            }
        }
        return user_input;
    }

    /**
     * ask user to enter a double check if it's valid
     *
     * @param min minimum value of the range
     * @param max maximum value of the range
     * @param msg Message that ask user to input
     * @return a valid integer in no lesser than min
     */
    public static double getValidDouble(double min, double max, String msg)
    {
        Scanner input = new Scanner(System.in);
        boolean isValidInput = false;
        double user_input = 0;
        while (isValidInput != true)
        {
            try
            {
                System.out.println(msg);
                user_input = input.nextDouble();
                input.nextLine();
                while ((user_input < min) || (user_input > max))
                {
                    System.out.println("Invalid - [" + min + "," + max + "] only");
                    user_input = input.nextDouble();
                    input.nextLine();
                }
                isValidInput = true;
            } catch (InputMismatchException e)
            {
                input.nextLine();
                System.out.println(INPUT_MISS_MATCH);
            }
        }
        return user_input;
    }
        /**
         * ask user to input T/F to return a boolean status with passing in
         * message
         *
         * @return a valid boolean either true of false
         */
    public static boolean getValidBoolean()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Input T/F");
        String user_input = input.nextLine();

        while (!user_input.toLowerCase().matches("[t|f|true|false]"))
        {
            System.out.println("Input T/F");
            user_input = input.nextLine();
        }
        if (user_input.startsWith("t"))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * ask user to input T/F to return a boolean status
     *
     * @param msg Message that ask user to input
     * @return a valid boolean
     */
    public static boolean getValidBoolean(String msg)
    {
        Scanner input = new Scanner(System.in);
        boolean validated_Boolean = false;
        System.out.println(msg);
        String user_input = input.nextLine();

        while (!user_input.toLowerCase().matches("[t|f|true|false]"))
        {
            System.out.println(msg);
            user_input = input.nextLine();
        }
        if (user_input.startsWith("t"))
        {
            validated_Boolean = true;
        }
        else
        {
            validated_Boolean = false;
        }
        return validated_Boolean;
    }
    
    public static boolean getValidBoolean(String msg, String validation)
    {
        Scanner input = new Scanner(System.in);
        boolean validated_Boolean = false;
        System.out.println(msg);
        String user_input = input.nextLine();

        while (!user_input.matches(validation))
        {
            System.out.println(msg);
            user_input = input.nextLine();
        }
        if (user_input.toLowerCase().startsWith("y"))
        {
            validated_Boolean = true;
        }
        else
        {
            validated_Boolean = false;
        }
        return validated_Boolean;
    }

    /**
     * system key in t to return true else everything will return false, use for
     * system load in file
     *
     * @param b t/f to return true and false
     * @return true or false
     */
    public static boolean getBoolean(String b)
    {
        if (b.toLowerCase().startsWith("t"))
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     *
     * @param msg Message that ask user to input
     * @param validation validation passing in
     * @return a valid string matches the validation that user pass in
     */
    public static String getValidString(String msg, String validation)
    {
        Scanner input = new Scanner(System.in);
        System.out.println(msg);
        String user_input = input.nextLine();
        while (user_input.length() == 0 || !user_input.matches(validation))
        {
            System.out.println(msg);
            user_input = input.nextLine();
        }
        return user_input;
    }

    /**
     * print a symbol with a specific amount that pass in
     *
     * @param symbol the symbol pass in to print
     * @param numberOfSymbol the number of symbol print
     */
    public static void printLine(String symbol, int numberOfSymbol)
    {
        for (int i = 0; i < numberOfSymbol; i++)
        {
            System.out.print(symbol);
        }
        System.out.println("");
    }
}
