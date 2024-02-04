package CSCI2110.Assignment2;
import java.util.Scanner;

public class Excercise1
{
    public static void main(String[] args)
    {
        //take in user input of n for Collatz sequence
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        //until user doesn't input 0, keep taking in n values and do all these things to print out the starting number of logest sequence
        //of a number less than or equal to n, it's size and execution time.
        while(n!=0)
        {
            //code to find Execution time
            long startTime, endTime, executionTime;
            startTime = System.currentTimeMillis();

            // calling lengthOfSeq function that returns array containing lengths of sequences of all numbers less than or equal to n
            int[] result = lengthOfSeq(n);
            int maxLength = 1;//the size of the smallest sequence is 1 where n is 1
            int num = 1;// the starting int of the smallest sequence is 1

            //find max length
            for(int i = 0; i< result.length; i++)
            {
                if(result[i]>maxLength)
                {
                    maxLength = result[i];
                    num = i+1;
                }
            }
            //code to find Execution time
            endTime = System.currentTimeMillis();
            executionTime = endTime - startTime;

            //output
            System.out.println(n +" " +num+ " "+maxLength + " " + executionTime);
            n = kb.nextInt();
        }

    }
    //method to make collatz sequence, since we just need the size of the sequence, I am not saving the number of the sequence
    public static int collatzSeq(int start)
    {
        //start with size 1,since smallest sequence's size is 1
        int size = 1;

        //if n is 1
        if(start==1)
        {
            return size;
        }

        //if n is something other than 1, we start at n and modify it according to sequence rules until we get 1
        int current = start;
        while (current != 1)
        {
            if (current % 2 == 0)
            {
                current /= 2;
                size++;
            }
            else
            {
                current = (current*3) + 1;
                size++;
            }
        }
        return size;
    }

    //this method uses the collatz sequence method to make array of all the lengths of sequence of numbers 1 to n
    public static int[] lengthOfSeq(int start)
    {
        int[] length = new int[start];
        for(int i = 0; i<start; i++)
        {
            length[i] = collatzSeq(i+1);
        }
        return length;
    }
}
