package CSCI2110.Lab1;

import java.util.Scanner;

public class Exercise2
{
    public static void main(String args[])
    {
        //for sample
        Scanner kb = new Scanner(System.in);
        int numTests = kb.nextInt();
        String output = "";
        for (int i = 0; i < numTests; i++)
        {
            Circle first = new Circle(kb.nextDouble(), kb.nextDouble(), kb.nextDouble());
            Circle second = new Circle(kb.nextDouble(), kb.nextDouble(), kb.nextDouble());

            output += "The first " + first + "\n\n" + "The second " + second + "\n\n" + "The 'contains' method returns: " + first.contains(second) + "\n" + "The 'touches' method returns: " + first.touches(second) + "\n\n\n";
        }
        System.out.println(output);

        //illustrated cases from pg.7 of the lab document
        // 0 0 5
        // 0 1 1

        // 0 0 5
        // 0 4 1

        // 0 0 5
        // 0 6 1

        // 0 0 5
        // 0 5 1

        Circle test1 = new Circle(0,0,5);

        System.out.println("1 "+ test1.contains(1,1));
        System.out.println("  "+ test1.touches(1,1));
        System.out.println();

        System.out.println("2 "+ test1.contains(0,5));
        System.out.println("  "+ test1.touches(0,5));
        System.out.println();

        Circle test2 = new Circle(0,1,1);
        System.out.println("3 "+ test1.contains(test2));
        System.out.println("  "+ test1.touches(test2));
        System.out.println();

        test2.setPos(0,4);
        System.out.println("4 "+ test1.contains(test2));
        System.out.println("  "+ test1.touches(test2));
        System.out.println();

        test2.setPos(0,6);
        System.out.println("5 "+ test1.contains(test2));
        System.out.println("  "+ test1.touches(test2));
        System.out.println();

        test2.setPos(0,5);
        System.out.println("6 "+ test1.contains(test2));
        System.out.println("  "+ test1.touches(test2));
        System.out.println();
    }
}
