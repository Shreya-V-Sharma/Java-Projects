package CSCI2110.Lab5;
import java.util.Scanner;

public class Exercise5
{
    //main method that calls writeVertical method using the n input by the user
    public static void main(String[] args)
    {
        Scanner kb = new Scanner(System.in);
        System.out.println("Enter a positive integer n:");
        int n = kb.nextInt();
        writeVertical(n);
    }
    //the recursive method to print number vertically
    public static void writeVertical(int n)
    {
        //base case, if n<10(so one digit), print n
        if(n<10)
        {
            System.out.println(n);
        }
        //glue case, call writeVertical on n/10 so with last digit removed and print n%10 so we get the last digit
        //(in this reverse order so the output will be in ascending order, first digit printed front, last digit printed last)
        else
        {
            writeVertical(n/10);
            System.out.println(n%10);
        }
    }
}
