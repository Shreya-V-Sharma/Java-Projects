package CSCI2110.Lab5;
import java.util.Scanner;

public class Exercise2
{
    //main method to call countDown using the n user input
    public static void main(String[] args)
    {
        Scanner kb = new Scanner(System.in);
        System.out.println("Enter a positive integer:");
        int n = kb.nextInt();
        countDown(n);
    }
    //recursive method to count down from n to 1 and print Blastoff! after
    public static void countDown(int n)
    {
        //base case, when done counting down, print Blastoff!
        if(n==0)
        {
            System.out.println("BlastOff!");
        }
        //glue case, print n and call count down on n-1
        else
        {
            System.out.print(n + "      " );
            countDown(n-1);
        }
    }

}
