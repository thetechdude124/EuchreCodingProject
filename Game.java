package EuchreCodingProject;
import java.util.LinkedList;
public class Game {
    private Member player1;
    private Member player2; 
    private Member player3;
    private Member player4;
    private int offencePoints;
    private int defencePoints;
    private boolean onGoing;
    private LinkedList<Round> rounds;

    // Overload constructor for ongoing and completed games

    // Ongoing games
    public Game(Member player1, Member player2, Member player3, Member player4) {
        this.player1 = player1;
        this.player2 = player2;
        this.player3 = player3;
        this.player4 = player4; 
        this.onGoing = true;
        this.rounds = new LinkedList<Round>();
    }

    // Completed games
    public Game(Member player1, Member player2, Member player3, Member player4, int offencePoints, int defencePoints, LinkedList<Round> rounds) {
        this.player1 = player1;
        this.player2 = player2;
        this.player3 = player3;
        this.player4 = player4; 
        this.offencePoints = offencePoints;
        this.defencePoints = defencePoints;
        this.onGoing = false;
        this.rounds = rounds;
    }

    // Getters
    public Member getPlayer1() {return player1;}
    public Member getPlayer2() {return player2;}
    public Member getPlayer3() {return player3;}
    public Member getPlayer4() {return player4;}
    public int getOffencePoints() {return offencePoints;}
    public int getDefencePoints() {return defencePoints;}
    public boolean getOnGoing() {return onGoing;}
    public LinkedList<Round> getRounds() {return rounds;}

    // Overload addRound for on going and completed rounds

    // Ongoing rounds
    public void addRound(Member offencePlayer1, Member offencePlayer2, Member defencePlayer1, Member defencePlayer2, Member dealer) {
        rounds.add(new Round(offencePlayer1, offencePlayer2, defencePlayer1, defencePlayer2, dealer));
    }

    // Completed rounds
    public void addRound(Member offencePlayer1, Member offencePlayer2, Member defencePlayer1, Member defencePlayer2, Member dealer, Member trumpEstablisher, boolean goingAlone, String trumpSuit, int offenceTricks, int defenceTricks, boolean offenceWin, int pointsAwarded) {
        rounds.add(new Round(offencePlayer1, offencePlayer2, defencePlayer1, defencePlayer2, dealer, trumpEstablisher, goingAlone, trumpSuit, offenceTricks, defenceTricks, offenceWin, pointsAwarded));
    }

}
