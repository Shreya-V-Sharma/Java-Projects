package Assignmet3.Foods.Foods;
import Assignmet3.Foods.Farm.Soil;
/**
 * This class represents a Cabbage which is a subclass of vegetable
 * it is responsible for constructing a cabbage object with specific information
 *
 * @author Shreya Sharma - B00891805
 */
public class Cabbage extends Vegetable
{
    /**
     * constructor for cabbage that uses super constructor and passes in specific information about a cabbage
     * it also sets the default preferred soil of cabbage to Clay using setter of the food class
     */
    public Cabbage()
    {
        super("Cabbage", 239.75 ,10, 50);
        setPreferredSoil(Soil.Clay);
    }
}