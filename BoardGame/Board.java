package CSCI2110.Assignment1;

//This class represents the board of the game which is 8 by 8, where the user can put piece objects
public class Board {

    public Piece[][] board;

    //constructor that creates 8 by 8 board(2D array of length and width equal to 8)
    public Board()
    {
        board = new Piece[8][8];
    }

    //add method to add a piece to the board if no other piece exixts at that location
    public void Add(Piece p, int x , int y)
    {
        if(board[y][x]==null)
        {
            board[y][x] = p;
        }
        else
        {
            System.out.println("A piece already exists at this position. Can't add this piece here.");
        }
    }

    //move method to move the pieces around on the board
    public void Move(int x, int y, String direction, int step)
    {
        //if the piece exists at that location
        if(board[y][x] != null)
        {
            int prevX = board[y][x].Position.x;
            int prevY = board[y][x].Position.y;

            //use move method according to the type of the piece
            if(board[y][x] instanceof SlowPiece)
            {
                ((SlowPiece) board[y][x]).move(direction);
            }
            else if(board[y][x] instanceof FastPiece)
            {
                ((FastPiece) board[y][x]).move(direction,step);
            }
            else if(board[y][x] instanceof SlowFlexible)
            {
                ((SlowFlexible) board[y][x]).move(direction);
            }
            else if(board[y][x] instanceof FastFlexible)
            {
                ((FastFlexible) board[y][x]).move(direction,step);
            }

            //if the move method didn't move the piece(when piece would move out of the board if moved)
            if(board[y][x].Position.x==prevX && board[y][x].Position.y == prevY)
            {
                System.out.println("The piece at [" + x + "," + y + "] cannot be moved.");
                return;
            }

            //change the location of the piece on the board(2D array)
            board[board[y][x].Position.y][board[y][x].Position.x] = board[y][x];
            board[y][x] = null;

            System.out.println("Piece at ("+ x +","+ y +") moved " + direction +" by "+ step +" spaces");
        }
        //when no piece exists at that position
        else
        {
            System.out.println("Error: no piece at (" + x + "," + y + ")");
        }
    }

    //method to display/print the board
    public void Display()
    {
        //for every element in the 2D arraylist, if a piece has been added, then print the piece, otherwise, print dash(-)
        // using String.format to make the output look like a board (just like the example in the lab document)
        for(int i = 0; i < 8; i++)
        {
            for(int j = 0; j < 8; j++)
            {
                if(board[i][j] == null)
                {

                    System.out.print(String.format("%-11s", "-"));
                }
                else
                {
                    System.out.print(String.format("%-11s", board[i][j]));
                }
            }
            System.out.println();
        }
    }

}
