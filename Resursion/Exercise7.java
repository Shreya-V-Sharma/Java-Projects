package CSCI2110.Lab5;
import java.util.Scanner;

public class Exercise7 {

    //main method to take user input and call solve method and print output
    public static void main(String[] args)
    {
        Scanner kb = new Scanner(System.in);
        System.out.println("Enter a positive integer n:");
        int n = kb.nextInt();

        //code to find execution time
        long startTime, endTime, executionTime;
        startTime = System.currentTimeMillis();

        //calling solve method using user input n
        long steps = solve(n);

        //code to find execution time
        endTime = System.currentTimeMillis();
        executionTime = endTime - startTime;

        System.out.println(n + "    " + steps + "    " + executionTime );
    }

    //overloaded solve method
    //calls the other solve method with input with extra input 1,3,2
    public static long solve(int n)
    {
        return solve(n,1,3,2);
    }

    //overloaded solve method
    //solves towers of hanoi problem with n number of discs and returns the number of steps taken
    public static long solve(int n, int start, int end, int tmp)
    {
        //starting with one step, using this to do similar thing as return 1 + solve(), but since we have to call solve method twice, we can't
        //return twice, so keeping out in the steps, each call to the method will have different steps variables initialized to 1, when the last call
        //return, it will add all of them
        long steps = 1;
        //base case, if 0 discs, then 0 steps required
        if(n==0)
        {
            return 0;
        }
        //glue case
        if(n>0)
        {
            //steps to solve tower of hanoi, adding them to steps variable
            steps += solve(n-1,start,tmp,end);
            steps += solve(n-1,tmp,end,start);
        }
        return steps;
    }
}
