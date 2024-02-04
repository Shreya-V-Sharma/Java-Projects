package Assignmet3.Foods.Foods;

import Assignmet3.Foods.Farm.Soil;

/**
 * This class represents a fruit which provides implementation of the abstract grow method from the food class
 *
 * @author Shreya Sharma - B00891805
 */
public class Fruit extends Food
{
    /*count just days since potted without incrementing the daysSincePotted variable because the growth cycle is differet
     * when the fruit is not grown in preferred soil
     */
    private int countDays = 1;

    /**
     * This is constructor for the fruit soil that uses the super constructor and initializes preffered soil to silt
     * @param name name of the fruit
     * @param price sell price of the fruit
     * @param days days it would take the fruit to mature
     * @param area the required area of the fruit
     */
    public Fruit(String name, double price, int days, int area)
    {
        super(name,price,days,area);
        preferredSoil = Soil.Silt;
    }

    /**
     * This method provides implementation of the abstract grow method from the food class, if the fruit is seeded in a
     * preferred soil then the fruit will grow normally, otherwise it will grow every 3 days, it uses the grow method from
     * the food class to grow normally
     * @param soil the soil the food is seeded in
     * @return the growth cycle(days since potted / days to mature) returns 1 if days since potted is greater than the
     * days to mature
     */
    public double grow(Soil soil)
    {
        //if seeded in preferred soil
        if(soil.equals(preferredSoil))
        {
            return grow();
        }
        //if not preferred soil but the days are multiples of 3(3,6,9,12... so every 3 days) then grow normally
        else if(countDays%3==0)
        {
            //need to increment the countDays to keep track of these abnormal growth cycle
            countDays++;
            return grow();
        }
        //if not preferred soil and if it is not those days to grow
        else
        {
            //need to increment the countDays to keep track of these abnormal growth cycle
            countDays++;
            // just return 1 if the number of days since potted is greater than days to mature
            if (this.getDaysSincePotted() >= this.getDaysToMature())
            {
                return 1.00;
            }
            //return the growth cycle without actually growing
            return (double) this.getDaysSincePotted() / this.getDaysToMature();
        }
    }
}