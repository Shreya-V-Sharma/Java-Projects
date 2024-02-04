package CSCI2110.Lab4;
import java.util.Scanner;

public class LinkedListDemo {

    public static void main(String[] args){

        //take in user inputs and make Linked list of Strings
        Scanner kb = new Scanner(System.in);
        System.out.println("Enter Pokemon names, one on each line\nEnter quit to end");
        String names = kb.next();
        LinkedList<String> pokemon = new LinkedList<>();
        while(!(names.equals("quit")))
        {
            pokemon.add(names);
            names = kb.next();
        }
        //call all the methods and print the output in specific format
        pokemon.enumerate();
        System.out.println();
        System.out.println();
        displayEven(pokemon);
        System.out.println();
        System.out.println();
        displayOdd(pokemon);
        System.out.println();
        System.out.println();
        System.out.println("Here is the reversed linked list:");
        reverse(pokemon).enumerate();
        System.out.println();
        System.out.println();
        removeMiddle(pokemon);
        pokemon.enumerate();
        System.out.println();
        System.out.println();
        pokemon.removeAll("A");
        pokemon.enumerate();

    }

    //method to display even-numbered nodes
    public static void displayEven(LinkedList<String> list){
        System.out.println("Here is the linked list with even-numbered nodes:");
        for(int i = 0; i<list.size(); i+=2)
        {
            System.out.print(list.getAt(i) + "   ");
        }
    }

    //method to display odd-numbered nodes
    public static void displayOdd(LinkedList<String> list){
        System.out.println("Here is the linked list with odd-numbered nodes:");
        for(int i = 1; i<list.size(); i+=2)
        {
            System.out.print(list.getAt(i) + "   ");
        }
    }

    //method to create a reversed linked list
    public static LinkedList<String> reverse(LinkedList<String> list){
        LinkedList<String> rev = new LinkedList<>();
        for(int i = 0; i< list.size(); i++)
        {
            rev.add(list.getAt(i));
        }
        return rev;
    }

    //method to remove the middle node in the linked list
    public static void removeMiddle(LinkedList<String> list){
        if(list.size() % 2 == 0)
        {
            list.removeAt((list.size() / 2) -1);
        }
        else
        {
            list.removeAt((list.size() / 2));
        }
    }
}


