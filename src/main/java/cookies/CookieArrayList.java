package cookies;

//I am importing this to gain access to user input commands.
import java.util.*;


// I am importing all of the stuff I use for my normal java programs
//import java.io.PrintWriter.*;
//import java.io.IOException.*;
//import java.util.Scanner.*;
//import java.io.*;
//import java.text.*;


//import java.util.Random.*;
//import java.math.*;


public class CookieArrayList {




    public static void main(String[] args) {

        //Scanner input = new Scanner(System.in);
        //Scanner sc = new Scanner(System. in);

        // Array of something
        //The current amount of something

        // Constructor that creates an initial array of some size;
        int ExtendedArraySize;
        double[] BasicArray = new double[5];
        int NumberOfAdditions = 30;
        int CurrentLoopCount = 0;
        double RandomizedNumber;
        int LoopCountPlus = 1;

        System.out.println("Program has begun.");


        // Get method that returns the something of a given index;
        System.out.println("Starting off, there are 5 slots in the array");


        while (CurrentLoopCount < NumberOfAdditions) {
            // I'm just going to insert a random number from 1-100 to fill out
            // every given slot

            // If statement to test if the array is too small or not
            if (CurrentLoopCount >= BasicArray.length) {


                System.out.println("If statement activated!");

                BasicArray = ExpandArray(NumberOfAdditions, BasicArray);

            }

            RandomizedNumber = (Math.random() * 100);
            RandomizedNumber = (Math.round(RandomizedNumber));

            BasicArray[CurrentLoopCount] = RandomizedNumber;

            System.out.print("There are currently " + LoopCountPlus + " enteries in the list. ");
            System.out.println("the entry at slot " + CurrentLoopCount + " is " + BasicArray[CurrentLoopCount]);

            CurrentLoopCount = CurrentLoopCount + 1;
            LoopCountPlus = LoopCountPlus + 1;

            // activate choice function

        }
        options(BasicArray);
    }


    // Array expansion method
    public static double[] ExpandArray(int NumberOfAdditions, double[] BasicArray) {


        int ExtendedArraySize;

        ExtendedArraySize = NumberOfAdditions;
        ExtendedArraySize = BasicArray.length * 2;
        double[] ExpandedArray = new double[ExtendedArraySize];

        //ExtendedArraySize = ExtendedArraySize;
        // create a while loop to transfer content from the first array to the new one
        int TransferLoopCount = 0;
        while (TransferLoopCount < BasicArray.length) {
            ExpandedArray[TransferLoopCount] = BasicArray[TransferLoopCount];
            TransferLoopCount++;
        }
        BasicArray = new double[ExtendedArraySize];
        BasicArray = ExpandedArray;
        System.out.println("The array has been updated to be: " + BasicArray.length);

        return BasicArray;


    }
    // I am going to create an options method to give the user choices on how to proceed
    // and what methods to create from there

    public static void options(double[] BasicArray) {
        // This was never given access to the Basic Array. This needs to be modified to accept
        // that as input.

        boolean confirmation;
        String UserChoice;

        Scanner input = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);



        System.out.println("What would you like to do next?: ");
        System.out.println("Enter 'InventoryCheck' if you want to see if the array contains a certain item or not");
        System.out.println("Enter 'CompareArrays' if you want to see if the main array is identical to another or not");
        System.out.println("Enter 'SetSlot' if you want to adjust a specific entry in the array");
        System.out.println("Any input that isn't one of those three will resolve the program.");

        UserChoice = input.next();
        System.out.println(UserChoice);

        //A Switch statement would be better here, but I'm not sure those accept strings, so I'm using an
        // if/else nest instead.

        // PROBLEM: These always result in "False"
        if (UserChoice.equals("InventoryCheck")) {
            // Activate inventory check function
            confirmation = inventoryCheck(BasicArray);
            System.out.println(confirmation);
        } else if (UserChoice.equals("CompareArrays")) {
            confirmation = inventoryCompare(BasicArray);
            System.out.println(confirmation);
            // Activate compare inventory function
        } else if (UserChoice.equals("SetSlot")) {
            // activate insert number function
            confirmation = insertNumber(BasicArray);
            System.out.println(confirmation);
        } else {
            System.out.print("Program concluded");
        }
    }

    // Inventory check function
    public static boolean inventoryCheck(double[] BasicArray) {

        Scanner input = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);
        double searchVar;
        int loopCount = 0;
        System.out.println("Enter the number to check for in the array: ");
        searchVar = input.nextDouble();

        // Create a loop to compare the SearchVar to every entry in the array
        while (BasicArray.length > loopCount) {
            if (BasicArray[loopCount] == searchVar) {
                return true;

            }
            loopCount++;
        }
        return false;
    }

    // Compare array function
    public static boolean inventoryCompare(double[] BasicArray) {
        // Here's what I'll do. I will make three arrays. The first is
        // a randomly generated array that should effectivly always be false
        // the second is a new array with every entry equal to an entry in the BasicArray
        // the third is one that I force to be entirly the same as the BasicArray
        Scanner input = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);

        int arraySize = BasicArray.length;
        int loopCount = 0;
        double dice;
        boolean entryValid = false;
        String chosenArray;

        // create random array
        double[] RandomArray = new double[arraySize];

        while (loopCount < arraySize) {
            dice = (Math.random() * 100);
            dice = (Math.round(dice));
            RandomArray[loopCount] = dice;
            loopCount++;
        }
        loopCount = 0;

        // create slot-by-slot identical array
        double[] SlotArray = new double[arraySize];

        while (loopCount < arraySize) {
            SlotArray[loopCount] = BasicArray[loopCount];
            loopCount++;
        }

        // create truly identical array
        double[] IdenticalArray = new double[arraySize];
        IdenticalArray = BasicArray;

        // ask the user which they'd like to test
        while (entryValid == false) {
            System.out.println("Which array would you like to compare to the first?:");
            System.out.println("Enter 'RandomArray' if you want the array with random contents");
            System.out.println("Enter 'SlotArray' if you want the array with each slot made to match a BasicArray slot");
            System.out.println("Enter 'TrueIdentical' if you want the array made to have the same address as the BasicArray");
            chosenArray = input.next();

            if (chosenArray.equals("RandomArray")) {
                entryValid = true;
                if (RandomArray == BasicArray) {
                    return true;
                } else {
                    return false;
                }
            }
            if (chosenArray.equals("SlotArray")) {
                entryValid = true;
                if (SlotArray == BasicArray) {
                    return true;
                } else {
                    return false;
                }
            }
            if (chosenArray.equals("TrueIdentical")) {
                entryValid = true;
                if (IdenticalArray == BasicArray) {
                    return true;
                } else {
                    return false;
                }
            }

        }

        return false;
    }

    // Insert number function
    public static boolean insertNumber(double[] BasicArray) {
        Scanner input = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);

        int chosenSlot;
        double newNumber;

        System.out.println("Enter the number you'd like to insert: ");
        newNumber = input.nextDouble();

        System.out.println("Enter the place you'd like to put it");
        chosenSlot = input.nextInt();

        if (chosenSlot < 0){
            System.out.println("Slot number too low. Ending program");
            return false;
        }
        if (chosenSlot > BasicArray.length){
            System.out.println("Slow number too high. Ending program");
            return false;
        }
        BasicArray[chosenSlot] = newNumber;
        if (BasicArray[chosenSlot] == newNumber){
            return true;
        } else {
            return false;
        }
    }
}