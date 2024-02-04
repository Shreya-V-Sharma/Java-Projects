package Assignmet3.Foods.Foods;

import Assignmet3.Foods.Farm.Soil;

/**
 * This class represents an apple which is a subclass of fruit
 * it is responsible for constructing an apple object with specific information
 *
 * @author Shreya Sharma- B00891805
 */
public class Apple extends Fruit
{
    /**
     * constructor for apple that uses super constructor and passes in specific information about an apple
     * it also sets the default preferred soil of apples to loam using setter of the food class
     */
    public Apple()
    {
        super("Apple", 1250.00 ,15, 275);
        setPreferredSoil(Soil.Loam);
    }
}
