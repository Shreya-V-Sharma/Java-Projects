package CSCI2110.Assignment5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

//class that creates the huffman tree using the file provided by user, finds encoding for each letter
//and encodes and decodes line of text given by user.
public class Huffman {

    //the main method that takes in user input, uses other static method to build huffman tree and encoding for each letter, and outputs the results to user
    public static void main(String[] args) throws FileNotFoundException
    {
        //the array to hold all the inputted binaryTree of pairs
        ArrayList<BinaryTree<Pair>> S = new ArrayList<BinaryTree<Pair>>();

        //take in file name to read from
        Scanner kb = new Scanner(System.in);
        System.out.println("Huffman Coding");
        System.out.print("Enter the name of the file with S and probability: ");
        String filename = kb.nextLine();
        File file = new File(filename);
        Scanner inputFile = new Scanner(file);

        System.out.println("\nBuilding the Huffman tree...");

        //read from the file to make pair and make a tree with that pair as data, add it to S
        while(inputFile.hasNext())
        {
            Pair l = new Pair(inputFile.next().charAt(0),inputFile.nextDouble());
            BinaryTree<Pair> pair = new BinaryTree<Pair>();
            pair.makeRoot(l);
            S.add(pair);
        }
        inputFile.close();


        //arraylist used in making the huffman Tree
        ArrayList<BinaryTree<Pair>> T = new ArrayList<BinaryTree<Pair>>();

        //while S has some tree left in it
        while(S.size()>0)
        {
            //the variables to store binary tree of pair with the lowest probabilities
            BinaryTree<Pair> small1;
            BinaryTree<Pair> small2;

            //if there is nothing in T  then take first two things from S as smallest thing
            if(T.size()==0)
            {
                small1 = S.remove(0);
                small2 = S.remove(0);

            }

            //otherwise
            else
            {

                //temp array to store all the smallest things from S and T
                ArrayList<BinaryTree<Pair>> temp = new ArrayList<BinaryTree<Pair>>();

                //add first from S to temp, if there is one more, add that too
                temp.add(S.get(0));
                if(S.size()>1)
                {
                    temp.add(S.get(1));
                }
                //add everything from T
                temp.addAll(T);
                //find the lowest two from temp
                temp = findTwoLowest(temp);
                //get those two lowest things
                small1 = temp.remove(0);
                small2 = temp.remove(0);
                //remove them from S and/or T
                findAndRemove(S,small1,small2);
                findAndRemove(T,small1,small2);
            }

            //make root with the sum of probabilities of the two lowest, sttach small things as child of that root, and add it to T
            BinaryTree<Pair> root = new BinaryTree<Pair>();
            root.makeRoot(new Pair('-',small1.getData().getProb()+small2.getData().getProb()));
            root.attachLeft(small1);
            root.attachRight(small2);
            T.add(root);
        }

        //When we only have things left in T and not S, and it's not one item(the huffman tree) then combine them and make one huffman tree
        //similar to above but with just T
        while(T.size()>1)
        {
            ArrayList<BinaryTree<Pair>> temp = findTwoLowest(T);
            BinaryTree<Pair> small1 = temp.remove(0);
            BinaryTree<Pair> small2 = temp.remove(0);
            findAndRemove(T,small1,small2);
            BinaryTree<Pair> root = new BinaryTree<Pair>();
            root.makeRoot(new Pair('-',small1.getData().getProb()+small2.getData().getProb()));
            root.attachLeft(small1);
            root.attachRight(small2);
            T.add(root);
        }

        //the encoded array with binary encoding from A to Z
        String[] encoding = findEncoding(T.get(0));

        System.out.println("Huffman coding completed.\n");


        //Take in user input to encode, convert it to char array and use that and the encoding array from above to make
        // String array of binary strings for each of the letter the user inputted
        System.out.print("Enter a line of text (uppercase letters only): ");
        String original = kb.nextLine();
        char[] characters = original.toCharArray();
        String[] encoded = new String[characters.length];

        for (int i = 0; i< characters.length; i++)
        {
            //if the character is space then just add space in String
            if (characters[i] == ' ')
            {
                encoded[i] = " ";
            }
            //add binary code for that character
            else
            {
                encoded[i] = encoding[characters[i] - 65];
            }
        }

        System.out.print("Here’s the encoded line: ");

        //print the array of encoded binary
        for(int i = 0; i < encoded.length; i++)
        {
            System.out.print(encoded[i]);
        }
        System.out.println();


        System.out.print("The decoded line is: ");

        //to decode encoded string
        for (int i = 0; i< encoded.length; i++) {
            boolean alphabet = false;
            //for each encoded values, go through the encoding array and if it matches then print that character
            for (int j = 0; j< encoding.length; j++) {
                if (encoded[i].equals(encoding[j])) {
                    //the character gotten by index+65 because when putting it into the array we put it at index =character-65 so chracter = index=65
                    System.out.print((char)(j+65));
                    alphabet = true;
                }
            }
            //if not in the encoding array, that means not alphabet, then print space
            if(!alphabet)
            {
                System.out.print(" ");
            }
        }
    }


    //a helper method to find the two binarytree of pair with the lowest Prob
    //return arraylist of binarytree of pair that has the two lowest binarytree of pair in it
    public static  ArrayList<BinaryTree<Pair>> findTwoLowest(ArrayList<BinaryTree<Pair>> a)
    {
        //the arraylist to return
        ArrayList<BinaryTree<Pair>> temp = new ArrayList<BinaryTree<Pair>>();
        //the first two things from the given arraylist
        BinaryTree<Pair> s1 = a.get(0);
        BinaryTree<Pair> s2 = a.get(1);

        //starting at the third item
        for (int i = 2; i<a.size();i++ )
        {
            BinaryTree<Pair> b = a.get(i);

            //if this item is less than or equal to the first item s1
            if(b.getData().compareTo(s1.getData())<=0)
            {
                //make the s2 equal to s1 so now that is the second-lowest item
                s2 = s1;
                //make the s1 equal to this item, the fist-lowest item
                s1 = b;
            }
            //if this item is less than the second item, then make s2 equal to this
            else if(b.getData().compareTo(s2.getData())<0 )
            {
                s2 = b;
            }

        }
        //and the two lowest items to temp and return it
        temp.add(s1);
        temp.add(s2);
        return temp;
    }

    //helper method to remove given s1 and s2 from array given, if it contains it
    public static void findAndRemove(ArrayList<BinaryTree<Pair>> a,BinaryTree<Pair> s1, BinaryTree<Pair> s2)
    {
        a.removeIf(b -> b == s1 || b == s2);
    }

    //helper method to find the binary encoding for each letter, returns array containing binary encoding from A to Z
    //from lab document
    private static String[] findEncoding(BinaryTree<Pair> bt){
        //for all the letters in the alphabets, so size 26
        String[] result = new String[26];
        //calling on the overloaded method
        findEncoding(bt, result, "");
        return result;
    }

    //overloaded method
    //from lab document
    private static void findEncoding(BinaryTree<Pair> bt, String[] a, String prefix){
        // test is node/tree is a leaf
        if (bt.getLeft()==null && bt.getRight()==null){
            //A=65 so A-65=0, so it is ordering from A to Z in array, binary code for A first then for B then C and so on
            a[bt.getData().getValue() - 65] = prefix;
        }
        // recursive calls
        else{
            //for left add prefix 0, for left add prefix1
            findEncoding(bt.getLeft(), a, prefix+"0");
            findEncoding(bt.getRight(), a, prefix+"1");
        }
    }

}
