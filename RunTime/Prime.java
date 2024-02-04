package CSCI2110.Lab3;
import java.util.Scanner;
/*
Prime Solution
*/
/**
 This class tests the code for Lab2: Exercise1. It calls a method to
 calculate the nth prime and prints information about running time.
 */
public class Prime {
    public static void main(String[] args)
    {
        Scanner kb = new Scanner(System.in);
        String output;
        //the n to find the nth prime
        int n = kb.nextInt();
        //keep taking input n until n is equal to 0
        while(n != 0)
        {
            output = "";

            //code to find the execution time
            long startTime, endTime, executionTime;
            startTime = System.currentTimeMillis();

            //calling the the method to find the nth prime
            long prime = nthPrime(n);

            //code to find the execution time
            endTime = System.currentTimeMillis();
            executionTime = endTime - startTime;

            //making output using n, the nth prime number and execution time
            output +=  n + " " + prime + " " +executionTime;

            //outputting and taking in next n
            System.out.println(output);
            n = kb.nextInt();
        }

    }
    //method to find nth prime, takes n(declared as p in this case) and returns the nth prime(variable named number)
    public static long nthPrime(long p){

        //if p is 1, just return 2, because 1st prime is 2
        if(p==1)
        {
            return 2;
        }
        //if p is more than 1
        //start it at number of prime == 1 and moves up until number of prime is p
        long numOfPrime = 1;
        //we would check all the numbers (odd, start at 1 and increment it by 2 because prime can't be even) if they are prime increment the number of prime
        //the loop breaks when number of prime is equal to p and returns that number(the pth prime)
        long number = 1;
        while(numOfPrime != p)
        {
            number += 2;
            //uses is prime method that is defined below
            if(isPrime(number))
            {
                numOfPrime++;
            }
        }
        return number;
    }

    //isPrime method takes parameter n and return true if n is prime and false otherwise
    public static boolean isPrime(long n)
    {
        //if n is negative, 0 or 1, it returns false, because those are not prime
        if(n<=1)
        {
            return false;
        }
        //if n is 2 and 3, returns true, because we know 2 and 3 are prime
        else if(n==2 || n==3)
        {
            return true;
        }
        //if n is more than 3
        else
        {
            //go from 2 to square root of n, and finds if it has any factors
            for(int i = 2; i <= Math.sqrt(n); i++)
            {
                //if it is divisible by any number, then it is not prime, and return false
                if(n%i ==0)
                {
                    return false;
                }
            }
            //if gone through all the values but there was no factor then return true, the number n is prime
            return true;
        }
    }
}

//I understood this algorithm for finding nth prime from https://java2blog.com/nth-prime-number-java/#Nth_prime_number_in_java