package CSCI2110.Lab5;
import java.util.Scanner;

public class Exercise1
{
    //main method that takes in user input and call all the recursive methods using that for testing
    public static void main(String[] args)
    {
        Scanner kb = new Scanner(System.in);

        System.out.println("Factorial of a number");
        System.out.println("The factorials of the integers 1 through 10 are");

        //loop to call the factorial method to find factorials of numbers 1 to 10
        for(int i = 1; i <= 10; i++)
        {
            //if it's last number, print without the comma
            if(i==10)
            {
                System.out.print(factorial(i));
            }
            //if it's the first or middle numbers, print with comma
            else
            {
                System.out.print(factorial(i) + ", ");
            }
        }
        //for adding space in between the outputs
        System.out.println("\n");

        System.out.println("Fibonacci numbers");
        System.out.println("The first 20 numbers in the Fibonacci series are ");

        //loop to call the fibonacci method to find first 20 fibonacci numbers
        for(int i = 0; i < 20 ; i++)
        {
            //if last, without comma
            if(i==19)
            {
                System.out.print(fib(i));
            }
            //if not last, then print with comma
            else
            {
                System.out.print(fib(i) + ", ");
            }
        }
        System.out.println("\n");

        //taking in integers x and n and calling power method to output x^n
        System.out.println("Power of a number");
        System.out.println("Enter a positive integer x:");
        int x = kb.nextInt();
        System.out.println("Enter another positive integer:");
        int n = kb.nextInt();
        System.out.println(x + " to the power of " + n + " is " + power(x,n));
    }

    //recursive method to find factorical of n, so n!
    public static int factorial(int n)
    {
        //base case, factorial of 0 is 1
        if(n==0)
        {
            return 1;
        }
        //glue case
        else
        {
            return n * factorial(n-1);
        }
    }

    //recursive method to find the nth number of fibonacci sequence
    public static int fib(int n)
    {
        //base case, first(zeroth) fibonacci number is 0
        if(n==0)
        {
            return 0;
        }
        //base case 2, second(n=1) fibonacci number is 1
        else if(n==1)
        {
            return 1;
        }
        //glue case, nth fibonacci number is sum of the two previous fibonacci numbers
        else
        {
            return fib(n-1) + fib(n-2);
        }
    }

    //recursive method to find x^n
    public static int power(int x, int n)
    {
        //base case x^0 =1
        if(n==0)
        {
            return 1;
        }
        //glue case, x^n = x * x^(n-1)
        else
        {
            return x * power(x,n-1);
        }
    }
}
