package CSCI2110.Lab5;
import java.util.Scanner;

public class Exercise3
{
    //main method to call special countdown method using n, user input
    public static void main(String[] args)
    {
        Scanner kb = new Scanner(System.in);
        System.out.println("Enter a positive integer:");
        int n = kb.nextInt();
        countDown(n);
    }
    // different count down that counts down even, if n is even, and odd if n is odd
    public static void countDown(int n)
    {
        //base case, when done counting down (only positive numbers in count down) then print Blastoff!
        if(n<=0)
        {
            System.out.println("BlastOff!");
        }
        //glue case, print n and call method on n-2, subtracting 2 will keep the number even or odd depending on if n was even or odd
        else
        {
            System.out.print(n + "      " );
            countDown(n-2);
        }
    }
}
