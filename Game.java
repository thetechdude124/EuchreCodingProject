import java.util.HashMap;
public class Game {
    private int gameID;
    private static int gameIDGen = 0;
    private Member player1;
    private Member player2; 
    private Member player3;
    private Member player4;
    private int team1Points;
    private int team2Points;
    private boolean team1Win;
    private boolean onGoing;
    private HashMap<Integer, Round> rounds;
    private static int roundIDGen;

    // Overload constructor for ongoing and completed games

    // Ongoing games
    public Game(Member player1, Member player2, Member player3, Member player4) {
        this.gameID = gameIDGen++;
        this.player1 = player1;
        this.player2 = player2;
        this.player3 = player3;
        this.player4 = player4; 
        this.onGoing = true;
        this.rounds = new HashMap<Integer, Round>();
    }

    // Completed games
    public Game(Member player1, Member player2, Member player3, Member player4, int team1Points, int team2Points, HashMap<Integer, Round> rounds) {
        this.gameID = gameIDGen++;
        this.player1 = player1;
        this.player2 = player2;
        this.player3 = player3;
        this.player4 = player4; 
        this.team1Points = team1Points;
        this.team2Points = team2Points;
        this.team1Win = (team1Points > team2Points) ? true : false; 
        this.onGoing = false;
        this.rounds = rounds;
    }

    // Getters
    public int getGameID() {return gameID;}
    public Member getPlayer1() {return player1;}
    public Member getPlayer2() {return player2;}
    public Member getPlayer3() {return player3;}
    public Member getPlayer4() {return player4;}
    public int getteam1Points() {return team1Points;}
    public int getteam2Points() {return team2Points;}
    public boolean getteam1Win() {return team1Win;}
    public boolean getOnGoing() {return onGoing;}
    public HashMap<Integer, Round> getRounds() {return rounds;}
    public Round getRound(int roundID) {return rounds.get(roundID);}

    public void setGameID(int gameID) {this.gameID = gameID;}

    // Completed rounds
    public void addRound(boolean team1Offence, Member team1Player1, Member team1Player2, Member team2Player1, Member team2Player2, Member dealer, Member trumpEstablisher, boolean goingAlone, String trumpSuit, int team1Tricks, int team2Tricks, boolean team1Win, int pointsAwarded) {
        if (team1Offence) {rounds.put(roundIDGen, new Round(roundIDGen++, team1Player1, team1Player2, team2Player1, team2Player2, dealer, trumpEstablisher, goingAlone, trumpSuit, team1Tricks, team2Tricks, team1Win, pointsAwarded));}
        else {rounds.put(roundIDGen, new Round(roundIDGen++, team2Player1, team2Player2, team1Player1, team1Player2, dealer, trumpEstablisher, goingAlone, trumpSuit, team2Tricks, team1Tricks, !team1Win, pointsAwarded));}
        if (team1Win) {this.team1Points += pointsAwarded;}
        else {this.team2Points += pointsAwarded;}
        if (team1Points >= 10) {endGame(true);} 
        else if (team2Points >= 10) {endGame(false);}
    }

    public void endGame(boolean team1Win) {
        if (onGoing) {
            this.team1Win = team1Win;
            onGoing = false;
        }
    }

}
