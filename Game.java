import java.util.HashMap;
public class Game {
    private int gameID;
    private static int gameIDGen = 0;
    private Member player1;
    private Member player2; 
    private Member player3;
    private Member player4;
    private int p1p2Points;
    private int p3p4Points;
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
    public Game(Member player1, Member player2, Member player3, Member player4, int p1p2Points, int p3p4Points, HashMap<Integer, Round> rounds) {
        this.gameID = gameIDGen++;
        this.player1 = player1;
        this.player2 = player2;
        this.player3 = player3;
        this.player4 = player4; 
        this.p1p2Points = p1p2Points;
        this.p3p4Points = p3p4Points;
        this.onGoing = false;
        this.rounds = rounds;
    }

    // Getters
    public int getGameID() {return gameID;}
    public Member getPlayer1() {return player1;}
    public Member getPlayer2() {return player2;}
    public Member getPlayer3() {return player3;}
    public Member getPlayer4() {return player4;}
    public int getp1p2Points() {return p1p2Points;}
    public int getp3p4Points() {return p3p4Points;}
    public boolean getOnGoing() {return onGoing;}
    public HashMap<Integer, Round> getRounds() {return rounds;}

    public void setGameID(int gameID) {this.gameID = gameID;}

    // Overload addRound for on going and completed rounds

    // Ongoing rounds
    public void addRound(Member p1p2Player1, Member p1p2Player2, Member p3p4Player1, Member p3p4Player2, Member dealer) {
        rounds.put(roundIDGen, new Round(roundIDGen++,p1p2Player1, p1p2Player2, p3p4Player1, p3p4Player2, dealer));
    }

    public void endRound(int roundID) {
        if (rounds.get(roundID).getOnGoing()) {}
    }

    // Completed rounds
    public void addRound(Member p1p2Player1, Member p1p2Player2, Member p3p4Player1, Member p3p4Player2, Member dealer, Member trumpEstablisher, boolean goingAlone, String trumpSuit, int p1p2Tricks, int p3p4Tricks, boolean p1p2Win, int pointsAwarded) {
        rounds.put(roundIDGen, new Round(roundIDGen++, p1p2Player1, p1p2Player2, p3p4Player1, p3p4Player2, dealer, trumpEstablisher, goingAlone, trumpSuit, p1p2Tricks, p3p4Tricks, p1p2Win, pointsAwarded));
        if (p1p2Points >= 10 || p3p4Points >= 10) {endGame();}
    }

    public void endGame() {
        if (onGoing) {}
    }

}
