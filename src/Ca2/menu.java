/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ca2;

import java.util.Scanner;

/**
 *
 * @author HP
 */
public class menu
{
    public static Scanner input = new Scanner(System.in);
    //final value
    public static final String INPUT_MESSAGE    = "Enter Action > ";
    public static final String QUIT_MESSAGE     = "System Quit.";
    public static final String ERROR_MESSAGE    = "Something went wrong, pls try again!";
    
    public static void main(String[] args)
    {
        
    }
    public static void runMenu()
    {
        printMenu();
        System.out.print(INPUT_MESSAGE + "(0 to 3 only)");
        int user_input = ifInputValid(0, 3);
        while (user_input != 0)
        {
            switch (user_input)
            {
                case 1:
                    break;
                case 2:
                    break;
                default:
                    break;
            }
            printMenu();
            System.out.print(INPUT_MESSAGE + "(0 to 3 only)");
            user_input = ifInputValid(0, 3);
        }
        System.out.print(QUIT_MESSAGE);
    }
    
    public static void printMenu()
    {
        System.out.println("***********************************");
        System.out.println("Welcome to Cipher Text!");
        System.out.println("1) Display two String");
        System.out.println("2) Decrypt by using Key 3");
        System.out.println("3) Decrypt by Unknown Key");
        System.out.println("0) Enter 0 to quit");
        System.out.println("***********************************");
    }
    
    public static int ifInputValid(int min, int max)
    {
        int user_input = -1;
        boolean isValidInput = false;
        System.out.print(INPUT_MESSAGE);
        while (isValidInput == false)
        {
            try
            {
                user_input = input.nextInt();
                input.nextLine();

                while ((user_input < min) || (user_input > max))  // while outside range, re-enter
                {
                    System.out.println("Invalid - [" + min + "," + max + "] only");
                    user_input = input.nextInt();
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
}
