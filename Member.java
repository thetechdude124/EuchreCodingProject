package EuchreCodingProject;

import java.util.ArrayList;
public class Member {
    private String name;
    private String username; 
    private long userID;
    private int numGames;
    private int totalWins;
    private int totalLosses;
    private int winsOnOffence;
    private int winsOnDefence;
    private int lossesOnOffence;
    private int lossesOnDefence;
    private float winLossRate;
    private float averageScore;
    private ArrayList<Tournament> tournaments;
    private ArrayList<Game> gamesPlayed;
    private ArrayList<Partnership> partnershipHistory;

    // Setup multiple overloaded constructors for varying amounts of data available when addMember is called

    // This constructor is for an established member
    public Member(String name, String username, long userID, int numGames, int totalWins, int totalLosses, int winsOnOffence, int winsOnDefence, int lossesOnOffence, int lossesOnDefence, float winLossRate, float averageScore, ArrayList<Tournament> tournaments, ArrayList<Game> gamesPlayed, ArrayList<Partnership> partnershipHistory) {
        this.name = name;
        this.username = username;
        this.userID = userID;
        this.numGames = numGames;
        this.totalWins = totalWins;
        this.totalLosses = totalLosses;
        this.winsOnOffence = winsOnOffence;
        this.winsOnDefence = winsOnDefence;
        this.lossesOnOffence = lossesOnOffence; 
        this.lossesOnDefence = lossesOnDefence;
        this.winLossRate = winLossRate;
        this.averageScore = averageScore; 
        this.tournaments = tournaments;
        this.gamesPlayed = gamesPlayed;
        this.partnershipHistory = partnershipHistory;
    }
}
