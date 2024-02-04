package CSCI2110.Lab8;//Hash Table Experiment
//This is a simple demo program that
//creates an ArrayList of LinkedList of Integer objects
//It first displays the empty linked lists
//It then hashes some keys and displays the linked lists again
//It uses the generic LinkedList class and the generic Node class

//MODIFY THIS PROGRAM TO DO EXERCISE 1
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
public class HashTableExperiment
{
	public static void main(String[] args)
	{
		//prompt the user to enter the table size
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Enter the hash table size: ");
		int n = keyboard.nextInt();
		
		//create an Arraylist of size n
		//The ArrayList holds a LinkedList object 
		//The LinkedList consists of nodes that hold integer objects
		ArrayList<LinkedList<Integer>> hashtable = new ArrayList<LinkedList<Integer>>();
		for (int i=0; i<n; i++)
		{
			hashtable.add(i, new LinkedList<Integer>());
		}
		//prompt the user to enter number of keys
		System.out.print("Enter number of keys to be hashed: ");
		int k = keyboard.nextInt();

		// generate random numbers within 1 to 1000
		ArrayList<Integer> keys = new ArrayList<>();
		Random randomGenerator = new Random();
		for (int i = 0; i < k; i++) {
			int rand = randomGenerator .nextInt(1000) + 1;
			if(!keys.contains(rand))
			{
				keys.add(rand);
				int index = rand%n;
				hashtable.get(index).add(rand);
			}
			else
			{
				i--;
			}
		}

		int numCollisions = 0;
		int longestLength = 0;
		for (int i=0; i<n; i++)
		{
			if(!hashtable.get(i).isEmpty())
			{
				numCollisions += hashtable.get(i).size()-1;
			}
			int x = hashtable.get(i).size();
			if(x>longestLength)
			{
				longestLength=x;
			}
		}

		System.out.println("Statistics:");
		System.out.println("Table size: " + n);
		System.out.println("Number of Keys: " + k );
		System.out.println("Load factor: " + k/(n*1.0));
		System.out.println("Number of collisions: " + numCollisions);
		System.out.println("Longest list: " + longestLength);
	}
}
			
		