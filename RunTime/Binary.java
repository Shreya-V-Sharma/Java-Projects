package CSCI2110.Lab3;
import java.util.Scanner;
/*
Binary Number Generation
*/
/**
 This class tests the code for Lab2: Exercise3. It calls a method that accepts a positive
 integer n and
 generates binary numbers between 0 and 2^n -1. The main method prints information about
 running time.
 */

public class Binary{
    public static void main(String[] args){

        //take in the user input
        Scanner kb = new Scanner(System.in);
        System.out.println("Enter a positive integer: ");
        int n = kb.nextInt();

        //the last number we have to find binary for
        int x = (int)(Math.pow(2,n)) - 1;

        //code to find execution time
        long startTime, endTime, executionTime;
        startTime = System.currentTimeMillis();

        //calling the method to find all the binary numbers from 0 to 2^n -1
        generateBinary(n);

        //code to find execution time
        endTime = System.currentTimeMillis();
        executionTime = endTime - startTime;

        //printing output including the execution time
        System.out.println("The execution time to generate binary number from 0 to " + x + " is " +executionTime+ " ms");
    }

    //method to generate binary int from 0 to 2^n -1
    public static void generateBinary(int n){
        //x = 2^n -1
        int x = (int)(Math.pow(2,n))-1;
        // from 0 to 2^n -1
        for(int i = 0; i<=x; i++)
        {
            //generate binary String
            Integer.toBinaryString(i);
        }
    }
}
