package CSCI2110.Assignment2;
import java.util.Scanner;

public class Excercise2 {
    public static void main(String[] args)
    {
        //take in user input of n for Cousin Collatz sequence
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        //until user doesn't input 0, keep taking in n values and do all these things to print out the starting number of logest sequence
        //of a number less than or equal to n, it's size and execution time.
        while(n!=0)
        {
            //code to find Execution time
            long startTime, endTime, executionTime;
            startTime = System.currentTimeMillis();

            //calling lengthOfSeq function that returns array containing lengths of sequences of all numbers less than or equal to n
            //then find the max length
            int[] result = lengthOfSeq(n);
            int maxLength = 1;
            int num = 1;
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
    //method to make Cousin collatz sequence, since we just need the size of the sequence, I am not saving the number of the sequence
    public static int cuzCollatzSeq(int start)
    {
        //for start(n) = 1
        int size = 1;
        if(start==1)
        {
            return size;
        }

        //modify current according to sequence rules until we get current equals 1, keep updating the size accordingly
        int current = start;
        while (current != 1)
        {
            if (current % 2 == 0)
            {
                current /= 2;
                size++;
            }
            else if(current%4==1)
            {
                current = (current*7) + 1;
                size++;
            }
            else if(current%4==3)
            {
                current = (current*7) - 1;
                size++;
            }
        }
        return size;
    }
    //this method uses the cousin collatz sequence method to make array  to store all the lengths of sequence of numbers 1 to n
    public static int[] lengthOfSeq(int start)
    {
        int[] length = new int[start];
        for(int i = 0; i<start; i++)
        {
            length[i] = cuzCollatzSeq(i+1);
        }
        return length;
    }
}