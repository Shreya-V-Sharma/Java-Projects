package Assignment2;

import java.util.ArrayList;
/**
 * This class represents a restaurant, It has array list of dishes(menu) and arraylist of tables, and a name.
 * It also keeps track of total revenue(totalSalesVolume).
 *
 * @autor Shreya Sharma - B00891805
 */
public class Restaurant {

    private ArrayList<Dish> menu;
    private ArrayList<Table> tables;
    private double totalSalesVolume;
    private final String RESTAURANT_NAME;

    /**
     * This a constructor for creating a restaurant object with the restaurant name
     * @param name the name of the restaurant
     */
    public Restaurant(String name)
    {
        RESTAURANT_NAME = name;
        menu = new ArrayList<Dish>();
        tables = new ArrayList<Table>();
    }

    /**
     * This method gets the menu(arrayList)
     * @return the menu
     */
    public ArrayList<Dish> getMenu()
    {
        return menu;
    }

    /**
     * This method gets the table using the table number
     * @param number the number of the table that we want
     * @return the table with that number if table number is valid(>=1), and null if table number invalid
     */
    public Table getTableByNumber(int number)
    {
        //valid table numbers start from 1 and are positive
        if (number>=1)
        {
            //the table numbers start at one but their indexes in the tables list start at 0 so number -1 = index
            return tables.get(number - 1);
        }
        return null;
    }

    /**
     * This method makes a dish object using the name and price passed in and adds it to the menu
     * @param name the name of the dish
     * @param price the price of the dish
     */
    public void addDishToMenu(String name, double price)
    {
        Dish newItem = new Dish(name, price);
        menu.add(newItem);
    }

    /**
     * This method creates a table using the size passed in and the number that it creates and adds it
     * to the list of tables
     * @param size the size of the table
     */
    public void createTable(int size)
    {
        //the number start at one when the indexes start at zero
        // the table added should have a number one greater than the size
        //for example if the list is empty(size 0) the table added should have number 1, if size 1, table number 2 and so on
        int number = tables.size() +1;
        Table table = new Table(size,number);
        tables.add(table);
    }

    /**
     * This method prints the menu(every dish)
     */
    public void printMenu()
    {
        //print menu-  implicitly uses the toString of the dish class
        for(int i =0; i<menu.size();i++)
        {
            System.out.println((i+1) + " - " +menu.get(i));
        }
    }

    /**
     * This method "closes" a table with a table number passed in by calculating its total revenue and adding it to
     * the restaurants total sales volume
     * @param tableNumber the table number identifying the table to close
     */
    public void closeTable(int tableNumber)
    {
        // got a table by number using method from this class and revenue of it using getTotalTableRevenue method of the table class
        totalSalesVolume += getTableByNumber(tableNumber).getTotalTableRevenue();
    }

    /**
     * This method returns a string representation of the Restaurant object that includes the restaurant name and it's revenue
     * @return String representation of a restaurant object
     */
    public String toString()
    {
        return String.format("Restaurant %s,night revenue so far %.2f", RESTAURANT_NAME,totalSalesVolume);
    }

}
