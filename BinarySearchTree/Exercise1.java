package CSCI2110.Lab7;
import java.util.Scanner;

//this class uses BinarySearchTree, used to test findMax,findMin and recursive search methods
public class Exercise1 {
    public static void main(String[] args) {
        //the search tree that we will test method on
        BinarySearchTree<Integer> intTree = new BinarySearchTree<Integer>();

        //make the tree using user input, keep taking input and stop when the user inputs 0
        Scanner kb = new Scanner(System.in);
        System.out.print("Enter int or '0': ");
        int num = kb.nextInt();
        while(num != 0)
        {
            //use insert method from BinarySearch tree to add a node/tree/leaf but keep it sorted according to the rule
            intTree.insert(num);
            System.out.print("Enter name or done: ");
            num = kb.nextInt();
        }

        //testing out the 3 methods, findMan, findMin and recursiveSearch
        System.out.println("The max data value in the BST is: " + intTree.findMax());
        System.out.println("The min data value in the BST is: " + intTree.findMin());
        System.out.print("What key would you like to search for? ");
        int findNum = kb.nextInt();
        //if there is some data in it, then find using key otherwise print tree is empty
        if(!intTree.isEmpty())
        {
            intTree.recursiveSearch(findNum);
        }
        else
        {
            System.out.println("The tree is empty");
        }

    }
}
