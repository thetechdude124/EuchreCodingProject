import java.util.LinkedList;
public class Member {
    private String name;
    private String username; 
    private int userID;
    private static int userIDGen = 0; 
    private int numGames;
    private int gameWins;
    private int gameLosses;
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
    public Member(String name, String username, int numGames, int gameWins, int gameLosses, int winsOnOffence, int winsOnDefence, int lossesOnOffence, int lossesOnDefence, float winLossRate, float averageScore, LinkedList<Tournament> tournaments, LinkedList<Game> gamesPlayed, LinkedList<Partnership> partnershipHistory) {
        this.name = name;
        this.username = username;
        this.userID = userIDGen++;
        this.numGames = numGames;                       //index0
        this.gameWins = gameWins;                       //index1
        this.gameLosses = gameLosses;                   //index2
        this.winsOnOffence = winsOnOffence;             //index3
        this.winsOnDefence = winsOnDefence;             //index4
        this.lossesOnOffence = lossesOnOffence;         //index5
        this.lossesOnDefence = lossesOnDefence;         //index6
        this.winLossRate = winLossRate;                 //index7
        this.averageScore = averageScore;               //index8
        this.stats = new double[] {numGames, gameWins, gameLosses, winsOnOffence, winsOnDefence, lossesOnOffence, lossesOnDefence, winLossRate, averageScore}; 
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
        this.gameWins = 0;                  //index1
        this.gameLosses = 0;                //index2
        this.winsOnOffence = 0;             //index3
        this.winsOnDefence = 0;             //index4
        this.lossesOnOffence = 0;           //index5
        this.lossesOnDefence = 0;           //index6
        this.winLossRate = 0;               //index7
        this.averageScore = 0;              //index8
        this.stats = new double[] {numGames, gameWins, gameLosses, winsOnOffence, winsOnDefence, lossesOnOffence, lossesOnDefence, winLossRate, averageScore}; 
        this.tournaments = new LinkedList<Tournament>();
        this.gamesPlayed = new LinkedList<Game>();
        this.partnershipHistory = new LinkedList<Partnership>();
    }

    // Getters
    public String getName() {return name;}
    public String getUsername() {return username;}
    public int getUserID() {return userID;}
    public int getNumGames() {return numGames;}
    public int getGameWins() {return gameWins;}
    public int getGameLosses() {return gameLosses;}
    public int getWinsOnOffence() {return winsOnOffence;}
    public int getWinsOnDefence() {return winsOnDefence;}
    public int getLossesOnOffence() {return lossesOnOffence;}
    public int getLossesOnDefence() {return lossesOnDefence;}
    public float getWinLossRate() {return winLossRate;}
    public float getAverageScore() {return averageScore;}
    public double[] getStats() {stats = new double[] {numGames, gameWins, gameLosses, winsOnOffence, winsOnDefence, lossesOnOffence, lossesOnDefence, winLossRate, averageScore}; return stats;}
    public LinkedList<Tournament> getTournaments() {return tournaments;}
    public LinkedList<Game> getGamesPlayed() {return gamesPlayed;}
    public LinkedList<Partnership> getPartnershipHistory() {return partnershipHistory;}

    // Setters
    public void setName(String name) {this.name = name;}
    public void setUsername(String username) {this.username = username;}
    public void incrNumGames() {numGames++;}
    public void incrGameWins() {gameWins++;}
    public void incrGameLosses() {gameLosses++;}
    public void incrWinsOnOffence() {winsOnOffence++;}
    public void incrWinsOnDefence() {winsOnDefence++;}
    public void incrLossesOnOffence() {lossesOnOffence++;}
    public void incrLossesOnDefence() {lossesOnDefence++;}
    
    // Methods
    public void newGame(Game game, boolean win, int score) {
        gamesPlayed.add(game);
        numGames++;
        if (win) {gameWins++;} 
        else {gameLosses++;}
        winLossRate = gameWins / numGames; 
        averageScore = (averageScore*(numGames-1) + score)/numGames;
        stats = new double[]{numGames, gameWins, gameLosses, winsOnOffence, winsOnDefence, lossesOnOffence, lossesOnDefence, winLossRate, averageScore};
    } 
    public void newTournament(Tournament tournament) {tournaments.add(tournament);}
    public void newPartnership(Partnership partnership) {partnershipHistory.add(partnership);}

}
