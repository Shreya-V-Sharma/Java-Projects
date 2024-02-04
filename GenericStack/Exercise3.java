package CSCI2110.Lab2;

import java.util.*;
import java.io.*;

public class Exercise3{
    public static void main(String[] args)throws IOException{

        //creating GenericStack to hold all the StudentRecords
        GenericStack<StudentRecord> stack1 = new GenericStack<StudentRecord>();

        //taking in the file name
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter the filename to read from: ");
        String filename = keyboard.nextLine();

        //Creating file object to read from it
        File file = new File(filename);
        Scanner inputFile = new Scanner(file);
        StringTokenizer token;

        //reading from the file - until it has something left to read
        while (inputFile.hasNext()){
            //reading from file
            String line = inputFile.nextLine();
            token = new StringTokenizer(line, " ");
            String firstName = token.nextToken();
            String lastName = token.nextToken();
            String IDString = token.nextToken();

            //convert String IDString to an Integer Object IDNum
            Integer IDNum = Integer.valueOf(IDString);

            //Create a StudentRecord Object with the first name, last name
            //and ID number, push it into stack1
            StudentRecord student  = new StudentRecord(firstName, lastName, IDNum);
            stack1.push(student);

        }

        //close the file
        inputFile.close();

        //pop StudentRecord object from stack1 and pushing the last name from it in the stack2
        GenericStack<String> stack2 = new GenericStack<String>();
        int stack1Size = stack1.size();
        for(int i = 0; i < stack1Size; i++)
        {
            stack2.push(stack1.pop().getLastName());
        }

        //popping and printing all the last names from stack2
        int stack2Size = stack2.size();
        for(int i = 0; i < stack2Size; i++)
        {
            System.out.println(stack2.pop());
        }


    }
}
