package CSCI2110.Lab2;
import java.util.*;
public class GenericStackDemo{
    public static void main(String[] args) {
        GenericStack<String> stack1 = new GenericStack<String>();
        GenericStack<Integer> stack2 = new GenericStack<Integer>();

        Scanner kb = new Scanner(System.in);

        //taking input until the next word is not "quit"
        String elem = kb.next();
        while(!(elem.equals("quit")))
        {
            stack1.push(elem);
            elem = kb.next();
        }

        //taking input until the next int is not -1(negative)
        int num = kb.nextInt();
        while(num>=0)
        {
            stack2.push(num);
            num = kb.nextInt();
        }

        int size1 = stack1.size();
        int size2 = stack2.size();

        //popping all the elements from the stack and printing them
        System.out.println("String Stack Contents: ");
        for(int i = 0; i <size1; i++)
        {
            System.out.println(stack1.pop());
        }
        System.out.println("\nInteger Stack Contents: ");
        for(int j = 0; j <size2; j++)
        {
            System.out.println(stack2.pop());
        }


    }
}
