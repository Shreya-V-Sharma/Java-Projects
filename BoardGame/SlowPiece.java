package CSCI2110.Assignment1;
import java.awt.*;

// class representing a slow piece, sub-class of Piece, that can move 1 space left and right
public class SlowPiece extends Piece{

    //constructor, just uses the piece constructor
    public SlowPiece(String name, String color, Point position)
    {
        super(name, color, position);
    }

    //move method to move piece on the game board - left and right by 1 space
    public void move(String direction)
    {
        //if the direction provided is left and the piece stays inside the board after moving
        if(direction.equals("left") && (Position.x - 1) >=0)
        {
            this.setPosition(Position.x -1, Position.y);
        }

        //if direction is right
        else if(direction.equals("right") && (Position.x + 1) <8)
        {
            this.setPosition(Position.x +1, Position.y);
        }
    }

    //toString method to print the slowPiece
    @Override
    public String toString()
    {
        return Name + Color + "S";
    }
}
