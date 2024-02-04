package CSCI2110.Assignment3;
//A player record class to represent an object that stores all the information about a player
public class PlayerRecord {
    //instance varibales for different information about a player
    private String name;
    private String pos;
    private String teamName;
    private int gameTotal;
    private int goals;
    private int assists;
    private int penaltyMin;
    private int shots;
    private int winGoals;

    //the constructor that sets all of the instance variables
    public PlayerRecord(String name, String pos, String teamName, int gTotal, int goals, int assists, int penaltyMin, int shots, int winGoals)
    {
        this.name = name;
        this.pos = pos;
        this.teamName = teamName;
        this.gameTotal = gTotal;
        this.goals = goals;
        this.assists = assists;
        this.penaltyMin = penaltyMin;
        this.shots = shots;
        this.winGoals = winGoals;
    }

    //get and set methods for each instance variable
    public String getName() {
        return name;
    }
    public String getPos() {
        return pos;
    }
    public String getTeamName() {
        return teamName;
    }
    public int getGameTotal() {
        return gameTotal;
    }
    public int getGoals() {
        return goals;
    }
    public int getAssists() {
        return assists;
    }
    public int getPenaltyMin() {
        return penaltyMin;
    }
    public int getShots() {
        return shots;
    }
    public int getWinGoals() {
        return winGoals;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setPos(String pos) {
        this.pos = pos;
    }
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
    public void setGameTotal(int gameTotal) {
        this.gameTotal = gameTotal;
    }
    public void setGoals(int goals) {
        this.goals = goals;
    }
    public void setAssists(int assists) {
        this.assists = assists;
    }
    public void setPenaltyMin(int penaltyMin) {
        this.penaltyMin = penaltyMin;
    }
    public void setShots(int shots) {
        this.shots = shots;
    }
    public void setWinGoals(int winGoals) {
        this.winGoals = winGoals;
    }

    //method to check if one playerRecord is equal to the other
    public boolean equals(PlayerRecord other)
    {
        //if player have same name and are on same team, they are equal
        return (name.equals(other.name) && teamName.equals(other.teamName));

    }
}
