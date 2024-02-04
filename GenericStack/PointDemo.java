package CSCI2110.Lab2;
import java.util.Scanner;

public class PointDemo {
    public static void main(String[] args){
        Scanner kb = new Scanner(System.in);

        //taking input and creating point objects
        System.out.println("Enter integer coordinates x and y: ");
        Point<Integer> point1 = new Point<Integer>(kb.nextInt(), kb.nextInt());

        System.out.println("Enter double coordinates x and y: ");
        Point<Double> point2 = new Point<Double>(kb.nextDouble(), kb.nextDouble());

        System.out.println("Enter String coordinates x and y: ");
        Point<String> point3 = new Point<String>(kb.next(), kb.next());

        //printing the objects
        System.out.println(point1);
        System.out.println(point2);
        System.out.println(point3);
    }
}
