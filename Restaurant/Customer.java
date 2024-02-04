package Assignment2;

import java.util.ArrayList;
/**
 * This class represents a customer
 * They have an array list of dishes they ordered and has a name
 * It was also used to get order description and total cost using the methods from the dish class
 *
 * @autor Shreya Sharma - B00891805
 */
public class Customer {

    private ArrayList<Dish> order;
    private String name;

    /**
     * This is a constructor to create Customer object using name
     * @param name the name of the customer
     */
    public Customer(String name)
    {
        this.name = name;
        order = new ArrayList<Dish>();
    }

    /**
     * This method returns the name of customer
     * @return name of the customer
     */
    public String getName()
    {
        return name;
    }

    /**
     * This method add the dish passed in as a parameter to the order
     * @param dish the object dish to be added to the order
     */
    public void addToOrder(Dish dish)
    {
        order.add(dish);
    }

    /**
     * This method creates a string with description of each dish in the order using the tostring method of the
     * dish class and then returns that string
     * @return the string representing the description of the order
     */
    public String getOrderDescription()
    {
        String orderDescription = "";
        //iterate over the whole order array list
        for(int i = 0; i<order.size(); i++)
        {
            orderDescription += order.get(i).toString();
            //add new line if the i is not the last one(size-1) so i < size-1
            if(i < order.size()-1)
            {
                orderDescription += "\n";
            }
        }

        return orderDescription;
    }

    /**
     * This method calculates the order value of the customer by using getPrice method of the Dish class
     * @return the total value(price) of the order
     */
    public double getOrderTotalValue()
    {
        double totalValue = 0;
        /*
         * iterate through the order arraylist and use getPrice method from the Dish class to get the price
         * of each dish and add to get the total
         */
        for(int i = 0; i<order.size(); i++)
        {
            totalValue += order.get(i).getPrice();
        }
        return totalValue;
    }

    /**
     * This method checks if two customers are equal by checking their names
     * @param customer the other customer to check with the current customer
     * @return true if both customers are the same, and false if they are not
     */
    public boolean equals(Object customer)
    {
        //if they have the same memory address then they are the same
        if (this == customer){
            return true;
        }
        //if object is not instance of the Customer class then it is not equal to the current customer
        if(!(customer instanceof Customer))
        {
            return false;
        }
        //cast the object into customer object  and then check the names, if same names, they are the same
        Customer other = (Customer)customer;
        if(other.getName() == name)
        {
            return true;
        }
        return false;

    }
}
