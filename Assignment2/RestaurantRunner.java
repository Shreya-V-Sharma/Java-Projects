package Assignment2;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * This class represents a dish
 * it has a name and a price
 *
 * @autor Shreya Sharma - B00891805
 */
public class RestaurantRunner {
    public static void main(String[] args) {
        //This code will ONLY compile after you have completed the other classes

        //Uncomment the lines below once you finished the other classes

        //Ideally we would read all this info from a file
        //but we haven't seen files yet
        Scanner kb = new Scanner(System.in);
        Restaurant spicyJoe = new Restaurant("Spicy Joe");
        //Spicy Joe is very exclusive, there is only one table ;)
        spicyJoe.createTable(4);

        //First we create the restaurant's menu
        int numDishes = kb.nextInt();
        for (int i = 0; i < numDishes; i++) {
            //get rid of that pesky \n
            kb.nextLine();
            String name = kb.nextLine();
            double price = kb.nextDouble();

            //Add the dish to teh menu
            spicyJoe.addDishToMenu(name, price);
        }

        //Cool, lets create some customers
        Customer anne = new Customer("Anne");
        Customer eve = new Customer("Eve");
        Customer mike = new Customer("Mike");

        //They all seat together
        spicyJoe.getTableByNumber(1).seatCustomer(anne);
        //Wait.. we have an overloaded method to seat a party
        ArrayList<Customer> party = new ArrayList<>(2);
        party.add(eve);
        party.add(mike);
        spicyJoe.getTableByNumber(1)
                .seatCustomer(party);

        //Print the menu
        spicyJoe.printMenu();

        //Mike wants #1
        //We already have the reference to mike, we don't need to search for mike on the table
        mike.addToOrder(spicyJoe.getMenu().get(0));
        //Eve is really hungry
        eve.addToOrder(spicyJoe.getMenu().get(0));
        eve.addToOrder(spicyJoe.getMenu().get(1));
        eve.addToOrder(spicyJoe.getMenu().get(1));
        eve.addToOrder(spicyJoe.getMenu().get(2));
        //Anne is cheap and will eat from everyone's plate so she does not have to pay ;)

        //Bill time, split?
        boolean split = kb.nextBoolean();
        System.out.println(spicyJoe.getTableByNumber(1).generateBill(split));

    }
}
