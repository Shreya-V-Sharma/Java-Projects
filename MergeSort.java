package CSCI2110;

import java.util.ArrayList;
import java.util.Scanner;
public class MergeSort<T extends Comparable <T>> {

    /**
     * Merge two ordered ArrayLists to form a new ordered ArrayList.
     * It uses the two-finger walk algorithm.
     * @param a The first of the two ordered ArrayLists to be merged.
     * @param b The second of the two ordered ArrayLists to be merged.
     * @return The merged array list that's ordered.
     */
    private static <T extends Comparable<T>> ArrayList<T> merge (ArrayList<T> a, ArrayList<T> b) {
        int newArraySize = a.size() + b.size();
        // It's better to initize the array list capacity since it will
        // prevent internal memory movement which would lead to more time wasted.
        ArrayList<T> newList = new ArrayList<T>(newArraySize);
        int p1 = 0;
        int p2 = 0;
        T a_elem, b_elem;
        for (int i=0; i<newArraySize; i++) {
            if (p1 == a.size()) {
                newList.add(b.get(p2));
                p2++;
            } else if (p2 == b.size()) {
                newList.add(a.get(p1));
                p1++;
            } else {
                a_elem = a.get(p1);
                b_elem = b.get(p2);
                if (a_elem.compareTo(b_elem) < 0) {
                    newList.add(a_elem);
                    p1++;
                } else {
                    newList.add(b_elem);
                    p2++;
                }
            }
        }

        return newList;
    }

    /**
     * Returns the sorted version of an ArrayList using the MergeSort algorithm.
     * @param list The ArrayList to be sorted.
     * @return The new ArrayList containing the sorted version of list.
     */
    public static <T extends Comparable<T>> ArrayList<T> mergeSort (ArrayList<T> list) {
        if (list.size() > 1) {
            int n1 = list.size()/2;
            int n2 = list.size()-n1;

            ArrayList<T> left = new ArrayList<T>(n1);
            ArrayList<T> right = new ArrayList<T>(n2);

            for (int i=0; i<n1; i++) left.add(list.get(i));
            for (int i=0; i<n2; i++) right.add(list.get(i + n1));

            left = mergeSort(left);
            right = mergeSort(right);

            return merge(left, right);
        }
        return list;
    }

   //Test program that sorts a list of positive integers
   public static void main(String[] args){
         ArrayList<Integer> myList = new ArrayList<Integer>();
         Scanner kbd = new Scanner(System.in);
         System.out.println("Enter positive integers, end with -1");
         Integer i = kbd.nextInt();
         while (i!=-1){
              myList.add(i);
              i = kbd.nextInt();
         }

         myList = mergeSort(myList);
         System.out.println(myList);
   }
}
