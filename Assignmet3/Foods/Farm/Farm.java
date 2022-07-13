package Assignmet3.Foods.Farm;
import Assignmet3.Foods.Foods.Food;

import java.util.ArrayList;
/**
 * This class represents a farm with specific area, list of food grown there and type of soil
 * It also keeps track of the area left
 *
 * @author Shreya Sharma - B00891805
 */
public class Farm
{
    private int totalArea;
    private int currentArea;
    private ArrayList<Food> foods;
    private Soil farmSoil;

    /**
     * This is a constructor to create a farm using the passed in total area and the type of the soil
     * @param area the total area of the farm
     * @param soil the type of the soil of the farm
     */
    public Farm(int area, Soil soil)
    {
        totalArea = area;
        farmSoil = soil;
        currentArea = area;
        foods = new ArrayList<>();
    }

    /**
     * This method gets the total area of the farm
     * @return total area of the farm
     */
    public int getTotalArea()
    {
        return totalArea;
    }

    /**
     * This method gets the current area left in the farm
     * @return current area of the farm(area left)
     */
    public int getCurrentArea()
    {
        return currentArea;
    }

    /**
     * This method gets the type of the soil that a farm has
     * @return the type of farm soil
     */
    public Soil getFarmSoil()
    {
        return farmSoil;
    }

    /**
     * This methos gets the number of food(s) that growing in a farm
     * @return the number of food(s) seeded in the farm
     */
    public int getFoodQuantity()
    {
        return foods.size();
    }

    /**
     * This method return a food at a specific index from the arrayList of foods, it returns null if the index is invalid
     * @param index the index we want to get food from
     * @return food(object) at the index if the index is within 0 and size of the arraylist or else it returns null
     */
    public Food getFood(int index)
    {
        if(index>=0 && index<foods.size())
        {
            return foods.get(index);
        }
        return null;
    }

    /**
     * This method returns the total farm value by adding the sellprice of all the food that is seeded in the farm
     * @return total price of the farm's food
     */
    public double getTotalFarmValue()
    {
        double total = 0;
        for(Food food:foods)
        {
            total+=food.getSellPrice();
        }
        return total;
    }

    /**
     * This method returns the total value of the food that are ready to harvest from the farm,
     * food is ready to harvest if the days since it was potted are greater than the days to mature
     * @return total sellprice of the food that is ready to harvest
     */
    public double getReadyToHarvestValue()
    {
        double total = 0;
        for(Food food:foods)
        {
            //if ready to harvest
            if(food.getDaysSincePotted()>=food.getDaysToMature())
            {
                total+=food.getSellPrice();
            }
        }
        return total;
    }

    /**
     * This method add(seeds) the food to the farm if there is space left for it
     * @param food the food to be seeded
     * @return true if the food was seeded and false if it wasn't
     */
    public boolean seedFood(Food food)
    {
        //if enough space
        if(currentArea-food.getRequiredArea()>=0)
        {
            foods.add(food);
            currentArea-=food.getRequiredArea();
            return true;
        }
        return false;
    }

    /**
     * This method harvests food at a given index by removing it from the food list and adds the required space of that
     * food back to the left area, the food needs to be ready to harvest to harvest it
     * @param index the index at which the food has to be harvested
     * @return the removed food if the method was able to remove the full(valid index and food ready), if not,
     * it will return null
     */
    public Food harvestFood(int index)
    {
        //if valid index
        if(index>=0 && index<foods.size())
        {
            Food food = foods.get(index);
            //if ready to harvest
            if(food.getDaysSincePotted()>=food.getDaysToMature())
            {
                //add the area freed back to current area
                currentArea+=food.getRequiredArea();
                return foods.remove(index);
            }
            return null;
        }
        return null;
    }

    /**
     * This method is called each day, it grows each food on the farm(grow method)
     */
    public void overnightGrow()
    {
        if(foods!=null)
        {
            for(Food food:foods)
            {
                food.grow(this.getFarmSoil());
            }
        }
    }

    /**
     * This method creates a String representation of the farm with farm value, harvest value, and food information if
     * any food is available
     * @return String representation of farm
     */
    public String toString()
    {
        double tValue = this.getTotalFarmValue();
        double hValue = this.getReadyToHarvestValue();
        String food = "";
        for(int i=0;i<foods.size();i++)
        {
            food+= i + " - " +foods.get(i).toString() + "\n";
        }
        //if no food available
        if(food.equals(""))
        {
            return String.format("Total farm value: %.2f\nReady to harvest value: %.2f\nNo food available",tValue,hValue);
        }
        return String.format("Total farm value: %.2f\nReady to harvest value: %.2f\nFood available: %s",tValue,hValue,food);

    }
}
