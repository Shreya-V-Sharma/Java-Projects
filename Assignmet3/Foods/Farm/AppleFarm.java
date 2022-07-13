package Assignmet3.Foods.Farm;
import Assignmet3.Foods.Foods.Food;
import Assignmet3.Foods.Foods.Apple;
/**
 * This class represents an apple farm and has the seedFood method so only apples can be seeded
 * in the apple farm
 *
 * @author Shreya Sharma - B00891805
 */
public class AppleFarm extends Farm
{
    /**
     * This is a constructor for the apple farm which users the constructor of the super class farm by passing in area
     * and preferred soil of apples which is Loam.
     * @param area the required area of apple
     */
    public AppleFarm(int area)
    {
        super(area,Soil.Loam);
    }

    /**
     * This method seed the food if it is apple and returns true, if the food is not apple returns false
     * @param food the food to be seeded
     * @return true if the food was apple and was seeded, or else returns false
     */
    public boolean seedFood(Food food)
    {
        //if not apple
        if(!(food instanceof Apple))
        {
            return false;
        }
        //if apple
        super.seedFood(food);
        return true;
    }
}
