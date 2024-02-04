package CSCI2110.Assignment3;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.util.StringTokenizer;

//demo class that use PlayerRecord and NHLStats
public class NHLListDemo {
    public static void main(String[] args) throws IOException
    {
        //take in file name, from which we will read player records, make a file
        Scanner kb = new Scanner(System.in);
        System.out.print("Enter the filename to read from: ");
        String filename = kb.nextLine();
        File file = new File(filename);
        Scanner inputFile = new Scanner(file);

        StringTokenizer token;
        NHLStats playerList = new NHLStats();

        //take each line of input from the file,use tokenizer, make player record and add them to the unordered list
        while(inputFile.hasNext())
        {
            String playerInfo = inputFile.nextLine();
            token = new StringTokenizer(playerInfo, "\t");

            playerList.add(new PlayerRecord(token.nextToken(),token.nextToken(),token.nextToken(),Integer.parseInt(token.nextToken()),Integer.parseInt(token.nextToken()),Integer.parseInt(token.nextToken()),Integer.parseInt(token.nextToken()),Integer.parseInt(token.nextToken()),Integer.parseInt(token.nextToken())));
        }
        inputFile.close();

        //print all the outcomes of different methods from NHLStats class
        System.out.println("NHL Results Summary\n");

        System.out.println("Players with highest points and their teams:");
        System.out.println(playerList.mostPoints() + "\n");

        System.out.println("Most aggressive players, their teams and their positions:");
        System.out.println(playerList.mostAggressive()+ "\n");

        System.out.println("Most valuable players and their teams:");
        System.out.println(playerList.mvp()+ "\n");

        System.out.println("Most promising players and their teams:");
        System.out.println(playerList.mostPromising()+ "\n");

        System.out.println("Teams that had the most number of penalty minutes:");
        System.out.println(playerList.aggressiveTeam()+ "\n");

        System.out.println("Teams that had the most number of game winning goals:");
        System.out.println(playerList.winningTeam()+ "\n");
    }
}
