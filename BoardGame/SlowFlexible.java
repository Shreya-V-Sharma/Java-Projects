package CSCI2110.Assignment1;
import java.awt.*;

// class representing a slow flexible piece, sub-class of SlowPiece, that can move 1 space left, right, up and down
public class SlowFlexible extends SlowPiece {

    //constructor, just uses the SlowPiece constructor
    public SlowFlexible(String name, String color, Point position)
    {
        super(name, color, position);
    }

    //Move method to move piece move 1 space left, right, up and down on the board
    public void move(String direction)
    {
        //if direction is up
        if(direction.equals("up") && (Position.y - 1) >= 0)
        {
            this.setPosition(Position.x , Position.y - 1);
        }

        //if direction is down
        else if(direction.equals("down") && (Position.y + 1) < 8)
        {
            this.setPosition(Position.x , Position.y + 1);
        }

        //if direction is left or right, use move method of SlowPiece
        else{
            super.move(direction);
        }

    }

    //toString method to print slow flexible piece
    @Override
    public String toString()
    {
        return Name + Color + "SF";
    }

}
