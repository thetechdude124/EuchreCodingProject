package EuchreCodingProject;
import java.util.ArrayList;
public class Member {
    private String name;
    private String username; 
    private long userID;
    private long userIDGen = 1000000; 
    private int numGames;
    private int totalWins;
    private int totalLosses;
    private int winsOnOffence;
    private int winsOnDefence;
    private int lossesOnOffence;
    private int lossesOnDefence;
    private float winLossRate;
    private float averageScore;
    private LinkedList<Tournament> tournaments;
    private LinkedList<Game> gamesPlayed;
    private LinkedList<Partnership> partnershipHistory;

    // Setup multiple overloaded constructors for varying amounts of data available when addMember is called

    // This constructor is for an established member
    public Member(String name, String username, long userID, int numGames, int totalWins, int totalLosses, int winsOnOffence, int winsOnDefence, int lossesOnOffence, int lossesOnDefence, float winLossRate, float averageScore, LinkedList<Tournament> tournaments, LinkedList<Game> gamesPlayed, LinkedList<Partnership> partnershipHistory) {
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

    // This constructor is for a brand new member
    public Member(String name, String username) {
        this.name = name;
        this.username = username;
        this.userID = userIDGen;
        userIDGen++;
        this.numGames = 0;
        this.totalWins = 0;
        this.totalLosses = 0;
        this.winsOnOffence = 0;
        this.winsOnDefence = 0;
        this.lossesOnOffence = 0; 
        this.lossesOnDefence = 0;
        this.winLossRate = 0;
        this.averageScore = 0; 
        this.tournaments = new LinkedList<Tournament>();
        this.gamesPlayed = new LinkedList<Game>();
        this.partnershipHistory = new LinkedList<Partnership>();
    }

    public String getName() {return name;}
    public String getUsername() {return username;}
    public long getUserID() {return userID;}
    public int getNumGames() {return numGames;}
    public int getTotalWins() {return totalWins;}
    public int getTotalLosses() {return totalLosses;}
    public int getWinsOnOffence() {return winsOnOffence;}
    public int getWinsOnDefence() {return winsOnDefence;}
    public int getLossesOnOffence() {return lossesOnOffence;}
    public int getLossesOnDefence() {return lossesOnDefence;}
    public float getWinLossRate() {return winLossRate;}
    public float getAverageScore() {return averageScore;}
    public LinkedList<Tournament> getTournaments() {return tournaments;}
    public LinkedList<Game> getGamesPlayed() {return gamesPlayed;}
    public LinkedList<Partnership> getPartnershipHistory() {return partnershipHistory;}

    public void setName(String name) {this.name = name;}
    public void setUsername(String username) {this.username = username;}
    public void newGame(Game game, boolean win, boolean offence, int score) {
        gamesPlayed.add(game);
        numGames++;
        if (win) {
            totalWins++;
            if (win) {winsOnOffence++;} else {winsOnDefence++;}
        } else {
            totalLosses++;
            if (offence) {lossesOnOffence++;} else {lossesOnDefence++;}
        }
        winLossRate = totalWins / numGames; 
        averageScore = (averageScore*(numGames-1) + score)/numGames;
    } 
    public void newTournament(Tournament tournament) {tournaments.add(tournament);}
    public void newPartnership(Partnership partnership) {partnershipHistory.add(partnership);}

}
