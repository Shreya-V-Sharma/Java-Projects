package Assignmet3.Foods.Farmer;
import Assignmet3.Foods.Farm.Farm;
import Assignmet3.Foods.Foods.Food;
import Assignmet3.Foods.Foods.Vegetable;
import Assignmet3.Foods.Foods.Fruit;
/**
 * This class represents a farmer with a name, energy and farm
 *
 * @author Shreya Sharma - B00891805
 */
public class Farmer
{
    private String name;
    private int energy;
    private Farm farm;

    /**
     * This is a constructor to make a farmer object by assigning a name and initializing the energy to 100
     * @param name the name of the farmer
     */
    public Farmer(String name)
    {
        this.name = name;
        energy=100;
    }

    /**
     * This is another constuctor to make a farmer which also assigns a farm to the farmer
     * @param name the name of the farmer
     * @param farm the farm of the farmer
     */
    public Farmer(String name, Farm farm)
    {
        this(name);
        this.farm = farm;
    }

    /**
     * This method gets food from the farmer's farm by using the getFood method from the farm class
     * @param index the index used to get the food
     * @return returns food at that index from the farm
     */
    public Food getFoodFromFarm(int index)
    {
        return farm.getFood(index);
    }

    /**
     * This method gets the name of the farmer
     * @return return name of the farmer
     */
    public String getName()
    {
        return name;
    }

    /**
     * This method gets the energy of the farmer
     * @return the energy of the farmer
     */
    public int getEnergy()
    {
        return energy;
    }

    /**
     * This method is called every night and it increases the energy of the farmer by 35 and also grows every
     * it uses the overnightGrow method from the Farm class
     */
    public void sleep()
    {
        //if the energy + 35 would be 100 at max
        if (energy + 35 <= 100) {
            energy += 35;
        }
        //if farmer has a farm
        if(farm!=null)
        {
            farm.overnightGrow();
        }
    }

    /**
     * This method seeds a food if the farmer has a farm,has enough energy(depending on if it's a fruit or a vegetable)
     * to seed it, and farm has space for the food, it uses the seedFood method of the farm class
     * @param food the food to be seeded
     * @return true if the food was seeded, false otherwise
     */
    public boolean seedFood(Food food)
    {
        //if farmer has a farm
        if(farm!=null)
        {
            //if vegetable and energy is greater than 30
            if(food instanceof Vegetable && energy>=30)
            {
                //if the farm has space
                if(farm.getCurrentArea()-food.getRequiredArea()>=0)
                {
                    farm.seedFood(food);
                    energy-=30;
                    return true;
                }
                return false;
            }
            //if vegetable and energy is greater than 50
            if(food instanceof Fruit && energy>=50)
            {
                //if the farm has space
                if(farm.getCurrentArea()-food.getRequiredArea()>=0)
                {
                    farm.seedFood(food);
                    energy-=50;
                    return true;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    /**
     * This method adds a farm to a farmer(buys) if the farmer doesn't have a farm
     * @param farm the farm for farmer to buy
     * @return true if the farm was bought(added), and false otherwise
     */
    public boolean buyFarm(Farm farm)
    {
        //if no farm
        if(this.farm==null)
        {
            this.farm = farm;
            return true;
        }
        return false;
    }

    /**
     * This method returns a String representation of the farmer, it includes the name, energy and farm info it
     * the farmer has a farm
     * @return a string representing a farmer
     */
    public String toString()
    {
        String str = "";
        str+="Farmer: " + name + "\n";
        str+="Energy left: " + energy + "/100" + "\n";

        //if farmer doesn't have a farm
        if(farm==null)
        {
            str+= name + " owns no farm";
        }
        //if farmer has a farm
        else
        {
            str+= "Farm info:\n";
            str+=farm.toString();
        }
        return str;
    }
}
