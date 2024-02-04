package CSCI2110.Assignment1;
import java.awt.*;

// class representing a fast flexible piece, sub-class of FastPiece, that can move n number of step left, right, up and down
public class FastFlexible extends FastPiece{

    //constructor, just uses the FastPiece constructor
    public FastFlexible(String name, String color, Point position)
    {
        super(name, color, position);
    }

    //Move method to move piece move n space(s) left, right, up and down on the board
    public void move(String direction, int n)
    {
        //if direction is up
        if(direction.equals("up") && (Position.y - n) >= 0)
        {
            this.setPosition(Position.x , Position.y - n);
            return;
        }

        //if direction is down
        else if(direction.equals("down") && (Position.y + n) < 8)
        {
            this.setPosition(Position.x , Position.y + n);
            return;
        }

        //if direction is left or right, use move method of FastPiece
        else
        {
            super.move(direction, n);
        }
    }

    //toString method to print fast flexible piece
    @Override
    public String toString()
    {
        return Name + Color + "FF";
    }

}
