package CSCI2110.Assignment3;

import CSCI2110.Assignment3.ExpenseListApplicationExample.Expense;
//a class to represent a whole record that contains student records which then is used to find statistics such as player with most number of points
public class NHLStats {

    //instance variable to represent list of player records
    private List<PlayerRecord> list;

    //constructor
    public NHLStats()
    {
        list = new List<PlayerRecord>();
    }
    //add to the list
    public void add(PlayerRecord p)
    {
        list.add(p);
    }
    //return true if list is empty, false otherwise
    public boolean isEmpty()
    {
        return list.isEmpty();
    }
    //checks if playerecord p is contained in the list
    public boolean contains(PlayerRecord p)
    {
        return list.contains(p);
    }
    //returns the first player record
    public PlayerRecord first()
    {
        return list.first();
    }
    //returns the next player record
    public PlayerRecord next()
    {
        return list.next();
    }
    //prints whole list
    public void enumerate()
    {
        list.enumerate();
    }

    // method that finds and returns player name and team name for the player with the highest points(goals+assists)
    public String mostPoints()
    {

        int maxPoint =0;
        int point = 0;
        PlayerRecord mostPoint;
        //current player record p
        PlayerRecord p = list.first();
        String output = "";

        //loop that goes through all the records
        while (p!=null)
        {
            point = p.getGoals() + p.getAssists();

            //if points for the current player is greater than maxpoints
            if (point>maxPoint) {

                maxPoint = point;
                mostPoint = p;

                //make output equal to that player's info
                output = mostPoint.getName() + " " + mostPoint.getTeamName();
            }

            //if it's same as the maxpoints
            else if(point==maxPoint)
            {
                mostPoint = p;

                //add that players info to output
                output+= "\n" + mostPoint.getName() + " " + mostPoint.getTeamName();
            }

            //next playerrecord
            p = list.next();
        }
        return output;
    }

    // method that finds and returns player name,team name and position for the most aggressive player (one with the highest penalty minutes)
    public String mostAggressive()
    {
        int minutes =0;
        int maxMin = 0;
        PlayerRecord mostAggr;
        //current player record p
        PlayerRecord p = list.first();
        String output = "";

        //loop that goes through all the records
        while (p!=null)
        {
            minutes = p.getPenaltyMin();

            //if this player's minutes are higher than max minutes
            if (minutes>maxMin) {
                maxMin = minutes;
                mostAggr = p;

                //make output equal to this player's info
                output = mostAggr.getName() + " " + mostAggr.getTeamName() + " " + mostAggr.getPos();
            }
            //if same
            else if(minutes==maxMin)
            {
                mostAggr = p;
                //add this player's info to output
                output+= "\n" + mostAggr.getName() + " " + mostAggr.getTeamName() + " " + mostAggr.getPos();
            }
            //next playerrecord
            p = list.next();
        }
        return output;
    }

    //method to find most valuable player(most winning points) and returns info about that player
    //similar steps/method as 2 above methods
    public String mvp()
    {

        int maxWinGoals =0;
        int winGoals = 0;
        PlayerRecord mvp;
        PlayerRecord p = list.first();
        String output = "";
        while (p!=null)
        {
            winGoals = p.getWinGoals();
            if (winGoals>maxWinGoals) {
                maxWinGoals = winGoals;
                mvp = p;
                output = mvp.getName() + " " + mvp.getTeamName();
            }
            else if(winGoals==maxWinGoals)
            {
                mvp = p;
                output+= "\n" + mvp.getName() + " " + mvp.getTeamName();
            }
            p = list.next();
        }
        return output;
    }

    //method to find most promising player(have the highest number of shots) and return info about that player
    //similar steps/method mostAggressive() and mostPoints() methods
    public String mostPromising()
    {

        int maxShots =0;
        int shots = 0;
        PlayerRecord mostPromising;
        PlayerRecord p = list.first();
        String output = "";
        while (p!=null)
        {
            shots = p.getShots();
            if (shots>maxShots) {
                maxShots = shots;
                mostPromising = p;
                output = mostPromising.getName() + " " + mostPromising.getTeamName();
            }
            else if(shots==maxShots)
            {
                mostPromising = p;
                output+= "\n" + mostPromising.getName() + " " + mostPromising.getTeamName();
            }
            p = list.next();
        }
        return output;
    }

    //method to organize all players depending on their team, I use this method in finding the most aggressive team and team with highest winning goals
    private List<List<PlayerRecord>> teamList()
    {
        //a list(teams list) of list(team) of Player records
        List<List<PlayerRecord>> teams = new List<List<PlayerRecord>>();

        //iterating through all the player records
        PlayerRecord p = list.first();
        while (p!=null)
        {
            //iterating through all the teams
            List<PlayerRecord> team = teams.first();
            boolean teamfound = false;
            while(team!=null)
            {
                //if we find the team that this player belongs to
                String teamName = team.first().getTeamName();
                if(p.getTeamName().equals(teamName))
                {
                    //add that player record to this team and break team loop
                    team.add(p);
                    teamfound = true;
                    break;
                }
                team = teams.next();
            }
            //if after going through the teams loop, we didn't find the team
            if(!teamfound)
            {
                //make a new team, add the player, and
                List<PlayerRecord> newTeam = new List<PlayerRecord>();
                newTeam.add(p);
                teams.add(newTeam);
            }
            p = list.next();
        }

        return teams;
    }

    //method to find the most aggressive team(sum of all team's players' penaltypoints is highest)
    public String aggressiveTeam()
    {
        //using teamList method
        List<List<PlayerRecord>> teams = teamList();
        String output = "";

        //iterating through all the teams
        List<PlayerRecord> team = teams.first();
        int sum = 0;
        int maxSum = 0;
        while(team!=null)
        {
            //iterating through all player records
            PlayerRecord player = team.first();
            sum=0;
            //summing all penalty minutes for a team
            while(player!=null)
            {
                sum+=player.getPenaltyMin();
                player = team.next();
            }
            //if that sum is greater than maxsum
            if(sum>maxSum)
            {
                maxSum= sum;
                //make output equal to this team's info
                output = team.first().getTeamName();
            }
            //if it's equal
            else if (sum==maxSum)
            {
                //add the info of this team to output
                output +=  "\n" + team.first().getTeamName();
            }
            team = teams.next();
        }
        return output;
    }

    //method to find the team with most winning goals(sum of all team's players' winning goals is highest)
    //similar steps/method as previous method
    public String winningTeam()
    {
        List<List<PlayerRecord>> teams = teamList();
        String output = "";

        List<PlayerRecord> team = teams.first();
        int sum = 0;
        int maxSum = 0;
        while(team!=null)
        {
            PlayerRecord player = team.first();
            sum=0;
            while(player!=null)
            {
                sum+=player.getWinGoals();
                player = team.next();
            }
            if(sum>maxSum)
            {
                maxSum= sum;
                output = team.first().getTeamName();
            }
            else if (sum==maxSum)
            {
                output += "\n" + team.first().getTeamName();
            }
            team = teams.next();
        }
        return output;
    }


}

