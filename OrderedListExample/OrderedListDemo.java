package CSCI2110.Assignment4;

import java.util.Scanner;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;

//this class uses the OrderedList class and tests new methods with the data in the files provided(list1.txt, list2.txt)
//it writes the results in 3 files, merged.txt, difference.txt and common.txt
public class OrderedListDemo {
    public static void main(String[] args) throws IOException
    {
        //taking in user input for the file names to read from to make the ordered list
        //making file that we can read from
        Scanner kb = new Scanner(System.in);
        System.out.println("Enter the first filename to read from:");
        String fileName = kb.nextLine();
        File file = new File(fileName);
        Scanner inputFile = new Scanner(file);
        System.out.println("Enter the second filename to read from:");
        String fileName2 = kb.nextLine();
        File file2 = new File(fileName2);
        Scanner inputFile2 = new Scanner(file2);

        //making the ordered list of string
        OrderedList<String> wordList = new OrderedList<String>();
        OrderedList<String> wordList2 = new OrderedList<String>();

        //insert the word in the ordered lists from the files
        while(inputFile.hasNext())
        {
            wordList.insert(inputFile.next());
        }
        while(inputFile2.hasNext())
        {
            wordList2.insert(inputFile2.next());
        }

        //calling the three methods on the two ordered list made above and saving the results in these three ordered lists
        OrderedList<String> merged = merge(wordList,wordList2);
        OrderedList<String> different =  difference(wordList,wordList2);
        OrderedList<String> common = common(wordList,wordList2);

        //writing the words from above result lists(results of the methods) into the files merged.txt, difference.txt and common.txt
        //note: the file names of those three files are according to my location of those files, please change them according to the file path of those files on your computer

        FileWriter writer1 = new FileWriter("C:\\Users\\Shreya Sharma\\IdeaProjects\\src\\CSCI2110\\Assignment4\\merged.txt");
        writer1.write(merged.first() + "\n");
        for(int i = 1; i < merged.size(); i++)
        {
            writer1.write( merged.get(i)+ "\n");
        }
        writer1.close();

        FileWriter writer2 = new FileWriter("C:\\Users\\Shreya Sharma\\IdeaProjects\\src\\CSCI2110\\Assignment4\\diff.txt");
        writer2.write(different.first()+ "\n");
        for(int i = 1; i < different.size(); i++)
        {
            writer2.write(different.get(i)+ "\n");
        }
        writer2.close();

        FileWriter writer3 = new FileWriter("C:\\Users\\Shreya Sharma\\IdeaProjects\\src\\CSCI2110\\Assignment4\\common.txt");
        writer3.write(common.first()+ "\n");
        for(int i = 1; i < common.size(); i++)
        {
            writer3.write(common.get(i)+ "\n");
        }
        writer3.close();

        System.out.println("The merge operations are complete and the results are in merged.txt, difference.txt and common.txt");
    }

    //merge method that takes in two ordered list, merges them and returns an ordered list
    //used the two finger walking algorithm
    public static <T extends Comparable<T>> OrderedList<T> merge(OrderedList<T> list1, OrderedList<T> list2){
        //the third new list
        OrderedList<T> mergedList = new OrderedList<T>();

        //helper variable for first list
        T curr1 = list1.first();
        //helper variable for second list
        T curr2 = list2.first();

        //while both lists have next
        while(curr1 != null && curr2 != null)
        {
            //use compareTo method to compare the item from the first list to the item from the second list
            int compare = curr1.compareTo(curr2);

            //if the item from the first list comes first lexically, then add that item to the third result list and move the curr1 up to next item
            if(compare<0)
            {
                mergedList.add(curr1);
                curr1 = list1.next();
            }
            //if the second item comes first lexically, then add that and move curr2 to next item
            else if(compare>0)
            {
                mergedList.add(curr2);
                curr2 = list2.next();
            }
            //if they are the same, add once and move both curr1 and curr2
            else
            {
                mergedList.add(curr1);
                curr1 = list1.next();
                curr2 = list2.next();
            }
        }
        //if one of the list finishes, then just add all the items from the other list
        if(curr1==null)
        {
            while(curr2 != null)
            {
                mergedList.add(curr2);
                curr2 = list2.next();
            }
        }
        else if(curr2==null)
        {
            while(curr1 != null)
            {
                mergedList.add(curr1);
                curr1 = list2.next();
            }
        }
        return mergedList;
    }

    //difference method that takes in two ordered lists, and returns a list with items from the first list that are not in the second list
    //done by modifying the two finger walking algorithm
    //similar to merge method
    public static <T extends Comparable<T>> OrderedList<T> difference(OrderedList<T> list1, OrderedList<T> list2)
    {
        OrderedList<T> different = new OrderedList<T>();
        T curr1 = list1.first();
        T curr2 = list2.first();
        while(curr1 != null && curr2 != null)
        {
            int compare = curr1.compareTo(curr2);
            //if this(curr1) is greater, then there is still a chance that the other list(list2) has something that's equal to this(curr1)
            //so we go to the next item in second list to check this(move curr2 up to the next item)
            if(compare>0)
            {
                curr2 = list2.next();
            }
            //if this(curr1) is less, then there is no chance the second list has anything left that might be equal to it
            //so we just add curr1 to the result list and move to the next item to check(move curr1 up to the next item)
            else if(compare<0)
            {
                different.add(curr1);
                curr1 = list1.next();
            }
            //if they are equal, we are not adding it since we want only things that are different, so we move to the next item(move curr1 up to the next item)
            else
            {
                curr1 = list1.next();
            }
        }
        //if there is nothing left in the second list, the all the remaining items in the first list must be different
        //so we add them to the result list
        if(curr2==null)
        {
            while(curr1 != null)
            {
                different.add(curr1);
                curr1 = list2.next();
            }
        }
        return different;
    }

    //common method that takes in two ordered lists and returns an ordered list that contains the common items from the two lists
    //done by modifying the two finger walking algorithm
    //similar to merge method and difference method
    public static <T extends Comparable<T>> OrderedList<T> common(OrderedList<T> list1, OrderedList<T> list2)
    {
        OrderedList<T> common = new OrderedList<T>();
        T curr1 = list1.first();
        T curr2 = list2.first();
        while(curr1 != null && curr2 != null)
        {
            int compare = curr1.compareTo(curr2);
            //if this(curr1) is less, we need to go to next item(move curr1 to next item that will be greater) and see that is equal
            if(compare<0)
            {
                curr1 = list1.next();
            }
            //if this(curr1) is greater, go to the next item(move curr2 to the next item that will be greater) in other list and see if that is equal
            else if(compare>0)
            {
                curr2 = list2.next();
            }
            //if they are equal, add it to the result list once and move to next items in both lists(mover curr1 and curr2 to the next items)
            //We are moving curr2 to the next item because the next item in the first list will definitely be greater than this second list item
            //so we will be moving it up anyways
            else
            {
                common.add(curr1);
                curr1 = list1.next();
                curr2 = list2.next();
            }
        }
        //if any of the lists end, then there would be no common items left to find
        //so just return
        return common;
    }
}
