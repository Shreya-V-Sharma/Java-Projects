package Assignmet3.Foods.Foods;
import Assignmet3.Foods.Farm.Soil;
/**
 * This class represents a Carrot which is a subclass of vegetable
 * it is responsible for constructing a carrot object with specific information
 *
 * @author Shreya Sharma - B00891805
 */
public class Carrot extends Vegetable
{
    /**
     * constructor for Carrot that uses super constructor and passes in specific information about a Carrot
     * it also sets the default preferred soil of carrot to and using setter of the food class
     */
    public Carrot()
    {
        super("Carrot", 750.32 ,15, 100);
        setPreferredSoil(Soil.Sand);
    }
}