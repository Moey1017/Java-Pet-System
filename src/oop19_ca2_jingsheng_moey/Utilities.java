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
    public static void main(String[] args)
    {
        getValidString("whatever","(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])");
    }
    public static String INPUT_MISS_MATCH = "Input doesn't Match!";
    public static String ERROR_MESSAGE = "Something went wrong, pls try again!";
    public static Scanner input = new Scanner(System.in);

    public static int getValidInt(int min, int max, String msg)
    {
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
            } catch (Exception e)
            {
                input.nextLine();
                System.out.println(ERROR_MESSAGE);
            }
        }
        return user_input;
    }
    
     public static int getValidInt(int min, String msg)
    {
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
                    System.out.println("Invalid, Pls Enter at lease more than " + min );
                    user_input = input.nextInt();
                    input.nextLine();
                }
                isValidInput = true;
            } catch (Exception e)
            {
                input.nextLine();
                System.out.println(ERROR_MESSAGE);
            }
        }
        return user_input;
    }
    
    public static double getValidDouble(double min, double max, String msg)
    {
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
            } catch (IllegalArgumentException e)
            {
                System.out.println(e.getMessage());
            } catch (InputMismatchException e)
            {
                System.out.println(INPUT_MISS_MATCH);
                input.nextLine();
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
            while (!user_input.toLowerCase().matches("[t|f]"))
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
        } catch (InputMismatchException e)
        {
            System.out.println(INPUT_MISS_MATCH);
            input.nextLine();
        }
        return validated_Boolean;
    }
    
    public static boolean getValidBoolean(String msg)
    {
        boolean validated_Boolean = false;
        System.out.println(msg);
        String user_input = input.nextLine();
        try
        {
            while (!user_input.toLowerCase().matches("[t|f]"))
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
        } catch (InputMismatchException e)
        {
            System.out.println(INPUT_MISS_MATCH);
            input.nextLine();
        }
        return validated_Boolean;
    }
    
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

    public static String getValidString(String msg, String validation)
    {
        System.out.println(msg);
        String user_input = input.nextLine();
        try
        {

            while (user_input.length() == 0 || !user_input.matches(validation))
            {
                System.out.println(msg);
                user_input = input.nextLine();
            }
        } catch (IllegalArgumentException e)
        {
            System.out.println(e.getMessage());
            input.nextLine();
        } catch (InputMismatchException e)
        {
            System.out.println(INPUT_MISS_MATCH);
            input.nextLine();
        }
        return user_input;
    }
    
    public static void printLine(String symbol, int numberOfSymbol)
    {
        for(int i = 0; i < numberOfSymbol; i++)
        {
            System.out.print(symbol);
        }
        System.out.println("");
    }
    
}
