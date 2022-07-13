package Assignmet3.Foods.Foods;
import Assignmet3.Foods.Farm.Soil;
/**
 * This class represents food, it has a name, sell price, days to mature, area required and preferred soil
 * it also keeps track of days since the food was potted
 *
 * @author Shreya Sharma- B00891805
 */
public abstract class Food implements Comparable<Food>
{
    private String name;
    private double sellPrice;
    private int daysToMature;
    private int daysSincePotted;
    private int requiredArea;
    protected Soil preferredSoil;

    /**
     * This is a constructor to create food with name, sell price, days to mature and area required;
     * @param name the name of the food
     * @param price the sell price of the food
     * @param days the number of days it would take the food to mature(ready to harvest)
     * @param area the area required by the food plant
     */
    public Food(String name, double price, int days, int area)
    {
        this.name = name;
        sellPrice = price;
        daysToMature = days;
        requiredArea = area;
        daysSincePotted = 0;
    }

    /**
     * This gets the name of the food
     * @return name of the food
     */
    public String getName()
    {
        return name;
    }

    /**
     * This gets the sell price of the food
     * @return sell price of the food
     */
    public double getSellPrice()
    {
        return sellPrice;
    }

    /**
     * This gets the preferred soil of the food
     * @return preferred soil of the food
     */
    public Soil getPreferredSoil()
    {
        return preferredSoil;
    }

    /**
     * This sets the preferred soil of the food
     * @param soil the preferred soil of the food
     */
    public void setPreferredSoil(Soil soil)
    {
        preferredSoil = soil;
    }

    /**
     * This gets the number of days it would take the food to mature
     * @return number of days it would take the food to mature
     */
    public int getDaysToMature()
    {
        return daysToMature;
    }

    /**
     * This gets the number of days since the food of potted
     * @return days since the food was potted
     */
    public int getDaysSincePotted()
    {
        return daysSincePotted;
    }

    /**
     * This sets the number of days since the food of potted
     * @param days days since the food was potted
     */
    public void setDaysSincePotted(int days)
    {
        daysSincePotted = days;
    }

    /**
     * This gets the required area of the food
     * @return required area of the food
     */
    public int getRequiredArea()
    {
        return requiredArea;
    }

    /**
     * this is an abstract grow method which will be implemented by the sub class of food class
     * @param soil the soil the food is seeded in
     * @return the growth cycle
     */
    public abstract double grow(Soil soil);

    /**
     * This is the general grow method which increases the days sice potted by one and returns the growth cycle
     * @return the growth cycle(days since potted / days to mature), returns 1 if days since potted is greater than the
     * days to mature
     */
    protected double grow()
    {
        daysSincePotted++;
        //if days since potted is greater than days to mature, just return 1
        if(daysSincePotted>daysToMature)
        {
            return 1.00;
        }
        return (double)daysSincePotted/daysToMature;
    }

    /**
     * This method compares foods using the sell price, and is used to sort the foods form highest to lowest sells price
     * @param food the food to compare to
     * @return int that represents the deffence between the prices whose sign(-,0,+) can be used to order foods
     */
    @Override
    public int compareTo(Food food) {
        return (int)(food.getSellPrice() - this.sellPrice);
    }

    /**
     * This method creates String representation of the food objects
     * @return string containing the name of the food, the preferred soil, and shows a fraction of days since potted
     * and days to mature
     */
    public String toString()
    {
        //to make String representation of the soil
        String soil = "";
        if (preferredSoil == Soil.Loam)
        {
            soil ="Loam";
        }
        if (preferredSoil == Soil.Clay)
        {
            soil ="Clay";
        }
        if (preferredSoil == Soil.Sand)
        {
            soil ="Sand";
        }
        if (preferredSoil == Soil.Silt)
        {
            soil ="Silt";
        }

        return String.format("%s (%s) - %d/%d days",name,soil,daysSincePotted,daysToMature);
    }

}