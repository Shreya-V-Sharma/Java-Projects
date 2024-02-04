package CSCI2110.Lab5;
import java.util.Scanner;

public class Exercise4
{
    //main method that calls multiples method using the n and m input by the user
    public static void main(String[] args)
    {
        Scanner kb = new Scanner(System.in);
        System.out.println("Enter a positive integer n:");
        int n = kb.nextInt();
        System.out.println("Enter another positive integer m:");
        int m = kb.nextInt();
        multiples(n,m);
    }
    //recursive method to find m multiples of n
    public static void multiples(int n, int m)
    {
        //base case, if fist multiple, print n
        if(m==1)
        {
            System.out.print(n);
        }
        //glue case, find multiple m-1 and print that multiple(in this reverse order so the output will be in ascending order)
        else
        {
            multiples(n,m-1);
            System.out.print(", " + n*m );

        }

    }
}
