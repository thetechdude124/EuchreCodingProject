package EuchreCodingProject;
import java.util.LinkedList;
public class Member {
    private String name;
    private String username; 
    private int userID;
    private int userIDGen = 0; 
    private int numGames;
    private int totalWins;
    private int totalLosses;
    private int winsOnOffence;
    private int winsOnDefence;
    private int lossesOnOffence;
    private int lossesOnDefence;
    private float winLossRate;
    private float averageScore;
    private double[] stats;
    private LinkedList<Tournament> tournaments;
    private LinkedList<Game> gamesPlayed;
    private LinkedList<Partnership> partnershipHistory;

    // Setup multiple overloaded constructors for varying amounts of data available when addMember is called

    // This constructor is for an established member
    public Member(String name, String username, int numGames, int totalWins, int totalLosses, int winsOnOffence, int winsOnDefence, int lossesOnOffence, int lossesOnDefence, float winLossRate, float averageScore, LinkedList<Tournament> tournaments, LinkedList<Game> gamesPlayed, LinkedList<Partnership> partnershipHistory) {
        this.name = name;
        this.username = username;
        this.userID = userIDGen++;
        this.numGames = numGames;
        this.totalWins = totalWins;
        this.totalLosses = totalLosses;
        this.winsOnOffence = winsOnOffence;
        this.winsOnDefence = winsOnDefence;
        this.lossesOnOffence = lossesOnOffence; 
        this.lossesOnDefence = lossesOnDefence;
        this.winLossRate = winLossRate;
        this.averageScore = averageScore;
        this.stats = new double[] {numGames, totalWins, totalLosses, winsOnOffence, winsOnDefence, lossesOnOffence, lossesOnDefence, winLossRate, averageScore}; 
        this.tournaments = tournaments;
        this.gamesPlayed = gamesPlayed;
        this.partnershipHistory = partnershipHistory;
    }

    // This constructor is for a brand new member
    public Member(String name, String username) {
        this.name = name;
        this.username = username;
        this.userID = userIDGen++;
        this.numGames = 0;                  //index0
        this.totalWins = 0;                 //index1
        this.totalLosses = 0;               //index2
        this.winsOnOffence = 0;             //index3
        this.winsOnDefence = 0;             //index4
        this.lossesOnOffence = 0;           //index5
        this.lossesOnDefence = 0;           //index6
        this.winLossRate = 0;               //index7
        this.averageScore = 0;              //index8
        this.stats = new double[] {numGames, totalWins, totalLosses, winsOnOffence, winsOnDefence, lossesOnOffence, lossesOnDefence, winLossRate, averageScore}; 
        this.tournaments = new LinkedList<Tournament>();
        this.gamesPlayed = new LinkedList<Game>();
        this.partnershipHistory = new LinkedList<Partnership>();
    }

    // Getters
    public String getName() {return name;}
    public String getUsername() {return username;}
    public int getUserID() {return userID;}
    public int getNumGames() {return numGames;}
    public int getTotalWins() {return totalWins;}
    public int getTotalLosses() {return totalLosses;}
    public int getWinsOnOffence() {return winsOnOffence;}
    public int getWinsOnDefence() {return winsOnDefence;}
    public int getLossesOnOffence() {return lossesOnOffence;}
    public int getLossesOnDefence() {return lossesOnDefence;}
    public float getWinLossRate() {return winLossRate;}
    public float getAverageScore() {return averageScore;}
    public double[] getStats() {return stats;}
    public LinkedList<Tournament> getTournaments() {return tournaments;}
    public LinkedList<Game> getGamesPlayed() {return gamesPlayed;}
    public LinkedList<Partnership> getPartnershipHistory() {return partnershipHistory;}

    // Setters
    public void setName(String name) {this.name = name;}
    public void setUsername(String username) {this.username = username;}
    
    // Methods
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
        stats = new double[]{numGames, totalWins, totalLosses, winsOnOffence, winsOnDefence, lossesOnOffence, lossesOnDefence, winLossRate, averageScore};
    } 
    public void newTournament(Tournament tournament) {tournaments.add(tournament);}
    public void newPartnership(Partnership partnership) {partnershipHistory.add(partnership);}

}
