package CSCI2110.Lab5;
import java.util.Scanner;

public class Exercise6
{
    //main method that calls squares method using the n input by the user
    public static void main(String[] args)
    {
        Scanner kb = new Scanner(System.in);
        System.out.println("Enter a positive integer n:");
        int n = kb.nextInt();
        System.out.println("sum of the squares of all digits 1 through " + n + " is " + squares(n));
    }

    //recursive method that returns sum of squares of all digits 1 through n
    public static int squares(int n)
    {
        //base case, sum of squares of numbers 1 through 1 is 1
        if(n==1)
        {
            return 1;
        }
        //glue case, n^2 + sum of squares of 1 through n-1
        else
        {
            return (n*n) + squares(n-1);
        }
    }
}
