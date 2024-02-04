package CSCI2110.Assignment1;
import java.awt.*;

//A class to represent piece of the game with name, color and position on the game board
public class Piece {

    protected String Name;
    protected String Color;
    protected Point Position;

    // Constructor
    public Piece(String name, String color, Point position)
    {
        Name = name;
        Color = color;
        Position = position;
    }


    //get and set methods
    public String getName()
    {
        return Name;
    }
    public String getColor()
    {
        return Color;
    }
    public Point getPosition()
    {
        return Position;
    }
    public void setName(String name)
    {
        Name = name;
    }
    public void setColor(String color)
    {
        Color = color;
    }
    public void setPosition(int x, int y)
    {
        Position.x = x;
        Position.y = y;
    }

    //toString method
    public String toString()
    {
        return Name + Color;
    }
}
