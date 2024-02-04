package CSCI2110.Lab1;
import java.util.Scanner;

public class Exercise1 {
    public static void main(String args[])
    {
        //for sample
        Scanner kb = new Scanner(System.in);
        int numTests = kb.nextInt();
        String output = "";

        for(int i = 0; i < numTests; i++)
        {
            Rectangle1 first = new Rectangle1(kb.nextDouble(), kb.nextDouble(), kb.nextDouble(), kb.nextDouble());
            Rectangle1 second = new Rectangle1(kb.nextDouble(), kb.nextDouble(), kb.nextDouble(), kb.nextDouble());

            output += "The first " + first + "\n\n" + "The second " + second + "\n\n" + "The contains method returns: " + first.contains(second) + "\n" + "The touches method returns: " + first.touches(second) + "\n\n\n";
        }
        System.out.println(output);


//Use the below code for testing out the cases illustrated in the lab document (pg.5) and some more

        // 0 0 2 2
        // 0.5 0.5 1 1

        // 0 0 2 2
        // 1 1 1 1

        // 0 0 2 2
        // 2 2 1 1

        // 0 0 2 2
        // 2 1 1 1

        // 0 0 2 2
        // 2 3 1 1


        Rectangle1 test1 = new Rectangle1(0,0,2,2);
        Rectangle1 test2 = new Rectangle1(0.5,0.5,1,1);

        System.out.println("1 " + test1.contains(0.5,0.5));
        System.out.println("  " + test1.touches(0.5,0.5));
        System.out.println();

        System.out.println("2 " + test1.contains(2,0.5));
        System.out.println("  " + test1.touches(2,0.5));
        System.out.println();

        System.out.println("3 " + test1.contains(test2));
        System.out.println("  " + test1.touches(test2));
        System.out.println();

        test2.moveTo(1,1);
        System.out.println("4 " + test1.contains(test2));
        System.out.println("  " + test1.touches(test2));
        System.out.println();

        test2.moveTo(2,2);
        System.out.println("5 " + test1.contains(test2));
        System.out.println("  " + test1.touches(test2));
        System.out.println();

        test2.moveTo(2,1);
        System.out.println("6 " + test1.contains(test2));
        System.out.println("  " + test1.touches(test2));
        System.out.println();

        test2.moveTo(1.5,1.5);
        System.out.println("7 " + test1.contains(test2));
        System.out.println("  " + test1.touches(test2));
        System.out.println();

//extra test cases

        test2.moveTo(2,3);
        System.out.println("8 " + test1.contains(test2));
        System.out.println("  " + test1.touches(test2));
        System.out.println();

        System.out.println("9 " + test1.contains(2,2));
        System.out.println();

        System.out.println("10 " + test1.touches(2,5));
        System.out.println();

    }
}
