package CSCI2110.Assignment1;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.awt.Point;

//the main class that uses the other classes in package to test/play the game using the pieces, board and methods
public class GameDemo {

    //main method
    public static void main(String[] args)
    {
        Scanner kb = new Scanner(System.in);
        String command = "";
        Board game = new Board();

        //while the command is not exit, play the game/ ask for commands for testing
        while(!(command.equals("exit")))
        {
            System.out.println("Enter a command (type help for details): ");
            command = kb.nextLine();

            //using tokenizer, so I could take the whole command and break it up
            StringTokenizer token = new StringTokenizer(command, " ");
            String main = token.nextToken();

            //if the first word(main command) is create
            if(main.equals("create"))
            {
                //checking for if user provided all necessary information
                if(!token.hasMoreTokens())
                {
                    System.out.println("Error: need location");
                    continue;
                }



                //checking for invalid input
                String x = token.nextToken();
                Integer xpos;
                try
                {
                    xpos = Integer.valueOf(x);
                }
                catch(NumberFormatException e)
                {
                    System.out.println("Error: invalid input for location, please input integer");
                    continue;
                }

                //checking for if user provided all necessary information
                if(!token.hasMoreTokens())
                {
                    System.out.println("Error: need location");
                    continue;
                }

                //checking for invalid input
                String y = token.nextToken();
                Integer ypos;
                try
                {
                    ypos = Integer.valueOf(y);
                }
                catch(NumberFormatException e)
                {
                    System.out.println("Error: invalid input for location, please input integer");
                    continue;
                }

                Point pos = new Point(xpos, ypos);

                //asking for more information
                System.out.println("Input a name for the new piece: ");
                String name = kb.next();
                System.out.println("Input a colour for the new piece: ");
                String colour = kb.next();
                kb.nextLine();

                String type = "";
                while (token.hasMoreTokens())
                {
                    type += token.nextToken();
                }

                //creating asked piece and adding it to the board
                if (type.equals(""))
                {
                    SlowPiece slow = new SlowPiece(name, colour, pos);
                    game.Add(slow, xpos,ypos);
                }
                else if (type.equals("flexible"))
                {

                    SlowFlexible slowf = new SlowFlexible(name, colour, pos);
                    game.Add(slowf, xpos,ypos);
                }
                else if (type.equals("fast"))
                {
                    FastPiece fast = new FastPiece(name, colour, pos);
                    game.Add(fast, xpos,ypos);
                }
                else if (type.equals("fastflexible"))
                {
                    FastFlexible fastf = new FastFlexible(name, colour, pos);
                    game.Add(fastf, xpos,ypos);
                }

                //if invalid type is given
                else
                {
                    System.out.println("Error: not valid type");
                    continue;
                }

            }

            //if the main command is move
            else if(main.equals("move"))
            {
                //checking for if user provided all necessary information
                if(!token.hasMoreTokens())
                {
                    System.out.println("Error: need location, direction and steps(optional)");
                    continue;
                }

                String x = token.nextToken();
                Integer xpos;

                //checking for invalid input
                try
                {
                    xpos = Integer.valueOf(x);
                }
                catch(NumberFormatException e)
                {
                    System.out.println("Error: invalid input for location, please input integer");
                    continue;
                }

                //checking for if user provided all necessary information
                if(!token.hasMoreTokens())
                {
                    System.out.println("Error: need location, direction and steps(optional)");
                    continue;
                }

                //checking for invalid input
                String y = token.nextToken();
                Integer ypos;
                try
                {
                    ypos = Integer.valueOf(y);
                }
                catch(NumberFormatException e)
                {
                    System.out.println("Error: invalid input for location, please input integer");
                    continue;
                }

                //checking for if user provided all necessary information
                if(!token.hasMoreTokens())
                {
                    System.out.println("Error: need direction and steps(optional)");
                    continue;
                }

                String direction =  token.nextToken();

                String step = "";
                int steps = 1;
                if(token.hasMoreTokens())
                {
                    step = token.nextToken();
                    steps = Integer.parseInt(step);
                }

                //moving the piece by passing in the provided information to the move method of the board class
                game.Move(xpos,ypos,direction,steps);
            }

            //if the command is print, use display method of the board class
            else if(main.equals("print"))
            {
                game.Display();
            }

            //if the command is help, print these valid commands and their description
            else if(main.equals("help"))
            {
                System.out.println("Possible commands are as follows:");
                System.out.println("create location [fast][flexible]: Creates a new piece.");
                System.out.println("move location direction [spaces]: Moves a piece.");
                System.out.println("print: Displays the board.");
                System.out.println("help: Displays help.");
                System.out.println("exit: Exits the program.");
            }

            //if command is exit, break the loop of asking to enter new command
            else if(main.equals("exit"))
            {
                break;
            }

            //if it's not any of the valid commands
            else
            {
                System.out.println("Error: not valid command");
            }
        }
        System.out.println("Done.");
    }
}
