package Assignment2;

/**
 * This class represents a dish
 * it has a name and a price
 *
 * @autor Shreya Sharma - B00891805
 */
public class Dish {

    private String name;
    private double price;

    /**
     * This is the constructor to create a Dish object with a name and a price
     * @param name the name of the dish
     * @param price the price of the dish
     */
    public Dish(String name, double price)
    {
        this.name = name;
        this.price = price;
    }

    /**
     * This method returns the name of the dish
     * @return the dish name
     */
    public String getName()
    {
        return name;
    }

    /**
     * This method return the price of the dish
     * @return the dish price
     */
    public double getPrice()
    {
        return price;
    }

    /**
     * This method returns a string contaning information of the dish object including the name and price of the object
     * @return string representation of dish
     */
    public String toString()
    {
        return String.format("%s - %.2f CAD", name, price);
    }

}
