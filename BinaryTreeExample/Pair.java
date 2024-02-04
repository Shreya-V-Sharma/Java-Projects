package CSCI2110.Assignment5;

//pair class to represent information about one letter, the letter and it's probability
//from Step 2 of assignment document
public class Pair implements Comparable<Pair>
{
    // declare all required fields
    private char value;
    private double prob;

    //constructor
    public Pair(char c, double p)
    {
        value = c;
        prob = p;
    }
    //getters
    public char getValue()
    {
        return value;
    }

    public double getProb()
    {
        return prob;
    }

    //setters
    public void setProb(double prob)
    {
        this.prob = prob;
    }

    public void setValue(char value)
    {
        this.value = value;
    }

    //toString
    @Override
    public String toString() {
        return "Character: " + value + ", probability: " + prob;
    }

    /**
     The compareTo method overrides the compareTo method of the
     Comparable interface.
     */
    @Override
    public int compareTo(Pair p)
    {
        return Double.compare(this.getProb(), p.getProb());
    }
}
