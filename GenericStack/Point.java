package CSCI2110.Lab2;
//this class represents point class that is generic
public class Point<T> {

    //instance variables x and y of the point
    private T xpos, ypos;

    //constructor for point
    public Point(T x, T y)
    {
        xpos = x;
        ypos = y;
    }

    //get and set methods
    public T getXpos()
    {
        return xpos;
    }
    public T getYpos()
    {
        return ypos;
    }
    public void setXpos(T x)
    {
        xpos = x;
    }
    public void setYpos(T y)
    {
        ypos = y;
    }

    //toString method
    public String toString()
    {
        return "XPOS: "+xpos +" YPOS: "+ ypos;
    }

}
