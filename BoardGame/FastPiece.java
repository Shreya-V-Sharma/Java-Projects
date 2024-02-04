package CSCI2110.Assignment1;
import java.awt.*;

// class representing a fast piece, sub-class of Piece, that can move n number of steps left and right
public class FastPiece extends Piece{

    //constructor, just uses the piece constructor
    public FastPiece(String name, String color, Point position)
    {
        super(name, color, position);
    }

    ////move method to move piece on the game board - left and right by n space(s)
    public void move(String direction, int n)
    {
        //if the direction provided is left and the piece stays inside the board after moving
        if(direction.equals("left") && (Position.x - n) >=0)
        {
            this.setPosition(Position.x -n, Position.y);
        }

        //if direction is right
        else if(direction.equals("right") && (Position.x + n) <8)
        {
            this.setPosition(Position.x +n, Position.y);
        }
    }

    //toString method to print the fastPiece
    @Override
    public String toString()
    {
        return Name + Color + "F";
    }
}
